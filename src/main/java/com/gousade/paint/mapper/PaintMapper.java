package com.gousade.paint.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gousade.paint.entity.Paint;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author woxigousade
 * @since 2023-02-24
 */
public interface PaintMapper extends BaseMapper<Paint> {

    @Update("UPDATE `paint` SET `like_count` = `like_count` + 1  WHERE `id` = #{id}")
    void incrementLikeCount(Long id);

    @Update("UPDATE `paint` SET `like_count` = `like_count` - 1  WHERE `id` = #{id}")
    void decrementLikeCount(Long id);

    @Update("UPDATE `paint` SET `comment_count` = `comment_count` + 1  WHERE `id` = #{id}")
    void incrementCommentCount(Long id);

    @Update("UPDATE `paint` SET `comment_count` = `comment_count` - 1  WHERE `id` = #{id}")
    void decrementCommentCount(Long id);
}
