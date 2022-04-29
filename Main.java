public class Main {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Run());
        Thread t2 = new Thread(new Run());
        Thread t3 = new Thread(new Run());
        Thread t4 = new Thread(new Run());

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

    }
}