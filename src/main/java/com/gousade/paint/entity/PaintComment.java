package com.gousade.paint.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author woxigousade
 * @since 2023-02-24
 */
@Getter
@Setter
@TableName("paint_comment")
@ApiModel(value = "PaintComment对象", description = "")
public class PaintComment {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("绘图id")
    private Long paintId;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("评论")
    private String comment;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("逻辑删除")
    @TableLogic
    private Integer isDeleted;


}
