package com.paint.service.service.impl;

import com.paint.common.utils.DateUtils;
import com.paint.service.domain.PaintLike;
import com.paint.service.mapper.PaintLikeMapper;
import com.paint.service.service.IPaintLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 绘图点赞Service业务层处理
 *
 * @author story-x
 * @date 2023-02-26
 */
@Service
public class PaintLikeServiceImpl implements IPaintLikeService {
    @Autowired
    private PaintLikeMapper paintLikeMapper;

    /**
     * 查询绘图点赞
     *
     * @param id 绘图点赞主键
     * @return 绘图点赞
     */
    @Override
    public PaintLike selectPaintLikeById(String id) {
        return paintLikeMapper.selectPaintLikeById(id);
    }

    /**
     * 查询绘图点赞列表
     *
     * @param paintLike 绘图点赞
     * @return 绘图点赞
     */
    @Override
    public List<PaintLike> selectPaintLikeList(PaintLike paintLike) {
        return paintLikeMapper.selectPaintLikeList(paintLike);
    }

    /**
     * 新增绘图点赞
     *
     * @param paintLike 绘图点赞
     * @return 结果
     */
    @Override
    public int insertPaintLike(PaintLike paintLike) {
        paintLike.setCreateTime(DateUtils.getNowDate());
        return paintLikeMapper.insertPaintLike(paintLike);
    }

    /**
     * 修改绘图点赞
     *
     * @param paintLike 绘图点赞
     * @return 结果
     */
    @Override
    public int updatePaintLike(PaintLike paintLike) {
        paintLike.setUpdateTime(DateUtils.getNowDate());
        return paintLikeMapper.updatePaintLike(paintLike);
    }

    /**
     * 批量删除绘图点赞
     *
     * @param ids 需要删除的绘图点赞主键
     * @return 结果
     */
    @Override
    public int deletePaintLikeByIds(String[] ids) {
        return paintLikeMapper.deletePaintLikeByIds(ids);
    }

    /**
     * 删除绘图点赞信息
     *
     * @param id 绘图点赞主键
     * @return 结果
     */
    @Override
    public int deletePaintLikeById(String id) {
        return paintLikeMapper.deletePaintLikeById(id);
    }
}
