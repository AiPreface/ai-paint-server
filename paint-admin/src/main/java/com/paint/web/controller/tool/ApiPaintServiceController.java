package com.paint.web.controller.tool;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.paint.common.core.domain.ApiBaseCondition;
import com.paint.common.core.domain.R;
import com.paint.service.domain.Paint;
import com.paint.service.domain.condition.ApiPaintCondition;
import com.paint.service.domain.form.ApiCommentForm;
import com.paint.service.domain.form.ApiLikeForm;
import com.paint.service.domain.form.ApiPaintForm;
import com.paint.service.domain.vo.PaintVo;
import com.paint.service.service.IPaintCommentService;
import com.paint.service.service.IPaintLikeService;
import com.paint.service.service.IPaintService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(tags = {"绘图服务API"})
@RestController
@RequestMapping("/api/paint")
public class ApiPaintServiceController {
    @Autowired
    private IPaintService paintService;
    @Autowired
    private IPaintCommentService paintCommentService;
    @Autowired
    private IPaintLikeService paintLikeService;
    /**
     * 图片保存
     *
     * @param apiPaintForm api图片form
     * @return {@link R}<{@link String}>
     */
    @ApiOperation("保存图片信息")
    @PostMapping("/saveImg")
    public R<String> paintSave(@Validated @RequestBody ApiPaintForm apiPaintForm) {
        try {
            String paintId = paintService.ApiSavePaint(apiPaintForm);
            return R.ok(paintId);
        }catch (Exception e){
            return R.fail(e.getMessage());
        }

    }

    /**
     * 图片评论
     *
     * @param commentForm 评论form
     * @return {@link R}<{@link String}>
     */
    @ApiOperation("评论信息")
    @PostMapping("/imgComment")
    public R<String> imgComment(@Validated @RequestBody ApiCommentForm commentForm) {
        try {
            paintCommentService.ApiSaveComment(commentForm);
            return R.ok();
        }catch (Exception e){
            return R.fail(e.getMessage());
        }
    }

    /**
     * 图片点赞
     *
     * @param likeForm 点赞form
     * @return {@link R}<{@link String}>
     */
    @ApiOperation("点赞信息")
    @PostMapping("/imgLike")
    public R<String> imgLike(@Validated @RequestBody ApiLikeForm likeForm) {
        try {
            paintLikeService.ApiSaveLike(likeForm);
            return R.ok();
        }catch (Exception e){
            return R.fail(e.getMessage());
        }
    }


    /**
     *根据userId查询图片list
     */
    @ApiOperation("根据userId分页查询图片列表")
    @PostMapping("/getImgPageByUserId")
    public R<Page<PaintVo>> getImgPageByUserId(@Validated @RequestBody ApiPaintCondition condition) {
        try {
            Page<PaintVo> paintVoList = paintService.getImgPageByUserId(condition);
            return R.ok(paintVoList);
        }catch (Exception e){
            return R.fail(e.getMessage());
        }
    }

    @ApiOperation("根据userId查询全部图片列表")
    @PostMapping("/getImgListByUserId")
    public R<List<PaintVo>> getImgListByUserId(@Validated @RequestBody ApiPaintCondition condition) {
        try {
            List<PaintVo> paintVoList = paintService.getImgListByUserId(condition);
            return R.ok(paintVoList);
        }catch (Exception e){
            return R.fail(e.getMessage());
        }
    }
    /**
     *根据userId查询图片list
     */
    @ApiOperation("根据tag分页查询图片列表")
    @PostMapping("/getImgPageByTag")
    public R<Page<PaintVo>> getImgPageByTag(@Validated @RequestBody ApiPaintCondition condition) {
        try {
            Page<PaintVo> paintVoList = paintService.getImgPageByTag(condition);
            return R.ok(paintVoList);
        }catch (Exception e){
            return R.fail(e.getMessage());
        }
    }


    @ApiOperation("根据tag查询全部图片列表")
    @PostMapping("/getImgListByTag")
    public R<List<PaintVo>> getImgListByTag(@Validated @RequestBody ApiPaintCondition condition) {
        try {
            List<PaintVo> paintVoList = paintService.getImgListByTag(condition);
            return R.ok(paintVoList);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }


    @ApiOperation("分页查询绘图今日排行榜")
    @PostMapping("/rankToday")
    public R<Page<Paint>> rankToday(@Validated @RequestBody ApiBaseCondition condition) {
        try {
            Page<Paint> list = paintService.rankToday(condition);
            return R.ok(list);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

    @ApiOperation("分页查询绘图本周排行榜")
    @PostMapping("/rankWeek")
    public R<Page<Paint>> rankWeek(@Validated @RequestBody ApiBaseCondition condition) {
        try {
            Page<Paint> list = paintService.rankWeek(condition);
            return R.ok(list);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }

    @ApiOperation("分页查询绘图本月排行榜")
    @PostMapping("/rankMonth")
    public R<Page<Paint>> rankMonth(@Validated @RequestBody ApiBaseCondition condition) {
        try {
            Page<Paint> list = paintService.rankMonth(condition);
            return R.ok(list);
        } catch (Exception e) {
            return R.fail(e.getMessage());
        }
    }
}
