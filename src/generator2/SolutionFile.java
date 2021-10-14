package generator2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class SolutionFile {

    private List<ItemEntity> data;
    private Solution.FileType fileFormat;
    private String fileName;

    public SolutionFile(List<ItemEntity> dataList, Solution.FileType fileFormat, String fileName) {
        this.data = dataList;
        this.fileFormat = fileFormat;
        this.fileName = fileName;
    }

    private static List<ItemEntity> parseMD(List<String> content) {
        List<ItemEntity> lst = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        List<String> links = new ArrayList<>();
        List<String> formattedTasksLines = new ArrayList<>();


        int contentSize = content.size();
        int taskId = -1;
        int delimeterId = content.indexOf(Solution.FileType.MARKDOWN.FCOMMENT());
        for (int i = 0; i < contentSize; i++) {
            String line = content.get(i);
            if (line.equals(Solution.FileType.MARKDOWN.FCOMMENT())) {
                continue;
            }
            if ((content.indexOf(line) < delimeterId) && (line.contains("+"))) {
                titles.add(line);
                continue;
            }
            if (line.contains("##")) {
                taskId += 1;
                StringBuilder sB = new StringBuilder();
                sB.append(line).append("\n\n");
                formattedTasksLines.add("");

                while (!(line.equals("```"))) {
                    if (line.contains("https")) {
                        links.add(line);
                    }
                    i++;
                    line = content.get(i + 1);
                    if (line.equals("```")) {
                        sB.append(line);
                        formattedTasksLines.set(formattedTasksLines.size() - 1, sB.toString());

                        ItemEntity enity = new MarkdownEntity(titles.get(taskId), links.get(taskId), formattedTasksLines.get(taskId));
                        lst.add(enity);
                        break;

                    } else {
                        sB.append(line);
                        sB.append("\n");
                        formattedTasksLines.set(formattedTasksLines.size() - 1, sB.toString());
                    }
                }
            }
        }
        return lst;
    }

    public static SolutionFile parseFile(List<String> content, Solution.FileType fileFormat, String fileName) {
        //// cases realisation expected !

        //--parsing--//
        List<ItemEntity> dataList = new ArrayList<ItemEntity>();    // sample data
        switch (fileFormat) {
            case MARKDOWN: {
                dataList = parseMD(content);
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + fileFormat);
        }
        //--parsing--//


        return new SolutionFile(dataList, fileFormat, fileName);
    }

    public List<ItemEntity> add(ItemEntity new_item) {
        //// working with this.data

        //--addition--//
        this.data.add(new_item);
        //--addition--//

        return this.data;
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
            case MARKDOWN: {
                result = mdToString();
            }
            break;
            case HTML: {
                result = htmlToString();
            }
            break;
            case LATEX: {
                result = texToString();
            }
            default:
                throw new IllegalStateException("Unexpected value: " + fileFormat);
        }

        return result;
    }

}
