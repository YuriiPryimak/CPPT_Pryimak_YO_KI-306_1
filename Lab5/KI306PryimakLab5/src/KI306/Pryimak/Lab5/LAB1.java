package KI306.Pryimak.Lab5;
import java.io.*;
import java.util.*;

public class LAB1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File dataFile = new File("Lab1.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        int size;
        String filler;

        System.out.print("\nВведіть розмір квадратної матриці: ");
        size = scanner.nextInt();
        scanner.nextLine();
        //Виділення пам'яті

        char [][]arr = new char[size - 2][];
        arr[0] = new char[size - 2];
        for(int i = 1; i <= size - 4; i++)
            arr[i] = new char[2];
        arr[size - 3] = new char[size - 2];

        System.out.print("\nВведіть символ-заповнювач: ");
        filler = scanner.nextLine();
        exit:
        if (filler.length() == 1) {
            fout.print("\n");
            System.out.print("\n");
            for (int i = 0; i < size - 2; i++) {
                //System.out.print(" ");
                if( i == 0 || i == size - 3) {
                    for (int j = 0; j < size - 2; j++) {
                        arr[i][j] = (char) filler.codePointAt(0);
                        System.out.print(" " + arr[i][j]);
                        fout.print(" " + arr[i][j]);
                    }
                }
                else{
                    for(int j = 0; j < 2; j++){
                        arr[i][j] = (char) filler.codePointAt(0);
                        if(j == 1)
                            for(int l = 1; l < size - 3; l++){
                                System.out.print("  ");
                                fout.print("  ");
                            }
                        fout.print(" " + arr[i][j]);
                        System.out.print(" " + arr[i][j]);
                    }
                }
                System.out.print(" \n");
                fout.print(" \n");
            }
        }
        else if(filler.isEmpty())
        {
            System.out.print("\nНе введено символ заповнювач!");
            break exit;
        }
        else{
            System.out.print("\nЗабагато символів заповнювачів!");
            break exit;
        }
        System.out.println();
        fout.flush();
        fout.close();

        CalcWFio calculator = new CalcWFio();
        calculator.calculate(10); // Example calculation, replace with your logic
        calculator.writeResBin("resultBinary.dat"); // Writing result to binary file
    }
}