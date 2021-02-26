import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Test {
    public static void main(String[] args) throws IOException {
        Header header = new Header(new int[]{1,5});
        header.InformationList.put(TAGS.Field_strength.toString(), new Parameter(null,"Tesla",false, Collections.singletonList(9.4)));
        header.InformationList.put(TAGS.Nuclei.toString(), new Parameter(null,null,false, Arrays.asList(new String[]{Nucleus.N_1H.toString(), Nucleus.N_31P.toString()})));
        Dimension dim1 = new Dimension(DIM_KEYS.DIM_INDIRECT_0);
        dim1.addParameter(TAGS.EchoTime.toString(), new Parameter("Echo time increment","ms",false, Arrays.asList(new Double[]{0.03, 0.04})));
        header.DimensionsList.put(String.valueOf(DIM_KEYS.DIM_INDIRECT_0), dim1);
//        Parameter parameter = new Parameter("Echo time increment","ms",false, Arrays.asList(new Double[]{0.03, 0.04}));
//        Parameter parameter2 = new Parameter("Repitation time increment","ms",false, Arrays.asList(new Double[]{0.04, 0.05}));
//        Parameters parameters = new Parameters();
//        parameters.put(TAGS.EchoTime.toString(), new Parameter("Echo time increment","ms",false, Arrays.asList(new Double[]{0.03, 0.04})));
//        parameters.put(TAGS.RepetitionTime.toString(), new Parameter("Repitation time increment","ms",false, Arrays.asList(new Double[]{0.03, 0.04})));
//        header.getDimensionsList().get(0).put("parameters", parameters);

//        header.getDimensionsList().get(1).put("info", "Echo time increment");
//        LinkedList<Parameter> o = (LinkedList<Parameter>) header.getDimensionsList().get(1).get("parameters");
//        o.add(parameter);
//        o.add(parameter2);




        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter file = new FileWriter("test.json");
        gson.toJson(header, file);
        file.flush();

    }

}
