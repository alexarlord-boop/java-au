package generator2;

import java.util.List;
import java.util.StringJoiner;

public class MarkdownEntity implements ItemEntity {

    private final String taskTitle;
    private String taskUrl;    //// refactor getFormatted method
    private final String taskSolution;

    public MarkdownEntity(String title, String url, String solution) {
        this.taskTitle = title;
        this.taskUrl = url;
        this.taskSolution = solution;
    }

    public static MarkdownEntity parseEntity(List<String> s) {
        String title = s.get(0);
        String url = s.get(2);
        int d = s.size();
        List<String> solution = s.subList(3, d);

        String resTitle;
        String resSolution;

        //--parsing--//
        String lnkName = url.split("/")[4];
        StringBuilder sB = new StringBuilder("+ [").append(title).append("]").append("(#").
                append(lnkName).append(")");
        resTitle = sB.toString();

        sB.setLength(0);
        StringJoiner sJ = new StringJoiner("\n");
        for (String line : solution) {
            sJ.add(line);
        }

        sB.append("## ").append(title).append("\n\n").append(url).append("\n\n").
                append("```python").append(sJ.toString()).append("```\n");

        resSolution = sB.toString();

        //--parsing--//


        return new MarkdownEntity(resTitle, url, resSolution);
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
