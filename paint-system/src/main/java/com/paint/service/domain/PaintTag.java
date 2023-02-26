package com.paint.service.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.paint.common.annotation.Excel;
import com.paint.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDateTime;

/**
 * 绘图tag对象 paint_tag
 *
 * @author story-x
 * @date 2023-02-26
 */
@Data
public class PaintTag  {
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
    @TableField("paint_id")
    private String paintId;

    /**
     * 标签，例如JK、原神，一个标签一条数据
     */
    @Excel(name = "标签")
    @TableField("tag")
    private String tag;

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
