package f_VisibilityProblem;

// 本例子体现了内存可见性问题，即一个线程对共享变量的修改，另一个线程不能立即看到

public class a1_VisibilityProblem {
    private static boolean flag = false;

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
