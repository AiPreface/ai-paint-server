package com.paint.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.paint.common.core.domain.R;
import com.paint.service.domain.Paint;
import com.paint.service.domain.form.ApiPaintForm;

import java.util.List;

/**
 * 绘图主Service接口
 *
 * @author story-x
 * @date 2023-02-26
 */
public interface IPaintService extends IService<Paint> {
    /**
     * 查询绘图主
     *
     * @param id 绘图主主键
     * @return 绘图主
     */
     Paint selectPaintById(String id);

    /**
     * 查询绘图主列表
     *
     * @param paint 绘图主
     * @return 绘图主集合
     */
     List<Paint> selectPaintList(Paint paint);

    /**
     * 新增绘图主
     *
     * @param paint 绘图主
     * @return 结果
     */
    public int insertPaint(Paint paint);

    /**
     * 修改绘图主
     *
     * @param paint 绘图主
     * @return 结果
     */
     int updatePaint(Paint paint);

    /**
     * 批量删除绘图主
     *
     * @param ids 需要删除的绘图主主键集合
     * @return 结果
     */
     int deletePaintByIds(String[] ids);

    /**
     * 删除绘图主信息
     *
     * @param id 绘图主主键
     * @return 结果
     */
     int deletePaintById(String id);

    /**
     * 绘画保存
     *
     * @param apiPaintForm api绘画form
     * @return {@link R}<{@link String}>
     */
    String ApiSavePaint(ApiPaintForm apiPaintForm);
}
