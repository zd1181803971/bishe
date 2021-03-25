package io.renren.modules.dzu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.dzu.dao.NationDao;
import io.renren.modules.dzu.entity.NationEntity;
import io.renren.modules.dzu.entity.form.NationForm;
import io.renren.modules.dzu.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("nationService")
public class NationServiceImpl extends ServiceImpl<NationDao, NationEntity> implements NationService {

    @Autowired
    NationDao nationDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NationEntity> page = this.page(
                new Query<NationEntity>().getPage(params),
                new QueryWrapper<NationEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils getNationForm(Map<String, Object> params) {
        String name = null;
        if (params.get("name") != null && !params.get("name").equals("")) {
            name = params.get("name").toString();
        }
        IPage<NationForm> page = new Query<NationForm>().getPage(params);
        PageHelper.startPage((int) page.getCurrent(), (int) page.getSize());
        List<NationForm> nationFormList = nationDao.getNationFormList(name);
        PageInfo<NationForm> userInfoPage = new PageInfo<>(nationFormList);
        return new PageUtils(userInfoPage.getList(),
                (int) userInfoPage.getTotal(),
                userInfoPage.getSize(),
                userInfoPage.getPageNum());

    }

}
