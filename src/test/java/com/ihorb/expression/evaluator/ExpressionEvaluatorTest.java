package com.ihorb.expression.evaluator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExpressionEvaluatorTest {

  @Test
  public void testSimpleAddition() {
    ExpressionEvaluator evaluator = new ExpressionEvaluator();

    String expression = "(1 + 2)";

    double expected = 3.0;
    double result = evaluator.evaluate(expression);

    assertEquals(expected, result, 0.001, "Simple addition failed");
  }

  @Test
  public void testComplexExpression() {
    ExpressionEvaluator evaluator = new ExpressionEvaluator();

    String expression = "(1 + ((2 + 3) * (4 * 5)))";

    double expected = 1 + ((2 + 3) * (4 * 5));
    double result = evaluator.evaluate(expression);

    assertEquals(expected, result, 0.001, "Complex expression evaluation failed");
  }
}
