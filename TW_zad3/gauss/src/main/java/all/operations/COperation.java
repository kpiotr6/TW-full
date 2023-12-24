package all.operations;
// Klasa reprezentująca operację C
public class COperation extends AbstractOperation{
    private int j;
    //    nMatrix służy do przechowywania cząstkowych wartości obliczeń n
    private double[][] nMatrix;
    public COperation(int i, int k, int j) {
        super(i, k);
        this.j = j-1;
    }

    public void setnMatrix(double[][] nMatrix) {
        this.nMatrix = nMatrix;
    }

    @Override
    public double[][] call(){
        matrix[k][j] = matrix[k][j]-nMatrix[k][j];
        return matrix;
    }
}
