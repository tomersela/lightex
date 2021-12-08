package com.tomersela.lightex.runtime;

import com.tomersela.lightex.ast.*;
import com.tomersela.lightex.types.TypeCheckException;
import com.tomersela.lightex.types.function.FunctionsRegistry;
import com.tomersela.lightex.types.values.*;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Map;

import static com.tomersela.lightex.types.ExpressionType.*;
import static com.tomersela.lightex.types.values.NumberValue.MATH_CONTEXT;

public class ExecutionVisitor implements AstVisitor<LightexValue> {

    private final FunctionsRegistry functionsRegistry;
    private final Map<String, LightexValue> placeHolders;
    private final Map<String, LightexValue> vals;

    public ExecutionVisitor(FunctionsRegistry functionsRegistry, Map<String, LightexValue> vals, Map<String, LightexValue> placeHolders) {
        this.functionsRegistry = functionsRegistry;
        this.placeHolders = placeHolders;
        this.vals = vals;
    }

    @Override
    public LightexValue visit(Exp expression) {
        return expression.accept(this);
    }

    private TypeCheckException opException(BinOp operator, LightexValue left, LightexValue right) {
        return new TypeCheckException(
                MessageFormat.format("Operator \"{0}\" can''t be used for types {1} and {2}",
                        operator.getSymbol(), left.type().name(), right.type().name()),
                operator.getToken()
        );
    }

    private TypeCheckException opException(UnaryOp operator, LightexValue value) {
        return new TypeCheckException(
                MessageFormat.format("Operator \"{0}\" can''t be used for type {1}",
                        operator.getSymbol(), value.type().name()),
                operator.getToken()
        );
    }

    @Override
    public LightexValue visit(Add add) {
        LightexValue left = add.getLeft().accept(this);
        LightexValue right = add.getRight().accept(this);
        if (left.type() == NUMBER && right.type() == NUMBER) {
            NumberValue leftNumber = (NumberValue) left;
            NumberValue rightNumber = (NumberValue) right;
            return new NumberValue(leftNumber.getValue().add(rightNumber.getValue()));
        } else if (left.type() == TEXT || right.type() == TEXT) {
            return new TextValue(left.toString() + right.toString());
        }

        throw opException(add, left, right);
    }

    @Override
    public LightexValue visit(And and) {
        LightexValue left = and.getLeft().accept(this);
        LightexValue right = and.getRight().accept(this);

        if (left.type() == BOOLEAN && right.type() == BOOLEAN) {
            BooleanValue leftBool = (BooleanValue) left;
            BooleanValue rightBool = (BooleanValue) right;
            return new BooleanValue(rightBool.getValue() && leftBool.getValue());
        }

        throw opException(and, left, right);
    }

    @Override
    public LightexValue visit(Bool bool) {
        return new BooleanValue(bool.getValue());
    }

    @Override
    public LightexValue visit(Div div) {
        LightexValue left = div.getLeft().accept(this);
        LightexValue right = div.getRight().accept(this);

        if (left.type() == NUMBER && right.type() == NUMBER) {
            BigDecimal leftNum = ((NumberValue) left).getValue();
            BigDecimal rightNum = ((NumberValue) right).getValue();
            if (rightNum.compareTo(BigDecimal.ZERO) == 0) {
                throw new LightexRuntimeException("Division by zero", div.getToken());
            }
            return new NumberValue(leftNum.divide(rightNum, MATH_CONTEXT));
        }

        throw opException(div, left, right);
    }

    @Override
    public LightexValue visit(Equal equal) {
        LightexValue left = equal.getLeft().accept(this);
        LightexValue right = equal.getRight().accept(this);
        return new BooleanValue(left.equals(right));
    }

    @Override
    public LightexValue visit(FunctionCall functionCall) {
        Exp[] args = functionCall.params.getExpressions();
        LightexValue[] argValues = new LightexValue[args.length];
        for (int i = 0; i < args.length; i++) {
            argValues[i] = args[i].accept(this);
        }
        try {
            return functionsRegistry.get(functionCall.getName())
                    .orElseThrow(() -> new TypeCheckException(MessageFormat.format("Invalid method ''{0}''", functionCall.getName()), functionCall.getToken()))
                    .run(argValues);
        } catch (LightexRuntimeException e) {
            throw e.withToken(functionCall.getToken());
        }
    }

    @Override
    public LightexValue visit(Greater greater) {
        LightexValue left = greater.getLeft().accept(this);
        LightexValue right = greater.getRight().accept(this);

        if (left.type() == NUMBER && right.type() == NUMBER) {
            BigDecimal leftNum = ((NumberValue) left).getValue();
            BigDecimal rightNum = ((NumberValue) right).getValue();
            return new BooleanValue(leftNum.compareTo(rightNum) > 0);
        }

        throw opException(greater, left, right);
    }

    @Override
    public LightexValue visit(GreaterEqual greaterEqual) {
        LightexValue left = greaterEqual.getLeft().accept(this);
        LightexValue right = greaterEqual.getRight().accept(this);

        if (left.type() == NUMBER && right.type() == NUMBER) {
            BigDecimal leftNum = ((NumberValue) left).getValue();
            BigDecimal rightNum = ((NumberValue) right).getValue();
            return new BooleanValue(leftNum.compareTo(rightNum) >= 0);
        }

        throw opException(greaterEqual, left, right);
    }

    @Override
    public LightexValue visit(Less less) {
        LightexValue left = less.getLeft().accept(this);
        LightexValue right = less.getRight().accept(this);

        if (left.type() == NUMBER && right.type() == NUMBER) {
            BigDecimal leftNum = ((NumberValue) left).getValue();
            BigDecimal rightNum = ((NumberValue) right).getValue();
            return new BooleanValue(leftNum.compareTo(rightNum) < 0);
        }

        throw opException(less, left, right);
    }

    @Override
    public LightexValue visit(LessEqual lessEqual) {
        LightexValue left = lessEqual.getLeft().accept(this);
        LightexValue right = lessEqual.getRight().accept(this);

        if (left.type() == NUMBER && right.type() == NUMBER) {
            BigDecimal leftNum = ((NumberValue) left).getValue();
            BigDecimal rightNum = ((NumberValue) right).getValue();
            return new BooleanValue(leftNum.compareTo(rightNum) <= 0);
        }

        throw opException(lessEqual, left, right);
    }

    @Override
    public LightexValue visit(Mod mod) {
        LightexValue left = mod.getLeft().accept(this);
        LightexValue right = mod.getRight().accept(this);

        if (left.type() == NUMBER && right.type() == NUMBER) {
            BigDecimal leftNum = ((NumberValue) left).getValue();
            BigDecimal rightNum = ((NumberValue) right).getValue();
            return new NumberValue(leftNum.remainder(rightNum, MATH_CONTEXT));
        }

        throw opException(mod, left, right);
    }

    @Override
    public LightexValue visit(Mul mul) {
        LightexValue left = mul.getLeft().accept(this);
        LightexValue right = mul.getRight().accept(this);

        if (left.type() == NUMBER && right.type() == NUMBER) {
            BigDecimal leftNum = ((NumberValue) left).getValue();
            BigDecimal rightNum = ((NumberValue) right).getValue();
            return new NumberValue(leftNum.multiply(rightNum, MATH_CONTEXT));
        } else if (left.type() == NUMBER && right.type() == MONEY) {
            BigDecimal num = ((NumberValue) left).getValue();
            MoneyValue money = ((MoneyValue) right);
            return new MoneyValue(money.getAmount().multiply(num), money.getCode());
        } else if (left.type() == MONEY && right.type() == NUMBER) {
            MoneyValue money = ((MoneyValue) left);
            BigDecimal num = ((NumberValue) right).getValue();
            return new MoneyValue(money.getAmount().multiply(num), money.getCode());
        }

        throw opException(mul, left, right);
    }

    @Override
    public LightexValue visit(Not not) {
        LightexValue value = not.getExpression().accept(this);

        if (value.type() == BOOLEAN) {
            return new BooleanValue(!((BooleanValue) value).getValue());
        }

        throw opException(not, value);
    }

    @Override
    public LightexValue visit(NotEqual notEqual) {
        LightexValue left = notEqual.getLeft().accept(this);
        LightexValue right = notEqual.getRight().accept(this);
        return new BooleanValue(!left.equals(right));
    }

    @Override
    public LightexValue visit(Num num) {
        return new NumberValue(num.getValue());
    }

    @Override
    public LightexValue visit(Or or) {
        LightexValue left = or.getLeft().accept(this);
        LightexValue right = or.getRight().accept(this);

        if (left.type() == BOOLEAN && right.type() == BOOLEAN) {
            boolean leftBool = ((BooleanValue) left).getValue();
            boolean rightBool = ((BooleanValue) right).getValue();
            return new BooleanValue(leftBool || rightBool);
        }

        throw opException(or, left, right);
    }

    @Override
    public LightexValue visit(PlaceHolder placeHolder) {
        LightexValue value = placeHolders.get(placeHolder.getId());
        if (value == null) {
            throw new LightexRuntimeException(MessageFormat.format("No value defined for {0}", placeHolder.getId()), placeHolder.getToken());
        }
        return value;
    }

    @Override
    public LightexValue visit(Pow pow) {
        LightexValue left = pow.getLeft().accept(this);
        LightexValue right = pow.getRight().accept(this);

        if (left.type() == NUMBER && right.type() == NUMBER) {
            BigDecimal leftNum = ((NumberValue) left).getValue();
            BigDecimal rightNum = ((NumberValue) right).getValue();
            return new NumberValue(leftNum.pow(rightNum.intValue(), MATH_CONTEXT));
        }

        throw opException(pow, left, right);
    }

    @Override
    public LightexValue visit(Sub sub) {
        LightexValue left = sub.getLeft().accept(this);
        LightexValue right = sub.getRight().accept(this);

        if (left.type() == NUMBER && right.type() == NUMBER) {
            BigDecimal leftNum = ((NumberValue) left).getValue();
            BigDecimal rightNum = ((NumberValue) right).getValue();
            return new NumberValue(leftNum.subtract(rightNum, MATH_CONTEXT));
        }

        throw opException(sub, left, right);
    }

    @Override
    public LightexValue visit(Text text) {
        return new TextValue(text.getValue());
    }

    @Override
    public LightexValue visit(UnaryMinus unaryMinus) {

        LightexValue value = unaryMinus.getExpression().accept(this);

        if (value.type() == NUMBER) {
            return new NumberValue(((NumberValue) value).getValue().negate());
        }

        throw opException(unaryMinus, value);
    }

    @Override
    public LightexValue visit(Val val) {
        LightexValue value = vals.get(val.getName());
        if (value == null) {
            throw new LightexRuntimeException(MessageFormat.format("No value defined for {0}", val.getName()), val.getToken());
        }
        return value;
    }
}
