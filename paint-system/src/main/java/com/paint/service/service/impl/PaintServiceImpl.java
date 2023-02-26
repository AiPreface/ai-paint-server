package com.paint.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.paint.common.enums.AvailableEnum;
import com.paint.common.utils.DateUtils;
import com.paint.service.domain.Paint;
import com.paint.service.domain.PaintTag;
import com.paint.service.domain.form.ApiPaintForm;
import com.paint.service.mapper.PaintMapper;
import com.paint.service.service.IPaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.Date;
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
    public Long savePaint(ApiPaintForm apiPaintForm) {
        if (CollectionUtils.isEmpty(apiPaintForm.getTags())) {
            return null;
        }
        //校验tag是否存在且未删除和一个paintId
//        List<PaintTag> existTags = paintTagService.list(new LambdaQueryWrapper<PaintTag>()
//                .in(PaintTag::getTag, apiPaintForm.getTags())
//                .ne(PaintTag::getStatus, AvailableEnum.HAS_DELETE.getCode())
//                .groupBy(PaintTag::getPaintId)
//                .having("count(1) = {0}", apiPaintForm.getTags().size())
//        );
//        if (!CollectionUtils.isEmpty(existTags)) {
//            throw new RuntimeException("该绘图已存在");
//        }
        //校验url
        Paint paintByUrl = getOne(new LambdaQueryWrapper<Paint>()
                .eq(Paint::getImageUrl, apiPaintForm.getImageUrl())
                .ne(Paint::getStatus, AvailableEnum.HAS_DELETE.getCode())
        );
        if (paintByUrl != null) {
            throw new RuntimeException("该绘图已存在");
        }


        Paint paint = new Paint();
        paint.setUserId(apiPaintForm.getUserId());
        paint.setImageUrl(apiPaintForm.getImageUrl());
        paint.setTitle(apiPaintForm.getTitle());
        paint.setStatus(AvailableEnum.UN_AVAILABLE.getCode());
        paint.setCreateTime(LocalDateTime.now());

        if (save(paint)){
            List<PaintTag> tags = apiPaintForm.getTags().stream().map(item -> {
                PaintTag paintTag = new PaintTag();
                paintTag.setPaintId(paint.getId());
                paintTag.setTag(item);
                paintTag.setStatus(AvailableEnum.UN_AVAILABLE.getCode());
                paintTag.setCreateTime(LocalDateTime.now());
                return paintTag;
            }).collect(Collectors.toList());
            paintTagService.saveBatch(tags);
        }
        return paint.getId();
    }
}
