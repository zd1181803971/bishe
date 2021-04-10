package io.renren.modules.dzu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 员工工资表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 17:55:17
 */
@Data
@TableName("dzu_salary")
@AllArgsConstructor
@NoArgsConstructor
public class SalaryEntity implements Serializable {
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
	 * 基本工资
	 */
	private Double basicsalary;
	/**
	 * 奖金
	 */
	private Double bonus;
	/**
	 * 午餐补助
	 */
	private Double lunchsalary;
	/**
	 * 交通补助
	 */
	private Double trafficsalary;
	/**
	 * 应发工资
	 */
	private Double allsalary;
}
