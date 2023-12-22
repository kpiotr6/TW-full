package all;


import all.operations.AbstractOperation;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<List<AbstractOperation>> l = Reader.readFoata();
    }
}