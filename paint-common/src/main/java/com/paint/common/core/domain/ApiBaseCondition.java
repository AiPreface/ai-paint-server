package com.paint.common.core.domain;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


/**
 * 基础条件
 *
 * @author story-x
 * @date 2023/02/27
 */
@Data
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
