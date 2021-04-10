package io.renren.modules.dzu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.dzu.entity.LeaveEntity;
import io.renren.modules.dzu.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 请假表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-22 08:50:11
 */
@RestController
@RequestMapping("dzu/leave")
public class LeaveController {
    @Autowired
    private LeaveService leaveService;


//    通过员工工号查询员工的所有请假记录
    @GetMapping("/getLeaveListByjobNumber")
    public R getLeaveListByJob(@RequestParam Map<String, Object> params){
        PageUtils page = leaveService.getLeaveListByJob(params);
        return R.ok().put("page",page);
    }



//    获取员工请假Form
     @GetMapping("/leaveFormList")
     public R getLeaveFormList(@RequestParam Map<String, Object> params){
         PageUtils page =leaveService.getLeaveFormList(params);
         return R.ok().put("page", page);
     }
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = leaveService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		LeaveEntity leave = leaveService.getById(id);
        return R.ok().put("leave", leave);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LeaveEntity leave){
        LeaveEntity eid = leaveService.getOne(new QueryWrapper<LeaveEntity>().eq("eid", leave.getEid()).eq("status",leave.getStatus()));
        if (eid == null){
            leaveService.save(leave);
            return R.ok();
        }else {
            return R.error("等待管理员审批后再次请假！");
        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody LeaveEntity leave){
        return leaveService.updateLeaveAndReportWork(leave);

    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		leaveService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
