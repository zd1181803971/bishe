package io.renren.modules.dzu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.dzu.dao.JoblevelDao;
import io.renren.modules.dzu.entity.JoblevelEntity;
import io.renren.modules.dzu.entity.form.JobleaveForm;
import io.renren.modules.dzu.service.JoblevelService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("joblevelService")
public class JoblevelServiceImpl extends ServiceImpl<JoblevelDao, JoblevelEntity> implements JoblevelService {

    @Autowired
    JoblevelDao joblevelDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JoblevelEntity> page = this.page(
                new Query<JoblevelEntity>().getPage(params),
                new QueryWrapper<JoblevelEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils getJobLeaveForm(Map<String, Object> params) {
        String name = null;
        if (StringUtils.isNotEmpty((String) params.get("name"))){
            name = params.get("name").toString();
        }
        IPage<JobleaveForm> page = new Query<JobleaveForm>().getPage(params);
        PageHelper.startPage((int) page.getCurrent(), (int) page.getSize());
        List<JobleaveForm> jobLeaveFormList = joblevelDao.getJobLeaveFormList(name);
        PageInfo<JobleaveForm> jobleaveFormPageInfo = new PageInfo<>(jobLeaveFormList);
        return new PageUtils(jobleaveFormPageInfo.getList(),
                (int) jobleaveFormPageInfo.getTotal(),
                jobleaveFormPageInfo.getSize(),
                jobleaveFormPageInfo.getPageNum());
    }

}
