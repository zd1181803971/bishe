package io.renren.modules.dzu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 员工工资表
 * 
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 17:55:17
 */
@Data
@TableName("dzu_salary")
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
	/**
	 * 养老金基数
	 */
	private Double pensionbase;
	/**
	 * 养老金比率
	 */
	private Float pensionper;
	/**
	 * 启用时间
	 */
	private Date createdate;
	/**
	 * 医疗基数
	 */
	private Integer medicalbase;
	/**
	 * 医疗保险比率
	 */
	private Float medicalper;
	/**
	 * 公积金基数
	 */
	private Integer accumulationfundbase;
	/**
	 * 公积金比率
	 */
	private Float accumulationfundper;
	/**
	 * 
	 */
	private String name;

}
