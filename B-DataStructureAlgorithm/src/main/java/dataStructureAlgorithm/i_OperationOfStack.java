package dataStructureAlgorithm;

import dataStructureAlgorithm.operationOfStack.StackManual;

import java.util.Stack;

public class i_OperationOfStack {
    public static void main(String[] args){
        // 使用内置Stack class实现
        Stack<Integer> stack = new Stack<>();
        // Push
            // 随机push10个元素
        for (int i = 0; i < 10; i++){
            int num = (int)(Math.random()*100);
            stack.push(num);
        }
        System.out.println("Stack after push: " + stack);
        // Pop
        int top = stack.pop();
        System.out.println("Element popped: " + top);
        System.out.println("Stack after pop: " + stack);
        // Peek
        int peek = stack.peek();
        System.out.println("Element at the top: " + peek);
        // isEmpty
        System.out.println("Is stack empty? " + stack.isEmpty());
        // Search
            // 根据元素值查找元素在栈中的位置，返回值为距离栈顶的距离，从1开始计数
        int position = stack.search(2);
        System.out.println("The position of element 2 is: " + position);
        int position2 = stack.search(3);
        System.out.println("The position of element 3 is: " + position2);


        // 自定义Stack class实现
        StackManual stackManual = new StackManual(10);
        // Push
        for (int i = 1 ; i <= stackManual.getCapacity(); i++ ){
            stackManual.push(i);
        }

        // Pop
        int pop = stackManual.pop();
        System.out.println("Element popped: " + pop);
        int pop2 = stackManual.popAndDelete();
        System.out.println("Element popped and deleted: " + pop2);

        // peek
        int peak = stackManual.peek();
        System.out.println("Element at the top: " + peak);

        // isEmpty
        System.out.println("Is stack empty? " + stackManual.isEmpty());
        // isFull
        System.out.println("Is stack full? " + stackManual.isFull());

        // Search
        int index = stackManual.searchByData(2);
        System.out.println("The index of data you search is: " + index);
        int data = stackManual.searchByIndex(2);
        System.out.println("The data of index you search is: " + data);

        // Print stack
        stackManual.show();


    }

}
