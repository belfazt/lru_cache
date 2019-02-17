public class DoubleLinkedListWithKey<K, V> {
  private int size;
  private Node<K, V> head;
  private Node<K, V> tail;

  public DoubleLinkedListWithKey() {
    this.size = 0;
  }

  public void append(Node<K, V> node) {
    if (this.size == 0) {
      this.head = node;
      this.tail = node;
    } else {
      node.setPrev(this.tail);
      this.tail.setNext(node);
      this.tail = node;
    }
    this.size++;
  }

  public void prepend(Node<K, V> node) {
    if (this.size == 0) {
      append(node);
    } else {
      node.setNext(this.head);
      this.head.setPrev(node);
      this.head = node;
    }
  }

  public Node<K, V> removeHead() {
    if (size == 0) {
      return null;
    }

    Node<K, V> oldHead = this.head;

    this.head = this.head.getNext();
    if (this.head != null) {
      this.head.setPrev(null);
    }

    return oldHead;
  }

  public Node<K, V> removeTail() {
    if (size == 0) {
      return null;
    }

    Node<K, V> oldTail = this.tail;

    this.tail = this.tail.getPrev();
    if (this.tail != null) {
      this.tail.setNext(null);
    }

    return oldTail;
  }

  public Node<K, V> getHead() {
    return head;
  }

  public Node<K, V> getTail() {
    return tail;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString()).append(" [");
    sb.append(this.size).append(" Elements");
    sb.append("(");
    sb.append("null");
    Node current = this.head;
    while (current != null) {
      sb.append(" <-> ").append(current);
      current = current.getNext();
    }
    sb.append(" <-> null");
    sb.append(")");
    sb.append("]");

    return sb.toString();
  }
}
