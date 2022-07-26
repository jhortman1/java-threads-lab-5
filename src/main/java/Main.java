import com.sun.jdi.event.ThreadStartEvent;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SavingsAccount mySavings = new SavingsAccount();

        Thread t1 = new Thread(()->{
            mySavings.deposit(100);
            mySavings.withdraw(50);
        });
        Thread t2 = new Thread(()->{
            mySavings.deposit(20);
            mySavings.withdraw(50);
        });
        Thread t3 = new Thread(()->{
            mySavings.deposit(25);
            mySavings.withdraw(5);
        });

        //+ 100 - 50 = 50
        t1.start();
        //+ 20 - 50 = 20
        t2.start();
        //+ 25 - 5 = 40
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        //40
        System.out.println("Total: " + mySavings.getTotal());
    }
}
