import java.util.*;
import java.util.stream.Collectors;

public class Lab4 {
    public static void main(String args[]) {
        Intersection[] array;
        array = new Intersection[9];
        array[0] = new Intersection("v1");
        array[1] = new Intersection("v2");
        array[2] = new Intersection("v3");
        array[3] = new Intersection("v4");
        array[4] = new Intersection("v5");
        array[5] = new Intersection("v6");
        array[6] = new Intersection("v7");
        array[7] = new Intersection("v8");
        array[8] = new Intersection("v9");

        List<Intersection> nodeList = new ArrayList<>();
        nodeList.addAll(Arrays.asList(array));

        List<Intersection> newSortedList = nodeList.stream().sorted(Comparator.comparing(Intersection::getName)).collect(Collectors.toList());

        Map<Intersection, List<Street>> cityMap = new HashMap<>();

        Street[] e;
        e = new Street[16];
        e[0] = new Street("e1",2);
        e[1] = new Street("e2",2);
        e[2] = new Street("e3",2);
        e[3] = new Street("e4",1);
        e[4] = new Street("e5",3);
        e[5] = new Street("e6",2);
        e[6] = new Street("e7",2);
        e[7] = new Street("e8",2);
        e[8] = new Street("e9",3);
        e[9] = new Street("e10",3);
        e[10] = new Street("e11",1);
        e[11] = new Street("e12",1);
        e[12] = new Street("e13",1);
        e[13] = new Street("e14",1);
        e[14] = new Street("e15",2);
        e[15] = new Street("e16",1);

        cityMap.put(array[0],Arrays.asList(e[0],e[1],e[2]));
        cityMap.put(array[1],Arrays.asList(e[2],e[3],e[4]));
        cityMap.put(array[2],Arrays.asList(e[4],e[5],e[9],e[10]));
        cityMap.put(array[3],Arrays.asList(e[9],e[11],e[12],e[14]));
        cityMap.put(array[4],Arrays.asList(e[1],e[3],e[5],e[6],e[7]));
        cityMap.put(array[5],Arrays.asList(e[0],e[6],e[8]));
        cityMap.put(array[6],Arrays.asList(e[8],e[10],e[14],e[15]));
        cityMap.put(array[7],Arrays.asList(e[7],e[11],e[13]));
        cityMap.put(array[8],Arrays.asList(e[12],e[13],e[15]));


    }
}
