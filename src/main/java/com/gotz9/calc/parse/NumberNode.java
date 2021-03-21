package com.gotz9.calc.parse;

import com.gotz9.calc.ast.TokenTreeNodeType;
import com.gotz9.calc.ast.ValueNode;

public class NumberNode extends ValueNode {

    private Number number;

    public NumberNode(Number number) {
        this.number = number;
    }

    @Override
    public TokenTreeNodeType type() {
        return TokenTreeNodeType.NUMBER;
    }

    @Override
    public String toString() {
        return number.toString();
    }

}
