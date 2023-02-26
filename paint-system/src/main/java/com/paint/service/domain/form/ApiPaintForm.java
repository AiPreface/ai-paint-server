package com.paint.service.domain.form;

import com.paint.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

@Data
@ApiModel(value = "Paint对象", description = "")
public class ApiPaintForm {

    /**
     * 用户id
     */
    @ApiModelProperty(name="用户id", required = true)
    private String userId;

    /**
     * 图链
     */
    @Size(max = 500, message = "[图链]长度不能大于{max}")
    @ApiModelProperty(name="图链", required = true)
    private String imageUrl;

    /**
     * 标题
     */
    @Size(max = 255, message = "[标题]长度不能大于{max}")
    @ApiModelProperty(name="标题", required = true)
    private String title;

    /**
     * 标签
     */
    @ApiModelProperty(name="标签", required = true)
    private List<String> tags;

}