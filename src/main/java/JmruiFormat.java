import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class JmruiFormat {
    private LinkedTreeMap header;
    private NDimensionalArray ndArray;
    private int[] dimensions;

    public JmruiFormat(int[] dims) {
        this.dimensions = dims;
        header = new LinkedTreeMap();
        header.put("Dimensions", dims);
        int[] ndArrayDims = dims;
        ndArrayDims[0] = 2 * ndArrayDims[0];
        ndArray = new NDimensionalArray(ndArrayDims);
    }

    public void write(String path) throws IOException {
        OutputStream os = new BufferedOutputStream(new FileOutputStream(path+".jmrui"));
        DataOutput dout = new DataOutputStream(os);
        for (double d:ndArray.getData()
             ) {
            dout.writeDouble(d);
        }
        os.close();
        ((DataOutputStream) dout).close();
    }

    public void read(String path) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        LinkedTreeMap header = gson.fromJson(new FileReader(path+".json"), LinkedTreeMap.class);
        int[] dims = ((ArrayList) header.get("Dimensions")).stream().mapToInt(value -> ((Double) value).intValue()).toArray();
        int storageSize = Arrays.stream(dims).reduce(1, (a, b) -> a * b);
        double[] data = new double[storageSize];
        InputStream is = new BufferedInputStream(new FileInputStream(path+".jmrui"));
        DataInput din = new DataInputStream(is);



        for (int i = 0; i < storageSize; i++) {
            data[i] = din.readDouble();
        }
        ndArray.setData(data);
    }



    public LinkedTreeMap getHeader() {
        return header;
    }

    public void setHeader(LinkedTreeMap header) {
        this.header = header;
    }

    public NDimensionalArray getNdArray() {
        return ndArray;
    }

    public void setNdArray(NDimensionalArray ndArray) {
        this.ndArray = ndArray;
    }

    public int[] getDimensions() {
        return dimensions;
    }

    public void setDimensions(int[] dimensions) {
        this.dimensions = dimensions;
    }
}
