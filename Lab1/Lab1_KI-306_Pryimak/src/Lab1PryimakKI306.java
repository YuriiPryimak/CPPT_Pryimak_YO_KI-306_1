import java.io.*;
import java.util.*;

public class Lab1PryimakKI306
{
    /* Статичний метод main є точкою входу в програму*/
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        File dataFile = new File("Lab1.txt");
        PrintWriter fout = new PrintWriter(dataFile);
        int size;
        String filler;
        System.out.print("\nВведіть розмір квадратної матриці: ");
        size = in.nextInt();
        in.nextLine();
        // Виділення пам'яті
        char [][]arr = new char[size - 2][];
        arr[0] = new char[size - 2];
        for(int i = 1; i <= size - 4; i++)
            arr[i] = new char[2];
        arr[size - 3] = new char[size - 2];

        System.out.print("\nВведіть символ-заповнювач: ");
        filler = in.nextLine();
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

        try (DataOutputStream binaryOut = new DataOutputStream(new FileOutputStream("matrixBinary.dat"))) {
            for (int i = 0; i < size - 2; i++) {
                for (int j = 0; j < size - 2; j++) {
                    binaryOut.writeInt(arr[i][j]);  // Замініть це на бінарний запис, наприклад, writeByte або writeInt
                }
            }
        }

        // Reading matrix from binary file and displaying in console
        try (DataInputStream binaryIn = new DataInputStream(new FileInputStream("matrixBinary.dat"))) {
            System.out.println("\nMatrix read from binary file:");

            for (int i = 0; i < size - 2; i++) {
                for (int j = 0; j < size - 2; j++) {
                    char value = binaryIn.readChar();
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        }
    }
    }

