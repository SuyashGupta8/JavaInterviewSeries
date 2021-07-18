package thread;

import java.util.ArrayList;
import java.util.List;

public class ObjectAcrossMultipleThreads {


    private List<String> list =  new ArrayList();
    private String activity;
    private boolean isCompleted;

    public synchronized void addToList(String string){

        System.out.println("{ \n " + "\"threadName \"" + ":" + Thread.currentThread().getName() + "," +
                " \n   "  +  "\"methodName \"" + ":" + "addToList" + "\n }"  );

        list.add(string);
        isCompleted = true;

        System.out.println("notifying everyone");
        this.notifyAll();
        System.out.println("notified everyone");

    }


    public synchronized void changeElement(String checkString, String updatedString){

        System.out.println("{ \n " + "\"threadName \"" + ":" + Thread.currentThread().getName() + "," +
                " \n   "  +  "\"methodName \"" + ":" + "run" + "\n }"  );

        try {if(!isCompleted)
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < list.size(); i++){
           if(list.get(i).equals(checkString)){
               list.set(i, updatedString);
           }
       }
    }

    public String getLastElement(){
        if(list.size() > 0)
            return list.get(list.size() -1 );
        return null;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
