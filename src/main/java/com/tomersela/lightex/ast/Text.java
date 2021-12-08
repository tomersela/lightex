package com.tomersela.lightex.ast;

import com.tomersela.lightex.UnescapeJavaString;
import com.tomersela.lightex.parser.Token;

public class Text implements Exp {
    private final String text;
    private final Token token;

    public Text(String text, Token token) {
        this.text = text;
        this.token = token;
    }

    public static Text fromQuoted(String str, Token token) {
        String unescaped = UnescapeJavaString.unescape(str);
        return new Text(unescaped.substring(1, unescaped.length() - 1), token);
    }

    public String getValue() {
        return text;
    }

    @Override
    public ExpType type() {
        return ExpType.TEXT;
    }

    @Override
    public Token getToken() {
        return token;
    }

    @Override
    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return '"' + text + '"';
    }
}
