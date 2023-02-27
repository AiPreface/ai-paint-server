package com.gousade.paint.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gousade.paint.entity.PaintLike;
import com.gousade.paint.mapper.PaintLikeMapper;
import com.gousade.paint.service.IPaintLikeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author woxigousade
 * @since 2023-02-24
 */
@Service
public class PaintLikeServiceImpl extends ServiceImpl<PaintLikeMapper, PaintLike> implements IPaintLikeService {
    @Override
    public boolean save(PaintLike entity) {
        PaintLike paintLike = baseMapper.select(entity.getPaintId(), entity.getUserId());
        if (paintLike == null) {
            return super.save(entity);
        } else {
            baseMapper.deleteById(paintLike.getId());
            return false;
        }
    }

    @Override
    public PaintLike select(Long paintId, String userId) {
        return baseMapper.select(paintId, userId);
    }
}
