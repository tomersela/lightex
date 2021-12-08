package com.tomersela.lightex.types.function;


import com.tomersela.lightex.runtime.ArgumentsValidator;
import com.tomersela.lightex.types.ExpressionType;
import com.tomersela.lightex.types.values.LightexValue;

import java.util.HashMap;
import java.util.Optional;

public class FunctionsRegistry {

    public class WithName {
        final String name;

        WithName(String name) {
            this.name = name;
        }

        public WithTypeCheck withTypeCheck(ExpressionType... expectedTypes) {
            return new WithTypeCheck(name, expectedTypes);
        }

        public void func(LightexFunctionN function) {
            registerN(name, function);
        }
    }

    public class WithTypeCheck {
        private final ExpressionType[] expectedTypes;
        private final String name;

        WithTypeCheck(String name, ExpressionType[] expectedTypes) {
            this.expectedTypes = expectedTypes;
            this.name = name;
        }

        public void func(LightexFunctionN function) {
            LightexFunctionN withValidation = args -> {
                ArgumentsValidator.validate(name, args, expectedTypes);
                return function.run(args);
            };

            registerN(name, withValidation);
        }

        public void func0(LightexFunction0 function) {
            if (expectedTypes.length != 0) throw new RuntimeException("Invalid number of types registered for validation");
            LightexFunctionN withValidation = args -> {
                ArgumentsValidator.validate(name, args, expectedTypes);
                return function.run();
            };

            registerN(name, withValidation);
        }

        public <RT extends LightexValue, A1 extends LightexValue> void func1(LightexFunction1<RT, A1> function) {
            if (expectedTypes.length != 1) throw new RuntimeException("Invalid number of types registered for validation");
            LightexFunctionN withValidation = args -> {
                ArgumentsValidator.validate(name, args, expectedTypes);
                //noinspection unchecked
                return function.run((A1) args[0]);
            };

            registerN(name, withValidation);
        }

        public <RT extends LightexValue, A1 extends LightexValue, A2 extends LightexValue> void func2(LightexFunction2<RT, A1, A2> function) {
            if (expectedTypes.length != 2) throw new RuntimeException("Invalid number of types registered for validation");
            LightexFunctionN withValidation = args -> {
                ArgumentsValidator.validate(name, args, expectedTypes);
                //noinspection unchecked
                return function.run((A1) args[0], (A2) args[1]);
            };

            registerN(name, withValidation);
        }

        public <RT extends LightexValue, A1 extends LightexValue, A2 extends LightexValue, A3 extends LightexValue> void func3(LightexFunction3<RT, A1, A2, A3> function) {
            if (expectedTypes.length != 3) throw new RuntimeException("Invalid number of types registered for validation");
            LightexFunctionN withValidation = args -> {
                ArgumentsValidator.validate(name, args, expectedTypes);
                //noinspection unchecked
                return function.run((A1) args[0], (A2) args[1], (A3) args[2]);
            };

            registerN(name, withValidation);
        }
    }

    HashMap<String, LightexFunctionN> functionsByName = new HashMap<String, LightexFunctionN>();

    public WithName register(String name) {
        return new WithName(name);
    }

    public void registerN(String name, LightexFunctionN function) {
        functionsByName.putIfAbsent(name.toUpperCase(), function);
    }

    public Optional<LightexFunctionN> get(String name) {
        return Optional.ofNullable(functionsByName.get(name.toUpperCase()));
    }
}
