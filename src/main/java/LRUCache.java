import java.util.HashMap;

public class LRUCache<K, V> {
  private int size;

  private final int capacity;
  private final HashMap<K, Node<K, V>> map;
  private final DoubleLinkedListWithKey<K, V> list;

  private static final int DEFAULT_CAPACITY = 100;

  public LRUCache() {
    this(DEFAULT_CAPACITY);
  }

  public LRUCache(int capacity) {
    this.size = 0;
    this.capacity = capacity;
    this.map = new HashMap<>();
    this.list = new DoubleLinkedListWithKey<>();
  }

  public V get(K key) {
    Node<K, V> node = this.map.get(key);
    if (node != null) {
      return node.getValue();
    } else {
      return null;
    }
  }

  public void put(K key, V value) {
    Node<K, V> node = new Node<>(key, value);
    if (this.map.containsKey(key)) {
      this.map.get(key).getPrev().setNext(this.map.get(key).getNext());
    }

    if (this.size == this.capacity) {
      this.map.remove(this.list.removeTail().getKey());
    }

    this.size++;

    list.prepend(node);
    this.map.put(key, node);
  }

  public String toString() {
    return "Size (" + this.size + ") Capacity (" + this.capacity + ") Values (" + this.map.entrySet().toString() + ")" + " List (" + this.list + ")";
  }
}
