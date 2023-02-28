package com.paint.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.paint.service.domain.Paint;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 绘图主Mapper接口
 *
 * @author story-x
 * @date 2023-02-26
 */
public interface PaintMapper extends BaseMapper<Paint> {
    /**
     * 查询绘图主
     *
     * @param id 绘图主主键
     * @return 绘图主
     */
    public Paint selectPaintById(String id);

    /**
     * 查询绘图主列表
     *
     * @param paint 绘图主
     * @return 绘图主集合
     */
    public List<Paint> selectPaintList(Paint paint);

    /**
     * 新增绘图主
     *
     * @param paint 绘图主
     * @return 结果
     */
    public int insertPaint(Paint paint);

    /**
     * 修改绘图主
     *
     * @param paint 绘图主
     * @return 结果
     */
    public int updatePaint(Paint paint);

    /**
     * 删除绘图主
     *
     * @param id 绘图主主键
     * @return 结果
     */
    public int deletePaintById(String id);

    /**
     * 批量删除绘图主
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePaintByIds(String[] ids);

    @Update("UPDATE `paint` SET `like_count` = `like_count` + 1  WHERE `id` = #{id}")
    void incrementLikeCount(String id);

    @Update("UPDATE `paint` SET `like_count` = `like_count` - 1  WHERE `id` = #{id}")
    void decrementLikeCount(String id);

    @Update("UPDATE `paint` SET `comment_count` = `comment_count` + 1  WHERE `id` = #{id}")
    void incrementCommentCount(String id);

    @Update("UPDATE `paint` SET `comment_count` = `comment_count` - 1  WHERE `id` = #{id}")
    void decrementCommentCount(String id);
}
