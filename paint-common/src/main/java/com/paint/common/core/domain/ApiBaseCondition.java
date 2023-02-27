package com.paint.common.core.domain;

import lombok.Data;


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
    private Integer page;
    /**
     * 行
     */
    private Integer pageSize;
}
