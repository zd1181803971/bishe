package io.renren.modules.dzu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.dzu.dao.OliticsstatusDao;
import io.renren.modules.dzu.entity.OliticsstatusEntity;
import io.renren.modules.dzu.entity.form.NationForm;
import io.renren.modules.dzu.entity.form.OliticsstatusForm;
import io.renren.modules.dzu.service.OliticsstatusService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("oliticsstatusService")
public class OliticsstatusServiceImpl extends ServiceImpl<OliticsstatusDao, OliticsstatusEntity> implements OliticsstatusService {
    @Autowired
    OliticsstatusDao oliticsstatusDao;

    @Override
    public PageUtils getOliticsstatusForm(Map<String, Object> params) {
        String name = null;
        if (StringUtils.isNotEmpty(params.get("name").toString())){
            name =  params.get("name").toString();
        }
        IPage<NationForm> page = new Query<NationForm>().getPage(params);
        PageHelper.startPage((int) page.getCurrent(), (int) page.getSize());
        List<OliticsstatusForm> oliticsstatusFormList = oliticsstatusDao.getOliticsstatusFormList(name);
        PageInfo<OliticsstatusForm> oliticsstatusFormPageInfo = new PageInfo<>(oliticsstatusFormList);
        return new PageUtils(oliticsstatusFormPageInfo.getList(),
                (int) oliticsstatusFormPageInfo.getTotal(),
                oliticsstatusFormPageInfo.getSize(),
                oliticsstatusFormPageInfo.getPageNum());
    }


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OliticsstatusEntity> page = this.page(
                new Query<OliticsstatusEntity>().getPage(params),
                new QueryWrapper<OliticsstatusEntity>()
        );

        return new PageUtils(page);
    }



}
