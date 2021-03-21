package io.renren.modules.dzu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 员工培训表
 * 
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 17:55:18
 */
@Data
@TableName("dzu_employeetrain")
public class EmployeetrainEntity implements Serializable {
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
	 * 培训日期
	 */
	private Date traindate;
	/**
	 * 培训内容
	 */
	private String traincontent;
	/**
	 * 备注
	 */
	private String remark;

}
