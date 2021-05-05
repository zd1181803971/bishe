package io.renren.modules.dzu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 客户表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-05-02 14:01:12
 */
@Data
@TableName("dzu_customer")
public class CustomerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 客户ID
	 */
	@TableId
	private Long id;
	/**
	 * 客户编号
	 */
	private String number;
	/**
	 * 客户公司名
	 */
	private String name;
	/**
	 * 地区
	 */
	private String area;
	/**
	 * 公司经理
	 */
	private String manager;
	/**
	 * 客户级别 1-5
	 */
	private Integer level;
	/**
	 * 客户满意度
	 */
	private Integer satisfied;
	/**
	 * 客户信用度
	 */
	private Integer credit;
	/**
	 * 客户详细地址
	 */
	private String address;
	/**
	 * 邮编
	 */
	private String postCode;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 官网
	 */
	private String webSite;
	/**
	 * 营业执照
	 */
	private String businessLicense;
	/**
	 * 客户法定代表人
	 */
	private String legalRepresentative;
	/**
	 * 注册资金
	 */
	private Long registeredCapital;
	/**
	 * 营业额
	 */
	private Long turnover;
	/**
	 * 开户行
	 */
	private String bankName;
	/**
	 * 银行账户
	 */
	private String bankId;
	/**
	 * 国税账户
	 */
	private String stateTax;
	/**
	 * 地税账户
	 */
	private String landTax;
	/**
	 * 客户状态 0流失 1正常
	 */
	private Integer state;
	/**
	 * 有效状态 0删除 1正常
	 */
	@TableLogic(value ="1",delval = "0")
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
