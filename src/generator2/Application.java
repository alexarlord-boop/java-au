package generator2;

import java.util.List;

public class Application {

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

    public static String generateContent(List<String> oldContent, List<String> newContent, FileType fileType, String fileName) {
        SolutionFile old = SolutionFile.parseFile(oldContent, fileType, fileName);
        old.add(MarkdownEntity.parseEntity(newContent));
        return old.toString();
    }

    public static void main(String[] args) {
        String userSource = "";
        String source = "";
        List<String> newContent = IOUtil.readData(userSource);
        List<String> oldContent = IOUtil.readData(source);

        IOUtil.writeData(source, generateContent(oldContent, newContent, FileType.MARKDOWN, "output"));
    }
}
