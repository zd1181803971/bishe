package io.renren.modules.dzu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 营销机会表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-05-02 14:01:12
 */
@Data
@TableName("dzu_sale_chance")
public class SaleChanceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 营销机会ID
	 */
	@TableId
	private Long id;
	/**
	 * 机会来源
	 */
	private String chanceSource;
	/**
	 * 客户名称
	 */
	private String customerName;
	/**
	 * 成功几率
	 */
	private Integer probability;
	/**
	 * 概要
	 */
	private String overview;
	/**
	 * 联系人
	 */
	private String linkMan;
	/**
	 * 联系号码
	 */
	private String linkPhone;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 创建人ID
	 */
	private Long createMan;
	/**
	 * 分配人ID
	 */
	private Long assignMan;
	/**
	 * 分配时间
	 */
	private Date assignTime;
	/**
	 * 分配状态 0未分配 1已分配
	 */
	private Integer allocationState;
	/**
	 * 开发状态 0未开发 1开发中 2成功 3失败
	 */
	private Integer devResult;
	/**
	 * 是否有效 0无效 1有效
	 */
	private Integer isValid;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 更新时间
	 */
	private Date updateDate;

}
