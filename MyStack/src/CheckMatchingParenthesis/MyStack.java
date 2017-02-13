/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CheckMatchingParenthesis;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Yunch
 */
public class MyStack<Item> extends LinkedList<Item>{

//    private int n;
//    private Node first;
//
//    private class ListIterator implements Iterator<Item> {
//
//        private Node current = first;
//        
//        public ListIterator() {
//        }
//
//        @Override
//        public boolean hasNext() {
//            return current != null;
//        }
//
//        @Override
//        public Item next() {
//            if(!hasNext()){
//                throw new NoSuchElementException();
//            }
//            Item item = current.item;
//            current = current.next;
//            return item;
//        }
//    }
//    
//
//    private class Node {
//        private Item item;
//        private Node next;
//    }

    public MyStack(){
        first = null;
        n = 0;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public int size(){
        return n;
    }
    
    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }
    
    public Item pop(){
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }
    
    public Item peek(){
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }
    
    public String toString(){
        StringBuilder string = new StringBuilder();
        for(Item item: this){
            string.append(item);
            string.append(" ");
        }
        return string.toString();
    }




    public static boolean match(char left, char right){
        return (left == '(' && right == ')') || (left == '{' && right == '}') || (left == '[' && right == ']'); 
    }

    public static boolean checkMatching(String line){
        MyStack<Character> stack = new MyStack<Character>();
        char p, left;
        for(int i=0;i<line.length();i++){
            p = line.charAt(i);
            if(p == '(' || p == '{' || p == '['){
                stack.push(p);
            }else{
                left = stack.pop();
                if(!match(left,p)) {
                    return false;
                }
            }
            
        }
        if(stack.size() != 0)
            return false;
        return true;
    }
    
    public static void main(String[] args) {
        
        
        String line = "(){}[]({{{}}}[(){}])";
        
        if(checkMatching(line))
            System.out.println("The parenthesises matched!!!");
        else
            System.out.println("The parenthesises do not match!!!");



    }
}

