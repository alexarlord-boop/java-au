# STREAM

+ [Top K Frequent Words](#top-k-frequent-words)
<!---->

## Top K Frequent Words

https://leetcode.com/problems/top-k-frequent-words/

<details>
    <summary> Test Cases </summary>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LeetcodeSolutionTest {
    private LeetcodeSolution solution;

    @BeforeEach
    void setSolution() {
        solution = new LeetcodeSolution();
    }

    @Test
    void testFirstCaseTopKFrequent(){
        int k = 2;
        String[] words = new String[] {"i","love","leetcode","i","love","coding"};
        assertEquals(List.of("i","love"), solution.topKFrequent(words, k));
    }

    @Test
    void testSecondCaseTopKFrequent(){
        int k = 4;
        String[] words = new String[] {"the","day","is","sunny","the","the","the","sunny","is","is"};
        assertEquals(List.of("the","is","sunny","day"), solution.topKFrequent(words, k));
    }

}    
``` 
</details>

```java
public List<String> topKFrequent(String[] words, int k) {
    return Arrays.stream(words)
            .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
            .entrySet()
            .stream()
            .sorted(Map.Entry.<String,Long>comparingByValue().reversed()
                       .thenComparing(Map.Entry.<String,Long>comparingByKey()))
            .map(Map.Entry::<String,Long>getKey)
            .limit(k)
            .collect(Collectors.toList());
}
```
