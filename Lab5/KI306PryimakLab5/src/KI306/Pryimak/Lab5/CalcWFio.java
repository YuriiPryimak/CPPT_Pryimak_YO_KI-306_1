package KI306.Pryimak.Lab5;

import java.io.*;
import java.util.Scanner;

class CalcWFio {
    private double result;

    public void writeResTxt(String fName) throws FileNotFoundException {
        try (PrintWriter f = new PrintWriter(fName)) {
            f.printf("%f ", result);
        }
    }

    public void readResTxt(String fName) {
        try {
            File f = new File(fName);
            if (f.exists()) {
                try (Scanner s = new Scanner(f)) {
                    result = s.nextDouble();
                }
            } else {
                throw new FileNotFoundException("File " + fName + " not found");
            }
        } catch (FileNotFoundException ex) {
            System.out.print(ex.getMessage());
        }
    }

    public void writeResBin(String fName) throws IOException {
        try (DataOutputStream f = new DataOutputStream(new FileOutputStream(fName))) {
            f.writeDouble(result);
        }
    }

    public void readResBin(String fName) throws IOException {
        try (DataInputStream f = new DataInputStream(new FileInputStream(fName))) {
            result = f.readDouble();
        }
    }

    public static void main(String[] args) {
        // Example usage or testing can be done here
    }

    public void calculate(double x) {
        // Replace this with the appropriate calculation logic
        result = 7 * x / Math.tan(2 * x - 4);
    }

    public double getResult() {
        return result;
    }
}
