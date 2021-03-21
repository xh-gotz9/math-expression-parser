package com.gotz9.calc.parse;

public enum ExpressionTokenType {
    START,
    END,

    NUMBER,
    /**
     * '.'
     */
    DECI,
    /**
     * '+'
     */
    PLUS,
    /**
     * '-'
     */
    MINUS,
    /**
     * '*'
     */
    MULTI,
    /**
     * '/'
     */
    DIVISION,
    /**
     * '('
     */
    LBRACE,
    /**
     * ')'
     */
    RBRACE,
}