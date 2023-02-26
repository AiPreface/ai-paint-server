package com.paint.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.paint.service.domain.PaintComment;
import com.paint.service.domain.form.ApiCommentForm;

import java.util.List;

/**
 * 绘图评论Service接口
 *
 * @author story-x
 * @date 2023-02-26
 */
public interface IPaintCommentService extends IService<PaintComment> {
    /**
     * 查询绘图评论
     *
     * @param id 绘图评论主键
     * @return 绘图评论
     */
     PaintComment selectPaintCommentById(String id);

    /**
     * 查询绘图评论列表
     *
     * @param paintComment 绘图评论
     * @return 绘图评论集合
     */
     List<PaintComment> selectPaintCommentList(PaintComment paintComment);

    /**
     * 新增绘图评论
     *
     * @param paintComment 绘图评论
     * @return 结果
     */
     int insertPaintComment(PaintComment paintComment);

    /**
     * 修改绘图评论
     *
     * @param paintComment 绘图评论
     * @return 结果
     */
     int updatePaintComment(PaintComment paintComment);

    /**
     * 批量删除绘图评论
     *
     * @param ids 需要删除的绘图评论主键集合
     * @return 结果
     */
     int deletePaintCommentByIds(String[] ids);

    /**
     * 删除绘图评论信息
     *
     * @param id 绘图评论主键
     * @return 结果
     */
     int deletePaintCommentById(String id);

    /**
     * api保存评论
     *
     * @param commentForm 评论形式
     */
    void ApiSaveComment(ApiCommentForm commentForm);
}
