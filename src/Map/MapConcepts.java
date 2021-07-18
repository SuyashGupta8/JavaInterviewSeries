package Map;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapConcepts extends Object {

    private int id;
    private String secret;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public boolean equals(Object o) {
       /* if (this == o) return true;
        if (!(o instanceof MapConcepts)) return false;
        MapConcepts that = (MapConcepts) o;
        return getId() == that.getId() && getSecret().equals(that.getSecret());*/
        return false;
    }

    @Override
    public int hashCode() {
        //return Objects.hash(getId(), getSecret());

        return 1;
    }

    /*@Override
    public String toString() {
        return "MapConcepts{" +
                "id=" + id +
                ", secret='" + secret + '\'' +
                '}';
    }*/

    //@Override
    /**
     *{ [key1] --> [v1,v2,v3]
     * [key2] --> [v1,v2,v3] }
     * @return
     */
    public static void main (String[] args){


        Map<MapConcepts, String> testMap = new HashMap<>();

        MapConcepts mapConcepts1 = new MapConcepts();
        mapConcepts1.setId(1);
        mapConcepts1.setSecret("one");

        MapConcepts mapConcepts2 = new MapConcepts();
        mapConcepts2.setId(2);
        mapConcepts2.setSecret("two");

        testMap.put(mapConcepts1, "one");
        testMap.put(mapConcepts2, "two");

        System.out.println("test map built it >>> " + testMap.toString());

        System.out.println("test map get object >>> " + testMap.get(mapConcepts1).toString());
        System.out.println("test map get object2 >>> " + testMap.get(mapConcepts2).toString());

        System.out.println("Size of test map built it >>> " + testMap.size());


    }
}
