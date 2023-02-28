package com.paint.common.validation.util;

import com.paint.common.validation.constraints.FieldRepeat;
import org.springframework.stereotype.Component;

@Component
public class FieldRepeatUtils {
    public boolean isValid(Object o, FieldRepeat fieldRepeat) {
        String[] fields = fieldRepeat.fields();
        //TODO 待实现 mybatisPlus可以根据实体类找到对应的mapper层并查询数据
        return true;
    }
}
