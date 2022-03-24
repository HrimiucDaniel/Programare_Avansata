import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The main program where we create the given graph.
 * The algorithm doesn't include the minimum cost spanning tree algorithm;
 */
public class Homwork4 {
    public static void main(String args[]) {
        City a = new City();
        var nodes = IntStream.rangeClosed(1,9).mapToObj(i -> new Intersection("v" + i)).toArray(Intersection[]::new);
        List<Intersection> nodeList = new ArrayList<>();
        nodeList.addAll(Arrays.asList(nodes));
        List<Intersection> newSortedList = nodeList.stream().sorted(Comparator.comparing(Intersection::getName)).collect(Collectors.toList());


        Street[] e;
        e = new Street[16];
        e[0] = new Street("s12",2);
        e[1] = new Street("s13",2);
        e[2] = new Street("s14",2);
        e[3] = new Street("s23",1);
        e[4] = new Street("s26",3);
        e[5] = new Street("s36",2);
        e[6] = new Street("s34",2);
        e[7] = new Street("s37",2);
        e[8] = new Street("s68",3);
        e[9] = new Street("s45",3);
        e[10] = new Street("s56",1);
        e[11] = new Street("s78",1);
        e[12] = new Street("s89",1);
        e[13] = new Street("s79",1);
        e[14] = new Street("s58",2);
        e[15] = new Street("s59",1);

        a.addIntersectionStreetList(newSortedList.get(0),Arrays.asList(e[0],e[1],e[2]));
        a.addIntersectionStreetList(newSortedList.get(1),Arrays.asList(e[0],e[3],e[4]));
        a.addIntersectionStreetList(newSortedList.get(2),Arrays.asList(e[1],e[3],e[5],e[6],e[7]));
        a.addIntersectionStreetList(newSortedList.get(3),Arrays.asList(e[2],e[6],e[9]));
        a.addIntersectionStreetList(newSortedList.get(4),Arrays.asList(e[14],e[15],e[9],e[10]));
        a.addIntersectionStreetList(newSortedList.get(5),Arrays.asList(e[8],e[5],e[4],e[10]));
        a.addIntersectionStreetList(newSortedList.get(6),Arrays.asList(e[7],e[11],e[13]));
        a.addIntersectionStreetList(newSortedList.get(7),Arrays.asList(e[8],e[11],e[12],e[14]));
        a.addIntersectionStreetList(newSortedList.get(8),Arrays.asList(e[12],e[13],e[15]));

        List<Street> streetList = new ArrayList<>();
        streetList.addAll(Arrays.asList(e));

        //streetList.stream().filter(s -> s.getLength() >= 2 && a.getNumberStreetsAdjacent(s)>=4).forEach(System.out::println);

        //System.out.println(a);


        Faker faker = new Faker();
        for (int i = 0; i < a.getIntersectionsList().size(); i++) {
            a.getIntersectionsList().get(i).setName(faker.name().firstName());
            for (int j = 0; j < a.getCityMap().get(a.getIntersectionsList().get(i)).size();j++) {
                a.getCityMap().get(a.getIntersectionsList().get(i)).get(j).setName(faker.name().lastName());
            }
        }

       // System.out.println(a);
    }
}
