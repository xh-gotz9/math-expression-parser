package com.gotz9.calc;


import com.gotz9.calc.parse.ExpressionParser;
import com.gotz9.calc.ast.ExpressionNode;
import org.junit.Test;

public class ParserTest {

    @Test
    public void test() {
        ExpressionNode ast = ExpressionParser.ast("(1 + 2) / 4 + 3");
        System.out.println(ast);
    }

}
