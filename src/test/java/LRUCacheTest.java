import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {
  private LRUCache<String, String> cache;

  @Before
  public void setUp() throws Exception {
    this.cache = new LRUCache<>();
  }

  @After
  public void tearDown() throws Exception {
    this.cache = null;
  }

  @Test
  public void get() {
    this.cache.put("Hello", "World");
    assertEquals("World", this.cache.get("Hello"));

    System.out.println(this.cache);
  }

  @Test
  public void put() {
    this.cache = new LRUCache<>(2);
    this.cache.put("Hi", "Hi");
    System.out.println(this.cache);

    this.cache.put("Bye", "Bye");
    System.out.println(this.cache);
    assertEquals("Hi", this.cache.get("Hi"));
    System.out.println(this.cache);

    this.cache.put("No", "No");
    System.out.println(this.cache);

    assertNull(this.cache.get("Bye"));
    System.out.println(this.cache);

    LRUCache<Integer, Integer> intCache = new LRUCache<>(2);

    intCache.put(2, 1);
    intCache.put(2, 2);
    intCache.get(2);

    intCache.put(1, 1);
    intCache.put(4, 1);
    intCache.get(2);

    intCache = new LRUCache<>(2);
    intCache.get(2);
    intCache.get(2);
    intCache.put(2, 6);
    intCache.get(1);

    System.out.println(intCache);
    intCache.put(1, 5);
    System.out.println(intCache);
    intCache.put(1, 2);
    System.out.println(intCache);
    intCache.get(1);
    intCache.get(2);

    intCache = new LRUCache<>(2);
    intCache.get(2);
    intCache.put(2, 6);
    intCache.get(1);
    intCache.put(1, 5);
    intCache.put(1, 2);
    intCache.get(1);

    System.out.println(intCache);
    assertNotNull(intCache.get(2));

    intCache = new LRUCache<>(2);

    intCache.put(2, 1);
    System.out.println(intCache);
    intCache.put(2, 2);
    System.out.println(intCache);

    assertEquals(java.util.Optional.of(2), java.util.Optional.of(intCache.get(2)));
    System.out.println(intCache);

    intCache.put(1, 1);
    System.out.println(intCache);
    intCache.put(4, 1);
    System.out.println(intCache);

    assertNull(intCache.get(2));

  }
}
