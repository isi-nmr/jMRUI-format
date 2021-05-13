package jMruiFormat;

import java.util.LinkedHashMap;

public class Dimension extends LinkedHashMap {
    public String KEY;
    Parameters parameters = new Parameters();
    public Dimension(DIM_KEYS KEY, String info) {
        this.put("info", info);
        this.put("parameters",parameters);
        this.KEY = String.valueOf(KEY);
    }
    public void addParameter(String name, Parameter parameter){
        parameters.put(name, parameter);
    }
}
