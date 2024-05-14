public class DoublyLinkedList<T>{
    public static class Node<T>{
        private T element;
        private Node<T> prev;
        private Node<T> next;

        public Node(T t){
            this.element = t;
            this.next = null;
            this.prev = null;
        }

        public T getElement(){return this.element;}
        public Node<T> getNext(){return this.next;}
        public Node<T> getPrev(){return this.prev;}

        public void setNext(Node<T> n){this.next = n;}
        public void setPrev(Node<T> p){this.prev = p;}
    }

    private Node<T> head;
    private int size = 0;
    public DoublyLinkedList(){}
    public boolean isEmpty(){return(size==0);}

    public void addFirst(T t){
        Node<T> newNode = new Node<>(t);
        if(isEmpty()){
            head = newNode;
            newNode.setNext(null);
            newNode.setPrev(null);
            size++;
        }else{
            newNode.setNext(head);
            head.setPrev(newNode);
        }
    }

    public void addLast(T t){
        if(isEmpty()){
            addFirst(t);
        }else{
            Node<T> temp = head;
            Node<T> newNode = new Node<>(t);
            while(temp.getNext()!=null){
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setPrev(temp);
            size++;
        }
    }

    public void printForward(){
        Node<T> temp = head;
        while(temp.getNext()!=null){
            System.out.println(temp.getElement());
            temp = temp.getNext();
        }
    }

    public void printReverse(){
        Node<T> temp = head;
        while(temp.getNext()!=null){
            temp = temp.getNext();
        }
        while(temp.getPrev()!=null){
            System.out.println(temp.getElement());
            temp=temp.getPrev();
        }
    }

    public void addAtIndex(T t, int index){
        Node<T> temp = head;
        Node<T> newNode = new Node<>(t);

        if(isEmpty()){
            addFirst(t);
        }else if(index == size){
            addLast(t);
        }else{
            for(int i = 1; i<index-1; i++){
                temp = temp.getNext();
            }
            newNode.setNext(temp.getNext());
            temp.getNext().setPrev(newNode);
            temp.setNext(newNode);
            newNode.setPrev(temp);
        }
    }

    public T deleteFirst(){
        T t = head.getElement();
        if(isEmpty()){
            return t;
        }else{
            head = head.getNext();
            size--;
        }
        return t;
    }

    public T deleteLast(){
        Node<T> temp = head;
        if(isEmpty()){
            deleteFirst();
        }else{
        while(temp.getNext().getNext()!=null){
            temp =temp.getNext();
        }
        temp.setNext(null);
        temp.getNext().setPrev(null);
        size--;
           }
           return temp.getElement();
}

    public T deleteAtIndex(int index){ 
        Node<T> temp = head;
        if(isEmpty() || index ==0){
            deleteFirst();
        }else if(index ==size){
            deleteLast();
        }else{
        for(int i =1; i<index-1; i++){
            temp = temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
        temp.getNext().getNext().setPrev(temp);
        size--;
    } 
       return temp.getNext().getElement();


    }

}
