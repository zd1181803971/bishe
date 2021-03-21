package io.renren.modules.dzu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 薪资调整表
 * 
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 17:55:18
 */
@Data
@TableName("dzu_adjustsalary")
public class AdjustsalaryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 调薪id
	 */
	@TableId
	private Long id;
	/**
	 * 员工id
	 */
	private Long eid;
	/**
	 * 调薪日期
	 */
	private Date asdate;
	/**
	 * 调前薪资
	 */
	private Double beforesalary;
	/**
	 * 调后薪资
	 */
	private Double aftersalary;
	/**
	 * 调薪原因
	 */
	private String reason;
	/**
	 * 备注
	 */
	private String remark;

}
