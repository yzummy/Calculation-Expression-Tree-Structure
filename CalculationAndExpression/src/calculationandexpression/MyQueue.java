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
public class MyQueue<Item> extends LinkedList<Item> {
    
    protected Node last;
    
    public MyQueue(){
        first = null;
        last = null;
        n = 0;
    }
    
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }
    
    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty())
            first = last;
        else
            oldLast.next = last;
        n++;
        
    }
    
    public Item dequeue(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if(isEmpty())
            last = null;
        return item;
    }
    
    
}
