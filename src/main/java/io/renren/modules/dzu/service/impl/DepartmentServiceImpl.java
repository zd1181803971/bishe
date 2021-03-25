package io.renren.modules.dzu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.dzu.dao.DepartmentDao;
import io.renren.modules.dzu.entity.DepartmentEntity;
import io.renren.modules.dzu.entity.form.DeptForm;
import io.renren.modules.dzu.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("departmentService")
public class DepartmentServiceImpl extends ServiceImpl<DepartmentDao, DepartmentEntity> implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    @Override
    public PageUtils getDeptForm(Map<String, Object> params) {
        String deptName = null;
        if (params.get("name") != null && !params.get("name").equals("")) {
            deptName = params.get("name").toString();
        }
        IPage<DeptForm> page = new Query<DeptForm>().getPage(params);
        PageHelper.startPage((int) page.getCurrent(), (int) page.getSize());
        List<DeptForm> deptFormList = departmentDao.getDeptFormList(deptName);
        PageInfo<DeptForm> userInfoPage = new PageInfo<>(deptFormList);
        return new PageUtils(userInfoPage.getList(),
                (int) userInfoPage.getTotal(),
                userInfoPage.getSize(),
                userInfoPage.getPageNum());

    }


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DepartmentEntity> page = this.page(
                new Query<DepartmentEntity>().getPage(params),
                new QueryWrapper<DepartmentEntity>()
        );

        return new PageUtils(page);
    }


}
