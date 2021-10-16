package generator2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    public static final List<String> OLD_CONTENT = Collections.singletonList("");
    public static final List<String> USER_CONTENT = Arrays.asList("Reverse Linked List",
            "\n",
            "https://leetcode.com/problems/reverse-linked-list/",
            "\n",
            "while head != None:",
            "    prev = head",
            "    head = n_node",
            "return prev\n");

    public static final String RESULT = """
            # TESTOUTPUT

            + [Reverse Linked List](#reverse-linked-list)
            <!---->

            ## Reverse Linked List

            https://leetcode.com/problems/reverse-linked-list/

            ```java
            while head != None:
                prev = head
                head = n_node
            return prev
            ```
            """;

    @Test
    void generateContent() {
        assertEquals(RESULT, Application.generateContent(OLD_CONTENT, USER_CONTENT, Application.FileType.MARKDOWN, "testoutput"));
    }
}