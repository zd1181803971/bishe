package io.renren.modules.dzu.dao;

import io.renren.modules.dzu.entity.SaleChanceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.dzu.entity.form.SaleChanceForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 营销机会表
 *
 * @author zhaodong
 * @email zhaodong0826@qq.com
 * @date 2021-05-02 14:01:12
 */
@Mapper
public interface SaleChanceDao extends BaseMapper<SaleChanceEntity> {

    List<SaleChanceForm> getFormList(String createMan, String assignMan, Integer state, Integer devResult);

    List<SaleChanceForm> getListFormByAssignEmp(String assignMan,String customerName, Integer state, Integer devResult);

}
