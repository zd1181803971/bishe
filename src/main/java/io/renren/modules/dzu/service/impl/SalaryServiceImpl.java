package io.renren.modules.dzu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.dzu.dao.SalaryDao;
import io.renren.modules.dzu.entity.SalaryEntity;
import io.renren.modules.dzu.entity.form.SalaryForm;
import io.renren.modules.dzu.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("salaryService")
public class SalaryServiceImpl extends ServiceImpl<SalaryDao, SalaryEntity> implements SalaryService {
    @Autowired
    private SalaryDao salaryDao;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<SalaryEntity> salaryEntityQueryWrapper = getQueryWrapper(params);
        IPage<SalaryEntity> page = this.page(
                new Query<SalaryEntity>().getPage(params),
                new QueryWrapper<SalaryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public SalaryEntity getSalaryByid(Long eid) {
        return  baseMapper.selectOne(new QueryWrapper<SalaryEntity>().eq("eid", eid));
    }

    @Override
    public HashMap<String, Integer> getCharBarData() {
        HashMap<String, Integer> map = new HashMap<>(5);
        Integer[] count = new Integer[]{0,0,0,0,0};
        List<SalaryEntity> entityList = baseMapper.selectList(null);
        for(SalaryEntity salaryEntity : entityList){
            if (salaryEntity.getAllsalary() != null){
                if (salaryEntity.getAllsalary() >= 2000.00 && salaryEntity.getAllsalary() < 3000.00){
                    count[0]++;
                }
                if (salaryEntity.getAllsalary() >= 3000.00 && salaryEntity.getAllsalary() < 5000.00){
                    count[1]++;
                }
                if (salaryEntity.getAllsalary() >= 5000.00 && salaryEntity.getAllsalary() < 8000.00){
                    count[2]++;
                }
                if (salaryEntity.getAllsalary() >= 8000.00 && salaryEntity.getAllsalary() < 10000.00){
                    count[3]++;
                }
                if (salaryEntity.getAllsalary() >= 10000.00){
                    count[4]++;
                }
            }
        }
        map.put("2k-3k",count[0]);
        map.put("3k-5k",count[1]);
        map.put("5k-8k",count[2]);
        map.put("8k-10k",count[3]);
        map.put("10k以上",count[4]);
        return map;
    }

    @Override
    public PageUtils getSalaryFormList(Map<String, Object> params) {
        List<SalaryForm> list;
        if (params.get("name") != null){
            list = salaryDao.getSalayFormList(params.get("name").toString());
        }else {
            list = salaryDao.getSalayFormList(null);
        }
        IPage<SalaryForm> page = new Query<SalaryForm>().getPage(params);
        return new PageUtils(list,(int)page.getTotal(),(int)page.getSize(),(int)page.getCurrent());
    }

    public QueryWrapper<SalaryEntity> getQueryWrapper(Map<String, Object> params){
//        if (params.get("name"))
        return null;
    }


}
