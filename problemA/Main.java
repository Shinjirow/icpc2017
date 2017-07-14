import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    List<Integer> data;

    void run(){
        Scanner sc = new Scanner(System.in);

        for(;;){
            data = new ArrayList<>();
            int numberOfShohin = sc.nextInt();
            int maxMoney = sc.nextInt();
            if((numberOfShohin == 0) && (maxMoney == 0)) return;

            /*
            System.out.println("数" + numberOfShohin);
            System.out.println("最大" + maxMoney);
            */

            for(int count = 0;count < numberOfShohin;count++){
                data.add(sc.nextInt());
            }
            int max = 0;
            int number1;
            int number2 = 0;
            int tmp;

            for(int i = 0;i < numberOfShohin;i++){
                number1 = data.get(i);
                for(int j = 0;j < numberOfShohin; j++){
                    if(i != j){
                        number2 = data.get(j);
                        tmp = number1 + number2;
                        if((tmp <= maxMoney) && (tmp > max)){
                            max = tmp;
                        }
                    }
                }
            }
            if(max == 0){
                System.out.println("NONE");
            }else{
                System.out.println(max);
            }
            /*
            System.out.println(data);
            */
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
