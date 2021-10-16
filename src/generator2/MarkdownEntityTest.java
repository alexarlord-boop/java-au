package generator2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MarkdownEntityTest {

    public static final String TITLE = "Reverse Linked List";
    public static final String URL = "https://leetcode.com/problems/reverse-linked-list/";
    public static final String SOLUTION = """
            ```java
            while head != None:
                prev = head
                head = n_node
            return prev
            ```
            """;
    public static final List<String> ENTITY_CONTENT = Arrays.asList("Reverse Linked List",
            "\n",
            "https://leetcode.com/problems/reverse-linked-list/",
            "\n",
            "while head != None:",
            "    prev = head",
            "    head = n_node",
            "return prev\n");
    public static final String RESULT_TITLE = "+ [Reverse Linked List](#reverse-linked-list)";

    @Test
    void testParseEntity() {
        MarkdownEntity expect = new MarkdownEntity(TITLE, URL, SOLUTION);
        MarkdownEntity res = MarkdownEntity.parseEntity(ENTITY_CONTENT);
        assertEquals(expect, res);
    }

    @Test
    void testParseEmptyEntity() {
        MarkdownEntity expect = new MarkdownEntity("", "", "");
        MarkdownEntity res = MarkdownEntity.parseEntity(Collections.singletonList(""));
        assertEquals(expect, res);
    }

    @Test
    void testGetTitle() {
        MarkdownEntity res = MarkdownEntity.parseEntity(ENTITY_CONTENT);
        assertEquals(RESULT_TITLE, res.getTitle());
    }

    @Test
    void testGetFormatted() {
    }
}