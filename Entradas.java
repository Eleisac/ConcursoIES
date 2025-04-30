import java.util.ArrayList;
import java.util.Scanner;

//Equipo 4C: Emilio García && David Martínez

public class Entradas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String num;
        do {

            do {
                num = sc.nextLine();

            } while (!isNumber(num) || Integer.parseInt(num) < 0);

            int[] numArray = convertToArray(Integer.parseInt(num));

            int mult, sum = 0, variator = 1;


            for (int i = 0; i < numArray.length; i++) {

                int mayor = 0, menor = numArray[i];
                mult = variator == 1 ? 3 : 2;
                if (mult == 2) {
                    for (int j = 0; j < i; j++) {
                        if (numArray[j] > mayor) mayor = numArray[j];
                    }
                    sum += (mult * numArray[i]) + mayor;
                } else {
                    for (int j = numArray.length - 1; j >= 0; j--) {
                        if (menor < numArray[j]) menor = numArray[j];

                    }
                    sum += (mult * numArray[i]) + menor;
                }

                variator *= -1;
            }
            if (Integer.parseInt(num) !=0)  System.out.println(sum - 1);
        }while(Integer.parseInt(num) !=0);

    }

    public static boolean isNumber(String num)
    {

        for (int i = 0; i < num.length(); i++){

            if ( !Character.isDigit(num.charAt(i)) )return false;
        }
        return true;
    }

    public static int [] convertToArray(int num)
    {

        ArrayList<Integer> intList = new ArrayList<>();


        while (num !=0)
        {
            intList.add(num%10);
            num /=10;

        }
        int [] newArray = new int[intList.size()];
        for (int i = 0; i < intList.size(); i++)
        {
            newArray[i] = intList.get(i);
        }

        return newArray;
    }

}
