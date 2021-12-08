package com.tomersela.lightex;


import com.tomersela.lightex.ast.PlaceHolder;
import com.tomersela.lightex.ast.Val;
import com.tomersela.lightex.parser.LightexAst;
import com.tomersela.lightex.parser.LightexParser;
import com.tomersela.lightex.parser.exceptions.LightexParseException;
import com.tomersela.lightex.runtime.ExecutionVisitor;
import com.tomersela.lightex.types.function.FunctionsRegistry;
import com.tomersela.lightex.types.values.LightexValue;

import java.util.Map;

public class LightexCompiler {

    private final FunctionsRegistry functionsRegistry;

    public LightexCompiler(FunctionsRegistry functionsRegistry) {
        this.functionsRegistry = functionsRegistry;
    }

    public CompiledExpression compile(String expression) throws LightexParseException {
        LightexAst ast = LightexParser.parse(expression);
        return new CompiledExpression() {
            @Override
            public Iterable<Val> getValues() {
                return ast.getVals();
            }

            @Override
            public Iterable<PlaceHolder> getPlaceHolders() {
                return ast.getPlaceHolders();
            }

            @Override
            public LightexValue compute(Map<String, LightexValue> values, Map<String, LightexValue> placeHolders) {
                ExecutionVisitor visitor = new ExecutionVisitor(functionsRegistry, values, placeHolders);
                return visitor.visit(ast.getExpression());
            }
        };
    }
}
