package dataStructureAlgorithm.operationOfStack;
// 通过Fixed Array实现Stack
public class StackManual {

    private int[] stack;
    private int size;
    private int capacity;
    private int top;

    // initialize
    public StackManual(int capacity){
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
        size = 0;
    }

    // determine if the stack is empty or full
    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    // Push
    public void push(int data){
        if (isFull()){
            System.out.println("Stack overflow!");
            return;
        }
        stack[++top] = data;
        size++;
        System.out.println("Data pushed: " + data);
    }

    // Pop
    public int pop(){
        if (isEmpty()){
            System.out.println("Stack underflow!");
            return -1;
        }
        int data = stack[top--];
        size--;
        return data;
    }
    public int popAndDelete(){
        if (isEmpty()){
            System.out.println("Stack underflow!");
            return -1;
        }
        int data = stack[top];
        stack[top] = 0;
        top--;
        size--;
        return data;
    }

    //Peek
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty!");
            return -1;
        }
        return stack[top];
    }

    // Search
    public int searchByData(int data){
        if (isEmpty()){
            System.out.println("Stack is empty!");
            return -1;
        }
        for (int i = 0; i <= top; i++) {
            if (stack[i] == data) {
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
        for (int i = 0; i <= top; i++){
            if (index <= top){
                return stack[index];
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
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    //get the size and capacity of the stack
    public int getSize(){
        return size;
    }
    public int getCapacity(){
        return capacity;
    }

}
