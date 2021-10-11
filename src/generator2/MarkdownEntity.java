package generator2;

import java.util.List;

public class MarkdownEntity implements ItemEntity {

    private String taskTitle;
    private String taskUrl;
    private String taskSolution;

    public MarkdownEntity(String title, String url, String solution) {
        this.taskTitle = title;
        this.taskUrl = url;
        this.taskSolution = solution;
    }

    public static MarkdownEntity parseEntity(List<String> s) {

        //--parsing--//

        String title = "sample title";
        String url = "sample url";
        String solution = "sample solution";

        return new MarkdownEntity(title, url, solution);
    }

    @Override
    public String getTitle() {
        return taskTitle;
    }

    @Override
    public String getFormatted() {
        return taskSolution;
    }


}
