package io.renren.modules.dzu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 营销管理计划表
 * 
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-05-02 14:01:12
 */
@Data
@TableName("dzu_sale_chance_plan")
public class SaleChancePlanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 开发计划项ID
	 */
	@TableId
	private Long id;
	/**
	 * 营销机会ID
	 */
	private Long saleChanceId;
	/**
	 * 计划项内容
	 */
	private String planItem;
	/**
	 * 计划时间
	 */
	private Date planDate;
	/**
	 * 执行效果
	 */
	private String exeAffect;
	/**
	 * 
	 */
	private Date createDate;
	/**
	 * 
	 */
	private Date updateDate;
	/**
	 * 
	 */
	private Integer isValid;

}
