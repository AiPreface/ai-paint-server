package com.paint.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.paint.common.enums.Available;
import com.paint.common.enums.LikeEnum;
import com.paint.service.domain.Paint;
import com.paint.service.domain.PaintLike;
import com.paint.service.domain.form.ApiLikeForm;
import com.paint.service.mapper.PaintLikeMapper;
import com.paint.service.service.IPaintLikeService;
import com.paint.service.service.IPaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 绘图点赞Service业务层处理
 *
 * @author story-x
 * @date 2023-02-26
 */
@Service
public class PaintLikeServiceImpl extends ServiceImpl<PaintLikeMapper, PaintLike> implements IPaintLikeService {

    @Autowired
    private IPaintService paintService;
    /**
     * 查询绘图点赞
     *
     * @param id 绘图点赞主键
     * @return 绘图点赞
     */
    @Override
    public PaintLike selectPaintLikeById(String id) {
        return baseMapper.selectPaintLikeById(id);
    }

    /**
     * 查询绘图点赞列表
     *
     * @param paintLike 绘图点赞
     * @return 绘图点赞
     */
    @Override
    public List<PaintLike> selectPaintLikeList(PaintLike paintLike) {
        return baseMapper.selectPaintLikeList(paintLike);
    }

    /**
     * 新增绘图点赞
     *
     * @param paintLike 绘图点赞
     * @return 结果
     */
    @Override
    public int insertPaintLike(PaintLike paintLike) {
        paintLike.setCreateTime(LocalDateTime.now());
        return baseMapper.insertPaintLike(paintLike);
    }

    /**
     * 修改绘图点赞
     *
     * @param paintLike 绘图点赞
     * @return 结果
     */
    @Override
    public int updatePaintLike(PaintLike paintLike) {
        paintLike.setUpdateTime(LocalDateTime.now());
        return baseMapper.updatePaintLike(paintLike);
    }

    /**
     * 批量删除绘图点赞
     *
     * @param ids 需要删除的绘图点赞主键
     * @return 结果
     */
    @Override
    public int deletePaintLikeByIds(String[] ids) {
        return baseMapper.deletePaintLikeByIds(ids);
    }

    /**
     * 删除绘图点赞信息
     *
     * @param id 绘图点赞主键
     * @return 结果
     */
    @Override
    public int deletePaintLikeById(String id) {
        return baseMapper.deletePaintLikeById(id);
    }

    @Override
    public void ApiSaveLike(ApiLikeForm likeForm) {
        Paint paint = paintService.getById(likeForm.getImgId());
        if (paint == null) {
            throw new RuntimeException("图片不存在");
        }
        LikeEnum likeEnum = LikeEnum.getLikeEnum(likeForm.getLikeType());
        PaintLike paintLike = new PaintLike();
        PaintLike already = getOne(new LambdaQueryWrapper<>(new PaintLike()).eq(PaintLike::getPaintId, likeForm.getImgId()).eq(PaintLike::getUserId, likeForm.getUserId()).ne(PaintLike::getStatus, Available.HAS_DELETE.getCode()));
        if (likeEnum== LikeEnum.LIKE) {
            //判断是否已经点赞
            if (already != null) {
                throw new RuntimeException("已经点赞过了");
            }
            paintLike.setPaintId(likeForm.getImgId());
            paintLike.setUserId(likeForm.getUserId());
            paintLike.setStatus(Available.AVAILABLE.getCode());
            paintLike.setCreateTime(LocalDateTime.now());
            save(paintLike);
        } else {
            if (already == null) {
                throw new RuntimeException("还没有点赞");
            }
            already.setStatus(Available.HAS_DELETE.getCode());
            already.setUpdateTime(LocalDateTime.now());
            updateById(already);
        }
    }
}
