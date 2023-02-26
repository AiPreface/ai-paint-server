package com.paint.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.paint.common.utils.DateUtils;
import com.paint.service.domain.PaintTag;
import com.paint.service.mapper.PaintTagMapper;
import com.paint.service.service.IPaintTagService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 绘图tagService业务层处理
 *
 * @author story-x
 * @date 2023-02-26
 */
@Service
public class PaintTagServiceImpl extends ServiceImpl<PaintTagMapper, PaintTag> implements IPaintTagService{

    /**
     * 查询绘图tag
     *
     * @param id 绘图tag主键
     * @return 绘图tag
     */
    @Override
    public PaintTag selectPaintTagById(String id) {
        return baseMapper.selectPaintTagById(id);
    }

    /**
     * 查询绘图tag列表
     *
     * @param paintTag 绘图tag
     * @return 绘图tag
     */
    @Override
    public List<PaintTag> selectPaintTagList(PaintTag paintTag) {
        return baseMapper.selectPaintTagList(paintTag);
    }

    /**
     * 新增绘图tag
     *
     * @param paintTag 绘图tag
     * @return 结果
     */
    @Override
    public int insertPaintTag(PaintTag paintTag) {
        return baseMapper.insertPaintTag(paintTag);
    }

    /**
     * 修改绘图tag
     *
     * @param paintTag 绘图tag
     * @return 结果
     */
    @Override
    public int updatePaintTag(PaintTag paintTag) {
        return baseMapper.updatePaintTag(paintTag);
    }

    /**
     * 批量删除绘图tag
     *
     * @param ids 需要删除的绘图tag主键
     * @return 结果
     */
    @Override
    public int deletePaintTagByIds(String[] ids) {
        return baseMapper.deletePaintTagByIds(ids);
    }

    /**
     * 删除绘图tag信息
     *
     * @param id 绘图tag主键
     * @return 结果
     */
    @Override
    public int deletePaintTagById(String id) {
        return baseMapper.deletePaintTagById(id);
    }
}
