package com.ihorb.clients;

import java.util.Scanner;
import com.ihorb.datastructures.stack.Stack;

public class ParenthesesWithoutLeft {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter an expression without left parentheses:");
    String input = sc.nextLine();
    sc.close();

    String[] tokens = input.split("\\s+");

    Stack<String> stack = new Stack<>();

    for (String token : tokens) {
      if (token.equals(")")) {
        String operand2 = stack.pop();
        String operator = stack.pop();
        String operand1 = stack.pop();

        String res = "( " + operand1 + " " + operator + " " + operand2 + " )";
        stack.push(res);
      } else {
        stack.push(token);
      }
    }

    String result = stack.pop();
    System.out.println(result);
  }
}
