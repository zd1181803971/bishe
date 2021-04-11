package io.renren.modules.dzu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 请假表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-22 08:50:11
 */
@Data
@TableName("dzu_leave")
public class LeaveEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	@TableId
	private Long id;
	/**
	 * 员工id
	 */
	private Long eid;
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
