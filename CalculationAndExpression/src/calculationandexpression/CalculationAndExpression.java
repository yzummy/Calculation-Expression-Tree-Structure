/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculationandexpression;

import java.util.NoSuchElementException;

/**
 *
 * @author Yunch
 */
public class CalculationAndExpression {

    public static MyQueue convertExpression(String expression){
        MyQueue<String> output = new MyQueue<String>();
        MyStack<String> operatorStack = new MyStack<String>();
        String opr = "+-*/^";
        String[] tokens = expression.split(" ");
        
        
        for(int i = 0; i < tokens.length; i++){
            
            if(opr.indexOf(tokens[i]) >= 0){
                if(operatorStack.isEmpty()){
                    operatorStack.push(tokens[i]);
                }else{
                                                                    int a = opr.indexOf(tokens[i]);
                                                                    int b = opr.indexOf(operatorStack.peek());
                    while(operatorStack.size()>0 && opr.contains(operatorStack.peek())){
                        if(opr.indexOf(tokens[i]) <= opr.indexOf(operatorStack.peek())){
                            output.enqueue(operatorStack.pop());
                        }else{
                            break;
                        }                        
                    } 
 
                    operatorStack.push(tokens[i]);
                }
            }else if(tokens[i].equals("(")){
                operatorStack.push(tokens[i]);
            }else if(tokens[i].equals(")")){

                while(!operatorStack.peek().equals("(")){
                    try{
                        output.enqueue(operatorStack.pop());
                    }catch(NoSuchElementException e){
                        System.out.println("Mismatched \"()\"");
                    }
                    
                }
      
                                    System.out.println(operatorStack.toString());

                operatorStack.pop();
            }else{
                output.enqueue(tokens[i]);
            }
        }
        
        while(!operatorStack.isEmpty()){
            output.enqueue(operatorStack.pop());
        }
        
        return output;
    }
    
    public static float evaluateConvertedExpression(MyQueue<String> input){
        MyStack<String> calc = new MyStack<String>();
        String opr = "+-/*^";
        float tempResult = 0;
        
        while(!input.isEmpty()){
            calc.push(input.dequeue());
            
            if(opr.indexOf(calc.peek()) != -1){
                String opt = calc.pop();
                String right = calc.pop();
                String left = calc.pop();
                tempResult = evaluate(left, right, opt); 
                calc.push(String.valueOf(tempResult));
            }
        }
        return tempResult;
    }
    
    public static float evaluate(String left, String right, String operator){
        float result = 0;
        switch(operator){
            case "+":
                result = Float.parseFloat(left) + Float.parseFloat(right);
                break;
            case "-":
                result = Float.parseFloat(left) - Float.parseFloat(right);                
                break;
            case "/":
                result = Float.parseFloat(left) / Float.parseFloat(right);
                break;
            case "*":
                result = Float.parseFloat(left) * Float.parseFloat(right);
                break;
            case "^":
                result = (float) Math.pow(Float.parseFloat(left), Float.parseFloat(right));
                break;
            default:
                break;
            
        }
        
        return result;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MyQueue<String> queue;
        String  exp = "1 / 3 * 2 / 3 / 3.14 + 0.14 - 0.01 * 1.11";
        queue = convertExpression(exp);
        System.out.println(queue.toString());
        System.out.println(evaluateConvertedExpression(queue));
        
    }
    
}
