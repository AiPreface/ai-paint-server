package com.gousade.paint.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gousade.paint.entity.Paint;
import com.gousade.paint.mapper.PaintMapper;
import com.gousade.paint.service.IPaintService;
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
public class PaintServiceImpl extends ServiceImpl<PaintMapper, Paint> implements IPaintService {

}
