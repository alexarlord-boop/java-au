package generator2;

import java.util.List;
import java.util.StringJoiner;

public class MarkdownEntity implements ItemEntity {

    private final String taskTitle;
    private String taskUrl;    //// refactor parseEntity method
    private final String taskSolution;

    public MarkdownEntity(String title, String url, String solution) {
        this.taskTitle = title;
        this.taskUrl = url;
        this.taskSolution = solution;
    }

    public static MarkdownEntity parseEntity(List<String> s) {
        String title = s.get(0);
        String url = s.get(2);
        List<String> solution = s.subList(3, s.size());
        String resSolution;

        resSolution = "```python" + String.join("\n", solution) + "```\n";

        return new MarkdownEntity(title, url, resSolution);
    }

    @Override
    public String getTitle() {
        return "+ [" + this.taskTitle + "]" +
                "(#" + this.taskUrl.split("/")[4] + ")";
    }

    @Override
    public String getFormatted() {
        StringBuilder sB = new StringBuilder();
        sB.append("## ").append(this.taskTitle).append("\n\n").append(this.taskUrl).append("\n\n").append(this.taskSolution);
        return sB.toString();
    }


}
