public class Node<K, V> {
  private final K key;
  private final V value;
  private Node<K, V> prev;
  private Node<K, V> next;

  public Node(V value) {
    this(null, value);
  }

  public Node(K key, V value) {
    this.key = key;
    this.value = value;
    this.setPrev(null);
    this.setNext(null);
  }

  public V getValue() {
    return value;
  }

  public Node<K, V> getPrev() {
    return prev;
  }

  public void setPrev(Node prev) {
    this.prev = prev;
  }

  public Node<K, V> getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public String toString() {
    return super.toString() + " (" + getKey() + "=>" + getValue() + ")";
  }

  public K getKey() {
    return key;
  }
}
