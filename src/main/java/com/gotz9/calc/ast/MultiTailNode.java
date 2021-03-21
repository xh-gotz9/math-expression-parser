package com.gotz9.calc.ast;

import com.gotz9.calc.parse.ExpressionTokenType;

public class MultiTailNode implements ASTNode {

    private ExpressionTokenType type;

    private ValueNode node;

    public MultiTailNode(ExpressionTokenType type, ValueNode node) {
        this.type = type;
        this.node = node;
    }

    @Override
    public TokenTreeNodeType type() {
        return TokenTreeNodeType.MULTIPLE_TAIL;
    }

    @Override
    public String toString() {
        return type.toString() + ' ' + node.toString();
    }

}
