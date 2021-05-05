package io.renren.modules.dzu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 客户流失表
 * 
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-05-02 14:01:12
 */
@Data
@TableName("dzu_customer_loss")
public class CustomerLossEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 流失客户id
	 */
	@TableId
	private Long id;
	/**
	 * 客户编号
	 */
	private String cusNumber;
	/**
	 * 客户公司名
	 */
	private String cusName;
	/**
	 * 客户经理
	 */
	private String cusManager;
	/**
	 * 最后下单时间
	 */
	private Date lastOrderTime;
	/**
	 * 确认流失时间
	 */
	private Date confirmLossTime;
	/**
	 * 状态 0暂缓流失 1流失
	 */
	private Integer state;
	/**
	 * 流失原因
	 */
	private String lossReason;
	/**
	 * 
	 */
	private Integer isValid;
	/**
	 * 
	 */
	private Date createDate;
	/**
	 * 
	 */
	private Date updateDate;

}
