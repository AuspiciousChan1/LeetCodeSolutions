package MyTypes.Matrix;

public interface Matrix <V>{
    void setDefaultValue(V v);
    V get(int rowIndex, int columnIndex);
    boolean set(int rowIndex, int columnIndex, V v);
}
