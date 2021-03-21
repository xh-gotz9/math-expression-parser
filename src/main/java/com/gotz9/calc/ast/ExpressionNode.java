package com.gotz9.calc.ast;

public class ExpressionNode implements ASTNode {

    private MultipleNode multiple;

    private AdditionNode expressionTail;

    public ExpressionNode(MultipleNode multiple, AdditionNode expressionTail) {
        this.multiple = multiple;
        this.expressionTail = expressionTail;
    }

    @Override
    public TokenTreeNodeType type() {
        return TokenTreeNodeType.EXPRESSION;
    }

    @Override
    public String toString() {
        return multiple.toString() + (expressionTail == null ? "" : " " + expressionTail);
    }
}
