package calculationandexpression;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Yunch
 */
public class MyStack<Item> extends LinkedList<Item>{


    public MyStack(){
        first = null;
        n = 0;
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
    


}



