package io.renren.modules.dzu.dao;

import io.renren.modules.dzu.entity.OliticsstatusEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.dzu.entity.form.OliticsstatusForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 员工政治面貌表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-03-20 17:55:18
 */
@Mapper
public interface OliticsstatusDao extends BaseMapper<OliticsstatusEntity> {

    List<OliticsstatusForm> getOliticsstatusFormList(@Param("name") String name);
}
