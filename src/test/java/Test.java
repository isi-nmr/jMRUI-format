import com.google.gson.internal.LinkedTreeMap;
import jMruiFormat.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test {
    public static void main(String[] args) throws IOException {
        JmruiFormat jmruiFile = new JmruiFormat(new int[]{1,1,1,10});
        jmruiFile.getHeader().put(TAGS.Field_strength.toString(), new Parameter(null,"Tesla",false, Collections.singletonList(9.4)));
        jmruiFile.getHeader().put(TAGS.Nuclei.toString(), new Parameter(null,null,false, Arrays.asList(new String[]{Nucleus.N_1H.toString(), Nucleus.N_31P.toString()})));
        Dimension dim1 = new Dimension(DIM_KEYS.DIM_INDIRECT_0, "DIM_INDIRECT_0");
        dim1.addParameter(TAGS.EchoTime.toString(), new Parameter("Echo time increment","ms",false, Arrays.asList(new Double[]{0.03, 0.04})));
        dim1.addParameter(TAGS.RepetitionTime.toString(), new Parameter("Repitation time increment","ms",false, Arrays.asList(new Double[]{0.04, 0.05})));
        jmruiFile.getHeader().put(String.valueOf(DIM_KEYS.DIM_INDIRECT_0), dim1);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <2 ; j++) {
                jmruiFile.getNdArray().set(new int[] {j,0,0,i},Math.random());
            }
        }

        Dimension dim2 = new Dimension(DIM_KEYS.DIM_USER_0, "Metabolite");
        jmruiFile.getHeader().put(dim2.KEY, dim2);

        jmruiFile.write("test");
        JmruiFormat jmruiFile2 = new JmruiFormat();
        jmruiFile2.read("XXX.json");
//        ArrayList metabolites = (LinkedTreeMap)((LinkedTreeMap) jmruiFile2.getHeader().get("DIM_USER_0")).get("parameters"));
        LinkedTreeMap fs = (LinkedTreeMap)(jmruiFile2.getHeader().get(TAGS.Field_strength.toString()));
        ArrayList value = (ArrayList) (fs.get("value"));
        LinkedTreeMap metabolitelist = (LinkedTreeMap) ((LinkedTreeMap)((LinkedTreeMap)((LinkedTreeMap)((LinkedTreeMap)(jmruiFile2.getHeader().get(DIM_KEYS.DIM_USER_0.toString()))).get("parameters"))).get("Metabolites")).get("value");
//        ArrayList value = (ArrayList) (fs.get("value"));
        System.out.println(jmruiFile2);

    }

}
