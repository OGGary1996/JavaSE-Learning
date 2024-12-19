package training.dataStructureAlgorithm;

import training.dataStructureAlgorithm.operarionOfQueue.QueueManual;

public class k_OperartionOfQueue {
    public static void main(String[] args){
        // 通过内置的Queue实现队列
        // 内置的Queue是一个接口，不能直接实例化，需要通过Array或者LinkedList或者ArrayList等类实现

        // 通过Flat Array实现Queue
        QueueManual queue = new QueueManual(5);
            // Enqueue
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.show();
            // Dequeue
        System.out.println("Dequeue: " + queue.deQueue());
        queue.show();
            // Peek
        System.out.println("Peek: " + queue.peek());


        // 通过Circle Array实现Queue




    }

}
