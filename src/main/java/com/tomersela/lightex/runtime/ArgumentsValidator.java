package com.tomersela.lightex.runtime;

import com.tomersela.lightex.types.ExpressionType;
import com.tomersela.lightex.types.values.LightexValue;

import java.text.MessageFormat;
import java.util.Arrays;

import static com.tomersela.lightex.types.ExpressionType.ANY;

public class ArgumentsValidator {

    public static void validate(String name, LightexValue[] args, ExpressionType[] expectedTypes) {
        ExpressionType[] receivedTypes = Arrays.stream(args).map(LightexValue::type).toArray(ExpressionType[]::new);
        if (!argsMatch(expectedTypes, receivedTypes)) {
            throw new LightexRuntimeException(
                    MessageFormat.format("Function ''{0}'' expects {1}{2}, but received {3}",
                            name.toUpperCase(),
                            pluralizeArguments(expectedTypes.length),
                            expectedTypes.length == 0 ? "" : " (" + toCommaSeparatedString(expectedTypes) + ")",
                            receivedTypes.length == 0 ? "no arguments" : "(" + toCommaSeparatedString(receivedTypes) + ")"
                    ));
        }
    }

    private static String toCommaSeparatedString(Object[] array) {
        return String.join(", ", Arrays.stream(array).map(Object::toString).toArray(String[]::new));
    }

    private static String pluralizeArguments(int number) {
        switch (number) {
            case 0: return "no arguments";
            case 1: return "argument of type";
            default: return "arguments of type";
        }
    }

    private static String pluralizeTypes(int number) {
        return number == 1 ? "type" : "types";
    }

    private static boolean argsMatch(ExpressionType[] registeredFunctionArgTypes, ExpressionType[] requestedFunctionArgTypes) {
        if (registeredFunctionArgTypes.length != requestedFunctionArgTypes.length) {
            return false;
        }
        for (int i = 0; i < requestedFunctionArgTypes.length; i++) {
            if (registeredFunctionArgTypes[i] != requestedFunctionArgTypes[i] && registeredFunctionArgTypes[i] != ANY) {
                return false;
            }
        }
        return true;
    }
}
