package com.gousade.paint.entity.dto;

import com.gousade.paint.entity.Paint;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PaintDTO extends Paint {
    private List<String> tags;
}
