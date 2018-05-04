package thread;

public class Ch2 {

	
	/**
	 * CPU执行哪个线程具有不确定性
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException{
		
//		test1();
//		test2();
//	    test3();
//		test4();
//		test5();
//		test6();
		test7();
	}

	private static void test7() throws InterruptedException {
		 	MyThread36 mt = new MyThread36();
		    mt.start();
		    mt.join();
		    System.out.println("我想当mt对象执行完毕之后我再执行，我做到了");
	}

	private static void test6() {
		
		try
        {
            MyThread11 mt = new MyThread11();
            mt.setDaemon(true);
            mt.start();
            Thread.sleep(5000);
            System.out.println("我离开thread对象再也不打印了，我停止了！");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
	}

	private static void test5() {

		for (int i = 0; i < 5; i++)
	    {
	        MyThread10_0 mt0 = new MyThread10_0();
	        mt0.setPriority(5);
	        mt0.start();
	        MyThread10_1 mt1 = new MyThread10_1();
	        mt1.setPriority(4);
	        mt1.start();
	    }
	}

	private static void test4() {
		 System.out.println("main thread begin, priority = " + 
		            Thread.currentThread().getPriority());
		 System.out.println("main thread end, priority = " + 
		            Thread.currentThread().getPriority());
		 MyThread05_1 thread = new MyThread05_1();
		 thread.start();
	}

	private static void test3() throws InterruptedException {

		MyThread04 myThread04 = new MyThread04();
		System.out.println("开始  ---> "+myThread04.isAlive());
		myThread04.start();
		Thread.sleep(1000);
		System.out.println("结束 ----> " +myThread04.isAlive());
	}

	private static void test2() {
		
		MyThread03 myThread03_1 = new MyThread03();
		MyThread03 myThread03_2 = new MyThread03();
		MyThread03 myThread03_3 = new MyThread03();
		
		new Thread(myThread03_1).start();
		new Thread(myThread03_2).start();
		new Thread(myThread03_3).start();
		
	}

	private static void test1() {
		 MyThread02 mt = new MyThread02();
		    mt.start();
		       
		    try{
		        for (int i = 0; i < 3; i++){
		            Thread.sleep((int)(Math.random() * 1000));
		            System.out.println("run = " + Thread.currentThread().getName());
		        }
		    }
		    catch (InterruptedException e){
		        e.printStackTrace();
		    }
	}
	
}

class MyThread02 extends Thread{
	
	public void run(){
		try{
			for (int i = 0; i < 3; i++){
				
                Thread.sleep((int)(Math.random() * 1000));
                System.out.println("run = " + Thread.currentThread().getName());
            }
		}catch (InterruptedException e){
			
            e.printStackTrace();
        }
	}
}


class MyThread03 implements Runnable{
	
	public void run(){
		System.out.println(Thread.currentThread().getName());
	}
}


class MyThread04 extends Thread{
	
	public void run(){
		System.out.println("run == "+ this.isAlive());
	}
}


class MyThread05_1 extends Thread{
	public void run(){
		System.out.println("MyThread05_1 的优先级为："+this.getPriority());
	}
}


class MyThread10_0 extends Thread
{
    public void run()
    {
        long beginTime = System.currentTimeMillis();
        for (int j = 0; j < 100000; j++){}
        long endTime = System.currentTimeMillis();
        System.out.println("◆◆◆◆◆ thread0 use time = " + 
                (endTime - beginTime));
    }
}

class MyThread10_1 extends Thread
{
    public void run()
    {
        long beginTime = System.currentTimeMillis();
        for (int j = 0; j < 100000; j++){}
        long endTime = System.currentTimeMillis();
        System.out.println("◇◇◇◇◇ thread1 use time = " + 
                (endTime - beginTime));
    }
}


class MyThread11 extends Thread
{
    private int i = 0;
    
    public void run()
    {
        try
        {
            while (true)
            {
                i++;
                System.out.println("i = " + i);
                Thread.sleep(1000);
            }
        } 
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}




class MyThread36 extends Thread
{
    public void run()
    {
        try
        {
            int secondValue = (int)(Math.random() * 10000);
            System.out.println(secondValue);
            Thread.sleep(secondValue);
        } 
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}



