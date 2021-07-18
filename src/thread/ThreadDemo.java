package thread;


import java.util.Arrays;
import java.util.List;

class ThreadAddElement implements Runnable{

    private  ObjectAcrossMultipleThreads objectAcrossMultipleThreads;

    public ThreadAddElement(){

    }

    public ThreadAddElement(ObjectAcrossMultipleThreads objectAcrossMultipleThreads){
        this.objectAcrossMultipleThreads = objectAcrossMultipleThreads;
    }


    @Override
    public void run() {
        if(objectAcrossMultipleThreads == null) return;
        List<String> list = Arrays.asList("left", "left", "left", "left", "left");
        for(String string: list){
            objectAcrossMultipleThreads.addToList(string);
        }
    }
}


class ThreadUpdateElement implements Runnable{

    private  ObjectAcrossMultipleThreads objectAcrossMultipleThreads;

    public ThreadUpdateElement(){
    }

    public ThreadUpdateElement(ObjectAcrossMultipleThreads objectAcrossMultipleThreads){
        this.objectAcrossMultipleThreads = objectAcrossMultipleThreads;
    }


    @Override
    public void run() {
        if(objectAcrossMultipleThreads == null) return;
        objectAcrossMultipleThreads.changeElement("left", "right");
    }
}




public class ThreadDemo {

    public static void main(String []args){

        ObjectAcrossMultipleThreads objectAcrossMultipleThreads = new ObjectAcrossMultipleThreads();

        Thread addElementThread = new Thread(new ThreadAddElement(objectAcrossMultipleThreads));
        addElementThread.setName("add_element_thread");

        Thread updateElementThread = new Thread(new ThreadUpdateElement(objectAcrossMultipleThreads));
        updateElementThread.setName("update_element_thread");

        addElementThread.start();
        updateElementThread.start();

        System.out.println("Main thread running");


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(objectAcrossMultipleThreads.getList().toString());
    }
}