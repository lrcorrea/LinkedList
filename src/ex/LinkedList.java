package ex;

public class LinkedList<T> implements IConjunto<T>{
    private Node<T> first = null;
     
    public void add(Node<T> node) {
        node.setNext(first);
        first = node;
    }
    
    public void remove(Node<T> data) {
        Node<T> current = first;
        
        if (this.first.getValue().equals(data.getValue())) {
            if (this.first.getNext() == null) {
                Node<T> newNode = new Node<T>();
                this.first.setValue(null);
                this.first = newNode;
            } else {
                this.first.setValue(null);
                this.first = this.first.getNext();
            }
        } else {
            boolean wasDeleted = false;
            while (!wasDeleted) {
                Node<T> currentNext = current.getNext();
                if (currentNext.getValue().equals(data.getValue())) {
                    currentNext.setValue(null);
                    current.setNext(currentNext.getNext());
                    currentNext = null;
                    wasDeleted = true;
                } else {
                    current = current.getNext();
                }
            }
        }
    }
    
    public boolean containsRec(Node<T> data) {
        System.out.println("this: "+this.first.getValue()+" data: "+data.getValue());
        if (this.first.getValue().equals(data.getValue())) {
            return true;
        } else {
            System.out.println("NEXT: "+ data.getNext());
            containsRec(data.getNext());
            return false;
        }
    }
    
    public boolean contains(Node<T> data){
        return containsRec(data);
    }
    
    public boolean empty(){
        if (first == null) {
            return true;
        }else{
            return false;
        }
    }
    
    /**
    * Recursively traverse this list and print the node value
    * @param node
    */
    private void printList(Node<T> node) {
        System.out.println("Lista: " + node.getValue());
        if(node.getNext()!=null) printList(node.getNext());
    }

    public void print(){
        printList(first);
    }

    @Override
    public void add(T obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(T obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(T obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
