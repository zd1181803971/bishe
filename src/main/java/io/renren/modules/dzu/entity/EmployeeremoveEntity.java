package io.renren.modules.dzu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 员工部门调动表
 * 
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 17:55:18
 */
@Data
@TableName("dzu_employeeremove")
public class EmployeeremoveEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private Long eid;
	/**
	 * 调动后部门
	 */
	private Long afterdepid;
	/**
	 * 调动后职位
	 */
	private Long afterjobid;
	/**
	 * 调动日期
	 */
	private Date removedate;
	/**
	 * 调动原因
	 */
	private String reason;
	/**
	 * 
	 */
	private String remark;

}
