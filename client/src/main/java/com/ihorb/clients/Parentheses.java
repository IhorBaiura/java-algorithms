package com.ihorb.clients;

import java.util.Scanner;
import com.ihorb.datastructures.stack.Stack;

public class Parentheses {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter an expression to check for balanced parentheses:");
    String input = sc.nextLine();

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);

      if (stack.isEmpty()) {
        stack.push(c);
        continue;
      }

      char current = stack.pop();

      if (!(c == ')' && current == '(') &&
          !(c == ']' && current == '[') &&
          !(c == '}' && current == '{')) {
        stack.push(current);
        stack.push(c);
      }
    }

    if (stack.isEmpty()) {
      System.out.println("Balanced parantheses");
    } else {
      System.out.println("Unbalaced parantheses");
    }

    sc.close();
  }
}
