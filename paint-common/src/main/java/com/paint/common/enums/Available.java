package com.paint.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 可用枚举
 *
 * @author story-x
 * @date 2023/02/26
 */
@Getter
@AllArgsConstructor
public enum Available {
    AVAILABLE(1, "可用"),
    UN_AVAILABLE(0, "不可用"),
    HAS_DELETE(-1, "已删除"),
    ;

    private final int code;
    private final String desc;
}

