package com.paint.service.domain.form;

import com.paint.common.enums.LikeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;

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
    private String userId;

    /**
     * 图片id
     */
    @ApiModelProperty(name="图片id", required = true)
    private String imgId;

    /**
     * 点赞
     */
    @ApiModelProperty(name="点赞", required = true)
    private Integer likeType;



}