package com.gousade.paint.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gousade.paint.entity.Paint;
import com.gousade.paint.entity.PaintComment;
import com.gousade.paint.entity.PaintLike;
import com.gousade.paint.entity.PaintTag;
import com.gousade.paint.entity.dto.PaintDTO;
import com.gousade.paint.mapper.PaintMapper;
import com.gousade.paint.service.IPaintCommentService;
import com.gousade.paint.service.IPaintLikeService;
import com.gousade.paint.service.IPaintService;
import com.gousade.paint.service.IPaintTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author woxigousade
 * @since 2023-02-24
 */
@Service
public class PaintServiceImpl extends ServiceImpl<PaintMapper, Paint> implements IPaintService {
    private IPaintTagService paintTagService;
    private IPaintLikeService paintLikeService;
    private IPaintCommentService paintCommentService;

    @Autowired
    public void setPaintTagService(IPaintTagService paintTagService) {
        this.paintTagService = paintTagService;
    }

    @Autowired
    public void setPaintLikeService(IPaintLikeService paintLikeService) {
        this.paintLikeService = paintLikeService;
    }

    @Autowired
    public void setPaintCommentService(IPaintCommentService paintCommentService) {
        this.paintCommentService = paintCommentService;
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void savePaint(PaintDTO dto) {
        dto.setLikeCount(0);
        dto.setCommentCount(0);
        save(dto);
        if (CollectionUtils.isEmpty(dto.getTags())) {
            return;
        }
        List<PaintTag> tags = dto.getTags().stream().map(e -> {
            PaintTag paintTag = new PaintTag();
            paintTag.setPaintId(dto.getId());
            paintTag.setTag(e);
            return paintTag;
        }).collect(Collectors.toList());
        paintTagService.saveBatch(tags);
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void like(PaintLike dto) {
        Paint paint = Objects.requireNonNull(getById(dto.getPaintId()));
        PaintLike paintLike = paintLikeService.select(dto.getPaintId(), dto.getUserId());
        if (paintLike == null) {
            paintLikeService.save(dto);
            baseMapper.incrementLikeCount(paint.getId());
        } else {
            paintLikeService.removeById(dto);
            baseMapper.decrementLikeCount(paint.getId());
        }
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void comment(PaintComment dto) {
        Paint paint = Objects.requireNonNull(getById(dto.getPaintId()));
        boolean b = paintCommentService.save(dto);
        if (b) {
            baseMapper.incrementCommentCount(paint.getId());
        }
    }

    @Transactional(rollbackFor = Throwable.class)
    @Override
    public void deleteComment(String commentId) {
        PaintComment comment = Objects.requireNonNull(paintCommentService.getById(commentId));
        boolean b = paintCommentService.removeById(commentId);
        if (b) {
            baseMapper.decrementCommentCount(comment.getPaintId());
        }
    }
}
