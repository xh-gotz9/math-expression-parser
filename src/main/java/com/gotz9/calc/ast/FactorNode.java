package com.gotz9.calc.ast;

public class FactorNode extends ValueNode {

    private ExpressionNode expression;

    public FactorNode(ExpressionNode expression) {
        this.expression = expression;
    }

    @Override
    public TokenTreeNodeType type() {
        return TokenTreeNodeType.FACTOR_EXPRESSION;
    }

    @Override
    public String toString() {
        return '(' + expression.toString() + ')';
    }
}
