package generator2;

import java.util.List;

public class Solution {

    enum FileType {
        MARKDOWN("md"), HTML("html");

        private String fType;

        FileType(String ft) {
            this.fType = ft;
        }


    }

    public static void main(String[] args) {
        String userSource = "solution.txt";
        String source = "array.md";
        List<String> userSolutionContent = IOUtil.readData(userSource);
        List<String> oldFileContent = IOUtil.readData(source);
        String[] parts = source.split("\\.");
        SolutionFile old = SolutionFile.parseFile(oldFileContent, FileType.MARKDOWN.fType, parts[0]);
        old.add(MarkdownEntity.parseEntity(userSolutionContent));
        IOUtil.writeData(source, old.toString());
    }
}
