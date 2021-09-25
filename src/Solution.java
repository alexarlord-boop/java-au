import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String res = new Utils().getCsvFormated(List.of(Map.of("a", "a1","b","b1"),Map.of("c", "c2")));
        System.out.println(res);
    }
}