

public class JavaCallByValue {

    private String identity;

    public  static void main(String[] args){
        JavaCallByValue obj1 = new JavaCallByValue();
        obj1.identity = "object one";

        JavaCallByValue obj2 = new JavaCallByValue();
        obj2.identity = "object two";

        JavaCallByValue.reassignIdentity(obj1);
        System.out.println("Final identity obtained is " + obj1.identity);
    }

    /**
     * value is thereference of object
     * @param javaCallByValue
     */
    public static void updateIdentity(JavaCallByValue javaCallByValue){
        javaCallByValue.identity = "object updated";
    }

    /**
     *
     * obj1 == "object one"
     * now function called
     * copy of the rfernce holder will
     * inside function reference will never get updated, instead holder value be updated
     * @param javaCallByValue its value is reference
     */
    public static  void  reassignIdentity(JavaCallByValue javaCallByValue){
        System.out.println("value before changing " + javaCallByValue.identity);
        javaCallByValue = new JavaCallByValue();
        javaCallByValue.identity = " new object";
        System.out.println("value after reassigning the object " + javaCallByValue.identity);
    }
}
