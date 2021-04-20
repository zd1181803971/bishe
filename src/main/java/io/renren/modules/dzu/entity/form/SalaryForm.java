package io.renren.modules.dzu.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname SalaryForm
 * @Description 薪资
 * @Date 2021/3/22 16:20
 * @Created by ZhaoDong
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryForm {

//    薪资id
    private Long id;

    /**
     * 员工姓名
     */
    private String name;
    /*
    员工工号
     */
    private String jobnumber;
    /**
     * 基本工资
     */
    private Double basicsalary;
    /**
     * 奖金
     */
    private Double bonus;
    /**
     * 午餐补助
     */
    private Double lunchsalary;
    /**
     * 交通补助
     */
    private Double trafficsalary;
    /**
     * 应发工资
     */
    private Double allsalary;
}
