package io.renren.modules.dzu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.dzu.dao.SaleChanceDao;
import io.renren.modules.dzu.entity.SaleChanceEntity;
import io.renren.modules.dzu.entity.form.SaleChanceForm;
import io.renren.modules.dzu.service.SaleChanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("saleChanceService")
public class SaleChanceServiceImpl extends ServiceImpl<SaleChanceDao, SaleChanceEntity> implements SaleChanceService {

    @Autowired
    SaleChanceDao saleChanceDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SaleChanceEntity> page = this.page(
                new Query<SaleChanceEntity>().getPage(params),
                new QueryWrapper<SaleChanceEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils getListForm(Map<String, Object> params) {
        String createMan = null;
        String assignMan = null;
        String state = null;
        Integer devResult = null;
        if (params.get("createMan") != null){
            createMan = (String)params.get("createMan");
        }
        if (params.get("assignMan") != null){
            assignMan = (String) params.get("assignMan");
        }
        if (params.get("allocationState") != null){
            state =  params.get("allocationState").toString();
        }

////        分页
        IPage<SaleChanceForm> page = new Query<SaleChanceForm>().getPage(params);
        PageHelper.startPage((int) page.getCurrent(), (int) page.getSize());
        List<SaleChanceForm> list = saleChanceDao.getFormList(createMan,assignMan,state,devResult);
        PageInfo<SaleChanceForm> pageInfo = new PageInfo<>(list);
        return new PageUtils(pageInfo.getList(),
                (int) pageInfo.getTotal(),
                pageInfo.getSize(),
                pageInfo.getPageNum());
    }

    @Override
    public PageUtils getListFormByAssignEmp(Map<String, Object> params) {
        String customerName = null;
        String assignMan = null;

        String state = null;
        String devResult = null;

        if (params.get("customerName") != null){
            customerName = (String) params.get("customerName");
        }
        if (params.get("assignMan") != null){
            assignMan = (String) params.get("assignMan");
        }
        if (params.get("allocationState") != null){
            state = (String) params.get("allocationState");
        }

        if (params.get("devResult") != null){
            devResult = (String) params.get("devResult");
        }
        if (assignMan == null){
            return null;
        }
        IPage<SaleChanceForm> page = new Query<SaleChanceForm>().getPage(params);
        PageHelper.startPage((int) page.getCurrent(), (int) page.getSize());
        List<SaleChanceForm> list = saleChanceDao.getListFormByAssignEmp(assignMan,customerName,state,devResult);
        PageInfo<SaleChanceForm> pageInfo = new PageInfo<>(list);
        return new PageUtils(pageInfo.getList(),
                (int) pageInfo.getTotal(),
                pageInfo.getSize(),
                pageInfo.getPageNum());
    }

}
