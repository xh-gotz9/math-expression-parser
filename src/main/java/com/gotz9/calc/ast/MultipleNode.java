package com.gotz9.calc.ast;

public class MultipleNode implements ASTNode {

    private ValueNode value;

    private MultiTailNode multiTailNode;

    public MultipleNode(ValueNode value, MultiTailNode multiTailNode) {
        this.value = value;
        this.multiTailNode = multiTailNode;
    }

    @Override
    public TokenTreeNodeType type() {
        return TokenTreeNodeType.MULTIPLE;
    }

    @Override
    public String toString() {
        return value.toString() + (multiTailNode == null ? "" : ' ' + multiTailNode.toString());
    }
}
