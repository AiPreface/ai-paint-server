package com.gousade.paint.controller;

import com.gousade.paint.entity.PaintComment;
import com.gousade.paint.entity.PaintLike;
import com.gousade.paint.entity.dto.PaintDTO;
import com.gousade.paint.service.IPaintService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author woxigousade
 * @since 2023-02-24
 */
@RestController
@RequestMapping("/paint")
public class PaintController {
    private IPaintService paintService;

    @Autowired
    public void setPaintService(IPaintService paintService) {
        this.paintService = paintService;
    }

    @ApiOperation(value = "保存绘图数据")
    @PostMapping("/save")
    public String save(@RequestBody PaintDTO dto) {
        paintService.savePaint(dto);
        return String.valueOf(dto.getId());
    }

    @ApiOperation(value = "点赞作品")
    @PostMapping("/like")
    public void like(@RequestBody PaintLike dto) {
        paintService.like(dto);
    }

    @ApiOperation(value = "评论作品")
    @PostMapping("/comment")
    public void comment(@RequestBody PaintComment dto) {
        paintService.comment(dto);
    }

    @ApiOperation(value = "删除评论")
    @DeleteMapping("/deleteComment/{commentId}")
    public void deleteComment(@PathVariable String commentId) {
        paintService.deleteComment(commentId);
    }
}
