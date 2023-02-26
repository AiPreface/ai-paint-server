package com.paint.web.controller.service;

import com.paint.common.annotation.Log;
import com.paint.common.core.controller.BaseController;
import com.paint.common.core.domain.AjaxResult;
import com.paint.common.core.page.TableDataInfo;
import com.paint.common.enums.BusinessType;
import com.paint.common.utils.poi.ExcelUtil;
import com.paint.service.domain.PaintTag;
import com.paint.service.service.IPaintTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 绘图tagController
 *
 * @author story-x
 * @date 2023-02-26
 */
@RestController
@RequestMapping("/service/tag")
public class PaintTagController extends BaseController {
    @Autowired
    private IPaintTagService paintTagService;

    /**
     * 查询绘图tag列表
     */
    @PreAuthorize("@ss.hasPermi('service:tag:list')")
    @GetMapping("/list")
    public TableDataInfo list(PaintTag paintTag) {
        startPage();
        List<PaintTag> list = paintTagService.selectPaintTagList(paintTag);
        return getDataTable(list);
    }

    /**
     * 导出绘图tag列表
     */
    @PreAuthorize("@ss.hasPermi('service:tag:export')")
    @Log(title = "绘图tag", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PaintTag paintTag) {
        List<PaintTag> list = paintTagService.selectPaintTagList(paintTag);
        ExcelUtil<PaintTag> util = new ExcelUtil<PaintTag>(PaintTag.class);
        util.exportExcel(response, list, "绘图tag数据");
    }

    /**
     * 获取绘图tag详细信息
     */
    @PreAuthorize("@ss.hasPermi('service:tag:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return success(paintTagService.selectPaintTagById(id));
    }

    /**
     * 新增绘图tag
     */
    @PreAuthorize("@ss.hasPermi('service:tag:add')")
    @Log(title = "绘图tag", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PaintTag paintTag) {
        return toAjax(paintTagService.insertPaintTag(paintTag));
    }

    /**
     * 修改绘图tag
     */
    @PreAuthorize("@ss.hasPermi('service:tag:edit')")
    @Log(title = "绘图tag", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PaintTag paintTag) {
        return toAjax(paintTagService.updatePaintTag(paintTag));
    }

    /**
     * 删除绘图tag
     */
    @PreAuthorize("@ss.hasPermi('service:tag:remove')")
    @Log(title = "绘图tag", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(paintTagService.deletePaintTagByIds(ids));
    }
}
