package com.lox.expressions;

public class Literal extends Expr {
    final Object value;

    Literal(Object value) {
        this.value = value;
    }

    @Override
    <R> R accept(Visitor<R> visitor) {
        return visitor.visitLiteralExpr(this);
    }
}