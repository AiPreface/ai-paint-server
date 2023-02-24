package com.gousade.paint.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
@ApiModel(value = "Paint对象", description = "")
public class Paint {

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @NotBlank
    @ApiModelProperty("用户id")
    private String userId;

    @NotBlank
    @Size(max = 500, message = "[图链]长度不能大于{max}")
    @ApiModelProperty("图链")
    private String imageUrl;

    @NotBlank
    @Size(max = 255, message = "[标题]长度不能大于{max}")
    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("点赞数")
    private Integer likeCount;

    @ApiModelProperty("评论数")
    private Integer commentCount;

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
