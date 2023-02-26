package com.paint.service.domain.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * 图片评论
 *
 * @author story-x
 * @date 2023/02/26
 */
@Data
@ApiModel(value = "PaintComment对象", description = "")
public class ApiCommentForm {

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
     * 评论
     */
    @Size(max = 255, message = "[评论]长度不能大于{max}")
    @ApiModelProperty(name="评论", required = true)
    private String discuss;


}