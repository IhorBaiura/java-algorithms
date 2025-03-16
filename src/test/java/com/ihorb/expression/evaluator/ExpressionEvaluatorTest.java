package com.ihorb.expression.evaluator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ExpressionEvaluatorTest {

  @Test
  public void testSimpleAddition() {
    ExpressionEvaluator evaluator = new ExpressionEvaluator();

    String expression = "(1 + 2)";

    double expected = 3.0;
    double result = evaluator.evaluate(expression);

    assertEquals("Simple addition failed", expected, result, 0.001);
  }

  @Test
  public void testComplexExpression() {
    ExpressionEvaluator evaluator = new ExpressionEvaluator();


    String expression = "(1 + ((2 + 3) * (4 * 5)))";

    double expected = 1 + ((2 + 3) * (4 * 5));
    double result = evaluator.evaluate(expression);

    assertEquals("Complex expression evaluation failed", expected, result, 0.001);
  }
}
