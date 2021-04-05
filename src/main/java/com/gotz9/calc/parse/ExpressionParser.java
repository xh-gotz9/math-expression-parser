package com.gotz9.calc.parse;

import com.gotz9.calc.ast.*;

import java.util.Queue;

import static com.gotz9.calc.parse.ExpressionTokenType.*;

/**
 * Expression: Value Value
 */
public class ExpressionParser {

    public static ExpressionNode ast(String source) {
        ExpressionLexer expressionLexer = new ExpressionLexer(source);
        Queue<Token> tokens = expressionLexer.tokens();

        return express(tokens);
    }

    /**
     * Expression: Multiple Addition
     */
    private static ExpressionNode express(Queue<Token> tokens) {
        MultipleNode multiple = multiple(tokens);
        AdditionNode AdditionNode = addition(tokens);
        return new ExpressionNode(multiple, AdditionNode);
    }

    /**
     * Addition: + Multiple | - Multiple | null
     */
    private static AdditionNode addition(Queue<Token> tokens) {
        ExpressionTokenType type = peek(tokens);
        switch (type) {
            case PLUS:
            case MINUS:
                Token token = match(tokens, type);
                MultipleNode multiple = multiple(tokens);
                return new AdditionNode(token.type, multiple);
            case END:
                return null;
            default:
                throw new IllegalStateException("unmatched token");
        }
    }

    /**
     * Multiple: Value MultipleTail
     */
    private static MultipleNode multiple(Queue<Token> tokens) {
        ValueNode value = value(tokens);
        MultiTailNode multiTailNode = multipleTail(tokens);
        return new MultipleNode(value, multiTailNode);
    }

    /**
     * MultiTail: * Value | / Value | null
     */
    private static MultiTailNode multipleTail(Queue<Token> tokens) {
        ExpressionTokenType type = peek(tokens);
        switch (type) {
            case MULTI:
            case DIVISION:
                Token token = match(tokens, type);
                ValueNode value = value(tokens);
                return new MultiTailNode(token.type, value);
            case END:
            default:
                return null;
        }
    }

    /**
     * Value: (Expression) | number
     *
     * @return
     */
    private static ValueNode value(Queue<Token> tokens) {
        switch (peek(tokens)) {
            case LBRACE:
                return factorExpression(tokens);
            case MINUS:
                match(tokens, MINUS);
                return number(tokens, -1);
            case NUMBER:
                return number(tokens, 1);
            default:
                throw new IllegalStateException();
        }
    }

    /**
     * (Expression)
     */
    private static FactorNode factorExpression(Queue<Token> tokens) {
        Token lbrace = match(tokens, LBRACE);
        ExpressionNode express = express(tokens);
        match(tokens, RBRACE);
        return new FactorNode(express);
    }

    /**
     * number
     */
    private static NumberNode number(Queue<Token> tokens, int bonus) {
        Token token = match(tokens, NUMBER);
        return new NumberNode(Double.parseDouble(token.text) * bonus);
    }

    private static ExpressionTokenType peek(Queue<Token> tokens) {
        Token node = tokens.peek();

        if (node == null) {
            return END;
        }

        return node.type;
    }

    private static Token match(Queue<Token> tokens, ExpressionTokenType type) {
        Token node = tokens.poll();
        if (node == null) {
            throw new IllegalStateException();
        }

        if (type != node.type) {
            throw new IllegalStateException("unmatched type. match " + type + ", except " + node.type);
        }

        return node;
    }

}
