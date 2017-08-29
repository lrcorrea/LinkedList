package ex;
import java.util.Iterator;

public class Conjunto<T extends Comparable> implements IConjunto<T>{
    private Node<T> first = null;
    private Node<T> last = null;
    private int size = 0;
    
    public void add(T obj){
        Node<T> newnode;
        newnode = new Node<>(obj);
        if(last==null){
            first=newnode;
            last=newnode;
            newnode.setNext(null);
            newnode.setPrev(null);
        }else{
            newnode.setPrev(last);
            last.setNext(newnode);
            last=newnode;
        }
        size++;
    }
    
    public void remove(T value){
        Node found = contains(value);
        if (found != null){// node exists
                // check for head
            if (found.getPrev() == null){
                found.getNext().setPrev(null);
                first = found.getNext();
            } else {// check for tail
                if (found.getNext() == null){
                    found.getPrev().setNext(null);
                    last = found.getPrev();
                } else {// fix pointers
                    found.getPrev().setNext(found.getNext());
                    found.getNext().setPrev(found.getPrev());
                }
            }
            size--;
        }
    }
    
    public Node contains(T value){
        Node current = first;
        while (current != null){
            if (current.getValue().equals(value)) return current;
            current = current.getNext();
        }
        return null;
    }
    
    public Conjunto<T> union(Conjunto<T> b) {
        Conjunto<T> newList = new Conjunto<T>();
        Node a = first;
        
        newList.add((T) a);
        newList.add((T) first);

        return newList;
    }
    
    public void insertionSort(){
        
        Node out;
        Node in = null;
        
        for (out = first.getNext(); out != null; out = out.getNext())
        {
            Node temp = out;
            in = out;
            
            while (in.getPrev() != null && in.getPrev().getValue().compareTo(temp.getValue()) > 0){
                in = in.getPrev();
            }
            
            if (in != out){
                if (temp.getPrev() != null){
                    temp.getPrev().setNext(temp.getNext());
                }
                if (temp.getNext() != null){
                    temp.getNext().setPrev(temp.getPrev());
                }
                if (in.getPrev() == null){
                    first.setPrev(temp);
                    temp.setNext(first);
                    first = temp;
                    first.setPrev(null);
                }

                else{
                    temp.setPrev(in.getPrev());
                    in.getPrev().setNext(temp);
                    in.setPrev(temp);
                    temp.setNext(in);
                }
            }
            
            if (out.getNext() == null){
                last = out;
            }
        }
        
        /*if(first != null){
        
            Node temp = null;
            while(current != null){
                
                for(Node prev = current; prev != null && prev.getPrev() != null; prev = prev.getPrev()) {
                    System.out.println("a: "+prev.getValue()+" / b: " +prev.getPrev().getValue());
                    if(prev.getValue().compareTo(prev.getPrev().getValue()) <= 0){
                        System.out.println("troca");
                        if (prev==current) {
                            current=prev.getPrev();
                        }
                        
                        swap(prev,prev.getPrev());
                    }
                }
                
                current = current.getNext();
            }
        }*/
        
        /*
        for(Node prev=current; prev != null && prev.prev != null; prev = prev.prev) {
            if(prev.data.compareTo(prev.prev.data) <= 0) {
                if (prev==current) {
                    current=prev.prev;
                }
                swap(prev,prev.prev);
            }
        }
        current = current.next;*/
    }
    
    public void swap(Node node1, Node node2) {


        if (node1 == node2) {
            return;
        }

        // make sure node1 is before node2
        if (node1.getPrev() == node2) {
            Node temp = node2;
            node2 = node1;
            node1 = temp;
        }

        Node node1Prev = node1.getPrev();
        Node node1Next = node1.getNext();
        Node node2Prev = node2.getPrev();
        Node node2Next = node2.getNext();

        node1.setNext(node2Next);
        if (node2Next != null) {
            node2Next.setPrev(node1);
        }

        node2.setPrev(node1Prev);
        if (node1Prev != null) {
            node1Prev.setNext(node2);
        }

        if (node1 == node2Prev) {
            node1.setPrev(node2);
            node2.setNext(node1);
        } else {
            node1.setPrev(node2Prev);
            if (node2Prev != null) {
                node2Prev.setNext(node1);
            }

            node2.setNext(node1Next);
            if (node1Next != null) {
                node1Next.setPrev(node2);
            }
        }

        if (node1 == first) {
            first = node2;
        } else if (node2 == first) {
            first = node1;
        }
    }
    
    public int size() {
        return size;
    }
    
    public boolean empty(){
        if (first == null) {
            return true;
        }else{
            return false;
        }
    }
    
    private void printList(Node<T> node) {
        System.out.println("Lista: " + node.getValue());
        if(node.getNext()!=null) printList(node.getNext());
    }

    public void print(){
        printList(first);
    }
    
    private class Node<T extends Comparable> {
        private T value;
        private Node<T> next;
        private Node<T> prev;
        
        public Node(T obj){
            this.value = obj;
            prev = null;
            next = null;
	}

        public void setNext(Node<T> next) {
            this.next = next;
        }
        
        public void setPrev(Node<T> next) {
            this.prev = next;
        }

        public Node<T> getNext() {
            return next;
        }
        
        public Node<T> getPrev() {
            return prev;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }
}
