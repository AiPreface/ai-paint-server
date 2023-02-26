package com.paint.service.service.impl;

import com.paint.common.utils.DateUtils;
import com.paint.service.domain.PaintComment;
import com.paint.service.mapper.PaintCommentMapper;
import com.paint.service.service.IPaintCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 绘图评论Service业务层处理
 *
 * @author story-x
 * @date 2023-02-26
 */
@Service
public class PaintCommentServiceImpl implements IPaintCommentService {
    @Autowired
    private PaintCommentMapper paintCommentMapper;

    /**
     * 查询绘图评论
     *
     * @param id 绘图评论主键
     * @return 绘图评论
     */
    @Override
    public PaintComment selectPaintCommentById(String id) {
        return paintCommentMapper.selectPaintCommentById(id);
    }

    /**
     * 查询绘图评论列表
     *
     * @param paintComment 绘图评论
     * @return 绘图评论
     */
    @Override
    public List<PaintComment> selectPaintCommentList(PaintComment paintComment) {
        return paintCommentMapper.selectPaintCommentList(paintComment);
    }

    /**
     * 新增绘图评论
     *
     * @param paintComment 绘图评论
     * @return 结果
     */
    @Override
    public int insertPaintComment(PaintComment paintComment) {
        paintComment.setCreateTime(DateUtils.getNowDate());
        return paintCommentMapper.insertPaintComment(paintComment);
    }

    /**
     * 修改绘图评论
     *
     * @param paintComment 绘图评论
     * @return 结果
     */
    @Override
    public int updatePaintComment(PaintComment paintComment) {
        paintComment.setUpdateTime(DateUtils.getNowDate());
        return paintCommentMapper.updatePaintComment(paintComment);
    }

    /**
     * 批量删除绘图评论
     *
     * @param ids 需要删除的绘图评论主键
     * @return 结果
     */
    @Override
    public int deletePaintCommentByIds(String[] ids) {
        return paintCommentMapper.deletePaintCommentByIds(ids);
    }

    /**
     * 删除绘图评论信息
     *
     * @param id 绘图评论主键
     * @return 结果
     */
    @Override
    public int deletePaintCommentById(String id) {
        return paintCommentMapper.deletePaintCommentById(id);
    }
}
