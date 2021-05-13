package jMruiFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class Parameter {
    LinkedHashMap info = new LinkedHashMap();
    List value = new ArrayList();
    public Parameter(String description, String ms, boolean b, List value) {
        info.put("description", description);
        info.put("unit", ms);
        info.put("anonymous", b);
        this.value = value;
    }
    public Parameter(String description, String ms, boolean b, float value) {
        info.put("description", description);
        info.put("unit", ms);
        info.put("anonymous", b);
        this.value = Collections.singletonList(value);
    }
}
