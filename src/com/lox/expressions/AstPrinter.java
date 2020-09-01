package com.lox.expressions;

import com.lox.Token;
import com.lox.TokenType;

public class AstPrinter implements Visitor<String> {
    String print(Expr expr) {
        return expr.accept(this);
    }

    public String visitBinaryExpr(Binary expr) {
        return parenthesize(expr.operator.getLexeme(), expr.left, expr.right);
    }

    public String visitGroupingExpr(Grouping expr) {
        return parenthesize("group", expr.expression);
    }

    public String visitLiteralExpr(Literal expr) {
        if (expr.value == null) return "nil";
        return expr.value.toString();
    }

    public String visitUnaryExpr(Unary expr) {
        return parenthesize(expr.operator.getLexeme(), expr.right);
    }

    private String parenthesize(String name, Expr... exprs) {
        StringBuilder builder = new StringBuilder();

        builder.append("(").append(name);
        for (Expr expr : exprs) {
            builder.append(" ");
            builder.append(expr.accept(this));
        }
        builder.append(")");

        return builder.toString();
    }
}
