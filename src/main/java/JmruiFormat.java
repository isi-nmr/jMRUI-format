public class JmruiFormat {
    Header header;
    NDimensionalArray ndArray;
    int[] dimensions;
    public JmruiFormat(int[] dims) {
        this.dimensions = dims;
        header = new Header(dimensions);
        ndArray = new NDimensionalArray(dimensions);
    }
}
