    /*"42=*", "43=+", "45=-", "47=/" */
    /*"73=I", "86=V", "88=X"*/
    /*"48=0", "49=1", "50=2", "51=3", "52=4", "53=5", "54=6", "55=7", "56=8", "57=9"*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

    public class Calc
    {
        public static void main(String[] args)
        {
            ArrayList<String> Rome = new ArrayList<>(Arrays.asList("0","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
                    "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV",
                    "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI",
                    "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV",
                    "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"));
            ArrayList<String> Arabica = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));

            String calc = new String();
            String calcNewA = new String();
            String calcNewB = new String();
            System.out.print("Enter an example:");
            Scanner in = new Scanner(System.in);
            calc = in.nextLine();
            int oper =0, pos =0, a =0, b =0, c =0, calcError = 0;
            int sysNumA = 0, sysNumB = 0;

            int operAdd = calc.indexOf("+");
            int operSub = calc.indexOf("-");
            int operMul = calc.indexOf("*");
            int operDiv = calc.indexOf("/");
            if (operAdd == -1 && operSub ==-1 && operMul == -1 && operDiv == -1) {
                oper = 0;
                pos = 0;
                calcError = 1;
            }
            else if (operAdd != -1) {
                oper = 1;
                pos = operAdd;
            }
            else if (operSub != -1) {
                oper = 2;
                pos = operSub;
            }
            else if (operMul != -1) {
                oper = 3;
                pos = operMul;
            }
            else if (operDiv != -1) {
                oper = 4;
                pos = operDiv;
            }
            calcNewA = addStrA(calc, pos);
            calcNewB = addStrB(calc, pos);
            a = Arabica.indexOf(calcNewA);
            b = Arabica.indexOf(calcNewB);
            sysNumA = 1;
            sysNumB = 1;
            if (a == -1) {
                a = Rome.indexOf(calcNewA);
                if (a>10) {
                    calcError = 6;
                }
                sysNumA = 2;
                if (a == -1) {
                    calcError = 5;
                }
            }
            if (b == -1) {
                b = Rome.indexOf(calcNewB);
                if (a>10) {
                    calcError = 6;
                }
                sysNumB = 2;
                if (b == -1) {
                    calcError = 6;
                }
            }
            if (sysNumB != sysNumA ) {
                calcError = 7;
            }

            switch (oper) {
                case (1):  // "+"
                    c = a + b;
                    break;
                case (2):  // "-"
                    c = a - b;
                    break;
                case (3):  // "*"
                    c = a * b;
                    break;
                case (47):  // "/"
                    if (b == 0) {calcError = 2;} //деление на 0
                    else {c = a / b;}
                    break;
                default:
                    calcError = 1;
                    break;
            }

            System.out.print("Replay:");
            if (calcError == 0) {
                if (sysNumA == sysNumB && sysNumA == 2) {
                    String romeRes = Rome.get(c);
                    System.out.print(romeRes +"\r\n");
                }
                else {System.out.print(c +"\r\n");}
            }
            else {
                System.out.print("Throws Exception" +"\r\n");
            }

            System.out.print("press Enter");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();

            //System.out.print(calcNewA + "\r\n");
            //System.out.print(calcNewB + "\r\n");
            //System.out.print("a =" + a + "\r\n");
            //System.out.print("b =" + b + "\r\n");
            //System.out.print("Recult =" + c + "\r\n");
            //System.out.print("Error" + calcError + "\r\n");
        }
////////////////////////**************************////////////////////////
//сборка числа из сторки, до знака
        static String addStrA(String calc, int pos){
            int i =0;
            char calcTempA[] = calc.toCharArray();
            String calcNumA = new String();
            calcNumA = calcNumA.copyValueOf(calcTempA, 0 ,pos);
            return calcNumA;
        }
////////////////////////**************************////////////////////////
//сборка числа из сторки, после знака
        static String addStrB(String calc, int pos){
            int i =0;
            char calcTempB[] = calc.toCharArray();
            pos ++;
            i = calcTempB.length - pos;
            String calcNumB = new String();
            calcNumB = calcNumB.copyValueOf(calcTempB, pos, i);
            return calcNumB;
        }
    }