package com.paint.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.paint.common.enums.Available;
import com.paint.common.utils.StringUtils;
import com.paint.service.domain.Paint;
import com.paint.service.domain.PaintTag;
import com.paint.service.domain.condition.ApiPaintCondition;
import com.paint.service.domain.form.ApiPaintForm;
import com.paint.service.domain.vo.PaintVo;
import com.paint.service.mapper.PaintMapper;
import com.paint.service.service.IPaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 绘图主Service业务层处理
 *
 * @author story-x
 * @date 2023-02-26
 */
@Service
public class PaintServiceImpl extends ServiceImpl<PaintMapper, Paint> implements IPaintService{

    @Autowired
    private PaintTagServiceImpl paintTagService;

    /**
     * 查询绘图主
     *
     * @param id 绘图主主键
     * @return 绘图主
     */
    @Override
    public Paint selectPaintById(String id) {
        return baseMapper.selectPaintById(id);
    }

    /**
     * 查询绘图主列表
     *
     * @param paint 绘图主
     * @return 绘图主
     */
    @Override
    public List<Paint> selectPaintList(Paint paint) {
        return baseMapper.selectPaintList(paint);
    }

    /**
     * 新增绘图主
     *
     * @param paint 绘图主
     * @return 结果
     */
    @Override
    public int insertPaint(Paint paint) {
        paint.setCreateTime(LocalDateTime.now());
        return baseMapper.insertPaint(paint);
    }

    /**
     * 修改绘图主
     *
     * @param paint 绘图主
     * @return 结果
     */
    @Override
    public int updatePaint(Paint paint) {
        paint.setUpdateTime(LocalDateTime.now());
        return baseMapper.updatePaint(paint);
    }

    /**
     * 批量删除绘图主
     *
     * @param ids 需要删除的绘图主主键
     * @return 结果
     */
    @Override
    public int deletePaintByIds(String[] ids) {
        return baseMapper.deletePaintByIds(ids);
    }

    /**
     * 删除绘图主信息
     *
     * @param id 绘图主主键
     * @return 结果
     */
    @Override
    public int deletePaintById(String id) {
        return baseMapper.deletePaintById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String ApiSavePaint(ApiPaintForm apiPaintForm) {
        //校验tag是否存在且未删除和一个paintId
//        List<PaintTag> existTags = paintTagService.list(new LambdaQueryWrapper<PaintTag>()
//                .in(PaintTag::getTag, apiPaintForm.getTags())
//                .ne(PaintTag::getStatus, Available.HAS_DELETE.getCode())
//                .groupBy(PaintTag::getPaintId)
//                .having("count(1) = {0}", apiPaintForm.getTags().size())
//        );
//        if (!CollectionUtils.isEmpty(existTags)) {
//            throw new RuntimeException("该绘图已存在");
//        }
        //校验url
        Paint paintByUrl = getOne(new LambdaQueryWrapper<Paint>()
                .eq(Paint::getImageUrl, apiPaintForm.getImageUrl())
                .ne(Paint::getStatus, Available.HAS_DELETE.getCode())
        );
        if (paintByUrl != null) {
            throw new RuntimeException("该图片已存在");
        }


        Paint paint = new Paint();
        paint.setUserId(apiPaintForm.getUserId());
        paint.setImageUrl(apiPaintForm.getImageUrl());
        paint.setLikeCount(0);
        paint.setCommentCount(0);
        paint.setTitle(apiPaintForm.getTitle());
        paint.setStatus(Available.AVAILABLE.getCode());
        paint.setCreateTime(LocalDateTime.now());

        if (save(paint)) {
            List<PaintTag> tags = apiPaintForm.getTags().stream().map(item -> {
                PaintTag paintTag = new PaintTag();
                paintTag.setPaintId(paint.getId());
                paintTag.setTag(item);
                paintTag.setStatus(Available.AVAILABLE.getCode());
                paintTag.setCreateTime(LocalDateTime.now());
                return paintTag;
            }).collect(Collectors.toList());
            paintTagService.saveBatch(tags);
        }
        return paint.getId();
    }

    /**
     * 根据userId查询图片列表
     *
     * @param condition 查询条件
     * @return {@link List}<{@link PaintVo}>
     */
    @Override
    public List<PaintVo> getImgListByUserId(ApiPaintCondition condition) {
        LambdaQueryWrapper<Paint> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Paint::getUserId, condition.getUserId())
            .ne(Paint::getStatus, Available.HAS_DELETE.getCode())
            .orderByDesc(Paint::getCreateTime);
        if (StringUtils.isNotBlank(condition.getTitle())){
            wrapper.like(Paint::getTitle, condition.getTitle());
        }
        List<PaintVo> paintVos =list(wrapper).stream().map(item -> {
            PaintVo paintVo = new PaintVo();
            paintVo.setId(item.getId());
            paintVo.setTitle(item.getTitle());
            paintVo.setImageUrl(item.getImageUrl());
            paintVo.setCommentCount(item.getCommentCount());
            paintVo.setLikeCount(item.getLikeCount());
            paintVo.setCreateTime(item.getCreateTime());
            return paintVo;
        }).collect(Collectors.toList());
        return paintVos;
    }

    /**
     * 根据userId分页查询图片列表
     *
     * @param condition 用户id
     * @return {@link List}<{@link PaintVo}>
     */
    @Override
    public Page<PaintVo> getImgPageByUserId(ApiPaintCondition condition) {
        LambdaQueryWrapper<Paint> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Paint::getUserId, condition.getUserId())
                .ne(Paint::getStatus, Available.HAS_DELETE.getCode())
                .orderByDesc(Paint::getCreateTime);
        if (StringUtils.isNotBlank(condition.getTitle())) {
            wrapper.like(Paint::getTitle, condition.getTitle());
        }
        if (!CollectionUtils.isEmpty(condition.getTags())) {
            //TODO 用户+标签搜索
//            wrapper.in(Paint::getTag, condition.getTags());
        }

        IPage<Paint> paintIPage = page(new Page<>(condition.getPage(), condition.getPageSize()), wrapper);
        List<PaintVo> paintVos = paintIPage.getRecords().stream().map(item -> {
            PaintVo paintVo = new PaintVo();
            paintVo.setId(item.getId());
            paintVo.setTitle(item.getTitle());
            paintVo.setImageUrl(item.getImageUrl());
            paintVo.setCommentCount(item.getCommentCount());
            paintVo.setLikeCount(item.getLikeCount());
            paintVo.setCreateTime(item.getCreateTime());
            return paintVo;
        }).collect(Collectors.toList());
        Page<PaintVo> paintVoPage = new Page<>();
        paintVoPage.setRecords(paintVos);
        paintVoPage.setTotal(paintIPage.getTotal());
        paintVoPage.setCurrent(paintIPage.getCurrent());
        paintVoPage.setSize(paintIPage.getSize());
        return paintVoPage;
    }

    /**
     * 根据tag分页图片列表
     *
     * @param condition 查询条件
     * @return {@link List}<{@link PaintVo}>
     */
    @Override
    public Page<PaintVo> getImgPageByTag(ApiPaintCondition condition) {
        if (CollectionUtils.isEmpty(condition.getTags())) {
            throw new RuntimeException("tags不能为空");
        }
        Page<PaintTag> paintIdPage = paintTagService.page(new Page<>(condition.getPage(), condition.getPageSize()),
                Wrappers.<PaintTag>query().select("distinct paint_id").lambda()
                        .in(PaintTag::getTag, condition.getTags())
                        .eq(PaintTag::getStatus, Available.AVAILABLE.getCode())
        );

        if (CollectionUtils.isEmpty(paintIdPage.getRecords())) {
            throw new RuntimeException("没有查询到相关图片");
        }

        List<String> paintIds = paintIdPage.getRecords().stream().map(PaintTag::getPaintId).collect(Collectors.toList());
        LambdaQueryWrapper<Paint> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(Paint::getId, paintIds)
                .ne(Paint::getStatus, Available.HAS_DELETE.getCode())
                .orderByDesc(Paint::getCreateTime);

        if (StringUtils.isNotBlank(condition.getTitle())){
            wrapper.eq(Paint::getTitle, condition.getTitle());
        }

        IPage<Paint> paintIPage = page(new Page<>(condition.getPage(), condition.getPageSize()), wrapper);
        List<PaintVo> paintVos = paintIPage.getRecords().stream().map(item -> {
            PaintVo paintVo = new PaintVo();
            paintVo.setId(item.getId());
            paintVo.setTitle(item.getTitle());
            paintVo.setImageUrl(item.getImageUrl());
            paintVo.setCommentCount(item.getCommentCount());
            paintVo.setLikeCount(item.getLikeCount());
            paintVo.setCreateTime(item.getCreateTime());
            return paintVo;
        }).collect(Collectors.toList());
        Page<PaintVo> paintVoPage = new Page<>();
        paintVoPage.setRecords(paintVos);
        paintVoPage.setTotal(paintIPage.getTotal());
        paintVoPage.setCurrent(paintIPage.getCurrent());
        paintVoPage.setSize(paintIPage.getSize());
        return paintVoPage;

    }

    /**
     * 根据tag查询图片列表
     *
     * @param condition 查询条件
     * @return {@link List}<{@link PaintVo}>
     */
    @Override
    public List<PaintVo> getImgListByTag(ApiPaintCondition condition) {
        if (CollectionUtils.isEmpty(condition.getTags())) {
            throw new RuntimeException("tags不能为空");
        }
        List<PaintTag> paintTags = paintTagService.list(new LambdaQueryWrapper<PaintTag>()
                .in(PaintTag::getTag, condition.getTags())
                .eq(PaintTag::getStatus, Available.AVAILABLE.getCode())
//                .groupBy(PaintTag::getPaintId)
        );

        if (CollectionUtils.isEmpty(paintTags)) {
           throw new RuntimeException("没有查询到相关图片");
        }

        List<String> paintIds = paintTags.stream().map(PaintTag::getPaintId).collect(Collectors.toList());
        LambdaQueryWrapper<Paint> wrapper=new LambdaQueryWrapper<>();
        wrapper.in(Paint::getId, paintIds)
                .ne(Paint::getStatus, Available.HAS_DELETE.getCode())
                .orderByDesc(Paint::getCreateTime);
        if (StringUtils.isNotBlank(condition.getTitle())){
            wrapper.eq(Paint::getTitle, condition.getTitle());
        }
        List<PaintVo> paintVos =list(wrapper).stream().map(item -> {
            PaintVo paintVo = new PaintVo();
            paintVo.setId(item.getId());
            paintVo.setTitle(item.getTitle());
            paintVo.setImageUrl(item.getImageUrl());
            paintVo.setCommentCount(item.getCommentCount());
            paintVo.setLikeCount(item.getLikeCount());
            paintVo.setCreateTime(item.getCreateTime());
            return paintVo;
        }).collect(Collectors.toList());

        return paintVos;
    }
}
