package io.renren.modules.dzu.entity.form;

import io.renren.modules.dzu.entity.SalaryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname SalaryForm
 * @Description TODO
 * @Date 2021/3/22 16:20
 * @Created by ZhaoDong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryForm  extends SalaryEntity {
    /**
     * 员工姓名
     */
    private String name;
    /*
    员工工号
     */
    private String jobnumber;
}
