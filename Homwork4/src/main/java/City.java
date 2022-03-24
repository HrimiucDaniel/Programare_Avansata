import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The city class that contain a hashmap where the keys are represented by the Intersections and the values are the list of street adjacent with the intersections;
 * It also contains a list of the intersections present in the map;
 * It can get and set the map through different methods
 */
public class City {
    private Map<Intersection, List<Street>> cityMap = new HashMap<>();
    private List<Intersection> intersectionsList = new ArrayList<>();

    public List<Intersection> getIntersectionsList() {
        return intersectionsList;
    }


    public City() {
    }



    public void addIntersection(Intersection i) {
        for (int j = 0; j < intersectionsList.size(); j++) {
            if (i == intersectionsList.get(j)) return;
        }
        cityMap.put(i, null);
        intersectionsList.add(i);
    }

    public Map<Intersection, List<Street>> getCityMap() {
        return cityMap;
    }


    public void addIntersectionStreet(Intersection i, Street s) {
        for (int j = 0; j < intersectionsList.size(); j++) {
            if (i == intersectionsList.get(j)) return;
        }
        List<Street> s_temp = new ArrayList<>();
        s_temp.add(s);
        cityMap.put(i, s_temp);
        intersectionsList.add(i);
    }
    public void addStreetToIntersection(Street s, Intersection i) {
        List<Street> s_temp = new ArrayList<>();
        s_temp = cityMap.get(i);
        s_temp.add(s);
        cityMap.replace(i,s_temp);
    }
    public void addListStreettoIntersection(List<Street> s, Intersection i){
        List<Street> s_temp = Stream.concat(cityMap.get(i).stream(),s.stream()).collect(Collectors.toList());
        cityMap.replace(i,s_temp);
    }
    public void addIntersectionStreetList(Intersection i, List<Street> s) {
        for (int j = 0; j < intersectionsList.size(); j++) {
            if (i == intersectionsList.get(j)) return;
        }
        cityMap.put(i,s);
        intersectionsList.add(i);
    }

    public int getNumberStreetsAdjacent(Street s) {
        int maximum = 0;
        for (int i = 0; i < intersectionsList.size(); i++) {
            List<Street> s_temp = new ArrayList<>();
            s_temp = cityMap.get(intersectionsList.get(i));
            if (s_temp.contains(s) && s_temp.size()>maximum) {
                maximum = s_temp.size();
            }
        }
        return maximum;
    }

    public Boolean containsIntersection(Intersection i) {
        return cityMap.containsKey(i);
    }
    public int getCitySize() {
        return cityMap.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < intersectionsList.size(); i++) {
            sb.append(intersectionsList.get(i));
            sb.append(" - ");
            if (cityMap.get(intersectionsList.get(i)) != null) {
                for (int j = 0; j < cityMap.get(intersectionsList.get(i)).size(); j++) {
                    sb.append(cityMap.get(intersectionsList.get(i)).get(j));
                    sb.append(",");
                }
            }
            sb.append("\n");
        }
        String s = sb.toString();
        return s;
    }
}
