package dataStructureAlgorithm.operationOfStack;

// 使用自定义的动态数组实现栈

public class DynamicStackManual {
    private int[] dynamicStack;
    private int capacity;
    private int size;
    private int top;

    // initialize
    public DynamicStackManual(){
        capacity = 2;
        dynamicStack = new int[capacity];
        top = -1;
        size = 0;
    }

    // determine if the stack is empty or full
    public boolean isEmpty(){
        return size == 0;
    }
    // determine if the stack is full
    public boolean isFull(){
        return size == capacity;
    }

    // Resize the stack
        // expand the stack capacity
    public void expand(){
        int[] newStack = new int[capacity*2];
        for (int i = 0; i < size; i++){
            newStack[i] = dynamicStack[i];
        }
        dynamicStack = newStack;
        capacity = capacity * 2;
        newStack = null;
    }
        // shrink the stack size
    public void shrink(){
        int[] newStack = new int[capacity/2];
        for (int i = 0; i < size; i++){
            newStack[i] = dynamicStack[i];
        }
        dynamicStack = newStack;
        capacity = capacity / 2;
        newStack = null;
    }

    // Push
    public void push(int data){
        if (isFull()){
            expand();
        }
        dynamicStack[++top] = data;
        size++;
        System.out.println("Data pushed: " + data);
    }

    // Pop
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack underflow!");
            return -1;
        }
        int data = dynamicStack[top--];
        size--;
        if (top < capacity/2){
            shrink();
        }
        return data;
    }

    // Peak
    //Peak
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty!");
            return -1;
        }
        return dynamicStack[top];
    }

    // Search
    public int searchByData(int data){
        if (isEmpty()){
            System.out.println("Stack is empty!");
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (dynamicStack[i] == data) {
                return i;
            }
        }
        System.out.println("Data not found!");
        return -1;
    }
    public int searchByIndex(int index){
        if (isEmpty()){
            System.out.println("Stack is empty!");
            return -1;
        }
        for (int i = 0; i < size; i++){
            if (index < size){
                return dynamicStack[index];
            }
        }
        System.out.println("Index out of bound!");
        return -1;
    }

    // Print stack
    public void show(){
        if(isEmpty()){
            System.out.println("Stack is empty!");
        }
        for (int i = 0; i < size; i++){
            System.out.print(dynamicStack[i] + " ");
        }
        System.out.println();
    }

    // Get the size and capacity of the stack
    public int getSize(){
        return size;
    }
    public int getCapacity(){
        return capacity;
    }
}
