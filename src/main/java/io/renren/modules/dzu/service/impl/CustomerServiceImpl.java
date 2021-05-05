package io.renren.modules.dzu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;
import io.renren.modules.dzu.dao.CustomerDao;
import io.renren.modules.dzu.dao.CustomerLossDao;
import io.renren.modules.dzu.entity.CustomerEntity;
import io.renren.modules.dzu.entity.CustomerLossEntity;
import io.renren.modules.dzu.entity.dto.EchartsCountDto;
import io.renren.modules.dzu.entity.form.SelectForm;
import io.renren.modules.dzu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("customerService")
public class CustomerServiceImpl extends ServiceImpl<CustomerDao, CustomerEntity> implements CustomerService {

    @Autowired
    private CustomerLossDao customerLossDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CustomerEntity> page = this.page(
                new Query<CustomerEntity>().getPage(params),
                getQueryWrapper(params)
        );

        return new PageUtils(page);
    }

    public QueryWrapper<CustomerEntity> getQueryWrapper(Map<String, Object> params) {
        QueryWrapper<CustomerEntity> wrapper = new QueryWrapper<>();
        if (params.get("name") != null) {
            wrapper.like("name", params.get("name"));
        }
        wrapper.eq("state", "1");
        return wrapper;
    }

    @Override
    public R lossCustomer(CustomerEntity customer) {
        baseMapper.updateById(customer);
        CustomerLossEntity entity = new CustomerLossEntity();
        CustomerEntity customerEntity = baseMapper.selectById(customer.getId());
        entity.setCusNumber(customerEntity.getNumber());
        entity.setCusManager(customerEntity.getManager());
        entity.setCusName(customerEntity.getName());
        entity.setCreateDate(new Date());
        // 暂缓流失
        entity.setState(0);
        entity.setIsValid(1);
        customerLossDao.insert(entity);
        return R.ok();
    }

    @Override
    public List<EchartsCountDto> getCustomerCountByEcharts() {
        List<CustomerEntity> entityList = baseMapper.selectList(new QueryWrapper<CustomerEntity>().eq("state", 1));
        ArrayList<EchartsCountDto> echartsCountDtos = new ArrayList<>();
        int[] ints = new int[5];
        for (CustomerEntity customerEntity : entityList) {
            if (customerEntity.getLevel() == 1) {
                ints[0]++;
            }
            if (customerEntity.getLevel() == 2) {
                ints[1]++;
            }
            if (customerEntity.getLevel() == 3) {
                ints[2]++;
            }
            if (customerEntity.getLevel() == 4) {
                ints[3]++;
            }
            if (customerEntity.getLevel() == 5) {
                ints[4]++;
            }
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("普通客户");
        arrayList.add("重点开发客户");
        arrayList.add("大客户");
        arrayList.add("战略合作伙伴");
        arrayList.add("VIP客户");
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 0) {
                echartsCountDtos.add(new EchartsCountDto(ints[i], arrayList.get(i)));
            }
        }

        return echartsCountDtos;
    }

    @Override
    public List<SelectForm> getCustomerAllNamesBySelect() {
        ArrayList<SelectForm> selectForms = new ArrayList<>();
        List<CustomerEntity> customerList = baseMapper.selectList(new QueryWrapper<CustomerEntity>().eq("state", 1));
        for (CustomerEntity entity : customerList) {
            selectForms.add(new SelectForm(entity.getName(), entity.getId()));
        }
        return selectForms;
    }

    @Override
    public R saveCustomer(CustomerEntity customer) {
        CustomerEntity one = baseMapper.selectOne(new QueryWrapper<CustomerEntity>().eq("number", customer.getNumber()).or().eq("name", customer.getName()));
        if (one != null) {
            return R.error("公司名称已经存在！");
        }
        CustomerEntity numberEntity = baseMapper.selectOne(new QueryWrapper<CustomerEntity>().orderByDesc("number").last("limit 1"));
        String number = numberEntity.getNumber();

        String regex = "HK[0-9]{0,3}";
        boolean flag = number.matches(regex);
        if (!flag) {
            return R.error("数据异常，请联系管理员");
        }
        int i = Integer.parseInt(number.substring(2));
        i++;
        String newNumber = null;
        if (i < 10) {
            newNumber = "HK00" + i;
        } else if (i < 100) {
            newNumber = "HK0" + i;
        } else if (i < 1000) {
            newNumber = "HK" + i;
        }
        customer.setNumber(newNumber);
        customer.setState(1);
        customer.setIsValid(1);
        customer.setCreateDate(new Date());
        baseMapper.insert(customer);
        return R.ok();
    }
}
