package io.renren.modules.dzu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;
import io.renren.modules.dzu.dao.EmployeeDao;
import io.renren.modules.dzu.entity.EmployeeEntity;
import io.renren.modules.dzu.entity.LeaveEntity;
import io.renren.modules.dzu.entity.SalaryEntity;
import io.renren.modules.dzu.entity.dto.DeptAndEmpCountDto;
import io.renren.modules.dzu.entity.dto.EmpIdNameDto;
import io.renren.modules.dzu.entity.form.DeptForm;
import io.renren.modules.dzu.entity.form.EmployeeForm;
import io.renren.modules.dzu.service.EmployeeService;
import io.renren.modules.dzu.service.LeaveService;
import io.renren.modules.dzu.service.SalaryService;
import io.renren.modules.sys.entity.SysRoleEntity;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.SysRoleService;
import io.renren.modules.sys.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service("employeeService")
public class EmployeeServiceImpl extends ServiceImpl<EmployeeDao, EmployeeEntity> implements EmployeeService {
    // 员工登录默认密码
    public static final String PASSWORD = "123456";
    // 角色名称
    public static final String ROLE_NAME = "员工";

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SalaryService salaryService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private LeaveService leaveService;

    @Override
    public List<DeptAndEmpCountDto> getDeptAndEmpCount() {
        List<DeptAndEmpCountDto> deptAndEmpCount = employeeDao.getDeptAndEmpCount();
        return deptAndEmpCount;
    }

    @Override
    public R saveEmpWithSalaryAndSysUser(EmployeeEntity employee) {
        if (employee != null){
            EmployeeEntity entity = baseMapper.selectOne(new QueryWrapper<EmployeeEntity>().eq("jobNumber", employee.getJobnumber()));
            if (entity == null){
                int insert = baseMapper.insert(employee);
                if (insert >0){
                    SysRoleEntity one = sysRoleService.getOne(new QueryWrapper<SysRoleEntity>().eq("role_name", ROLE_NAME));
                    if (one != null) {
                        SysUserEntity sysUserEntity = new SysUserEntity();
                        sysUserEntity.setUsername(employee.getJobnumber());
                        sysUserEntity.setStatus(1);
                        sysUserEntity.setPassword(PASSWORD);
                        sysUserEntity.setRoleIdList(Arrays.asList(one.getRoleId()));
                        sysUserEntity.setCreateUserId(one.getCreateUserId());
                        sysUserService.saveUser(sysUserEntity);

                        EmployeeEntity entityTemp = baseMapper.selectOne(new QueryWrapper<EmployeeEntity>().eq("jobNumber", employee.getJobnumber()));
                        SalaryEntity salaryEntity = new SalaryEntity(null,entityTemp.getId(),3000.00,0.00,10.00,200.00,3210.00);
                        boolean save = salaryService.save(salaryEntity);

                        if (save){
                            return R.ok("员工添加成功！");
                        }
                    }

                }

            }
        }
        return R.error("系统异常");
    }

    @Override
    public R removeByIdsWithSalaryAndSysUerAndLeaves(Long[] ids) {
        for (Long id : ids){
            EmployeeEntity entity = baseMapper.selectById(id);
            sysUserService.remove(new QueryWrapper<SysUserEntity>().eq("username",entity.getJobnumber()));
            salaryService.remove(new QueryWrapper<SalaryEntity>().eq("eid",id));
            leaveService.remove(new QueryWrapper<LeaveEntity>().eq("eid",id));
        }
        baseMapper.deleteBatchIds(Arrays.asList(ids));
        return R.ok("删除成功");
    }

    @Override
    public EmpIdNameDto getIdNameByJob(String jobNumber) {
        if (StringUtils.isNotEmpty(jobNumber)){
            return employeeDao.getIdNameByJob(jobNumber);
        }else {
            return null;
        }
    }



    @Override
    public PageUtils getEmpFormList(Map<String, Object> map) {
        Long id = null;
        String jobNumber = null;
        String name = null;
//        获取前端发送的条件参数
        if (map.get("id") != null && !map.get("id").equals("")){
            id = (Long) map.get("id");
        }
        if (map.get("jobNumber") != null && !map.get("jobNumber").equals("")) {
            jobNumber = map.get("jobNumber").toString();
        }
        if (map.get("name") != null && !map.get("name").equals("")) {
            name = map.get("name").toString();
        }
//        分页
        IPage<DeptForm> page = new Query<DeptForm>().getPage(map);
        PageHelper.startPage((int) page.getCurrent(), (int) page.getSize());
        List<EmployeeForm> empFormList = employeeDao.getEmpFormList(id, name, jobNumber);
        PageInfo<EmployeeForm> employeeFormPageInfo = new PageInfo<>(empFormList);
        return new PageUtils(employeeFormPageInfo.getList(),
                (int) employeeFormPageInfo.getTotal(),
                employeeFormPageInfo.getSize(),
                employeeFormPageInfo.getPageNum());
    }




    @Override
    public EmployeeEntity getEmployeeByjobNumber(String jobnumber) {
        EmployeeEntity entity = baseMapper.selectOne(new QueryWrapper<EmployeeEntity>().eq("jobNumber", jobnumber));
        return entity;
    }

    @Override
    public List<EmployeeEntity> getEmpByIds(Map<String, Object> map) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (map.get("ids") != null) {
            String ids = (String) map.get("ids");
            String[] split = ids.split(",");
            for (String s : split) {
                if (StringUtils.isNotEmpty(s)) {
                    integers.add(Integer.parseInt(s));
                }
            }

        }
        if (integers.size() != 0) {
            return baseMapper.selectBatchIds(integers);
        } else {
            return null;
        }
    }

    @Override
    public HashMap<String, Integer> getChartLineData() {
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        List<EmployeeEntity> entityList = baseMapper.selectList(null);
        int j = 1;

        for (int i = 0; i < entityList.size(); i++) {
            if (StringUtils.isNotBlank(entityList.get(i).getSchool())){
                if (!arrayList.contains(entityList.get(i).getSchool())) {

                    arrayList.add(entityList.get(i).getSchool());
                    hashMap.put(entityList.get(i).getSchool(), j);

                } else {
                    Integer integer = hashMap.get(entityList.get(i).getSchool());
                    integer++;
                    hashMap.put(entityList.get(i).getSchool(), integer);
                }
            }
        }
        hashMap.put("总计",baseMapper.selectCount(null));
        return hashMap;
    }


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EmployeeEntity> page = this.page(
                new Query<EmployeeEntity>().getPage(params),
                getEmployeeByName(params)
        );
        return new PageUtils(page);
    }

    public QueryWrapper<EmployeeEntity> getEmployeeByName(Map<String, Object> params) {
        if (StringUtils.isNotEmpty((String) params.get("name"))) {
            return new QueryWrapper<EmployeeEntity>().eq("name", params.get("name"));
        } else {
            return new QueryWrapper<EmployeeEntity>();
        }
    }

    @Override
    public R updateWithEmailAndPhone(EmployeeEntity employee) {
        baseMapper.updateById(employee);
        String name = null;
        if (StringUtils.isNotBlank(employee.getJobnumber())){
            name = employee.getJobnumber();
        }
        SysUserEntity one = sysUserService.getOne(new QueryWrapper<SysUserEntity>().eq("username", name));
        if (StringUtils.isNotBlank(employee.getEmail())){
            one.setEmail(employee.getEmail());
        }
        if (StringUtils.isNotBlank(employee.getPhone())){
            one.setMobile(employee.getPhone());
        }
      sysUserService.updateById(one);
        return null;
    }
}
