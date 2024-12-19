package training.tutorial.exampleThread;
// 之前的方法中，我们使用了extends Thread来创建线程，还有一种方法是实现Runnable接口。
// 当一个class想继承另外一个class，但同时又想创建一个线程时，我们不能使用extends Thread，因为Java不支持多重继承。
// 这时我们可以使用implements Runnable，然后重写run方法。
import training.tutorial.exampleClass.Animal;
public class ThreadC extends Animal implements Runnable {
    public ThreadC(String animalName) { // 创建constructor的原因是Animal class中只有一个constructor，且有参数
        super(animalName);
    }

    public void run() {
        for (int i = 0; i <= 20; i++) {
            System.out.println("ThreadC " + i);
            try {
                Thread.sleep(10); // 手动控制线程执行之后的间隔时间，单位是毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }   
    }
}
