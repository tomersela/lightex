package com.tomersela.lightex.ast;

public interface AstVisitor<T> {
    T visit(Exp expression);
    T visit(Add add);
    T visit(And and);
    T visit(Bool bool);
    T visit(Div div);
    T visit(Equal equal);
    T visit(FunctionCall functionCall);
    T visit(Greater greater);
    T visit(GreaterEqual greaterEqual);
    T visit(Less less);
    T visit(LessEqual lessEqual);
    T visit(Mod mod);
    T visit(Mul mul);
    T visit(Not not);
    T visit(NotEqual notEqual);
    T visit(Num num);
    T visit(Or or);
    T visit(PlaceHolder placeHolder);
    T visit(Pow pow);
    T visit(Sub sub);
    T visit(Text text);
    T visit(UnaryMinus unaryMinus);
    T visit(Val val);
}
