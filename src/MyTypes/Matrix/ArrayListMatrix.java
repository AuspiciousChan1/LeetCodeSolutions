package MyTypes.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListMatrix<V> implements Matrix<V> {
    ArrayList<ArrayList<V>> matrix;
    V defaultValue;
    int rowAmount;
    int columnAmount;

    public ArrayListMatrix(V defaultValue){
        this.matrix = new ArrayList<>();
        this.defaultValue = defaultValue;
        rowAmount = 0;
        columnAmount = 0;
    }

    @Override
    public void setDefaultValue(V v) {
        this.defaultValue = v;
    }

    @Override
    public V get(int rowIndex, int columnIndex) {
        if(rowIndex >= 0 && rowIndex < this.rowAmount && columnIndex >= 0 && columnIndex < this.columnAmount ){
            return this.matrix.get(rowIndex).get(columnIndex);
        }
        else{
            throw new IndexOutOfBoundsException("\n\tIndex: "+ rowIndex + ", " + columnIndex +"; \n\t" +
                    "Size: " + this.rowAmount + ", " + this.columnAmount +"\n");
        }
    }

    @Override
    public boolean set(int rowIndex, int columnIndex, V v) {
        if(rowIndex < 0 || columnIndex < 0){
            return false;
        }
        else if(rowIndex < this.rowAmount && columnIndex < this.columnAmount ){
            this.matrix.get(rowIndex).set(columnIndex, v);
        }
        else{
            //排数超标
            if(rowIndex >= this.rowAmount){
                ArrayList<V> defaultList = new ArrayList<>(this.columnAmount);
                for(int i = 0; i < this.columnAmount; i++){
                    defaultList.add(this.defaultValue);
                }

                for(int i = this.rowAmount; i <= rowIndex; i++){
                    this.matrix.add(new ArrayList<>(defaultList));
                }
                this.rowAmount = rowIndex + 1;
            }
            //列数超标
            if(columnIndex >= this.columnAmount){
                ArrayList<V> defaultList = new ArrayList<>(columnIndex - this.columnAmount + 1);
                for(int i = this.columnAmount; i <= columnIndex; i++){
                    defaultList.add(this.defaultValue);
                }

                for(int i = 0; i <= rowIndex; i++){
                    this.matrix.get(i).addAll(defaultList);
                }
                this.columnAmount = columnIndex + 1;
            }

            this.matrix.get(rowIndex).set(columnIndex, v);
        }
        return false;
    }
}
