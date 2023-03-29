package com.paint.common.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


/**
 * 基础条件
 *
 * @author story-x
 * @date 2023/02/27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiBaseCondition {

    /**
     * 页
     */
    @NotNull
    @Min(0)
    private Integer page;
    /**
     * 行
     */
    @NotNull
    @Min(0)
    private Integer pageSize;
}
