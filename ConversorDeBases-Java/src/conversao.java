import java.util.*;
public class Ppi {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        String novamente = "nao";
        System.out.println("\nBem vindo ao conversor de bases");

        do {
            StringBuilder sb = new StringBuilder(), sbaux = new StringBuilder();
            String num = "";
            int posicao = 0, i = 0, resto = 0, decInt = 0, baseDe = 0, basePara = 0;

            System.out.println("\nDigite de qual base gostaria de fazer a conversão:\n1 - Binario\n2 - Octal\n3 - Decimal\n4 - Hexadecimal\n");
            baseDe = tec.nextInt();
            tec.nextLine();

            if(baseDe==3){
                System.out.println("\ndigite o numero: ");
                decInt = tec.nextInt();
            }else{
                System.out.println("\ndigite o numero: ");
                num = tec.nextLine().toLowerCase();
                sb.insert(0, num);
            }

            System.out.println("\nDigite para qual base gostaria de fazer a conversão:\n1 - Binario\n2 - Octal\n3 - Decimal\n4 - Hexadecimal\n");
            basePara = tec.nextInt();

            if(baseDe == 1 && basePara == 2){ // Binario para Octal
                while (sb.length() % 3 != 0) {
                    sb.insert(0, '0');
                }

                StringBuilder resultado = new StringBuilder();

                for (int j = 0; j < sb.length(); j += 3) {
                    String grupo = sb.substring(j, j + 3);
                    switch (grupo) {
                        case "000": resultado.append('0'); break;
                        case "001": resultado.append('1'); break;
                        case "010": resultado.append('2'); break;
                        case "011": resultado.append('3'); break;
                        case "100": resultado.append('4'); break;
                        case "101": resultado.append('5'); break;
                        case "110": resultado.append('6'); break;
                        case "111": resultado.append('7'); break;
                        default:
                            System.out.println("Erro: grupo inválido " + grupo);
                            break;
                    }
                }
                System.out.println(resultado.toString());
            }

            else if (baseDe == 1 && basePara == 4){  // Binario para Hexadecimal
                posicao = num.length();
                i = posicao-4;

                while (posicao%4!=0) {
                    sb.insert(0, '0');
                    posicao++;
                    i++;
                }

                while (i>=0) {
                    switch (sb.substring(i, posicao)) {
                        case "0000":
                            sbaux.insert(0, 0);
                            break;
                        case "0001":
                            sbaux.insert(0, 1);
                            break;
                        case "0010":
                            sbaux.insert(0, 2);
                            break;
                        case "0011":
                            sbaux.insert(0, 3);
                            break;
                        case "0100":
                            sbaux.insert(0, 4);
                            break;
                        case "0101":
                            sbaux.insert(0, 5);
                            break;
                        case "0110":
                            sbaux.insert(0, 6);
                            break;
                        case "0111":
                            sbaux.insert(0, 7);
                            break;
                        case "1000":
                            sbaux.insert(0, 8);
                            break;
                        case "1001":
                            sbaux.insert(0, 9);
                            break;
                        case "1010":
                            sbaux.insert(0, 'a');
                            break;
                        case "1011":
                            sbaux.insert(0, 'b');
                            break;
                        case "1100":
                            sbaux.insert(0, 'c');
                            break;
                        case "1101":
                            sbaux.insert(0, 'd');
                            break;
                        case "1110":
                            sbaux.insert(0, 'e');
                            break;
                        case "1111":
                            sbaux.insert(0, 'f');
                            break;  

                    }  

                i-=4;
                posicao-=4;
                }
                System.out.println(sbaux);

            }

            else if(baseDe == 2 && basePara == 1){  // Octal para Binario
                posicao = num.length();

                do{
                    switch (num.charAt(posicao-1)) {
                        case '0':
                            sbaux.insert(0, "000");
                            break;
                        case '1':
                            sbaux.insert(0, "001");
                            break;
                        case '2':
                            sbaux.insert(0, "010");
                            break;
                        case '3':
                            sbaux.insert(0, "011");
                            break;
                        case '4':
                            sbaux.insert(0, "100");
                            break;
                        case '5':
                            sbaux.insert(0, "101");
                            break;
                        case '6':
                            sbaux.insert(0, "110");
                            break;
                        case '7':
                            sbaux.insert(0, "111");
                            break;
                        default:
                            break;    
                    }

                    posicao--;
                }while(posicao>0);

                while (sbaux.charAt(0)=='0') sbaux.deleteCharAt(0);

                System.out.println(sbaux);
            }

            else if (baseDe != 3 && basePara == 3) {  // Qualquer base para Decimal
                posicao = sb.length()-1;
                int y = 0;
                switch (baseDe) {
                    case 1:
                        y=2;
                        break;
                    case 2:
                        y=8;
                        break;
                    case 4:
                        y=16;
                        break;
                }

                for(i=0; i<sb.length(); i++){
                   switch (sb.charAt(i)) {
                    case 'a':
                        decInt += 10*Math.pow(16, posicao);
                        posicao--;                
                        break;
                    case 'b':
                        decInt += 11*Math.pow(16, posicao);
                        posicao--;
                        break;
                    case 'c':
                        decInt += 12*Math.pow(16, posicao);
                        posicao--;
                        break;
                    case 'd':
                        decInt += 13*Math.pow(16, posicao);
                        posicao--;
                        break;
                    case 'e':
                        decInt += 14*Math.pow(16, posicao);
                        posicao--;
                        break;
                    case 'f':
                        decInt += 15*Math.pow(16, posicao);
                        posicao--;
                        break;
                    default:
                        decInt += (sb.charAt(i)-'0')*Math.pow(y, posicao);
                        posicao--;            
                        break;
                   }

                }

                System.out.println(decInt);
            }

            else if (baseDe == 3 && basePara != 3) {  // Decimal para qualquer base
                switch (basePara) {
                    case 1:
                        i = 2;
                        break;
                    case 2:
                        i = 8;
                        break;
                    case 4:
                        i=16;
                        break;   
                }
                do{

                    resto=decInt%i;
                    decInt/=i;

                    switch (resto) {
                        case 10:
                            sb.insert(0, 'a');
                            break;

                        case 11:
                            sb.insert(0, 'b');
                            break;

                        case 12:
                            sb.insert(0, 'c'); 
                            break;

                        case 13:
                            sb.insert(0, 'd');
                            break;

                        case 14:
                            sb.insert(0, 'e');
                            break;

                        case 15:
                            sb.insert(0, 'f');
                            break; 

                        default:
                            sb.insert(0, resto);
                            break;
                    }

                }while(decInt>0);

                System.out.println(sb);
            }

            else if (baseDe == 4 && basePara == 1) {  // Hexa para Binario
                posicao = sb.length();
                do{
                    switch (sb.charAt(posicao-1)) {
                        case '0':
                            sbaux.insert(0, "0000");
                            break;
                        case '1':
                            sbaux.insert(0, "0001");
                            break;
                        case '2':
                            sbaux.insert(0, "0010");
                            break;
                        case '3':
                            sbaux.insert(0, "0011");
                            break;
                        case '4':
                            sbaux.insert(0, "0100");
                            break;
                        case '5':
                            sbaux.insert(0, "0101");
                            break;
                        case '6':
                            sbaux.insert(0, "0110");
                            break;
                        case '7':
                            sbaux.insert(0, "0111");
                            break;
                        case '8':
                            sbaux.insert(0, "1000");
                            break;
                        case '9':
                            sbaux.insert(0, "1001");
                            break;
                        case 'a':
                            sbaux.insert(0, "1010");
                            break;
                        case 'b':
                            sbaux.insert(0, "1011");
                            break;
                        case 'c':
                            sbaux.insert(0, "1100");
                            break;
                        case 'd':
                            sbaux.insert(0, "1101");
                            break;
                        case 'e':
                            sbaux.insert(0, "1110");
                            break;
                        case 'f':
                            sbaux.insert(0, "1111");
                            break;    
                    }
                    posicao--;
                }while(posicao>0);

                while (sbaux.charAt(0)=='0') sbaux.deleteCharAt(0);

                System.out.println(sbaux);
            }
            else System.out.println("conversão de bases invalida");

            tec.nextLine();
            System.out.println("\nDeseja fazer outra conversão? (sim/nao)");
            novamente = tec.nextLine().toLowerCase();
        } while (novamente.equals("sim"));

        tec.close();

    }
}
