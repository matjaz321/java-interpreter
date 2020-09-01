package com.lox.expressions;

public class Grouping extends Expr {
    final Expr expression;

    Grouping(Expr expression) {
        this.expression = expression;
    }

    @Override
    <R> R accept(Visitor<R> visitor) {
        return visitor.visitGroupingExpr(this);
    }
}