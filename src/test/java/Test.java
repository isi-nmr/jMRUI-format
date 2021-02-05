import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        Header header = new Header(new int[]{1,5});
        header.getDimensionsList().get(0).put("info", "TE");
        header.getDimensionsList().get(1).put("info", "TR");
        header.setFieldStrength(new double[] {9.4});
        header.setResonantNucleus(new String[] {Nucleus.N_1H.toString(), Nucleus.N_31P.toString()});
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter file = new FileWriter("test.json");
        gson.toJson(header, file);
        file.flush();

    }

}
