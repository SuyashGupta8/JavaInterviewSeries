package thread.custom.future.call;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ApiData {

    private int dataSize = 1000;
    private List<Integer> asyncApiResponse = new ArrayList();

    public synchronized void doSomeAsyncApiReq(){
        System.out.println("{ \n " + "\"threadName \"" + ":" + Thread.currentThread().getName() + ", " +
                " \n   "  +  "\"methodName \"" + ":" + "doSomeAsyncApiReq" + "\n }"  );
        int i = 0;
        while( i < dataSize){
            i++;
            asyncApiResponse.add(new Random().nextInt());
        }
    }

    public int getDataSize() {
        return dataSize;
    }

    public void setDataSize(int dataSize) {
        this.dataSize = dataSize;
    }

    public List<Integer> getAsyncApiResponse() {
        return asyncApiResponse;
    }

    public void setAsyncApiResponse(List<Integer> asyncApiResponse) {
        this.asyncApiResponse = asyncApiResponse;
    }
}
