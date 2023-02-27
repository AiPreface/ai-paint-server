package com.gousade.paint.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gousade.paint.entity.PaintLike;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author woxigousade
 * @since 2023-02-24
 */
public interface PaintLikeMapper extends BaseMapper<PaintLike> {

    @Select("SELECT * from `paint_like` where `paint_id` = #{paintId} and `user_id` = #{userId} ")
    PaintLike select(Long paintId, String userId);
}
