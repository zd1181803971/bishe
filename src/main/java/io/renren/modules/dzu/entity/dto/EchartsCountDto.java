package io.renren.modules.dzu.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author by ZhaoDong
 * @Classname EchartsCountDto
 * @Description echarts
 * @Date 2021/5/3 21:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EchartsCountDto {
    private Integer value;
    private String   name;
}
