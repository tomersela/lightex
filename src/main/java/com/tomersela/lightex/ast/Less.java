package com.tomersela.lightex.ast;

import com.tomersela.lightex.parser.Token;

import static com.tomersela.lightex.ast.ExpType.LESS;

public class Less extends BinOp {
    public Less(Exp left, Exp right, Token token) {
        super("<", left, right, token);
    }

    @Override
    public ExpType type() {
        return LESS;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
