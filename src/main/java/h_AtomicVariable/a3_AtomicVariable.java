package h_AtomicVariable;

// 本例子通过多线程模拟多个线程对一个文本进行累加操作，使用AtomicReference中的compareAndSet()方法来保证线程安全。

import java.util.concurrent.atomic.AtomicReference;

class addText{
    private AtomicReference<String> text = new AtomicReference<>("Initial");

    public void add(){
        String oldText = text.get();
        String newText = oldText + "-> updated by: " + Thread.currentThread().getName();
        boolean success = text.compareAndSet(oldText, newText);
        if (success){
            System.out.println(Thread.currentThread().getName() + " has updated the text to: " + newText);
        }else{
            System.out.println(Thread.currentThread().getName() + " failed to update the text");
        }
    }

    public String getText(){
        return text.get();
    }
}

public class a3_AtomicVariable {
    public static void main(String[] args) {
        addText demoText = new addText();
        Thread write = new Thread(() -> {
            for (int i = 0 ; i < 5 ; i++){
                demoText.add();
            }
        });
        write.start();
        try{
            write.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Result : " + demoText.getText());
    }
}
