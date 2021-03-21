package io.renren.modules.dzu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 员工考评表
 * 
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 17:55:18
 */
@Data
@TableName("dzu_appraise")
public class AppraiseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 考评id
	 */
	@TableId
	private Long id;
	/**
	 * 员工id
	 */
	private Long eid;
	/**
	 * 考评日期
	 */
	private Date appdate;
	/**
	 * 考评结果
	 */
	private String appresult;
	/**
	 * 考评内容
	 */
	private String appcontent;
	/**
	 * 备注
	 */
	private String remark;

}
