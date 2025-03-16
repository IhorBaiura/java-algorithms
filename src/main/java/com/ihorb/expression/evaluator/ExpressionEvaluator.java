package com.ihorb.expression.evaluator;

import java.util.Stack;

public class ExpressionEvaluator {
  public double evaluate(String expression) {
    Stack<String> ops = new Stack<String>();
    Stack<Double> vals = new Stack<Double>();

    String[] tokens = expression.split("");

    for (String token : tokens) {
      if (token.matches("\\d+\\.?\\d*"))  vals.push(Double.parseDouble(token));
      else if (token.matches("("))                                            ;
      else if (isOperator(token))                              ops.push(token);
      else if (token.matches(")") && !ops.isEmpty())  applyOperator(ops, vals);
    }

    while (!ops.isEmpty()) {
      applyOperator(ops, vals);
    }

    return vals.pop();
  }

  private void applyOperator(Stack<String> operators, Stack<Double> values) {
    String operator = operators.pop();
    Double value = values.pop();
    Double result = 0;

    switch (operator) {
      case "+":
        result = values.pop() + value;
        break;
      case "-":
        result = values.pop() - value;
        break;
      case "*":
        result = values.pop() * value;
        break;
      case "/":
        if (value == 0) {
          throw new ArithmeticException("Division by zero");
        }
        result = values.pop() / value;
        break;
    }

    values.push(result);
  }

  private boolean isOperator(String token) {
    return token.equals("+") || token.equals("-") || 
           token.equals("*") || token.equals("/");
  }
}
