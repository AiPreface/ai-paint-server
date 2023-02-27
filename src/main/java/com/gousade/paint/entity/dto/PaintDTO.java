package com.gousade.paint.entity.dto;

import com.gousade.paint.entity.Paint;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PaintDTO extends Paint {
    @NotEmpty(message = "[标签]不能为空")
    private List<String> tags;
}
