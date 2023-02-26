package com.paint.service.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.paint.common.annotation.Excel;
import com.paint.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDateTime;

/**
 * 绘图评论对象 paint_comment
 *
 * @author story-x
 * @date 2023-02-26
 */
@Data
public class PaintComment {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private String id;

    /**
     * 绘图id
     */
    @Excel(name = "绘图id")
    private String paintId;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private String userId;

    /**
     * 评论
     */
    @Excel(name = "评论")
    private String comment;

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
