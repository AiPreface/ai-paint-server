package com.paint.service.domain.condition;

import com.paint.common.core.domain.ApiBaseCondition;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 绘图主对象 paint
 *
 * @author story-x
 * @date 2023-02-26
 */
@Data
public class ApiPaintCondition extends ApiBaseCondition {
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @NotBlank(message = "用户ID不能为空")
    @ApiModelProperty(name="用户id", required = true)
    private String userId;

    /**
     * 标题
     */
    @ApiModelProperty(name="标题")
    private String title;


    /**
     * tags
     */
    @ApiModelProperty(name="tags")
    private List<String> tags;


}
