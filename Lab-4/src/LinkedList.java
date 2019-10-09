
public class LinkedList<E> {

    private Node<E> head;

    //TODO Implement the constructor.
    public LinkedList() {
        head = new Node<E>();
    }

    /**
     * TODO Implement this method.
     * Add the given element, value, to the end of the list.
     *
     * @param head The value to be added.
     */
    public void add(E value) {

        if (size() == 0) {
            head.setData(value);
        } else {
            Node<E> currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }

            Node<E> newNode = new Node<>(value);
            currentNode.setNext(newNode);
        }
    }

    /**
     * TODO Implement this method.
     * Add the given element, value, to the list at the given index.
     * After this operation is complete, get(index) will return value.
     * After this operation, all elements that had an index
     * greater than index (as determined by get()) will have their index increased by one.
     * This operation is only valid for 0 <= index <= size().
     *
     * @param index The index at which to add value.
     * @param value The value to be added.
     * @throws IndexOutOfBoundsException when index is less than zero or greater than size.
     */
    public void add(int index, E value) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

//        Node<E> temp = head;
//        while (temp.getNext() != null) {
//            temp = temp.getNext();
//        }
//
//        Node<E> newNode = new Node<>(value);
//        temp.setNext(newNode);


//        //for the case of adding between two nodes
        Node<E> temp = head;
        for(int i = 0; i < index ; i++){
            temp = temp.getNext();
        }

        Node<E> newNode = new Node<>();

        newNode.setData(value);
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
    }



//        for (int i = 0; i < index; i++){
//            head.setData(value);
//        }

    /**
     * TODO Implement this method.
     * Determine if the LinkedList is empty or not.
     * @return true if this LinkedList has no items. (This is the same as the size equal to zero.)
     * false if the size is greater than zero.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * TODO Implement this method.
     * Return the size (number of items) in this LinkedList.
     * @return the number of items in the list.
     */
    public int size() {
        Node<E> currentNode = head;
        int count = 1;

        if(currentNode.getNext() == null && currentNode.getData() == null){
            return 0;
        }
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
            count++;
        }
        return count;
    }


    /**
     * TODO Implement this method.
     * Return the element of the list at the given index.
     * This operation is only valid for 0 <= index < size().
     * This operation does not modify the list.
     * @param index The index at which to retrieve an element.
     * @return The element of the list at the given index.
     * @throws IndexOutOfBoundsException when index is less than zero or greater than or equal to size.
     */
    public E get(int index) {
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();}

            Node<E> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
            return temp.getData();
    }

    /**
     * TODO Implement this method.
     * Remove and return the first element (element number zero) from the list.
     * This operation is only valid for non-empty (size() > 0) lists.
     * @return The removed element.
     * @throws IndexOutOfBoundsException When the list is empty.
     */
    public E remove() {
        if(size() <= 0){
            throw new IndexOutOfBoundsException();
        }
        if(size() == 1){
            E deletedData = this.head.getData();
            this.head.setData(null);
            return deletedData;
        }

        E deletedData = this.head.getData();
        this.head = this.head.getNext();
        return deletedData;
    }

    /**
     * TODO Implement this method.
     * Remove and return the element with the given index from the list.
     * This operation is only valid for 0 <= index < size().
     * After this operation, all elements that had an index
     * greater than index (as determined by get()) will have their index reduced by one.
     * @param index The index to remove an element from.
     * @return The removed element.
     * @throws IndexOutOfBoundsException when removing from index less than zero or greater than or equal to size.
     */
    public E remove(int index) {
        return null;
    }
}