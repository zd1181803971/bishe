package io.renren.modules.dzu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

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
	@NotBlank(message = "部门名称不能为空")
	private String name;
	/**
	 * 上级部门id
	 */
	@NotBlank(message = "上级部门ID不能为空")
	private Long parentid;

}
