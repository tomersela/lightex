package com.tomersela.lightex;

import com.tomersela.lightex.ast.PlaceHolder;
import com.tomersela.lightex.ast.Val;
import com.tomersela.lightex.types.values.LightexValue;

import java.util.Map;

public interface CompiledExpression {
    Iterable<Val> getValues();
    Iterable<PlaceHolder> getPlaceHolders();
    LightexValue compute(Map<String, LightexValue> values, Map<String, LightexValue> placeHolders);
}
