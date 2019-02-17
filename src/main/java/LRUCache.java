import java.util.HashMap;

public class LRUCache<K, V> {
  private final int capacity;
  private final HashMap<K, Node<K, V>> map;
  private final DoubleLinkedListWithKey<K, V> list;

  private static final int DEFAULT_CAPACITY = 100;

  public LRUCache() {
    this(DEFAULT_CAPACITY);
  }

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.map = new HashMap<>();
    this.list = new DoubleLinkedListWithKey<>();
  }

  public V get(K key) {
    Node<K, V> node = this.map.get(key);
    if (node != null) {
      if (this.list.getHead().getKey() != key) {
        this.map.get(key).getPrev().setNext(this.map.remove(key).getNext());
        this.list.prepend(node);
        this.map.put(key, node);
      }
      return node.getValue();
    } else {
      return null;
    }
  }

  public void put(K key, V value) {
    Node<K, V> node = new Node<>(key, value);
    if (this.map.containsKey(key)) {
      if (key != this.list.getHead().getKey()) {
        Node<K, V> tempNode = this.map.remove(key);
        tempNode.getPrev().setNext(tempNode.getNext());
        this.map.put(key, node);
        this.list.prepend(node);
      }
    } else {
      this.map.put(key, node);
      this.list.prepend(node);
    }

    if (this.map.size() > this.capacity) {
      this.map.remove(this.list.getTail().getKey());
      this.list.removeTail();
    }

  }

  public String toString() {
    return "Size (" + this.map.size() + ") Capacity (" + this.capacity + ") Values (" + this.map.entrySet() + ")" + " List (" + this.list + ")";
  }
}
