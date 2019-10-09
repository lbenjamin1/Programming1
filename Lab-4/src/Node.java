
/**
 * Node represents an element in the LinkedList.
 *
 * DO NOT MODIFY THIS CLASS.
 *
 * @param <E> The data to be stored in the node.
 */
public class Node<E> {

    private E data;
    private Node<E> next;

    public Node() {

    }

    public Node(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
