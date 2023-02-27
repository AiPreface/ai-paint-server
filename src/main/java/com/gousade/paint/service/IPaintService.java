package com.gousade.paint.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gousade.paint.entity.Paint;
import com.gousade.paint.entity.PaintComment;
import com.gousade.paint.entity.PaintLike;
import com.gousade.paint.entity.dto.PaintDTO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author woxigousade
 * @since 2023-02-24
 */
public interface IPaintService extends IService<Paint> {

    void savePaint(PaintDTO dto);

    void like(PaintLike dto);

    void comment(PaintComment dto);

    void deleteComment(String commentId);
}
