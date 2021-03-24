package io.renren.modules.dzu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.dzu.entity.SalaryEntity;
import io.renren.modules.dzu.entity.form.SalaryForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 员工工资表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 17:55:17
 */
@Mapper
public interface SalaryDao extends BaseMapper<SalaryEntity> {


    List<SalaryForm> getSalayFormList(String name,String jobNumber);
}
