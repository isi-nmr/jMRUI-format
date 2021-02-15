import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) throws IOException {
        Header header = new Header(new int[]{1,5});
        header.getDimensionsList().get(0).put("info", DIM_KEYS.DIM_INDIRECT_0);
        Parameters parameters = new Parameters();
        Parameter parameter = new Parameter("Echo time increment","ms",false, Arrays.asList(new Double[]{0.03, 0.04}));
        Parameter parameter2 = new Parameter("Repitation time increment","ms",false, Arrays.asList(new Double[]{0.04, 0.05}));
        header.getDimensionsList().get(1).put("info", "Echo time increment");
        LinkedList<Parameter> o = (LinkedList<Parameter>) header.getDimensionsList().get(1).get("parameters");
        o.add(parameter);
        o.add(parameter2);
        header.setFieldStrength(new double[] {9.4});
        header.setResonantNucleus(new String[] {Nucleus.N_1H.toString(), Nucleus.N_31P.toString()});
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter file = new FileWriter("test.json");
        gson.toJson(header, file);
        file.flush();

    }

}
