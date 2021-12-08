package com.tomersela.lightex.ast;

import com.tomersela.lightex.parser.Token;

import static com.tomersela.lightex.ast.ExpType.MUL;

public class Mul extends BinOp {
    public Mul(Exp left, Exp right, Token token) {
        super("*", left, right, token);
    }

    @Override
    public ExpType type() {
        return MUL;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
