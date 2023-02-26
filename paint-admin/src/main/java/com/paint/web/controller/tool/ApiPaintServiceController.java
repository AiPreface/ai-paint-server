package com.paint.web.controller.tool;


import com.paint.common.core.domain.R;
import com.paint.service.domain.form.ApiPaintForm;
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

    /**
     * 绘画保存
     *
     * @param apiPaintForm api绘画form
     * @return {@link R}<{@link String}>
     */
    @ApiOperation("保存绘图信息")
    @PostMapping("/save")
    public R<String> paintSave(@Validated @RequestBody ApiPaintForm apiPaintForm) {
        try {
            Long paintId = paintService.savePaint(apiPaintForm);
            return R.ok(paintId.toString());
        }catch (Exception e){
            return R.fail(e.getMessage());
        }

    }



}
