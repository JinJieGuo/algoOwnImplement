package exampleCode.queue;

/**
 * Created by wangzheng on 2018/10/9.
 */
public class CircularQueue {
  // 数组：items，数组大小：n
  private String[] items;
  private int n = 0;
  // head表示队头下标，tail表示队尾下标
  private int head = 0;
  private int tail = 0;

  // 申请一个大小为capacity的数组
  public CircularQueue(int capacity) {
    items = new String[capacity];
    n = capacity;
  }

  // 入队
  public boolean enqueue(String item) {
    // 队列满了
    if ((tail + 1) % n == head) return false;
    items[tail] = item;
    tail = (tail + 1) % n;
    return true;
  }

  // 出队
  public String dequeue() {
    // 如果head == tail 表示队列为空
    if (head == tail) return null;
    String ret = items[head];
    head = (head + 1) % n;
    return ret;
  }

  public void printAll() {
    if (0 == n) return;
    for (int i = head; i % n != tail; ++i) {
      System.out.print(items[i % n] + " ");
    }
    System.out.println();
  }


  public static void main(String[] args) {


    /***
     * 当队列满时，图中的 tail 指向的位置实际上是没有存储数据...
     * 循环队列会浪费一个数组的存储空间
     */

    //数组大小为n 循环队列的大小为n-1
    CircularQueue circularQueue = new CircularQueue(5);

    // head表示队头下标，tail表示队尾下标

    circularQueue.enqueue("一");//success head:0 tail:1
    circularQueue.enqueue("一");//success head:0 tail:2
    circularQueue.enqueue("一");//success head:0 tail:3
    circularQueue.enqueue("一");//success head:0 tail:4
    circularQueue.enqueue("一");//fail 队列满了
    circularQueue.dequeue();         //success head:1 tail:4
    circularQueue.dequeue();         //success head:2 tail:4
    circularQueue.enqueue("二");//success head:2 tail:0
    circularQueue.enqueue("二");//success head:2 tail:1
    circularQueue.enqueue("二");//fail 队列满了

    circularQueue.printAll();
    //result : 一 一 二 二


  }

}
