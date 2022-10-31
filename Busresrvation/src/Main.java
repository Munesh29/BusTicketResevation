import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws Exception
    {
        File file1=new File("C:\\Users\\91944\\OneDrive\\Documents\\OneDrive\\Documents\\java files\\nonACbus.txt");
        File file2=new File("C:\\Users\\91944\\OneDrive\\Documents\\OneDrive\\Documents\\java files\\acbus.txt");
        Scanner sc=new Scanner(file1);
        Scanner sc1=new Scanner(file2);
        ArrayList<String> ACbus=new ArrayList<String>();
        ArrayList<String> NonACbus=new ArrayList<String>();
        while(sc1.hasNextLine()){
            ACbus.add(sc1.nextLine());
        }
        ACBus ac=new ACBus();
        ac.setbuslist(ACbus);
        ac.setbusdetails();
        while(sc.hasNextLine()){
            NonACbus.add(sc.nextLine());
        }
        NonACBus noac=new NonACBus();
        noac.setbuslist(NonACbus);
        noac.setbusdetails();
        Useraccess usac=new Useraccess();
        usac.useracessing();
        sc1.close();
        sc.close();
    }
}
