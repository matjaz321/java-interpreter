package com.lox.expressions;

abstract class Expr {
  abstract <R> R accept(Visitor<R> visitor);
}
