package io.renren.modules.dzu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.renren.common.validator.group.AddGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 员工报工
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 17:55:18
 */
@Data
@TableName("dzu_employeeec")
public class EmployeeecEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *	报工id
	 */
	@TableId
	private Long id;
	/**
	 * 员工id
	 */
	private Long eid;
	/**
	 * 报工日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	@NotBlank(message = "报工日期不能为空",groups = AddGroup.class)
	private Date ecdate;
	/**
	 * 工作内容
	 */
	@NotBlank(message = "工作内容不能为空",groups = AddGroup.class)
	private String ecreason;
	/**
	 * 工作时长
	 */
	@NotBlank(message = "工作时长不能为空",groups = AddGroup.class)
	private Long echour;
	/**
	 * 报工情况 0正常报工 1请假 2 矿工
	 */
	@NotBlank(message = "报工情况不能为空",groups = AddGroup.class)
	private Integer ectype;
	/**
	 * 备注
	 */
	private String remark;

}
