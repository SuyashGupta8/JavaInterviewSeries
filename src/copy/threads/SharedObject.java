package copy.threads;


import java.util.ArrayList;
import java.util.List;

/**
 * list = [left, left , left, left, left] on thread inserting to left
 * another thread updating to right
 */

public class SharedObject{


    private boolean isUpdated;
    private List<String> list = new ArrayList<>();


    public synchronized void addElements(String string){

        System.out.println("{ \n " + "\"threadName \"" + ":" + Thread.currentThread().getName() + "," +
                " \n   "  +  "\"methodName \"" + ":" + "addElements" + "\n }"  );

        list.add(string);
        if(list.size() == 5){
            isUpdated = true;

            System.out.println(" :::: Notify Method Called");
            this.notifyAll();
            System.out.println(" :::: Notify Method Calling Done:::");
        }

    }

    public synchronized void updateElement(String existingString, String toBeUpdated){

        System.out.println("{ \n " + "\"threadName \"" + ":" + Thread.currentThread().getName() + "," +
                " \n   "  +  "\"methodName \"" + ":" + "updateElement" + "\n }"  );
        try {
            System.out.println(" :::: Wait Method Called");
            this.wait();
            System.out.println(" :::: Wait Finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(!isUpdated)return;

        if(list == null) return;

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(existingString)){
                list.set(i, toBeUpdated);
            }
        }
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
