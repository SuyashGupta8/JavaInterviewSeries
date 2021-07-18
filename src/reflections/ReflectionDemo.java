package reflections;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Ref;

/**
 * use of reflection
 * 1) we can change during runtime properties of the class
 * 2) debugging is good with the help of reflections
 * 3) Junit test cases
 */
public class ReflectionDemo {

    private String demoName;

    private ReflectionDemo(){

    }

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName;
    }

    public static void main(String [] args){

        try {
            Class reflectionDemo = Class.forName("reflections.ReflectionDemo");



            //reflectionDemo.getConstructors();


            Field [] fields = reflectionDemo.getDeclaredFields();
            for(Field field: fields){
                System.out.println("field is >>> " + field);
            }

            Method []methods =  reflectionDemo.getDeclaredMethods();
            for(Method method: methods){
                System.out.println("method is >>> " + method);
            }

            ReflectionDemo testDemo = null;

            Constructor [] constructors = reflectionDemo.getDeclaredConstructors();
            for(Constructor constructor : constructors){
                constructor.setAccessible(true);
                try {
                    testDemo = (ReflectionDemo) constructor.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                if(testDemo != null){
                    break;
                }

            }

            testDemo.setDemoName("creating the  object even it has the private constructor");
            System.out.println(testDemo.getDemoName());




        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
