package io.renren.modules.dzu.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.dzu.entity.DepartmentEntity;
import io.renren.modules.dzu.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 部门表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 18:01:35
 */
@RestController
@RequestMapping("dzu/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;


//    得到部门和上级部门以及对应的人数
    @GetMapping("/getDeptForm")
    public R getDeptForm(@RequestParam Map<String, Object> params){
        PageUtils page = departmentService.getDeptForm(params);
        return R.ok().put("deptForm",page);
    }

    /**
     * 所有的
     */
    @RequestMapping("/listAll")
    public R listAll(){
        List<DepartmentEntity> list = departmentService.list();
        return R.ok().put("page", list);
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = departmentService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		DepartmentEntity department = departmentService.getById(id);

        return R.ok().put("department", department);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DepartmentEntity department){
		departmentService.save(department);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DepartmentEntity department){
		departmentService.updateById(department);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		departmentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
