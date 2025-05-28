package dataStructureAlgorithm;

import dataStructureAlgorithm.operationOfStack.DynamicStackManual;

// 使用自定义动态数组实现栈
public class j_OperationOfDynamicStack {
    public static void main(String[] args){
        DynamicStackManual dStack = new DynamicStackManual();
        // Push
        for (int i = 1; i <= 20; i++){
            dStack.push(i);
        }
        dStack.show();

        // Pop
        for (int i = 1; i <= 15; i++){
            int pop = dStack.pop();
            System.out.println("Element popped: " + pop);
        }
        dStack.show();
    }
}
