package com.tomersela.lightex.ast;

import com.tomersela.lightex.parser.Token;

public class Mod extends BinOp {
    public Mod(Exp left, Exp right, Token token) {
        super("%", left, right, token);
    }

    @Override
    public ExpType type() {
        return ExpType.MOD;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
