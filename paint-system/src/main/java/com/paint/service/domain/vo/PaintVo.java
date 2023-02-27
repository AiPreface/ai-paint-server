package com.paint.service.domain.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 绘图主对象 paint
 *
 * @author story-x
 * @date 2023-02-26
 */
@Data
public class PaintVo {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 图链
     */
    private String imageUrl;

    /**
     * 标题
     */
    private String title;

    /**
     * 点赞数
     */
    private Integer likeCount;

    /**
     * 评论数
     */
    private Integer commentCount;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 更新人
     */
    private Long updateUser;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;



}
