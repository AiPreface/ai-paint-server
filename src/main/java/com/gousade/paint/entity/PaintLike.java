package com.gousade.paint.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
@TableName("paint_like")
@ApiModel(value = "PaintLike对象", description = "")
public class PaintLike {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @NotNull(message = "[绘图id]不能为空")
    @ApiModelProperty("绘图id")
    private Long paintId;

    @NotBlank(message = "[用户id]不能为空")
    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("逻辑删除")
    @TableLogic
    @TableField(value = "is_deleted", fill = FieldFill.INSERT)
    private Boolean deleted;


}
