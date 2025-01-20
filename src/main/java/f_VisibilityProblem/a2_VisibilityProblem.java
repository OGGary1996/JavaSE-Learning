package f_VisibilityProblem;

// 本例子体现了内存可见性问题的解决，在需要共享的变量前加上volatile关键字

public class a2_VisibilityProblem {
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        new Thread(() -> {
            while (!flag) {
                // 无限循环，等待flag变为true
            }
            System.out.println("flag is now true");
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("flag is now true");
        }).start();
    }
}
