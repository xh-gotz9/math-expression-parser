package com.gotz9.calc.parse;

public class Token {

    ExpressionTokenType type;

    String text;

    public Token(ExpressionTokenType type, String text) {
        this.type = type;
        this.text = text;
    }

}