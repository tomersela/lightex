package com.tomersela.lightex.ast;

import com.tomersela.lightex.parser.Token;

import static com.tomersela.lightex.ast.ExpType.POW;

public class Pow extends BinOp {
    public Pow(Exp left, Exp right, Token token) {
        super("^", left, right, token);
    }

    @Override
    public ExpType type() {
        return POW;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
