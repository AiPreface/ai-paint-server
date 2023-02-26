package com.paint.service.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.paint.common.annotation.Excel;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 绘图主对象 paint
 *
 * @author story-x
 * @date 2023-02-26
 */
@Data
public class Paint  {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    @TableField("user_id")
    private String userId;

    /**
     * 图链
     */
    @Excel(name = "图链")
    @TableField("image_url")
    private String imageUrl;

    /**
     * 标题
     */
    @Excel(name = "标题")
    @TableField("title")
    private String title;

    /**
     * 点赞数
     */
    @Excel(name = "点赞数")
    @TableField("like_count")
    private Integer likeCount;

    /**
     * 评论数
     */
    @Excel(name = "评论数")
    @TableField("comment_count")
    private Integer commentCount;

    /**
     * 状态
     */
    @Excel(name = "状态")
    @TableField("status")
    private Integer status;

    /**
     * 更新人
     */
    @Excel(name = "更新人")
    @TableField("update_user")
    private Long updateUser;

    /**
     * 更新时间
     */
    @Excel(name = "更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @Excel(name = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;



}
