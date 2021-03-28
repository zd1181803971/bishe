package io.renren.modules.dzu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工奖罚表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 17:55:18
 */
@Data
@TableName("dzu_employeeec")
public class EmployeeecEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Long id;
	/**
	 * 员工工号
	 */
	private String eid;
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
	private Long ecpoint;
	/**
	 * 报工情况 0正常报工 1请假 2 矿工
	 */
	private Integer ectype;
	/**
	 * 备注
	 */
	private String remark;

}
