package com.paint.web.controller.service;

import com.paint.common.annotation.Log;
import com.paint.common.core.controller.BaseController;
import com.paint.common.core.domain.AjaxResult;
import com.paint.common.core.page.TableDataInfo;
import com.paint.common.enums.BusinessType;
import com.paint.common.utils.poi.ExcelUtil;
import com.paint.service.domain.Paint;
import com.paint.service.service.IPaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 绘图主Controller
 *
 * @author story-x
 * @date 2023-02-26
 */
@RestController
@RequestMapping("/service/paint")
public class PaintController extends BaseController {
    @Autowired
    private IPaintService paintService;

    /**
     * 查询绘图主列表
     */
    @PreAuthorize("@ss.hasPermi('service:paint:list')")
    @GetMapping("/list")
    public TableDataInfo list(Paint paint) {
        startPage();
        List<Paint> list = paintService.selectPaintList(paint);
        return getDataTable(list);
    }

    /**
     * 导出绘图主列表
     */
    @PreAuthorize("@ss.hasPermi('service:paint:export')")
    @Log(title = "绘图主", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Paint paint) {
        List<Paint> list = paintService.selectPaintList(paint);
        ExcelUtil<Paint> util = new ExcelUtil<Paint>(Paint.class);
        util.exportExcel(response, list, "绘图主数据");
    }

    /**
     * 获取绘图主详细信息
     */
    @PreAuthorize("@ss.hasPermi('service:paint:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return success(paintService.selectPaintById(id));
    }

    /**
     * 新增绘图主
     */
    @PreAuthorize("@ss.hasPermi('service:paint:add')")
    @Log(title = "绘图主", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Paint paint) {
        return toAjax(paintService.insertPaint(paint));
    }

    /**
     * 修改绘图主
     */
    @PreAuthorize("@ss.hasPermi('service:paint:edit')")
    @Log(title = "绘图主", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Paint paint) {
        return toAjax(paintService.updatePaint(paint));
    }

    /**
     * 删除绘图主
     */
    @PreAuthorize("@ss.hasPermi('service:paint:remove')")
    @Log(title = "绘图主", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(paintService.deletePaintByIds(ids));
    }
}
