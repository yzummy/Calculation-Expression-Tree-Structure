/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculationandexpression;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Yunch
 */
public class LinkedList<Item> implements Iterable<Item> {
    
    protected int n;
    protected Node first;

    public class ListIterator implements Iterator<Item> {

        private Node current = first;
        
        public ListIterator() {
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public int size(){
        return n;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    
    protected class Node {
        Item item;
        Node next;
    }

    public LinkedList(){
        first = null;
        n = 0;
    }
    
        public String toString(){
        StringBuilder string = new StringBuilder();
        for(Item item: this){
            string.append(item);
            string.append("");
        }
        return string.toString();
    }
    
}
