package generator2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
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
            ```\n""";
    public static final List<String> ENTITY_CONTENT = Arrays.asList("Reverse Linked List",
            "\n",
            "https://leetcode.com/problems/reverse-linked-list/",
            "\n",
            "while head != None:",
            "    prev = head",
            "    head = n_node",
            "return prev\n");

    @Test
    void parseEntity() {
        MarkdownEntity expect = new MarkdownEntity(TITLE, URL, SOLUTION);
        MarkdownEntity res = MarkdownEntity.parseEntity(ENTITY_CONTENT);
        assertEquals(expect, res);
    }

    @Test
    void getTitle() {
    }

    @Test
    void getFormatted() {
    }

    @Test
    void testParseEntity() {
    }

    @Test
    void testGetTitle() {
    }

    @Test
    void testGetFormatted() {
    }
}