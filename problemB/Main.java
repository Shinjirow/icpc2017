import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.List;

public class Main {
    List<String> okList1;
    List<String> ngList1;
    List<String> okList2;
    List<String> ngList2;

    void run(){
        Scanner sc = new Scanner(System.in);
        String line1;
        String line2;
        int count = 1;
        for(;;){
            line1 = sc.nextLine() + "\"";
            if(Objects.equals(line1, ".\"")) return;
            line2 = sc.nextLine() + "\"";
            //line1.matches("\".*\"");
            this.list1Put(line1);
            this.list2Put(line2);

            /*
            System.out.println("ok = " + okList1);
            System.out.println("okList1 length =" + okList1.size());
            System.out.println("ng = " + ngList1);
            System.out.println("ngList1 length =" +ngList1.size());
            System.out.println("ok = " + okList2);
            System.out.println("okList2 length =" +okList2.size());
            System.out.println("ng = " + ngList2);
            System.out.println("ngList2 length =" +ngList2.size());
            System.out.println(okList1.size() == okList2.size());
            System.out.println(ngList1.size() == ngList2.size());
            */

            this.hantei();
        }
    }

    void list1Put(String line){
        okList1 = new ArrayList<>();
        ngList1 = new ArrayList<>();
        int begin = 0;
        int count = 1;
        for (int i = 0;i < line.length();i++){
            char a = line.charAt(i);
            if(Objects.equals(a, '\"')){
                if(count % 2 == 0){
                    okList1.add(line.substring(begin, i));
                }else{
                    ngList1.add(line.substring(begin, i));
                }
                begin = i + 1;
                count++;
            }
        }
    }

    void list2Put(String line){
        okList2 = new ArrayList<>();
        ngList2 = new ArrayList<>();
        int begin = 0;
        int count = 1;
        for (int i = 0;i < line.length();i++){
            char a = line.charAt(i);
            if(Objects.equals(a, '\"')){
                if(count % 2 == 0){
                    okList2.add(line.substring(begin, i));
                }else{
                    ngList2.add(line.substring(begin, i));
                }
                begin = i + 1;
                count++;
            }
        }
    }

    void hantei(){
        Boolean closeortrue = true;
        if(okList1.size() != okList2.size() || ngList1.size() != ngList2.size()){
            System.out.println("DIFFERENT");
            return;
        }

        for(int i = 0;i < ngList1.size();i++){
            if(!Objects.equals(ngList1.get(i), ngList2.get(i))){
                System.out.println("DIFFERENT");
                return;
            }
        }
        for(int i = 0;i < okList1.size();i++){
            if(!Objects.equals(okList1.get(i), okList2.get(i))){
                if(closeortrue){
                    closeortrue = false;
                }else{
                    System.out.println("DIFFERENT");
                    return;
                }
            }
        }
        if(closeortrue){
            System.out.println("IDENTICAL");
        }else{
            System.out.println("CLOSE");
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
