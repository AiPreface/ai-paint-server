package com.gousade.paint.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gousade.paint.entity.Paint;
import com.gousade.paint.entity.PaintTag;
import com.gousade.paint.entity.dto.PaintDTO;
import com.gousade.paint.mapper.PaintMapper;
import com.gousade.paint.service.IPaintService;
import com.gousade.paint.service.IPaintTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
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

    @Autowired
    public void setPaintTagService(IPaintTagService paintTagService) {
        this.paintTagService = paintTagService;
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
}
