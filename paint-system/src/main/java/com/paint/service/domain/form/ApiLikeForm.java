package com.paint.service.domain.form;

import com.paint.common.enums.LikeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 图片点赞
 *
 * @author story-x
 * @date 2023/02/26
 */
@Data
@ApiModel(value = "PaintLik对象", description = "")
public class ApiLikeForm {

    /**
     * 用户id
     */
    @ApiModelProperty(name="用户id", required = true)
    @NotBlank(message = "用户ID不能为空")
    private String userId;

    /**
     * 图片id
     */
    @ApiModelProperty(name="图片id", required = true)
    @NotBlank(message = "图片ID不能为空")
    private String imgId;

    /**
     * 点赞
     */
    @ApiModelProperty(name = "点赞", required = true)
    @NotNull(message = "点赞状态不能为空")
    @com.paint.common.validation.constraints.Enum(target = LikeEnum.class, field = "type", message = "[点赞状态]应该为枚举{target}的{field}属性之一")
    private Integer likeType;
}