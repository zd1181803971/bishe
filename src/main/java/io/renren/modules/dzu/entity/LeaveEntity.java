package io.renren.modules.dzu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
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
	@NotBlank(message = "请假原因不能为空",groups = {AddGroup.class, UpdateGroup.class})
	private String reason;
	/**
	 * 请假状态
	 */
	private Integer status;
	/**
	 * 备注信息
	 */
	private String message;


}
