package all.operations;

import java.util.concurrent.Callable;

// Klasa abstrakcyjna reprezentująca operację. Dziedziczą z niej AOperation, BOperation, COperation
public abstract class AbstractOperation implements Callable<double[][]>{
    protected int i;
    protected int k;

    protected double matrix[][];
    public AbstractOperation(int i, int k) {
        this.i = i-1;
        this.k = k-1;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

}
