import java.util.*;

public class Utils {

    public Set<String> getKeys(List<Map<String, String>> data) {
        Set<String> sorted_set = new TreeSet<>();
        for (Map<String, String> map : data) {
            sorted_set.addAll(map.keySet());
        }
        //System.out.println(String.join(",", sorted_set));
        return sorted_set;
    }

    public String getCsvFormated(List<Map<String, String>> data) {
        List<String> lst = new ArrayList<>();
        List<String> row = new ArrayList<>();
        String res = "";
        Set<String> keys = getKeys(data);
        lst.add(String.join(",", keys));
        for (Map<String, String> set : data) {
            for (String key : keys) {
                if (set.containsKey(key)) {
                    row.add(set.get(key));
                } else {
                    row.add("");
                }
            }
            lst.add(String.join(",", row));
            row.clear();
        }
        res = String.join("\n", lst);

        return res;
    }
}
