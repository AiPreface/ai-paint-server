package com.paint.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.paint.common.enums.Available;
import com.paint.service.domain.Paint;
import com.paint.service.domain.PaintComment;
import com.paint.service.domain.form.ApiCommentForm;
import com.paint.service.mapper.PaintCommentMapper;
import com.paint.service.service.IPaintCommentService;
import com.paint.service.service.IPaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 绘图评论Service业务层处理
 *
 * @author story-x
 * @date 2023-02-26
 */
@Service
public class PaintCommentServiceImpl extends ServiceImpl<PaintCommentMapper, PaintComment> implements IPaintCommentService {


    @Autowired
    private IPaintService paintService;
    /**
     * 查询绘图评论
     *
     * @param id 绘图评论主键
     * @return 绘图评论
     */
    @Override
    public PaintComment selectPaintCommentById(String id) {
        return baseMapper.selectPaintCommentById(id);
    }

    /**
     * 查询绘图评论列表
     *
     * @param paintComment 绘图评论
     * @return 绘图评论
     */
    @Override
    public List<PaintComment> selectPaintCommentList(PaintComment paintComment) {
        return baseMapper.selectPaintCommentList(paintComment);
    }

    /**
     * 新增绘图评论
     *
     * @param paintComment 绘图评论
     * @return 结果
     */
    @Override
    public int insertPaintComment(PaintComment paintComment) {
        paintComment.setCreateTime(LocalDateTime.now());
        return baseMapper.insertPaintComment(paintComment);
    }

    /**
     * 修改绘图评论
     *
     * @param paintComment 绘图评论
     * @return 结果
     */
    @Override
    public int updatePaintComment(PaintComment paintComment) {
        paintComment.setUpdateTime(LocalDateTime.now());
        return baseMapper.updatePaintComment(paintComment);
    }

    /**
     * 批量删除绘图评论
     *
     * @param ids 需要删除的绘图评论主键
     * @return 结果
     */
    @Override
    public int deletePaintCommentByIds(String[] ids) {
        return baseMapper.deletePaintCommentByIds(ids);
    }

    /**
     * 删除绘图评论信息
     *
     * @param id 绘图评论主键
     * @return 结果
     */
    @Override
    public int deletePaintCommentById(String id) {
        return baseMapper.deletePaintCommentById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void ApiSaveComment(ApiCommentForm commentForm) {
        Paint paint = paintService.getById(commentForm.getImgId());
        if (paint == null) {
           throw new RuntimeException("图片不存在");
        }
        PaintComment paintComment = new PaintComment();
        paintComment.setPaintId(paint.getId());
        paintComment.setUserId(commentForm.getUserId());
        paintComment.setComment(commentForm.getDiscuss());
        paintComment.setCreateTime(LocalDateTime.now());
        paintComment.setStatus(Available.AVAILABLE.getCode());
        if (save(paintComment)) {
           synchronized (this) {
               paint = paintService.selectPaintById(commentForm.getImgId());
               paint.setCommentCount(paint.getCommentCount() + 1);
               paint.setUpdateTime(LocalDateTime.now());
               paintService.updatePaint(paint);
           }
        }
    }
}
