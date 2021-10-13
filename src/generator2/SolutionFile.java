package generator2;

import java.util.ArrayList;
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
        //--parsing--//
        List<ItemEntity> dataList = new ArrayList<ItemEntity>();    // sample data
        switch (fileFormat) {
            case MARKDOWN: {
                dataList = parseMD(content);
            }
        }
        //--parsing--//


        return new SolutionFile(dataList, fileFormat, fileName);
    }

    public List<ItemEntity> add(MarkdownEntity new_item) {
        // working with this.data

        //--addition--//
        this.data.add(new_item);
        //--addition--//

        return this.data;
    }

    @Override
    public String toString() {

        //// cases realisation expected !

        //// MarkDown only
        StringBuilder sB = new StringBuilder();
        StringJoiner jTitles = new StringJoiner("\n");
        StringJoiner jSolutions = new StringJoiner("\n\n");
        //--creating result string--//
        String[] titles = this.data.stream().map(ItemEntity::getTitle).toArray(String[]::new);
        for (String title : titles) { jTitles.add(title); }

        String[] solutions = this.data.stream().map(ItemEntity::getFormatted).toArray(String[]::new);
        for (String sol : solutions) { jSolutions.add(sol); }

        sB.append("# ").append(this.fileName.toUpperCase()).append("\n\n").
                append(jTitles).append("\n").
                append(Solution.FileType.MARKDOWN.FCOMMENT()).
                append("\n\n").append(jSolutions);
        //--creating result string--//

        return sB.toString();
    }

}
