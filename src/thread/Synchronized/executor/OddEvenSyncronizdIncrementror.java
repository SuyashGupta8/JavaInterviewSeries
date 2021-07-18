package thread.Synchronized.executor;

public class OddEvenSyncronizdIncrementror {
    private Integer integer = new Integer(0);
    private Integer maxValue;

    public void printEven(){
        while(integer < maxValue ){

            synchronized (this){
                if(integer%2 != 0){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(integer % 2 == 0){
                    System.out.println("{ " + "\n    " + "\"threadName\": " + Thread.currentThread().getName() +
                            ",\n    " + "\"value:\" "  + integer + "\n }");
                    integer++;
                    this.notifyAll();
                }
            }
        }
    }

    public void printOdd(){
        while(integer < maxValue ){

            synchronized (this){
                if(integer%2 == 0){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(integer % 2 != 0){
                    System.out.println("{ " + "\n    " + "\"threadName\": " + Thread.currentThread().getName() +
                            ",\n    " + "\"value:\" "  + integer + "\n }");
                    integer++;
                    this.notifyAll();
                }
            }
        }
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }
}
