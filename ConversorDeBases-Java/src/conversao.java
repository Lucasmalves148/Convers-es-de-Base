
import java.util.Scanner;

public class conversao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um número binário:");
        String binario = sc.nextLine();
        int decimal = Integer.parseInt(binario, 2);
        String octal = Integer.toOctalString(decimal);
        System.out.println("Resultado em octal: " + octal);
        sc.close();
    }
}
