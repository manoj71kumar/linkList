class LinklistMain {
  Node head;

  static class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  void deleteNode(int value) {
    Node temp = head, prev = null;

    if (temp != null && temp.data == value) {
      head = temp.next;
      return;
    }
    while (temp != null && temp.data != value) {
      prev = temp;
      temp = temp.next;
    }

    // If key was not present in linked list
    if (temp == null) return;

    // Unlink the node from linked list
    prev.next = temp.next;
  }

  public void push(int new_data) {
    Node new_node = new Node(new_data);
    new_node.next = head;
    head = new_node;
  }

  public void removeTailElement() {
    if (head == null) System.out.println("List is empty");
    else {
      Node n1 = null;
      Node n2 = head;
      while (n2.next != null) {
        n1 = n2;
        n2 = n2.next;
      }
      n1.next = null;
    }
  }

  public Integer getNextVal(int value) {

    Node tnode = head;

    while (tnode != null) {
      if (tnode.data > value) return tnode.data;

      tnode = tnode.next;
    }
    return null;
  }

  public void printList() {
    Node tnode = head;
    while (tnode != null) {
      System.out.print(tnode.data + " ");
      tnode = tnode.next;
    }
  }

  public static void main(String args[]) {
    LinklistMain ls = new LinklistMain();
    ls.push(7);
    ls.push(8);
    ls.push(9);
    ls.push(6);
    ls.push(5);
    ls.push(4);
    ls.push(3);
    ls.push(2);

    System.out.println("\nDelted Tail Element");
    ls.removeTailElement();
    ls.printList();

    System.out.println("\nCreated Linked list is:");
    ls.printList();

    int value = 2;
    while (true) {
      Integer next_val = ls.getNextVal(value);
      if (next_val == null) break;
      if (next_val != null || next_val != 0) ls.deleteNode(next_val);
    }

    System.out.println("\nLinked List after Deletion at position 4:");
    ls.printList();
  }
}
