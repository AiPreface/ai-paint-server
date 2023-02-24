package com.gousade.paint.controller;

import com.gousade.paint.entity.dto.PaintDTO;
import com.gousade.paint.service.IPaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/save")
    public String save(@RequestBody PaintDTO dto) {
        paintService.savePaint(dto);
        return String.valueOf(dto.getId());
    }
}
