package thread.custom.future.call;

public class FutureCallBackThread implements Runnable{


    private boolean taskCompleted;
    private ApiData apiData;



    FutureCallBackThread(ApiData apiData){
        this.apiData = apiData;
    }

    @Override
    public void run() {
        synchronized (this){
            System.out.println("{ \n " + "\"threadName \"" + ":" + Thread.currentThread().getName() + "," +
                    " \n   "  +  "\"methodName \"" + ":" + "run" + "\n }"  );
            this.apiData.doSomeAsyncApiReq();
            taskCompleted = true;
            this.notifyAll();
        }
    }

    public synchronized ApiData get(){
        System.out.println("{ \n " + "\"threadName \"" + ":" + Thread.currentThread().getName() + ", " +
                " \n   "  +  "\"methodName \"" + ":" + "ApiData get" + "\n }"  );
        if(!taskCompleted){
            try {
                System.out.println("before waiting state");
                this.wait();
                System.out.println("After waiting state");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return  this.apiData;
    }

    public ApiData getApiData() {
        return apiData;
    }

    public void setApiData(ApiData apiData) {
        this.apiData = apiData;
    }


    public static void main(String []args){

        Thread.currentThread().setName("main_thread");

        FutureCallBackThread futureCallBack = new FutureCallBackThread(new ApiData());

        Thread futureCallBackThread = new Thread(futureCallBack);
        futureCallBackThread.setName("future_call_back_thread");
        futureCallBackThread.start();

        ApiData apiData = futureCallBack.get();
        System.out.println("{ \n " + "\"apiData \"" + ":" + apiData.getAsyncApiResponse().toString() + ", \n }");

    }
}
