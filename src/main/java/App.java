import com.tomersela.lightex.parser.LightexAst;
import com.tomersela.lightex.parser.LightexParser;
import com.tomersela.lightex.runtime.LightexRuntimeException;
import com.tomersela.lightex.runtime.ExecutionVisitor;
import com.tomersela.lightex.types.TypeCheckException;
import com.tomersela.lightex.types.function.FunctionsRegistry;
import com.tomersela.lightex.types.values.*;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.tomersela.lightex.types.ExpressionType.*;

public class App {
    public static void main(String[] argss) throws Exception {
//        long startTime = System.nanoTime();
        try {
//            LightexAst ast = LightexParser.parse("e ^ !(-sin(\"1\", 2.2 * t5(), i, true) * 2) ^ abc");
//            LightexAst ast = LightexParser.parse("lower(\"\", a)+\"xscsc*cos(8)\"");
//            LightexAst ast = LightexParser.parse("{{\"/work/site\"}}^{{d}}^{{xyz}}\"");
//            LightexAst ast = LightexParser.parse("x > 1 and y or z != f and 9 <= 1 * f()");
//            LightexAst ast = LightexParser.parse("/*x*/");
//            LightexAst ast = LightexParser.parse("x or y");
//            LightexAst ast = LightexParser.parse("(1+1)*sin(-1,2)");
//            LightexAst ast = LightexParser.parse("2*1");
//            long stopTime = System.nanoTime();
//        System.out.println(stopTime - startTime);
//            String vals = "Vals: " + StreamSupport.stream(ast.getVals().spliterator(), false)
//                    .map(Val::getName)
//                    .collect(Collectors.joining(" "));
//            String palceHolders = "PlaceHolders: " + StreamSupport.stream(ast.getPlaceHolders().spliterator(), false)
//                    .map(PlaceHolder::getId)
//                    .collect(Collectors.joining(" "));
//            System.out.println(vals);
//            System.out.println(palceHolders);
//            new FunctionsRegistry().register(new Concat());
            FunctionsRegistry registry = new FunctionsRegistry();
            registry.register("RAND")
                    .withTypeCheck()
                    .func0(() -> new NumberValue(BigDecimal.valueOf(Math.random())));
            registry.register("FIRST")
                    .withTypeCheck(ARRAY)
                    .<LightexValue, ArrayValue>func1((arr) -> {
                        try {
                            return arr.getValues()[0];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            throw new LightexRuntimeException("received empty array");
                        }
                    });
            registry.register("LAST")
                    .withTypeCheck(ARRAY)
                    .<LightexValue, ArrayValue>func1((arr) -> {
                        try {
                            return arr.getValues()[arr.getValues().length - 1];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            throw new LightexRuntimeException("received empty array");
                        }
                    });
            registry.register("MONEY")
                    .withTypeCheck(NUMBER, TEXT)
                    .<MoneyValue, NumberValue, TextValue>func2((amount, symbol) -> new MoneyValue(amount.getValue(), symbol.getValue()));
            registry.register("IF")
                    .withTypeCheck(BOOLEAN, ANY, ANY)
                    .<LightexValue, BooleanValue, LightexValue, LightexValue>func3((cond, ifTrue, ifFalse) -> cond.getValue() ? ifTrue : ifFalse);
            registry.register("SPLIT")
                    .withTypeCheck(TEXT, TEXT)
                    .<ArrayValue, TextValue, TextValue>func2((text, regex) -> {
                        String[] arr = text.getValue().split(regex.getValue());
                        LightexValue[] lightexValues = new LightexValue[arr.length];
                        for (int i = 0; i < arr.length; i++) {
                            lightexValues[i] = new TextValue(arr[i]);
                        }
                        return new ArrayValue(lightexValues);
                    });

            registry.register("ADD")
                    .func((args) -> {
                        if (args.length != 2) {
                            throw new LightexRuntimeException("Function 'ADD' takes 2 arguments");
                        }
                        LightexValue arg1 = args[0];
                        LightexValue arg2 = args[1];
                        if (arg1.type() == TEXT || arg2.type() == TEXT) {
                            return new TextValue(arg1.toString() + arg2.toString());
                        } else if (arg1.type() == NUMBER && arg2.type() == NUMBER) {
                            return new NumberValue(((NumberValue)arg1).getValue().add(((NumberValue)arg2).getValue()));
                        }
                        throw new LightexRuntimeException(MessageFormat.format("Function 'ADD' called with invalid value types - {0}, {1}", arg1.type().name(), arg2.type().name()));
                    });
            registry.register("OR")
                    .withTypeCheck(BOOLEAN, BOOLEAN)
                    .<BooleanValue, BooleanValue, BooleanValue>func2((arg1, arg2) -> new BooleanValue(arg1.getValue() || arg2.getValue()));
            registry.register("NOT")
                    .withTypeCheck(BOOLEAN)
                    .<BooleanValue, BooleanValue>func1(arg -> new BooleanValue(!arg.getValue()));
            registry.register("CONCAT")
                    .func(args -> new TextValue(String.join("", Arrays.stream(args).map(Object::toString).toArray(String[]::new))));

            Map<String, LightexValue> placeHolders = new HashMap<String, LightexValue>() {{
                put("/work/start date", new NumberValue(new BigDecimal(3)));
                put("b2", new NumberValue(new BigDecimal(2)));
                put("b3", new BooleanValue(true));
            }};
            long startTime = System.nanoTime();
            LightexAst ast = LightexParser.parse("\"random number: \" + {{/work/start date}} * RAND()");
            long stopTime = System.nanoTime();
            System.out.println((stopTime - startTime) + "ns: " + ast.getExpression());
            startTime = System.nanoTime();
            LightexValue result = new ExecutionVisitor(registry, Collections.emptyMap(), placeHolders).visit(ast.getExpression());
            stopTime = System.nanoTime();
            System.out.println((stopTime - startTime) + "ns: " + result);
            startTime = System.nanoTime();
            ast = LightexParser.parse("IF(RAND() > 0.1, MONEY(5, 'USD') * 5, FIRST(SPLIT('a,b,c,d', ',')))");
            stopTime = System.nanoTime();
            System.out.println((stopTime - startTime) + "ns: " + ast.getExpression());
            startTime = System.nanoTime();
            result = new ExecutionVisitor(registry, Collections.emptyMap(), placeHolders).visit(ast.getExpression());
            stopTime = System.nanoTime();
            System.out.println((stopTime - startTime) + "ns: " + result);
        } catch (TypeCheckException e) {
            System.out.println(e.getMessage());
            System.out.println("line: " + e.getToken().beginLine + "; column: " + e.getToken().beginColumn);
        } catch (LightexRuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}
