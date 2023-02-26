package com.paint.web.controller.service;

import com.paint.common.annotation.Log;
import com.paint.common.core.controller.BaseController;
import com.paint.common.core.domain.AjaxResult;
import com.paint.common.core.page.TableDataInfo;
import com.paint.common.enums.BusinessType;
import com.paint.common.utils.poi.ExcelUtil;
import com.paint.service.domain.PaintLike;
import com.paint.service.service.IPaintLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 绘图点赞Controller
 *
 * @author story-x
 * @date 2023-02-26
 */
@RestController
@RequestMapping("/service/like")
public class PaintLikeController extends BaseController {
    @Autowired
    private IPaintLikeService paintLikeService;

    /**
     * 查询绘图点赞列表
     */
    @PreAuthorize("@ss.hasPermi('service:like:list')")
    @GetMapping("/list")
    public TableDataInfo list(PaintLike paintLike) {
        startPage();
        List<PaintLike> list = paintLikeService.selectPaintLikeList(paintLike);
        return getDataTable(list);
    }

    /**
     * 导出绘图点赞列表
     */
    @PreAuthorize("@ss.hasPermi('service:like:export')")
    @Log(title = "绘图点赞", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PaintLike paintLike) {
        List<PaintLike> list = paintLikeService.selectPaintLikeList(paintLike);
        ExcelUtil<PaintLike> util = new ExcelUtil<PaintLike>(PaintLike.class);
        util.exportExcel(response, list, "绘图点赞数据");
    }

    /**
     * 获取绘图点赞详细信息
     */
    @PreAuthorize("@ss.hasPermi('service:like:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return success(paintLikeService.selectPaintLikeById(id));
    }

    /**
     * 新增绘图点赞
     */
    @PreAuthorize("@ss.hasPermi('service:like:add')")
    @Log(title = "绘图点赞", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PaintLike paintLike) {
        return toAjax(paintLikeService.insertPaintLike(paintLike));
    }

    /**
     * 修改绘图点赞
     */
    @PreAuthorize("@ss.hasPermi('service:like:edit')")
    @Log(title = "绘图点赞", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PaintLike paintLike) {
        return toAjax(paintLikeService.updatePaintLike(paintLike));
    }

    /**
     * 删除绘图点赞
     */
    @PreAuthorize("@ss.hasPermi('service:like:remove')")
    @Log(title = "绘图点赞", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(paintLikeService.deletePaintLikeByIds(ids));
    }
}
