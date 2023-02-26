package com.paint.service.service;

import com.paint.service.domain.PaintLike;

import java.util.List;

/**
 * 绘图点赞Service接口
 *
 * @author story-x
 * @date 2023-02-26
 */
public interface IPaintLikeService {
    /**
     * 查询绘图点赞
     *
     * @param id 绘图点赞主键
     * @return 绘图点赞
     */
    public PaintLike selectPaintLikeById(String id);

    /**
     * 查询绘图点赞列表
     *
     * @param paintLike 绘图点赞
     * @return 绘图点赞集合
     */
    public List<PaintLike> selectPaintLikeList(PaintLike paintLike);

    /**
     * 新增绘图点赞
     *
     * @param paintLike 绘图点赞
     * @return 结果
     */
    public int insertPaintLike(PaintLike paintLike);

    /**
     * 修改绘图点赞
     *
     * @param paintLike 绘图点赞
     * @return 结果
     */
    public int updatePaintLike(PaintLike paintLike);

    /**
     * 批量删除绘图点赞
     *
     * @param ids 需要删除的绘图点赞主键集合
     * @return 结果
     */
    public int deletePaintLikeByIds(String[] ids);

    /**
     * 删除绘图点赞信息
     *
     * @param id 绘图点赞主键
     * @return 结果
     */
    public int deletePaintLikeById(String id);
}
