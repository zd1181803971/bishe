package io.renren.modules.dzu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工职位等级表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 17:55:18
 */
@Data
@TableName("dzu_joblevel")
public class JoblevelEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	@TableId
	private Long id;
	/**
	 * 职称名称
	 */
	private String name;
	/**
	 *
	 */
	private String titlelevel;
	/**
	 *
	 */
	private Date createdate;
	/**
	 *
	 */
	private Integer enabled;

}
