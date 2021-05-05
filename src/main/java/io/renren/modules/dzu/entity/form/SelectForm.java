package io.renren.modules.dzu.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author by ZhaoDong
 * @Classname SelectForm
 * @Description 选择器表单
 * @Date 2021/5/2 15:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectForm {
    private String label;
    private Long value;
}
