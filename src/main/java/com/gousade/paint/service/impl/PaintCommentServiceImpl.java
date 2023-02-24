package com.gousade.paint.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gousade.paint.entity.PaintComment;
import com.gousade.paint.mapper.PaintCommentMapper;
import com.gousade.paint.service.IPaintCommentService;
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
public class PaintCommentServiceImpl extends ServiceImpl<PaintCommentMapper, PaintComment> implements IPaintCommentService {

}
