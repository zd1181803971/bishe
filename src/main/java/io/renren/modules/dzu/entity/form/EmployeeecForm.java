package io.renren.modules.dzu.entity.form;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author by ZhaoDong
 * @Classname EmployeeecForm
 * @Description 报工管理表单
 * @Date 2021/4/21 13:22
 */
@Data
public class EmployeeecForm {

    /**
     *
     */
    @TableId
    private Long id;
    /**
     * 员工姓名
     */
    private String name;
    /**
     * 员工工号
     */
    private String jobnumber;
    /**
     * 报工日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date ecdate;
    /**
     * 工作内容
     */
    private String ecreason;
    /**
     * 工作时长
     */
    private Long echour;
    /**
     * 报工情况 0正常报工 1请假 2 矿工
     */
    private Integer ectype;
    /**
     * 备注
     */
    private String remark;

}
