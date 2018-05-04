package thread;

public class Ch1 {
	
	public static void main(String[] args){
		
		MyThread00 mt0 = new MyThread00();
		mt0.start();
		MyThread01 myThread01 = new MyThread01();
		new Thread(myThread01).start();
		
		for (int i = 0; i < 5; i++){
	        System.out.println(Thread.currentThread().getName() + "在运行！");
	    }
	}
}


class  MyThread00 extends Thread{
	
	public void run(){
		for(int i=0;i<5;i++){
			 System.out.println(Thread.currentThread().getName() + "在运行!");
		}
	}
}

class MyThread01 implements Runnable{
	
	public void run(){
		for(int i=0;i<5;i++){
			 System.out.println(Thread.currentThread().getName() + "在运行!");
		}
	}
}
