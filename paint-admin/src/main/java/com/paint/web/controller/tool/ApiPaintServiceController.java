package com.paint.web.controller.tool;


import com.paint.common.core.domain.R;
import com.paint.service.domain.form.ApiCommentForm;
import com.paint.service.domain.form.ApiLikeForm;
import com.paint.service.domain.form.ApiPaintForm;
import com.paint.service.service.IPaintCommentService;
import com.paint.service.service.IPaintLikeService;
import com.paint.service.service.IPaintService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


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
     * 绘画保存
     *
     * @param apiPaintForm api绘画form
     * @return {@link R}<{@link String}>
     */
    @ApiOperation("保存绘图信息")
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
     * 绘画评论
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
     * 绘画点赞
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


}
