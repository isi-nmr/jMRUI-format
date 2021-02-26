import java.util.LinkedHashMap;

public class Dimension extends LinkedHashMap {
    DIM_KEYS info;
    Parameters parameters = new Parameters();
    public Dimension(DIM_KEYS info) {
        this.put("info", info);
        this.put("parameters",parameters);

    }
    public void addParameter(String name, Parameter parameter){
        parameters.put(name, parameter);
    }
}
