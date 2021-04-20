package io.renren.modules.dzu.entity.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Classname LeaveForm
 * @Description 请假
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
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date startTime;
    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date endTime;
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
