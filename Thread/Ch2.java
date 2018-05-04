package thread;

public class Ch2 {

	
	/**
	 * CPU执行哪个线程具有不确定性
	 * @param args
	 */
	public static void main(String[] args){
		
//		test1();
		test2();
	   
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






















