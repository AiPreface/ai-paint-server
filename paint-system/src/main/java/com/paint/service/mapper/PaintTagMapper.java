package com.paint.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.paint.service.domain.PaintTag;

import java.util.List;

/**
 * 绘图tagMapper接口
 *
 * @author story-x
 * @date 2023-02-26
 */
public interface PaintTagMapper extends BaseMapper<PaintTag> {
    /**
     * 查询绘图tag
     *
     * @param id 绘图tag主键
     * @return 绘图tag
     */
    public PaintTag selectPaintTagById(String id);

    /**
     * 查询绘图tag列表
     *
     * @param paintTag 绘图tag
     * @return 绘图tag集合
     */
    public List<PaintTag> selectPaintTagList(PaintTag paintTag);

    /**
     * 新增绘图tag
     *
     * @param paintTag 绘图tag
     * @return 结果
     */
    public int insertPaintTag(PaintTag paintTag);

    /**
     * 修改绘图tag
     *
     * @param paintTag 绘图tag
     * @return 结果
     */
    public int updatePaintTag(PaintTag paintTag);

    /**
     * 删除绘图tag
     *
     * @param id 绘图tag主键
     * @return 结果
     */
    public int deletePaintTagById(String id);

    /**
     * 批量删除绘图tag
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePaintTagByIds(String[] ids);
}
