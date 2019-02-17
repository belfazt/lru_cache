public class DoubleLinkedListWithKey<K, V> {
  private Node<K, V> head;
  private Node<K, V> tail;

  public void append(Node<K, V> node) {
    if (this.head == null) {
      this.head = node;
      this.tail = node;
    } else {
      node.setPrev(this.getTail());
      this.getTail().setNext(node);
      this.setTail(node);
    }
  }

  public void prepend(Node<K, V> node) {
    if (this.head == null) {
      append(node);
    } else {
      node.setNext(this.head);
      this.head.setPrev(node);
      this.head = node;
    }
  }

  public Node<K, V> removeHead() {
    if (this.head == null) {
      return null;
    }

    Node<K, V> oldHead = this.getHead();

    this.head = this.head.getNext();
    if (this.head != null) {
      this.head.setPrev(null);
    }

    return oldHead;
  }

  public Node<K, V> removeTail() {
    if (this.head == null) {
      return null;
    }

    Node<K, V> oldTail = this.getTail();

    Node<K, V> newTail = oldTail.getPrev();

    this.setTail(newTail);

    if (newTail != null) {
      newTail.setNext(null);
    }

    return oldTail;
  }

  public Node<K, V> getHead() {
    if (this.head != null) {
      while (this.head.getPrev() != null) {
        this.head = this.head.getPrev();
      }
    }

    return head;
  }

  public Node<K, V> getTail() {
    if (this.tail != null) {
      return this.tail;
    }

    while (this.tail.getNext() != null) {
      this.tail = this.tail.getNext();
    }
    return this.tail;
  }

  public void setTail(Node<K, V> node) {
    getTail();
    this.tail = node;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString()).append(" [");
    sb.append("null");
    Node current = this.getHead();
    while (current != null) {
      sb.append(" <-> ").append(current);
      current = current.getNext();
    }
    sb.append(" <-> null");
    sb.append("]");

    return sb.toString();
  }
}
