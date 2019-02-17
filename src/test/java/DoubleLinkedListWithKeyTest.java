import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleLinkedListWithKeyTest {
  private DoubleLinkedListWithKey<Object, Integer> list;

  @Before
  public void setUp() throws Exception {
    this.list = new DoubleLinkedListWithKey<>();
  }

  @After
  public void tearDown() throws Exception {
    this.list = null;
  }

  @Test
  public void removeHead() {
    assertNull(this.list.removeHead());

    Node head = new Node(1);
    this.list.append(head);
    assertEquals(head, this.list.removeHead());
  }

  @Test
  public void removeTail() {
    assertNull(this.list.removeTail());

    Node tail = new Node(1);
    this.list.append(tail);
    assertEquals(tail, this.list.removeTail());
  }


  @Test
  public void append() {
    Node head = new Node<>(1);
    this.list.append(head);
    assertEquals(head, this.list.getHead());
    assertEquals(head, this.list.getTail());
    Node tail = new Node<>(2);
    this.list.append(tail);
    assertEquals(head, this.list.getHead());
    assertEquals(tail, this.list.getTail());
    tail = new Node<>(3);
    this.list.append(tail);
    assertEquals(head, this.list.getHead());
    assertEquals(tail, this.list.getTail());

    System.out.println(this.list);
  }

  @Test
  public void prepend() {
    Node tail = new Node<>(1);
    this.list.prepend(tail);
    assertEquals(tail, this.list.getHead());
    assertEquals(tail, this.list.getTail());

    Node head = new Node<>(2);
    this.list.prepend(head);
    assertEquals(head, this.list.getHead());
    assertEquals(tail, this.list.getTail());
    head = new Node<>(3);
    this.list.prepend(head);
    assertEquals(head, this.list.getHead());
    assertEquals(tail, this.list.getTail());

    System.out.println(this.list);
  }

  @Test
  public void getHead() {
    assertNull(this.list.getHead());
    this.list.append(new Node<>(1));
    assertNotNull(this.list.getHead());
  }

  @Test
  public void getTail() {
    assertNull(this.list.getTail());
    this.list.append(new Node<>(1));
    assertNotNull(this.list.getTail());
  }
}
