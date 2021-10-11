package generator2;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    enum FileType {
        MARKDOWN("md", "<!---->"), HTML("html", "<!---->");

        private final String ftp;
        private final String fcomment;

        FileType(String tp, String comment){
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
//        ItemEntity someEntity = new MarkdownEntity("title", "url", "solution");
//        List<ItemEntity> lst = new ArrayList<>();


        List<String> userSolutionContent = IOUtil.readData(userSource);
        List<String> oldFileContent = IOUtil.readData(source);
//        String[] parts = source.split("\\.");
        SolutionFile old = SolutionFile.parseFile(oldFileContent, FileType.MARKDOWN, "testOutput");
//        old.add(MarkdownEntity.parseEntity(userSolutionContent));
//        IOUtil.writeData(source, old.toString());
    }
}
