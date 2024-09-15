package MultiThreading;

public class RunnablePractice implements Runnable{

    public static void main(String[] args){
        RunnablePractice practice = new RunnablePractice();
        Thread thread = new Thread(practice);
        thread.start();
    }

    @Override
    public void run() {
        for(int i =1; i<=10; i++){
            System.out.println("Using runnable: "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
