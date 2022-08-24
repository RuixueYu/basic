package interviewcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author : YuRuixue
 * @Description: 三个线程顺序打印字符共100次
 * 第一个线程打印A 第二个线程打印B 第三个线程打印C
 * 使用JUC里面的重入锁ReentrantLock
 * @date :   2022-08-22 18:53
 */
public class ThreeThreadOrderToPrint {
    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Condition conditionA = reentrantLock.newCondition();
        Condition conditionB = reentrantLock.newCondition();
        Condition conditionC = reentrantLock.newCondition();
        Thread t1 = new Thread(new PrintRunner(reentrantLock, conditionA, conditionB, 34, 'A'));
        Thread t2 = new Thread(new PrintRunner(reentrantLock,conditionB, conditionC, 33, 'B'));
        Thread t3 = new Thread(new PrintRunner(reentrantLock,conditionC, conditionA, 33, 'C'));
        t1.start();
        t2.start();
        t3.start();

    }

    static class PrintRunner implements Runnable {
        //重入锁
        private ReentrantLock reentrantLock;

        //代表当前打印字符
        private Condition curCondition;

        //代表下个要打印的字符
        private Condition nextCondition;

        //记录打印字符
        private Integer count;

        //要打印的字符
        private Character character;

        //已打印的个数
        private int index = 0;


        public PrintRunner(ReentrantLock reentrantLock, Condition curCondition, Condition nextCondition, Integer count, Character character) {
            this.reentrantLock = reentrantLock;
            this.curCondition = curCondition;
            this.nextCondition = nextCondition;
            this.count = count;
            this.character = character;
        }
        @Override
        public void run() {
            while (true) {
                reentrantLock.lock();
                if(index <= count) {
                    System.out.print(character);
                    System.out.print(" ");
                    index ++;
                }
                nextCondition.signal();
                try {
                    curCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock.unlock();
            }
        }
    }
}

