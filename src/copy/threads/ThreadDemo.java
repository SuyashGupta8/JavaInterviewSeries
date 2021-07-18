package copy.threads;


import java.util.Arrays;
import java.util.List;

class AddElementThread implements Runnable {

    private SharedObject sharedObject;

    public  AddElementThread(){

    }

    public AddElementThread(SharedObject sharedObject){
        this.sharedObject = sharedObject;
    }

    @Override
    public void run() {
        if(sharedObject == null) return;
        List<String> inputList = Arrays.asList("left", "left", "left", "left", "left");
        for(String inputString: inputList){
            this.sharedObject.addElements(inputString);
        }
    }
}

class UpdateElementThread implements Runnable {

    private SharedObject sharedObject;

    public  UpdateElementThread(){

    }

    public UpdateElementThread(SharedObject sharedObject){
        this.sharedObject = sharedObject;
    }

    @Override
    public void run() {
        this.sharedObject.updateElement("left", "right");
    }
}



public class ThreadDemo {
    public static void main (String [] args){
        SharedObject sharedObject = new SharedObject();

        Thread addElementThread = new Thread(new AddElementThread(sharedObject));
        addElementThread.setName("ADD_ELEMENT_THREAD");

        Thread updateElementThread = new Thread(new UpdateElementThread(sharedObject));
        updateElementThread.setName("UPDATE_ELEMENT_THREAD");


        addElementThread.start();
        updateElementThread.start();


        try {
            addElementThread.join();
            updateElementThread.join();
            //Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" Main thread executing");
        System.out.println("{ \n   " + "sharedObjectList: " + sharedObject.getList().toString()
        + "\n}");

    }
}
