package com.paint.service.domain;

import com.paint.common.annotation.Excel;
import com.paint.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 绘图评论对象 paint_comment
 *
 * @author story-x
 * @date 2023-02-26
 */
public class PaintComment extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private String id;

    /**
     * 绘图id
     */
    @Excel(name = "绘图id")
    private Long paintId;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private String userId;

    /**
     * 评论
     */
    @Excel(name = "评论")
    private String comment;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private String status;

    /**
     * 更新人
     */
    @Excel(name = "更新人")
    private Long updateUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getPaintId() {
        return paintId;
    }

    public void setPaintId(Long paintId) {
        this.paintId = paintId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("paintId", getPaintId())
            .append("userId", getUserId())
            .append("comment", getComment())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("updateUser", getUpdateUser())
            .toString();
    }
}
