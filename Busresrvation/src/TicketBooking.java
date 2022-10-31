import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class TicketBooking extends UserData{
    public static LocalDate date;
    Scanner scan2=new Scanner(System.in);
    boolean ticketbooking()
    {
        System.out.println("\nEnter where you want to travel from : ");
        String From=scan2.next();
        System.out.println("\nEnter where you want to end your travel : ");
        String to=scan2.next();
        System.out.println("\nTicket reservation is only available for next 7 seven days\nEnter a date of traveling in a formate \"yyyy-MM-dd\"");
        boolean valid=true,run=true;
        LocalDate presentdate=LocalDate.now();
        while(valid){
        String dateinput=scan2.next();
        try {
            date=LocalDate.parse(dateinput,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            if(date.compareTo(presentdate)>=1 && date.compareTo(presentdate)<=7){
            valid=false;
            }
            else{
                System.out.println("\nPresent day date is "+presentdate+"\nPlease entre a valid date");
            }
        } catch (Exception e) {
            System.out.println("\nPlease entre a valid date format of \"yyyy-MM-dd\" : ");
        }
        }
        System.out.println("\nIf you want to Travel in ACBus print \"yes\" or \"no\" :");
        String Acornot=scan2.next();
        ACBus Ac=new ACBus();
        NonACBus Noac=new NonACBus();
        if(Acornot.equalsIgnoreCase("yes")){
            int num=Ac.setdetails(From,to,date);
            System.out.println("\nIf you want to continue enter \"1\"\nIf you want to exit enter \"2\"");
            int ext=scan2.nextInt();
            if(ext==1){
            System.out.println("\nEnter your bus number : ");
            int busno=scan2.nextInt();
            System.out.println("\nEnter a number of seats needed");
            int numofseats=scan2.nextInt();
            System.out.println("\nIf want to confirm your ticket enter\"1\"\nIf you want to exit enter \"2\"\nIf you want to logout enter \"0\"");
            String confirm=scan2.next();
            
            if(confirm.equals("1")){
                String bustype="AC";
                int busfare=300;
            Ac.updatebookingdetails(busno,numofseats,num);
            Ac.getticketdetails(busno,numofseats,num,From,to,bustype,busfare);
            }
            else if(confirm.equals("2")){
                run=true;
            }
            else if(confirm.equals("0")){
                run=false;
            }
        }
        else{
            run=true;
        }
            
        }
        else if(Acornot.equalsIgnoreCase("no")){
            int num=Noac.setdetails(From,to,date);
            System.out.println("If you want to continue enter \"1\"\nIf you want to exit enter \"2\"");
            int ext=scan2.nextInt();
            if(ext==1){
            System.out.println("Enter your bus number : ");
            int busno=scan2.nextInt();
            System.out.println("Enter a number of seats needed");
            int numofseats=scan2.nextInt();
            System.out.println("If want to confirm your ticket enter\"1\"\nIf you want to exit enter \"2\"\nIf you want to logout enter \"0\"");
            String confirm=scan2.next();
            if(confirm.equals("1")){
                String bustype="Non AC";
                int busfare=150;
            Noac.updatebookingdetails(busno,numofseats,num);
            Noac.getticketdetails(busno,numofseats,num,From,to,bustype,busfare);
            }
            else if(confirm.equals("2")){
                run=true;
            }
            else if(confirm.equals("0")){
                run=false;
            }
        }
        else{
            run=true;
        }
        }
        return run;
    }
}
