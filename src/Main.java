import MyTypes.Matrix.ArrayListMatrix;
import utils.Outputs;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayListMatrix<Integer> arrayListMatrix = new ArrayListMatrix<>(0);
        arrayListMatrix.set(5, 5, 10);
        Outputs.outputln(arrayListMatrix.get(5, 5));
        Outputs.outputln(arrayListMatrix.get(6, 8));
        arrayListMatrix.setDefaultValue(5);
        Outputs.outputln(arrayListMatrix.get(5, 5));
        Outputs.outputln(arrayListMatrix.get(6, 8));
    }
}
