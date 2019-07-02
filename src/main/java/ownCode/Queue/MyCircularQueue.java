package ownCode.Queue;

/***
 *
 * leetcode-622 设计循环队列
 * @Author gjj
 *
 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。

 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。

 你的实现应该支持如下操作：

 MyCircularQueue(k): 构造器，设置队列长度为 k 。
 Front: 从队首获取元素。如果队列为空，返回 -1 。
 Rear: 获取队尾元素。如果队列为空，返回 -1 。
 enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 isEmpty(): 检查循环队列是否为空。
 isFull(): 检查循环队列是否已满。

 */



public class MyCircularQueue {
    //数组实现
    private int[] item ;
    //初始化队列数组大小itemSize = 0
    //初始化队列首部下标head
    //初始化队列尾部下标tail
    private int itemSize,head,tail=0;


    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.item = new int[k];
        this.itemSize = k;
        this.head = 0;
        this.tail = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        //队列满了
        if (isFull()) return false;
        item[tail] = value;
        tail = (tail + 1) % itemSize;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        //队列为空
        if (isEmpty()) return false;
        head = (head + 1) % itemSize;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        //队列为空 返回-1
        if (isEmpty()) return -1;
        return item[head];

    }

    /** Get the last item from the queue. */
    public int Rear() {
        //队列为空 返回-1
        if (isEmpty()) return -1;

        //tail 所指向的数组下标为空 存在真实有数据的队列尾部下标为 tail - 1

        int weibu = tail -1;
        if (tail == 0)
            weibu = itemSize -1;
        return item[weibu];

    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return tail == head;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (tail + 1) % itemSize == head;
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(4);
        //构造器入参为数组长度 并非队列长度  顺序队列的长度 = 数组长度 -1

        boolean b = circularQueue.enQueue(1);
        System.out.println(b);

        boolean b1 = circularQueue.enQueue(2);
        System.out.println(b1);

        boolean b2 = circularQueue.enQueue(3);
        System.out.println(b2);

        boolean b3 = circularQueue.enQueue(4);
        System.out.println(b3);

        int rear = circularQueue.Rear();
        System.out.println(rear);

        boolean full = circularQueue.isFull();
        System.out.println(full);

        boolean b4 = circularQueue.deQueue();
        System.out.println(b4);

        boolean b5 = circularQueue.enQueue(4);
        System.out.println(b5);

        int rear1 = circularQueue.Rear();
        System.out.println(rear1);

        int front = circularQueue.Front();
        System.out.println(front);

    }


}
