package com.paint.service.domain.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 图片
 *
 * @author story-x
 * @date 2023/02/26
 */
@Data
@ApiModel(value = "Paint对象", description = "")
public class ApiPaintForm {

    /**
     * 用户id
     */
    @ApiModelProperty(name="用户id", required = true)
    @NotBlank(message = "用户ID不能为空")
    private String userId;

    /**
     * 图链
     */
    @Size(max = 500, message = "[图链]长度不能大于{max}")
    @ApiModelProperty(name="图链", required = true)
    @NotBlank(message = "图链不能为空")
    private String imageUrl;

    /**
     * 标题
     */
    @Size(max = 255, message = "[标题]长度不能大于{max}")
    @ApiModelProperty(name="标题", required = true)
    @NotBlank(message = "标题不能为空")
    private String title;

    /**
     * 标签
     */
    @ApiModelProperty(name="标签", required = true)
    private List<String> tags;

}