package io.renren.modules.dzu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.dzu.entity.LeaveEntity;

import java.util.Map;

/**
 * 请假表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-22 08:50:11
 */
public interface LeaveService extends IService<LeaveEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils getLeaveFormList(Map<String, Object> params);

    PageUtils getLeaveListByJob(Map<String, Object> params);

    /**
     * 请假审批通过 报工添加请假记录
     * @param leave
     * @return
     */
    R updateLeaveAndReportWork(LeaveEntity leave);


    R addLeave(LeaveEntity leave);
}

