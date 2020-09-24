package com.heps.java_core_technology1.java_thread;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    //可重入锁
    private ReentrantLock bankLock = new ReentrantLock();

    //条件对象，（条件变量）
    private Condition sufficientFunds = bankLock.newCondition();

    private final double[] accounts;

    public Bank(int n,double initialBalance) {
        accounts  = new double[n];
        Arrays.fill(accounts,initialBalance);
    }

    public  void transfer(int from,int to,double amount){
        bankLock.lock();
        try {

            //符合点前的钱不够转账的条件   当前线程等待，直到另一个线程在同一条件上调用signalAll
            while (accounts[from] < amount){
                sufficientFunds.await();
            }
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.println("%10.2f from %d to %d"+amount+from+to);
            accounts[to] += amount;
            System.out.println("Total Balace:%10.2f%n"+getTotalBalance());

            //对象状态变化 给等待的线程一个机会来检查余额  激活等待这个条件的所有线程
            sufficientFunds.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bankLock.unlock();
        }
    }

    public double getTotalBalance(){
        double sum = 0;
        for (double a :
                accounts) {
            sum += a;
        }
        return sum;
    }

    public int size(){
        return accounts.length;
    }

}
