package io.renren.modules.dzu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

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
	 * 员工编号
	 */
	private Long eid;
	/**
	 * 奖罚日期
	 */
	private Date ecdate;
	/**
	 * 奖罚原因
	 */
	private String ecreason;
	/**
	 * 奖罚分
	 */
	private Long ecpoint;
	/**
	 * 奖罚类别，0：奖，1：罚
	 */
	private Integer ectype;
	/**
	 * 备注
	 */
	private String remark;

}
