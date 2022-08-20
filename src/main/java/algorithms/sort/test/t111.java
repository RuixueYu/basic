package algorithms.sort.test;

/**
 * @Author: YuRuixue
 * @Description: TODO
 * @date 2022/7/17/0017 16:05
 */
public class t111 {
    public static void main(String[] args) {
        Thread t= new Thread(){
            @Override
            public void run(){
                pong();
            }
        };
        t.run();
        System.out.println("ping");

    }
    static void pong(){
        System.out.println("pong");
    }
}
