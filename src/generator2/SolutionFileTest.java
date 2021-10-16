package generator2;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SolutionFileTest {
    public static final List<String> MD_EMPTY_FILE_CONTENT = Collections.singletonList("");
    public static final String MD_TITLE = "Reverse Linked List";
    public static final String MD_URL = "https://leetcode.com/problems/reverse-linked-list/";
    public static final String MD_SOLUTION = """
            ```java
            while head != None:
                prev = head
                head = n_node
            return prev
            ```
            """;

    public static final String MD_RESULT_STRING = "# OUTPUT\n\n" +
            "+ ["+ MD_TITLE + "](#reverse-linked-list)\n" +
            "<!---->\n\n" + "## " + MD_TITLE + "\n\n" + MD_URL + "\n\n" + MD_SOLUTION;

    public List<String> MD_NON_EMPTY_FILE = Arrays.asList("# TESTOUTPUT",
            "\n",
            "+ [Reverse Linked List](#reverse-linked-list)",
            "<!---->",
            "\n",
            "## Reverse Linked List",
            "\n",
            "https://leetcode.com/problems/reverse-linked-list/",
            "\n",
            "```java",
            "while head != None:",
            "    prev = head",
            "    head = n_node",
            "return prev",
            "```");

    @Test
    void testNotEmptyMarkdownFile() {
        SolutionFile res = SolutionFile.parseFile(MD_NON_EMPTY_FILE, Solution.FileType.MARKDOWN, "output");
        List<ItemEntity> lst = List.of(new MarkdownEntity(MD_TITLE, MD_URL, MD_SOLUTION));
        SolutionFile expect = new SolutionFile(lst, Solution.FileType.MARKDOWN, "output");
        assertEquals(expect, res);
    }

    @Test
    void testEmptyMarkdownFile() {
        SolutionFile res = SolutionFile.parseFile(MD_EMPTY_FILE_CONTENT, Solution.FileType.MARKDOWN, "output");
        List<ItemEntity> lst = List.of();
        SolutionFile expect = new SolutionFile(lst, Solution.FileType.MARKDOWN, "output");
        assertEquals(expect, res);
    }

    @Test
    void testToMarkdownString() {
        SolutionFile result = SolutionFile.parseFile(MD_NON_EMPTY_FILE, Solution.FileType.MARKDOWN, "output");
        assertEquals(MD_RESULT_STRING, result.toString());
    }
}