package io.renren.modules.dzu.entity.form;

import lombok.Data;

/**
 * @Classname DeptForm
 * @Description 部门表单
 * @Date 2021/3/25 15:00
 * @Created by ZhaoDong
 */
@Data
public class DeptForm {
    private Long id;
    private String name;
    private String parent;
    private Integer value;
}
