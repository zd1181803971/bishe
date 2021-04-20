package io.renren.modules.dzu.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Classname EmployeeForm
 * @Description 员工表单
 * @Date 2021/3/23 22:25
 * @Created by Administrator
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeForm {
    /**
     * 员工编号
     */
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
     * 性别
     */
    private String gender;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 身份证号
     */
    private String idcard;
    /**
     * 婚姻状况
     */
    private String wedlock;
    /**
     * 民族
     */
    private String nation;
    /**
     * 籍贯
     */
    private String nativeplace;
    /**
     * 政治面貌
     */
    private String politic;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 所属部门
     */
    private String department;
    /**
     * 职称ID
     */
    private String joblevel;
    /**
     * 职位ID
     */
    private String pos;
    /**
     * 聘用形式
     */
    private String engageform;
    /**
     * 最高学历
     */
    private String tiptopdegree;
    /**
     * 所属专业
     */
    private String specialty;
    /**
     * 毕业院校
     */
    private String school;
    /**
     * 入职日期
     */
    private Date begindate;
    /**
     * 在职状态
     */

    private Integer workstate;

    /**
     * 离职日期
     */
    private Date notworkdate;
    /**
     * 合同起始日期
     */
    private Date begincontract;
    /**
     * 合同终止日期
     */
    private Date endcontract;

}
