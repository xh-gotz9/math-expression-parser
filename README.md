# math-expression-parser

数学计算式的递归下降解析器.

目前仅支持简单的四则运算, 括号. 默认以 `double` 类型进行运算.

## 文法

```
Expression:     Value Addition
Addition:       + Multipule | - Multiple | null
Multiple:       Value MultipleTail
MultipleTail:   * Value | / Value | null
Value:          ( Expression ) | number
```