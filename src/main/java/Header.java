import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Header {
    int[] Dimensions;
    double[] FieldStrength;
    String[] ResonantNucleus;
    LinkedList<LinkedHashMap> DimensionsList = new LinkedList<>();
    public Header(int[] dims) {
        this.Dimensions = dims;
        for (int i = 0; i < Dimensions.length; i++)  {
            addDimension(i);
        }
    }
    public void addDimension(int i){
        DimensionsList.add(new LinkedHashMap());
        DimensionsList.get(i).put("id",i);
        DimensionsList.get(i).put("info", "no info");
    }






    public int[] getDimensions() {
        return Dimensions;
    }

    public void setDimensions(int[] dimensions) {
        Dimensions = dimensions;
    }

    public double[] getFieldStrength() {
        return FieldStrength;
    }

    public void setFieldStrength(double[] fieldStrength) {
        FieldStrength = fieldStrength;
    }

    public String[] getResonantNucleus() {
        return ResonantNucleus;
    }

    public void setResonantNucleus(String[] resonantNucleus) {
        ResonantNucleus = resonantNucleus;
    }

    public void setDimensionsList(LinkedList<LinkedHashMap> dimensionsList) {
        DimensionsList = dimensionsList;
    }

    public LinkedList<LinkedHashMap> getDimensionsList() {
        return DimensionsList;
    }
}
