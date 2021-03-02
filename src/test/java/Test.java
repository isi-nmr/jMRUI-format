import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Test {
    public static void main(String[] args) throws IOException {
        JmruiFormat jmruiFile = new JmruiFormat(new int[]{2,1,1,10});
        jmruiFile.getHeader().put(TAGS.Field_strength.toString(), new Parameter(null,"Tesla",false, Collections.singletonList(9.4)));
        jmruiFile.getHeader().put(TAGS.Nuclei.toString(), new Parameter(null,null,false, Arrays.asList(new String[]{Nucleus.N_1H.toString(), Nucleus.N_31P.toString()})));
        Dimension dim1 = new Dimension(DIM_KEYS.DIM_INDIRECT_0);
        dim1.addParameter(TAGS.EchoTime.toString(), new Parameter("Echo time increment","ms",false, Arrays.asList(new Double[]{0.03, 0.04})));
        dim1.addParameter(TAGS.RepetitionTime.toString(), new Parameter("Repitation time increment","ms",false, Arrays.asList(new Double[]{0.04, 0.05})));
        jmruiFile.getHeader().put(String.valueOf(DIM_KEYS.DIM_INDIRECT_0), dim1);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <2 ; j++) {
                jmruiFile.getNdArray().set(new int[] {j,0,0,i},Math.random());
            }
        }

        jmruiFile.write("test");
        jmruiFile.read("test");



        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter file = new FileWriter("test.json");
        gson.toJson(jmruiFile.getHeader(), file);
        file.flush();

    }

}
