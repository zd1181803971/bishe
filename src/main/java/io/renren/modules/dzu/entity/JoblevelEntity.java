package io.renren.modules.dzu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

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
}
