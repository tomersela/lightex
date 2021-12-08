package com.tomersela.lightex.types.function;

import com.tomersela.lightex.types.values.LightexValue;

public interface LightexFunction3<RT extends LightexValue, A1 extends LightexValue, A2 extends LightexValue, A3 extends LightexValue> {
    RT run(A1 arg1, A2 arg2, A3 arg3);
}
