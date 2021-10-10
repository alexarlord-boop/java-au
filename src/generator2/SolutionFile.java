package generator2;

import java.util.List;

public class SolutionFile {

    private List<ItemEntity> data;

    public SolutionFile(List<ItemEntity> dataList) {
        this.data = dataList;
    }


    public static SolutionFile parseFile(List<String> content, String fileFormat, String fileName) {

        //--parsing--//

        List<ItemEntity> dataList = null;    // sample data

        return new SolutionFile(dataList);
    }

    public List<ItemEntity> add(ItemEntity new_item) {
        List<ItemEntity> newList = null;

        //--addition--//

        return newList;
    }

    @Override
    public String toString(){
        StringBuilder sBuilder = new StringBuilder();

        //--creating result string--//

        return sBuilder.toString();
    }

}
