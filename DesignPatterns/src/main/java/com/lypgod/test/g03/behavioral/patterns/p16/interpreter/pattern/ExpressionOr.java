package com.lypgod.test.g03.behavioral.patterns.p16.interpreter.pattern;

/**
 * @author richard
 */
public class ExpressionOr implements Expression {
   private Expression expr1;
   private Expression expr2;
 
   ExpressionOr(Expression expr1, Expression expr2) {
      this.expr1 = expr1;
      this.expr2 = expr2;
   }
 
   @Override
   public boolean interpret(String context) {      
      return expr1.interpret(context) || expr2.interpret(context);
   }
}