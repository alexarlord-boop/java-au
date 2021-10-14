package generator2;

import java.util.List;

public class MarkdownEntity implements ItemEntity {

    private final String taskTitle;
    private final String taskUrl;
    private final String taskSolution;

    public MarkdownEntity(String title, String url, String solution) {
        this.taskTitle = title;
        this.taskUrl = url;
        this.taskSolution = solution;
    }

    public static MarkdownEntity parseEntity(List<String> s) {
        String solution = "```java" + String.join("\n", s.subList(3, s.size())) + "```\n";
        return new MarkdownEntity(s.get(0), s.get(2), solution);
    }

    @Override
    public String getTitle() {
        return "+ [" + this.taskTitle + "]" + "(#" + this.taskUrl.split("/")[4] + ")";
    }

    @Override
    public String getFormatted() {
        return "## " + this.taskTitle + "\n\n" + this.taskUrl + "\n\n" + this.taskSolution;
    }
}
