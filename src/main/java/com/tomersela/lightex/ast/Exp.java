package com.tomersela.lightex.ast;

import com.tomersela.lightex.parser.Token;

public interface Exp {
    ExpType type();
    Token getToken();
    <T> T accept(AstVisitor<T> visitor);
}
