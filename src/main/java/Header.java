

import java.util.LinkedHashMap;
@Deprecated
public class Header extends LinkedHashMap {
    int[] Dimensions;

    public Header(int[] dims) {
        this.Dimensions = dims;
        this.put("Dimensions", dims);
    }







    public int[] getDimensions() {
        return Dimensions;
    }

    public void setDimensions(int[] dimensions) {
        Dimensions = dimensions;
    }

}
