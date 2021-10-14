package generator2;

import java.util.ArrayList;
import java.util.List;

public class SolutionFile {

    private final List<ItemEntity> data;
    private final Solution.FileType fileFormat;
    private final String fileName;

    public SolutionFile(List<ItemEntity> dataList, Solution.FileType fileFormat, String fileName) {
        this.data = dataList;
        this.fileFormat = fileFormat;
        this.fileName = fileName;
    }

    private static List<ItemEntity> parseMD(List<String> content) {
        List<ItemEntity> lst = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        List<String> links = new ArrayList<>();


        int contentSize = content.size();
        int taskCount = 0;
        int delimeterId = content.indexOf(Solution.FileType.MARKDOWN.FCOMMENT());
        int i = 0;
        while (i < delimeterId) {
            String line = content.get(i);
            if (line.contains("+ [")) {
                titles.add(line.split("[\\[\\]]")[1]);
            }
            i++;
        }
        i++;
        while (i > delimeterId && i < contentSize) {
            String line = content.get(i);
            if (line.contains("http")) {
                links.add(line);
                i++;
            } else if (line.contains("```python")) {
                StringBuilder sB = new StringBuilder();
                while (!line.equals("```")) {
                    line = content.get(i);
                    sB.append(line).append("\n");
                    i++;
                }
                ItemEntity entity = new MarkdownEntity(titles.get(taskCount), links.get(taskCount), sB.toString());
                taskCount++;
                lst.add(entity);
            }
            i++;
        }

        return lst;
    }

    private static List<ItemEntity> parseHTML(List<String> content) {
        List<ItemEntity> lst = new ArrayList<>();
        return lst;
    }

    private static List<ItemEntity> parseLATEX(List<String> content) {
        List<ItemEntity> lst = new ArrayList<>();
        return lst;
    }

    public static SolutionFile parseFile(List<String> content, Solution.FileType fileFormat, String fileName) {
        List<ItemEntity> dataList = new ArrayList<ItemEntity>();
        switch (fileFormat) {
            case MARKDOWN -> {
                dataList = parseMD(content);
            }
            case HTML -> {
                dataList = parseHTML(content);
            }
            case LATEX -> {
                dataList = parseLATEX(content);
            }
            default -> throw new IllegalStateException("Unexpected value: " + fileFormat);
        }

        return new SolutionFile(dataList, fileFormat, fileName);
    }

    public void add(ItemEntity new_item) {
        this.data.add(new_item);
    }

    private String mdToString() {
        StringBuilder sB = new StringBuilder();

        String titles = String.join("\n", this.data.stream().map(ItemEntity::getTitle).toArray(String[]::new));
        String solutions = String.join("\n\n", this.data.stream().map(ItemEntity::getFormatted).toArray(String[]::new));

        sB.append("# ").append(this.fileName.toUpperCase()).append("\n\n").
                append(titles).append("\n").
                append(Solution.FileType.MARKDOWN.FCOMMENT()).
                append("\n\n").append(solutions);

        return sB.toString();
    }

    private String htmlToString() {
        return null;
    }

    private String texToString() {
        return null;
    }

    @Override
    public String toString() {
        String result;
        switch (fileFormat) {
            case MARKDOWN -> {
                result = mdToString();
            }
            case HTML -> {
                result = htmlToString();
            }
            case LATEX -> {
                result = texToString();
            }
            default -> throw new IllegalStateException("Unexpected value: " + fileFormat);
        }

        return result;
    }
}
