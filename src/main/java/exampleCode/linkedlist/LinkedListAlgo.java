package exampleCode.linkedlist;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 *
 * Author: Zheng
 */
public class LinkedListAlgo {

  // 单链表反转
  public static Node reverse(Node list) {
    Node curr = list, pre = null;
    while (curr != null) {
      //获取下一个节点
      Node next = curr.next;
      //当前节点的插入结果节点的首部
      curr.next = pre;
      //结果链表的起始为当前节点
      pre = curr;
      //待反转链表后移一位
      curr = next;
    }
    return pre;
  }


    /**
     * 快慢节点  检测环
     * 环链表 slow节点遍历完一遍时 fast节点一定等于slow节点
     * @Author gjj
     * @param list
     * @return
     */
  public static boolean checkCircle(Node list) {
    if (list == null) return false;

    Node fast = list.next;
    Node slow = list;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (slow == fast) return true;
    }

    return false;
  }

  // 有序链表合并
  public static Node mergeSortedLists(Node la, Node lb) {
    if (la == null) return lb;
    if (lb == null) return la;

    Node p = la;
    Node q = lb;
    Node head;
    if (p.data < q.data) {
      head = p;
      p = p.next;
    } else {
      head = q;
      q = q.next;
    }
    Node r = head;

    while (p != null && q != null) {
      if (p.data < q.data) {
        r.next = p;
        p = p.next;
      } else {
        r.next = q;
        q = q.next;
      }
      r = r.next;
    }

    if (p != null) {
      r.next = p;
    } else {
      r.next = q;
    }

    return head;
  }

    /***
     * 1.先将链表后移K个节点记为链表b
     * 2.原始链表a与链表b同时遍历 当b结束时 a位置刚好为倒数K
     *
     * @param list
     * @param k
     * @return
     */
  // 删除倒数第K个结点
  public static Node deleteLastKth(Node list, int k) {
    Node fast = list;
    int i = 1;
    while (fast != null && i < k) {
      fast = fast.next;
      ++i;
    }

    if (fast == null) return list;

    Node slow = list;
    Node prev = null;
    while (fast.next != null) {
      fast = fast.next;
      prev = slow;
      slow = slow.next;
    }

    if (prev == null) {
      list = list.next;
    } else {
      prev.next = prev.next.next;
    }
    return list;
  }

  // 求中间结点
  public static Node findMiddleNode(Node list) {
    if (list == null) return null;

    Node fast = list;
    Node slow = list;

    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    return slow;
  }

  public static void printAll(Node list) {
    Node p = list;
    while (p != null) {
      System.out.print(p.data + " ");
      p = p.next;
    }
    System.out.println();
  }

  public static Node createNode(int value) {
    return new Node(value, null);
  }

  public static class Node {
    private int data;
    private Node next;

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }

    public int getData() {
      return data;
    }
  }

}
