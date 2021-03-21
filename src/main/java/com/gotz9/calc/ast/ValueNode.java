package com.gotz9.calc.ast;

public abstract class ValueNode implements ASTNode {

    @Override
    public TokenTreeNodeType type() {
        return TokenTreeNodeType.VALUE;
    }

}
