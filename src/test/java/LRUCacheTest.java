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

        this.cache.put("No", "No");
        System.out.println(this.cache);

        assertNull(this.cache.get("Hi"));
        System.out.println(this.cache);
    }
}
