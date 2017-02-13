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
public class LinkedList<Item> implements Iterable<Item> {
    
    public int n;
    public Node first;

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
    
}
