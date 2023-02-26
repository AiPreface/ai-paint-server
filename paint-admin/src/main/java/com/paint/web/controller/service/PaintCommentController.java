package com.paint.web.controller.service;

import com.paint.common.annotation.Log;
import com.paint.common.core.controller.BaseController;
import com.paint.common.core.domain.AjaxResult;
import com.paint.common.core.page.TableDataInfo;
import com.paint.common.enums.BusinessType;
import com.paint.common.utils.poi.ExcelUtil;
import com.paint.service.domain.PaintComment;
import com.paint.service.service.IPaintCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 绘图评论Controller
 *
 * @author story-x
 * @date 2023-02-26
 */
@RestController
@RequestMapping("/service/comment")
public class PaintCommentController extends BaseController {
    @Autowired
    private IPaintCommentService paintCommentService;

    /**
     * 查询绘图评论列表
     */
    @PreAuthorize("@ss.hasPermi('service:comment:list')")
    @GetMapping("/list")
    public TableDataInfo list(PaintComment paintComment) {
        startPage();
        List<PaintComment> list = paintCommentService.selectPaintCommentList(paintComment);
        return getDataTable(list);
    }

    /**
     * 导出绘图评论列表
     */
    @PreAuthorize("@ss.hasPermi('service:comment:export')")
    @Log(title = "绘图评论", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PaintComment paintComment) {
        List<PaintComment> list = paintCommentService.selectPaintCommentList(paintComment);
        ExcelUtil<PaintComment> util = new ExcelUtil<PaintComment>(PaintComment.class);
        util.exportExcel(response, list, "绘图评论数据");
    }

    /**
     * 获取绘图评论详细信息
     */
    @PreAuthorize("@ss.hasPermi('service:comment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return success(paintCommentService.selectPaintCommentById(id));
    }

    /**
     * 新增绘图评论
     */
    @PreAuthorize("@ss.hasPermi('service:comment:add')")
    @Log(title = "绘图评论", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PaintComment paintComment) {
        return toAjax(paintCommentService.insertPaintComment(paintComment));
    }

    /**
     * 修改绘图评论
     */
    @PreAuthorize("@ss.hasPermi('service:comment:edit')")
    @Log(title = "绘图评论", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PaintComment paintComment) {
        return toAjax(paintCommentService.updatePaintComment(paintComment));
    }

    /**
     * 删除绘图评论
     */
    @PreAuthorize("@ss.hasPermi('service:comment:remove')")
    @Log(title = "绘图评论", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(paintCommentService.deletePaintCommentByIds(ids));
    }
}
