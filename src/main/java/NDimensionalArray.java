import java.util.Arrays;

public class NDimensionalArray {

    private double[] data;
    private int[] dims;
    private int size;


    public NDimensionalArray(int[] dims) {
        this.dims = dims;
        size = 1;
        Arrays.stream(dims).forEach(i -> size *= i);
        this.data = new double[size];
    }

    public double get(int[] idc) {
        int idx = idc[idc.length-1];
        for (int i = idc.length-2; i >= 0 ; i--) {
            idx = ((dims[i] * idx) + idc[i]);
        }
        return data[idx];
    }

    public void set(int[] idc, double val) {
        int idx = idc[idc.length-1];
        for (int i = idc.length-2; i >= 0 ; i--) {
            idx = ((dims[i] * idx) + idc[i]);
        }
        data[idx] = val;
    }


    public int sizeX() {return dims[0];}
    public int sizeY() {return dims[1];}
    public int sizeZ() {return dims[2];}
    public int dimension() {return dims[3];}

    public int[] getDims() {
        return dims;
    }

    public void setDims(int[] dims) {
        this.dims = dims;
    }

    public double[] getData() {
        return data;
    }

    public void setData(double[] data) {
        this.data = data;
    }
}
