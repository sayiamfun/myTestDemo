package com.sayiamfun.mytestdemo;

import java.util.concurrent.TimeUnit;


/**
 * @auther zzyy
 * @create 2018-12-12 17:36
 */

/**
 * 死锁原理
 *     根据操作系统中的定义：死锁是指在一组进程中的各个进程均占有不会释放的资源，但因互相申请被其他进程所站用不会释放的资源而处于的一种永久等待状态。
 *
 * 死锁的四个必要条件：
 *      互斥条件(Mutual exclusion)：资源不能被共享，只能由一个进程使用。
 *      请求与保持条件(Hold and wait)：已经得到资源的进程可以再次申请新的资源。
 *      非剥夺条件(No pre-emption)：已经分配的资源不能从相应的进程中被强制地剥夺。
 *      循环等待条件(Circular wait)：系统中若干进程组成环路，该环路中每个进程都在等待相邻进程正占用的资源。
 * 3. 避免死锁
 *      上面1中列出了死锁的四个必要条件，我们只要想办法破其中的任意一个或多个条件，就可以避免死锁发生，一般有以下几种方法(FROM Sql Server 2005联机丛书)：
 *      (1).按同一顺序访问对象。(注：避免出现循环)
 *      (2).避免事务中的用户交互。(注：减少持有资源的时间，较少锁竞争)
 *      (3).保持事务简短并处于一个批处理中。(注：同(2)，减少持有资源的时间)
 *      (4).使用较低的隔离级别。(注：使用较低的隔离级别（例如已提交读）比使用较高的隔离级别（例如可序列化）持有共享锁的时间更短，减少锁竞争)
 *      (5).使用基于行版本控制的隔离级别：2005中支持快照事务隔离和指定READ_COMMITTED隔离级别的事务使用行版本控制，可以将读与写操作之间发生的死锁几率降至最低：
 *      SET ALLOW_SNAPSHOT_ISOLATION ON --事务可以指定 SNAPSHOT 事务隔离级别;
 *      SET READ_COMMITTED_SNAPSHOT ON  --指定 READ_COMMITTED 隔离级别的事务将使用行版本控制而不是锁定。默认情况下(没有开启此选项，没有加with nolock提示)，SELECT语句会对请求的资源加S锁(共享锁)；而开启了此选项后，SELECT不会对请求的资源加S锁。
 *      注意：设置 READ_COMMITTED_SNAPSHOT 选项时，数据库中只允许存在执行 ALTER DATABASE 命令的连接。在 ALTER DATABASE 完成之前，数据库中决不能有其他打开的连接。数据库不必一定要处于单用户模式中。
 *      (6).使用绑定连接。(注：绑定会话有利于在同一台服务器上的多个会话之间协调操作。绑定会话允许一个或多个会话共享相同的事务和锁(但每个回话保留其自己的事务隔离级别)，并可以使用同一数据，而不会有锁冲突。可以从同一个应用程序内的多个会话中创建绑定会话，也可以从包含不同会话的多个应用程序中创建绑定会话。在一个会话中开启事务(begin tran)后，调用exec sp_getbindtoken @Token out;来取得Token，然后传入另一个会话并执行EXEC sp_bindsession @Token来进行绑定(最后的示例中演示了绑定连接)。
 */
public class DeadLockDemo extends Thread
{
    private String lockA;
    private String lockB;

    public DeadLockDemo(String lockA, String lockB)
    {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    public void run()
    {
        synchronized (lockA)
        {
            System.out.println(Thread.currentThread().getName() + " 尝试获得: " + lockA);
            try
            {
                TimeUnit.SECONDS.sleep(2);
                synchronized (lockB)
                {
                    System.out.println(Thread.currentThread().getName() + " 尝试获得: " + lockB);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        String lockA = "lockA";
        String lockB = "lockB";
        DeadLockDemo t1 = new DeadLockDemo(lockA, lockB);
        DeadLockDemo t2 = new DeadLockDemo(lockB, lockA);
        t1.setName("Thread01");
        t2.setName("Thread02");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}