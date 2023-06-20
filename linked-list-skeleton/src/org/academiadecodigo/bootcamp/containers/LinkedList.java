package org.academiadecodigo.bootcamp.containers;

public class LinkedList<T> {

    private Node head;
    private int length = 0;

    public LinkedList() {

        this.head = new Node(null);
    }

    public int size() {

        return length;
    }

    /**
     * Adds an element to the end of the list
     * @param data the element to add
     */
    public void add(T data)  {

        Node node = new Node(data);
        Node iterator = head;
        while (iterator.getNext() != null){
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     * @param index the index of the element
     * @return the element
     */
    public T get(int index) {
        int counter = 0;
        Node iterator = head;

        while (iterator.getNext() != null){

            if(counter==index){
                return iterator.getNext().getData();
            }
            counter++;
            iterator=iterator.getNext();

        }
        return null;
    }

    /**
     * Returns the index of the element in the list
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(T data) {
        int counter = 0;
        Node iterator = head;
        while (counter < length){

            if(iterator.getNext().getData()==data){
                //System.out.println(iterator.getData());
                return counter;
            }
            iterator = iterator.getNext();
            counter++;
        }
        return -1;
    }

    /**
     * Removes an element from the list
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(Object data){
        Node iterator = head;

        while (iterator.getNext() != null){
            if (iterator==head && iterator.getNext().getData() == data) {
                head.setNext(iterator.getNext().getNext());
                length--;
                return true;
            }
            if(iterator.getNext().getData() == data) {
                iterator.setNext(iterator.getNext().getNext());
                length--;
                return true;
            }
            iterator = iterator.getNext();

        }
        return false;
    }

    private class Node {

        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
