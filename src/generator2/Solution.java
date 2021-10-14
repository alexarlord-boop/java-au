package generator2;

import java.util.List;

public class Solution {

    enum FileType {
        MARKDOWN("<!---->"),
        HTML("<!---->"),
        LATEX("%----");

        private final String fcomment;

        FileType(String comment) {
            fcomment = comment;
        }

        public String FCOMMENT() {
            return fcomment;
        }

    }

    public static void main(String[] args) {
        String userSource = "";
        String source = "";
        List<String> userSolutionContent = IOUtil.readData(userSource);
        List<String> oldFileContent = IOUtil.readData(source);

        SolutionFile old = SolutionFile.parseFile(oldFileContent, FileType.MARKDOWN, "testOutput");
        old.add(MarkdownEntity.parseEntity(userSolutionContent));
        IOUtil.writeData(source, old.toString());
    }
}
