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
        String userSource = "C:\\Users\\Александр\\OneDrive\\Документы\\testFiles\\testInput.txt";
        String source = "C:\\Users\\Александр\\OneDrive\\Документы\\testFiles\\testOutput.md";
        List<String> userSolutionContent = IOUtil.readData(userSource);
        List<String> oldFileContent = IOUtil.readData(source);

        SolutionFile old = SolutionFile.parseFile(oldFileContent, FileType.MARKDOWN, "testOutput");
        MarkdownEntity entity = MarkdownEntity.parseEntity(userSolutionContent);
        old.add(entity);
        IOUtil.writeData(source, old.toString());
    }
}
