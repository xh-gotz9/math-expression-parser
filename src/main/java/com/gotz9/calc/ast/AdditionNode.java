package com.gotz9.calc.ast;

import com.gotz9.calc.parse.ExpressionTokenType;

public class AdditionNode implements ASTNode {

    private ExpressionTokenType type;

    private MultipleNode multiple;

    public AdditionNode(ExpressionTokenType type, MultipleNode multiple) {
        this.type = type;
        this.multiple = multiple;
    }

    @Override
    public TokenTreeNodeType type() {
        return TokenTreeNodeType.ADDITION;
    }

    @Override
    public String toString() {
        return type.toString() + ' ' + multiple.toString();
    }
}
