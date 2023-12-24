package all;


import all.operations.AOperation;
import all.operations.AbstractOperation;
import all.operations.BOperation;
import all.operations.COperation;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {
//    Funkcja czyta FNF zapisane w pliku, następnie zwraca List<List<AbstractOperation>>
//    które zawiera wszystkie operację posegregowane według FNF.
    public static List<List<AbstractOperation>> readFoata() throws IOException {
        List<List<AbstractOperation>> operations = new LinkedList<>();
        String file = "src/main/resources/foata.txt";
        String foataLine;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            foataLine = reader.readLine();
        }
        Pattern pattern = Pattern.compile("\\([^\\)]+\\)");
        Matcher mainMatcher = pattern.matcher(foataLine);
        while(mainMatcher.find()){
            List<AbstractOperation> partFoata = new LinkedList<>();
            String part = mainMatcher.group(0);
            part = part.substring(1);
            part = part.substring(0, part.length() - 1);
            String[] operationStrings = part.split("\\|");
            for (int j = 0; j < operationStrings.length; j++) {
                int a, b, c;
                String[] operationElements = operationStrings[j].split(",");
                switch (operationElements[0].charAt(0)) {
                    case 'A':
                        a = Integer.parseInt(operationElements[1]);
                        b = Integer.parseInt(operationElements[2]);
                        partFoata.add(new AOperation(a, b));
                        break;
                    case 'B':
                        a = Integer.parseInt(operationElements[1]);
                        b = Integer.parseInt(operationElements[3]);
                        c = Integer.parseInt(operationElements[2]);
                        partFoata.add(new BOperation(a, b, c));
                        break;

                    case 'C':
                        a = Integer.parseInt(operationElements[1]);
                        b = Integer.parseInt(operationElements[3]);
                        c = Integer.parseInt(operationElements[2]);
                        partFoata.add(new COperation(a, b, c));
                        break;
                }
            }
            operations.add(partFoata);
        }
        return operations;
    }
//    Funkcja czyta z pliku test.txt wartości macierzy na której mamy wykonać eliminację gaussa
    public static double[][] readTest() throws FileNotFoundException, IOException{
        String file = "src/main/resources/test.txt";
        double[][] matrix;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            int inputSize = Integer.parseInt(reader.readLine());
            matrix = new double[inputSize][inputSize+1];
            for(int i=0; i<inputSize+1; i++){
                String line = reader.readLine();
                String[] splitted = line.split(" ");
                for(int j=0;j<splitted.length;j++){
                    matrix[j][i] = Double.parseDouble(splitted[j]);
                }
            }
        }

        return matrix;
   }
//    Funkcja zapisuje do pliku wyniki.
    public static void writeTest(double [][] test) throws FileNotFoundException, IOException{
        String file = "src/main/resources/test_result.txt";
        double[][] matrix;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write(test.length+"\n");
            for(int i=0;i<test[0].length;i++){
                StringBuilder tmp = new StringBuilder();
                for(int j=0;j<test.length;j++){
                    tmp.append(test[j][i]+" ");
                }
                writer.write(tmp.toString()+"\n");
            }
        }
    }
}   
