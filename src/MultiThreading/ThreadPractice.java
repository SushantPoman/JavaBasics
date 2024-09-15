package MultiThreading;

public class ThreadPractice extends Thread{

    public static void main(String[] args){
        ThreadPractice practice = new ThreadPractice();
        practice.start();
    }

    @Override
    public void run() {
        for(int i =10; i>=1; i--){
            System.out.println("Using runnable: "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
