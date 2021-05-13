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
        // 如果前端出入的数据封装成的Entity不为空
        if (employee != null) {
            // 使用Mybatis Plus的条件构造器查询是否已经有此员工
            EmployeeEntity entity = baseMapper.selectOne(new QueryWrapper<EmployeeEntity>()
                    .eq("jobNumber", employee.getJobnumber()));
            // 如果查询出的员工为空，说明新增的员工数据库中不存在
            if (entity == null) {
                // 增加员工
                int insert = baseMapper.insert(employee);
                // 若果返回的值大于零，增加成功
                if (insert > 0) {
                    //获取到员工角色的信息
                    SysRoleEntity one = sysRoleService.getOne(new QueryWrapper<SysRoleEntity>()
                            .eq("role_name", ROLE_NAME));
                    // 员工角色不为空
                    if (one != null) {
                        SysUserEntity sysUserEntity = new SysUserEntity();
                        // 设置登录名为员工共工号
                        sysUserEntity.setUsername(employee.getJobnumber());
                        // 设置账户状态
                        sysUserEntity.setStatus(1);
                        // 设置默认密码
                        sysUserEntity.setPassword(PASSWORD);
                        // 设置角色ID
                        sysUserEntity.setRoleIdList(Collections.singletonList(one.getRoleId()));
                        // 新增系统账户
                        sysUserService.saveUser(sysUserEntity);
                        // 查询出新添加的员工的id
                        EmployeeEntity entityTemp = baseMapper.selectOne(new QueryWrapper<EmployeeEntity>()
                                .eq("jobNumber", employee.getJobnumber()));
                        // 设置新员工默认薪资
                        SalaryEntity salaryEntity = new SalaryEntity(null,
                                entityTemp.getId(),
                                3000.00,
                                0.00,
                                10.00,
                                200.00,
                                3210.00);
                        // 添加此员工薪资记录
                        boolean save = salaryService.save(salaryEntity);
                        if (save) {
                            return R.ok("员工添加成功！");
                        }
                    }

                }

            }
        }
        return R.error("工号已经存在！");
    }

    @Override
    public R removeByIdsWithSalaryAndSysUerAndLeaves(Long[] ids) {
        for (Long id : ids) {
            EmployeeEntity entity = baseMapper.selectById(id);
            entity.setNotworkdate(new Date());
            baseMapper.updateById(entity);
            sysUserService.remove(new QueryWrapper<SysUserEntity>().eq("username", entity.getJobnumber()));
            salaryService.remove(new QueryWrapper<SalaryEntity>().eq("eid", id));
            leaveService.remove(new QueryWrapper<LeaveEntity>().eq("eid", id));

        }
        baseMapper.deleteBatchIds(Arrays.asList(ids));
        return R.ok("删除成功");
    }

    @Override
    public EmpIdNameDto getIdNameByJob(String jobNumber) {
        if (StringUtils.isNotEmpty(jobNumber)) {
            return employeeDao.getIdNameByJob(jobNumber);
        } else {
            return null;
        }
    }


    @Override
    public PageUtils getEmpFormList(Map<String, Object> map) {
        Long id = null;
        String jobNumber = null;
        String name = null;
//        获取前端发送的条件参数
        if (map.get("id") != null && !map.get("id").equals("")) {
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
            if (StringUtils.isNotBlank(entityList.get(i).getSchool())) {
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
        hashMap.put("总计", baseMapper.selectCount(null));
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
        EmployeeEntity entity1 = baseMapper.selectById(employee.getId());
        if (entity1.getWorkstate() == 1){
            baseMapper.updateById(employee);
            EmployeeEntity entity = baseMapper.selectById(employee.getId());
            String name = null;
            if (employee.getJobnumber() != null) {
                name = employee.getJobnumber();
                SysUserEntity one = sysUserService.getOne(new QueryWrapper<SysUserEntity>().eq("username", name));
                if (employee.getEmail() != null) {
                    one.setEmail(employee.getEmail());
                }
                if (employee.getPhone() != null) {
                    one.setMobile(employee.getPhone());
                }
                sysUserService.updateById(one);
                return R.ok();
            }else {
                name = entity.getJobnumber();
                SysUserEntity one = sysUserService.getOne(new QueryWrapper<SysUserEntity>().eq("username", name));
                if (one == null){
                    return R.ok();
                }
                if (entity.getEmail() != null) {
                    one.setEmail(entity.getEmail());
                }
                if (entity.getPhone() != null) {
                    one.setMobile(entity.getPhone());
                }
                sysUserService.updateById(one);
                return R.ok();
            }

        }
        else if (employee.getWorkstate() == 0){
//            离职 直接删
            return delEmpWithSalaryAndLeave(employee);
        }
        return R.error();
    }

    /**
     * 删除员工时 删除薪资和请假
     * @param employee
     * @return
     */
    public R delEmpWithSalaryAndLeave(EmployeeEntity employee){
        Long id = employee.getId();
        String jobnumber = employee.getJobnumber();
        if (id != null && StringUtils.isNotBlank(jobnumber)){
            baseMapper.updateById(employee);
            baseMapper.deleteById(employee);
            sysUserService.remove(new QueryWrapper<SysUserEntity>().eq("username", jobnumber));
            salaryService.remove(new QueryWrapper<SalaryEntity>().eq("eid",id));
            leaveService.remove(new QueryWrapper<LeaveEntity>().eq("eid",id));
            return R.ok();
        }else {
            return R.error();
        }

    }
}
