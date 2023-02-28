package com.paint.service.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.paint.common.annotation.Excel;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 绘图评论对象 paint_comment
 *
 * @author story-x
 * @date 2023-02-26
 */
@Data
public class PaintComment implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
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
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @Excel(name = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
