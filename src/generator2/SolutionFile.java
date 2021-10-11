package generator2;

import java.util.ArrayList;
import java.util.List;

public class SolutionFile {

    private List<ItemEntity> data;

    public SolutionFile(List<ItemEntity> dataList) {
        this.data = dataList;
    }

    private static List<ItemEntity> parseMD(List<String> content) {
        List<ItemEntity> lst = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        List<String> links = new ArrayList<>();
        List<String> formattedTasksLines = new ArrayList<>();


        boolean commentIsReached = false;
        int contentSize = content.size();
        int taskId = -1;
        int delimeterId = content.indexOf(Solution.FileType.MARKDOWN.FCOMMENT());
        for (int i = 0; i < contentSize; i++) {
            String line = content.get(i);
            if (line.equals(Solution.FileType.MARKDOWN.FCOMMENT())) {
                commentIsReached = true;
                continue;
            }
            if ((content.indexOf(line) < delimeterId) && (line.contains("+"))) {
                titles.add(line);
                continue;
            }
            if (line.contains("##")) {
                taskId += 1;
                StringBuilder sB = new StringBuilder();
                formattedTasksLines.add("");

                while (!(line.equals("```"))) {
                    if (line.contains("https")){
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


        return new SolutionFile(dataList);
    }

    public List<ItemEntity> add(ItemEntity new_item) {
        List<ItemEntity> newList = null;

        //--addition--//

        return newList;
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();

        //--creating result string--//

        return sBuilder.toString();
    }

}
