

import java.util.LinkedHashMap;

public class Header {
    int[] Dimensions;
    LinkedHashMap<String, Parameter> InformationList = new LinkedHashMap();
    LinkedHashMap<String, LinkedHashMap> DimensionsList = new LinkedHashMap();
    public Header(int[] dims) {
        this.Dimensions = dims;
        for (int i = 0; i < Dimensions.length; i++)  {
//            addDimension(i);
        }
    }
    public void addDimension(int i){
//        DimensionsList.add(new LinkedHashMap());
        DimensionsList.get(i).put("id",i);
        DimensionsList.get(i).put("info", new String());
        DimensionsList.get(i).put("parameters", new LinkedHashMap());
    }






    public int[] getDimensions() {
        return Dimensions;
    }

    public void setDimensions(int[] dimensions) {
        Dimensions = dimensions;
    }
//
//    public void setDimensionsList(LinkedList<LinkedHashMap> dimensionsList) {
//        DimensionsList = dimensionsList;
//    }
//
//    public LinkedList<LinkedHashMap> getDimensionsList() {
//        return DimensionsList;
//    }
}
