package com.paint.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LikeEnum {
    LIKE(1, "点赞"),
    UNLIKE(0, "取消点赞");
    private final Integer type;
    private final String desc;

    public static LikeEnum getLikeEnum(Integer type) {
        for (LikeEnum likeEnum : LikeEnum.values()) {
            if (likeEnum.getType().equals(type)) {
                return likeEnum;
            }
        }
        throw new IllegalArgumentException("未知的点赞类型");
    }
}