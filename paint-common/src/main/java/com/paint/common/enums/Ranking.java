package com.paint.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 排名枚举
 *
 * @author story-x
 * @date 2023/02/27
 */
@Getter
@AllArgsConstructor
public enum Ranking {
    /**
     * 周
     */
    WEEK(1 , "周榜"),

    /**
     * 上周
     */
    LAST_WEEK(2, "上周榜"),
    /**
     * 月
     */
    MONTH(3, "月榜"),

    /**
     * 3月
     */
    THREE_MONTH(4, "3月榜"),

    /**
     * 6月
     */
    SIX_MONTH(5, "6月榜"),

    /**
     * 年
     */
    YEAR(6, "年榜"),

    /**
     * 总
     */
    TOTAL(7, "总榜"),

    ;
    private final int code;

    private final String desc;
}
