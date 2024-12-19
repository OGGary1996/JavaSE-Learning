package training.dataStructureAlgorithm.operarionOfQueue;

// 使用自定义的Fixed Array实现队列

public class QueueManual {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    //initialize
    public QueueManual(int capacity){
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1 ;
        size = 0;
    }

    // determine if the queue is empty or full
        // determine if the queue is empty
    public boolean isEmpty(){
        return size == 0; // or front > rear
    }
        // determine if the queue is full
    public boolean isFull(){
        return size == capacity; // or rear == capacity - 1
    }

    // Enqueue
    public void enQueue(int data){
        if(isFull()){
            System.out.println("Queue overflow!");
            return;
        }
        queue[++rear] = data;
        size++;
    }

    // Dequeue
    public int deQueue(){
        if(isEmpty()){
            System.out.println("Queue underflow!");
            return -1;
        }
        int data = queue[front];
        // shift the elements to the left
        for(int i = front; i < rear ; i++){
            queue[i] = queue[i+1];
        }
        rear--; // shift the rear pointer to the left
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

    // Display
    public void show(){
        if(isEmpty()){
            System.out.println("Queue is empty!");
            return ;
        }
        for(int i = 0; i < size; i++){
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    // get the size and the capacity of the queue
    public int getSize(){
        return size;
    }
    public int getCapacity(){
        return capacity;
    }

}
