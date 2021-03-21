package com.gotz9.calc.parse;

import java.util.LinkedList;
import java.util.Queue;

import static com.gotz9.calc.parse.ExpressionTokenType.*;

public class ExpressionLexer {

    private String expression;

    private int index;

    private ExpressionTokenType token = START;

    private StringBuilder buffer = new StringBuilder();

    public ExpressionLexer(String expression) {
        this.expression = expression;
    }

    private char ch(int index) {
        if (index >= expression.length()) {
            throw new IllegalStateException("index out of bound: " + index);
        }

        return expression.charAt(index);
    }

    public ExpressionTokenType token() {
        return token;
    }

    public void next() {
        if (index + 1 >= expression.length()) {
            this.token = END;
            return;
        }

        // clean buffer
        buffer.delete(0, buffer.length());

        skipSpace();

        boolean success = scanEnd() || scanSymbol() || scanNumber();

        if (!success) {
            // syntax error: from index
        }

    }

    private boolean scanEnd() {
        if (index >= expression.length()) {
            token = END;
            return true;
        }
        return false;
    }

    private void skipSpace() {
        int i = 0;
        while (ch(index + i) == ' ') ++i;
        index += i;
    }

    private boolean scanNumber() {
        boolean res = false;
        boolean decimal = false;
        int i = 0;
        while (index + i < expression.length()) {
            char ch = ch(index + i);
            if (!(ch >= '0' && ch <= '9')) { // not number character
                if (ch == '.' && !decimal) { // is first decimal
                    decimal = true;
                } else {
                    //
                    break;
                }
            }
            buffer.append(ch);
            i++;
        }

        if (i > 0) {
            res = true;
            token = NUMBER;
            index += i;
        }

        return res;
    }

    private boolean scanSymbol() {
        char ch = ch(index);

        switch (ch) {
            case '+':
                token = PLUS;
                break;
            case '-':
                token = MINUS;
                break;
            case '*':
                token = MULTI;
                break;
            case '/':
                token = DIVISION;
                break;
            case '(':
                token = LBRACE;
                break;
            case ')':
                token = RBRACE;
                break;
            default:
                return false;
        }
        buffer.append(ch);
        ++index;
        return true;
    }

    public Queue<Token> tokens() {
        LinkedList<Token> nodes = new LinkedList<>();
        while (true) {
            Token tokenNode = new Token(token, buffer.toString());
            if (token == END) break;

            if (token != START)
                nodes.add(tokenNode);

            next();
        }
        return nodes;
    }


}
