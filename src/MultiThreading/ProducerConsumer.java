package MultiThreading;

/**
 * Problem statement:
 * Company have only one buffer it means it will store only one quantity value.
 * So develop producer and consumer in a way that producer will produce quantity then consumer will consume it. repeat process.
 * Run consumer after producer only and vice versa(One thread at a time)
 */

public class ProducerConsumer {

    public static void main(String[] args){

        Company company = new Company();

        ProducerT producerT = new ProducerT(company);
        Thread thread = new Thread(producerT);
        thread.start();

        ConsumerT consumerT = new ConsumerT(company);
        consumerT.start();
    }
}

class Company {
    int quantity;
    boolean flag = false;

    public synchronized void producerSend(int quantity) throws InterruptedException {
        if(flag) {
            wait();
        }
            this.quantity = quantity;
            System.out.println("Produced quantity " + quantity);
        flag = true;
        notify();
    }

    public synchronized int consumerReceive() throws InterruptedException {
        if(!flag){
            wait();
        }
        System.out.println("Consumed quantity "+this.quantity);
        flag = false;
        notify();
        return this.quantity;
    }
}

class ProducerT implements Runnable{

    Company company;

    public ProducerT(Company company) {
        this.company = company;
    }

    @Override
    public void run() {
        int i =1;
        while(true) {       // Run for unlimited times
            try {
                this.company.producerSend(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}


class ConsumerT extends Thread{

    Company company;

    public ConsumerT(Company company) {
        this.company = company;
    }

    @Override
    public void run() {
        while(true) {       // Run for unlimited times
            try {
                this.company.consumerReceive();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


/* Console output(without wait):
Produced quantity 1
Consumed quantity 1
Produced quantity 2
Consumed quantity 2
Consumed quantity 2
Produced quantity 3
Produced quantity 4
Consumed quantity 4
Consumed quantity 4
Produced quantity 5
Consumed quantity 5
Produced quantity 6
Produced quantity 7
Consumed quantity 7
Consumed quantity 7
Produced quantity 8
Produced quantity 9
Consumed quantity 9
Consumed quantity 9
Produced quantity 10
Produced quantity 11
Consumed quantity 11
Consumed quantity 11
Produced quantity 12
*/

/* Console output(with wait, flag and notify):
Produced quantity 1
Consumed quantity 1
Produced quantity 2
Consumed quantity 2
Produced quantity 3
Consumed quantity 3
Produced quantity 4
Consumed quantity 4
Produced quantity 5
Consumed quantity 5
Produced quantity 6
Consumed quantity 6
Produced quantity 7
Consumed quantity 7
Produced quantity 8
Consumed quantity 8
Produced quantity 9
Consumed quantity 9
*/


