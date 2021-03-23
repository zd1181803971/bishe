package io.renren.modules.dzu.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Classname LeaveForm
 * @Description TODO
 * @Date 2021/3/23 20:46
 * @Created by Administrator
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveForm {
    //    请假id
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
     * 开始时间
     */

    private Date starttime;
    /**
     * 结束时间
     */
    private Date endtime;
    /**
     * 请假原因
     */
    private String reason;
    /**
     * 请假状态 0未通过 1通过
     */
    private Integer status;
    /**
     * 备注信息
     */
    private String message;
}
