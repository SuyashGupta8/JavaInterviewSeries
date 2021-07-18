package DesignPattern;

public class SingletonClass {

    private static SingletonClass singletonClass;
    private String testStringId;

    private SingletonClass(){

    }

    public static SingletonClass getSingletonInstance(){
        if(singletonClass == null){
            synchronized (SingletonClass.class){
                if(singletonClass == null){
                    singletonClass = new SingletonClass();
                }
            }
        }
        return singletonClass;
    }
    public void setStringId(String testStringId){
        this.testStringId = testStringId;
    }

    public String getTestStringId() {
        return testStringId;
    }

    public static void main(String [] args){
        SingletonClass singletonClass = SingletonClass.getSingletonInstance();
        singletonClass.setStringId("#11aa");

        SingletonClass singletonClass1 = SingletonClass.getSingletonInstance();
        System.out.println("id obtained is " + singletonClass1.getTestStringId());

    }
}
