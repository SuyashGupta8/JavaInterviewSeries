package thread.Synchronized.executor;

public class PrintOddEven {

    public static void main(String []args){

        OddEvenSyncronizdIncrementror printOddEven = new OddEvenSyncronizdIncrementror();
        printOddEven.setMaxValue(100);

        Runnable printEven = new Runnable() {
            @Override
            public void run() {
                printOddEven.printEven();
            }
        };

        Runnable printOdd = new Runnable() {
            @Override
            public void run() {
                printOddEven.printOdd();
            }
        };

        Thread pOdd = new Thread(printOdd);
        Thread pEven = new Thread(printEven);

        pOdd.setName("odd Executor");
        pEven.setName("even Executor");
        pOdd.start();
        pEven.start();



        /*try {
           Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        System.out.println("Main Thread Completed");
    }
}
