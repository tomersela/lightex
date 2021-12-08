package com.tomersela.lightex.parser;

import com.tomersela.lightex.ast.Exp;
import com.tomersela.lightex.ast.PlaceHolder;
import com.tomersela.lightex.ast.Val;

public class LightexAst {
    private final Exp expression;
    private final Iterable<Val> vals;
    private final Iterable<PlaceHolder> placeHolders;

    public LightexAst(Exp expression, Iterable<Val> vals, Iterable<PlaceHolder> placeHolders) {
        this.expression = expression;
        this.vals = vals;
        this.placeHolders = placeHolders;
    }

    public Exp getExpression() {
        return expression;
    }

    public Iterable<Val> getVals() {
        return vals;
    }

    public Iterable<PlaceHolder> getPlaceHolders() {
        return placeHolders;
    }
}
