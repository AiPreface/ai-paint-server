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
@TableName("paint_tag")
@ApiModel(value = "PaintTag对象", description = "")
public class PaintTag {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("绘图id")
    private Long paintId;

    @ApiModelProperty("标签，例如JK、原神，一个标签一条数据")
    private String tag;

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
