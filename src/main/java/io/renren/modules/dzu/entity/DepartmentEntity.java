package io.renren.modules.dzu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 部门表
 * 
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 17:55:18
 */
@Data
@TableName("dzu_department")
public class DepartmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 部门id
	 */
	@TableId
	private Long id;
	/**
	 * 部门名称
	 */
	private String name;
	/**
	 * 上级部门id
	 */
	private Long parentid;
	/**
	 * 路径
	 */
	private String deppath;
	/**
	 * 默认开启
	 */
	private Integer enabled;
	/**
	 * 默认为父标签
	 */
	private Integer isparent;

}
