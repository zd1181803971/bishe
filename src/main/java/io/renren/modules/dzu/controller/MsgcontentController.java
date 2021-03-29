package io.renren.modules.dzu.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.dzu.entity.MsgcontentEntity;
import io.renren.modules.dzu.service.MsgcontentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 信息通知表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 18:01:35
 */
@RestController
@RequestMapping("dzu/msgcontent")
public class MsgcontentController {
    @Autowired
    private MsgcontentService msgcontentService;


    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = msgcontentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		MsgcontentEntity msgcontent = msgcontentService.getById(id);

        return R.ok().put("msgcontent", msgcontent);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MsgcontentEntity msgcontent){
		msgcontentService.save(msgcontent);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MsgcontentEntity msgcontent){
		msgcontentService.updateById(msgcontent);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		msgcontentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
