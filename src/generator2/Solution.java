package generator2;

import java.util.List;

public class Solution {

    enum FileType {
        MARKDOWN("md", "<!---->"),
        HTML("html", "<!---->"),
        LATEX("tex", "%----");

        private final String ftp;
        private final String fcomment;

        FileType(String tp, String comment) {
            ftp = tp;
            fcomment = comment;
        }

        public String FTYPE() {
            return ftp;
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
        MarkdownEntity entity = MarkdownEntity.parseEntity(userSolutionContent);
        old.add(entity);
        IOUtil.writeData(source, old.toString());
    }
}
