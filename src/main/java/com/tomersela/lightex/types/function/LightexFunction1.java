package com.tomersela.lightex.types.function;

import com.tomersela.lightex.types.values.LightexValue;

public interface LightexFunction1<RT extends LightexValue, A1 extends LightexValue> {
    RT run(A1 arg1);
}
