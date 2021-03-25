package io.renren.modules.dzu.dao;

import io.renren.modules.dzu.entity.NationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.dzu.entity.form.NationForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 员工民族表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 17:55:18
 */
@Mapper
public interface NationDao extends BaseMapper<NationEntity> {

    List<NationForm> getNationFormList(@Param("name") String name);
}
