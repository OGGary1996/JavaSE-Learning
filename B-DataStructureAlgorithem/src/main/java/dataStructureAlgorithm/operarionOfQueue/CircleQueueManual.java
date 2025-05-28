package dataStructureAlgorithm.operarionOfQueue;

// 使用circle array实现队列

public class CircleQueueManual {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    public int capacity;

    // initialize
    public CircleQueueManual(int capacity){
        this.capacity = capacity;
        queue = new int[capacity];
        rear = -1;
        front = 0;
        size = 0;
    }

    // determine if the queue is empty or full
        // determine if the queue is empty
    public boolean isEmpty(){
        return size == 0;
    }
        // determine if the queue is full
    public boolean isFull(){
        return size == capacity;
    }

    // Enqueue
    public void enQueue(int data){
        if (isFull()){
            System.out.println("Queue overflow!");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;
        System.out.println("Enqueue: " + data);
    }

    // Dequeue
    public int deQueue(){
        if (isEmpty()){
            System.out.println("Queue underflow!");
            return -1;
        }
        int data = queue[front];
        front = (front + 1) % capacity;
        size--;
        return data;
    }

    // Peek
    public int peek(){
        if (isEmpty()){
            System.out.println("Queue is empty!");
            return -1;
        }
        return queue[front];
    }

    //display the whole queue
    public void show1(){
        if (isEmpty()){
            System.out.println("Queue is empty!");
            return;
        }
        for (int i = 0; i < size; i++){
            int date = queue[(front + i) % capacity];
            System.out.print(date + " ");
        }
        System.out.println();
    }
    public void show2(){
        if (isEmpty()){
            System.out.println("Queue is empty!");
            return;
        }
        int i = front;
        while(i != rear){
            System.out.print(queue[i] + " ");
            i = (i + 1) % capacity;
        }
        System.out.print(queue[rear]);
    }

    // get the size and the capacity of the queue
    public int getSize(){
        return size;
    }
    public int getCapacity(){
        return capacity;
    }

}
