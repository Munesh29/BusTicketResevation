import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class TicketBooking {
    static LocalDate date;
    Scanner scan2=new Scanner(System.in);
    boolean ticketbooking(){
        boolean checkBusdetails=true,valid=true,run=true;;
        while(checkBusdetails){
        System.out.println("\nEnter where you want to travel from : ");
        String From=scan2.next();
        System.out.println("\nEnter where you want to end your travel : ");
        String to=scan2.next();
        System.out.println("\nTicket reservation is only available for next 7 seven days\nEnter a date of traveling in a formate \"yyyy-MM-dd\"");
        LocalDate presentdate=LocalDate.now();
        while(valid){
        String dateinput=scan2.next();
        try {
            date=LocalDate.parse(dateinput,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            if(date.compareTo(presentdate)>=1 && date.compareTo(presentdate)<=7){
            valid=false;
            }
            else{  System.out.println("\nPresent day date is "+presentdate+"\nPlease entre a valid date"); }
        }
        catch (Exception e) {  System.out.println("\nPlease entre a valid date format of \"yyyy-MM-dd\" : "); }
        }
        Boolean checkbustype=true;
        while(checkbustype){
        System.out.println("\nIf you want to Travel in ACBus print \"yes\" or \"no\" :");
        String Acornot=scan2.next();
        ACBus Ac=new ACBus();
        NonACBus Noac=new NonACBus();
        if(Acornot.equalsIgnoreCase("yes")){  checkbustype=false;
            int num=Ac.showbusdetails(From,to,date);
            int busavl=Ac.checkBuslistIsAvailable();
            if(busavl==0){
                Boolean check1=true;
                while(check1){
                System.out.println("\nAbove Enetered Ticket details has no Buses\n\nIf you want to re-enter Ticket details enter \"1\"");
                System.out.println("If you want to exit enter \"9\"\nIf you want to logout enter \"0\"");
                String check=scan2.next();
                if(check.equals("1")){checkBusdetails=true;valid=true;check1=false;}
                else if(check.equals("9")){checkBusdetails=false; run=true;check1=false;}
                else if(check.equals("0")){checkBusdetails=false; run=false;check1=false;}
                else{check1=true;}
                }
            }
            else{
                checkBusdetails=false;
                Boolean checkext=true;
                while(checkext){
            System.out.println("\nIf you want to continue enter \"1\"\nIf you want to exit enter \"2\"");
            String ext=scan2.next();
            if(ext.equals("1")){checkext=false;
            System.out.println("\nEnter your bus number : ");
            int busno=scan2.nextInt();
            System.out.println("\nEnter a number of seats needed");
            int numofseats=scan2.nextInt();
            Boolean checkconfirm=true;
            while(checkconfirm){
            System.out.println("\nIf want to confirm your ticket enter\"1\"\nIf you want to exit enter \"2\"\nIf you want to logout enter \"0\"");
            String confirm=scan2.next();
            if(confirm.equals("1")){checkconfirm=false;
                String bustype="AC";
                int busfare=300;
            Ac.updatebookingdetails(busno,numofseats,num);
            Ac.getticketdetails(busno,numofseats,num,From,to,bustype,busfare);
            }
            else if(confirm.equals("2")){ run=true;checkconfirm=false;}
            else if(confirm.equals("0")){ run=false; checkconfirm=false;}
            else{checkconfirm=true;}
        }
        }
        else if(ext.equals("2")){ run=true; checkext=false;} 
        else{checkext=true;}
        }  
        } 
        }
        else if(Acornot.equalsIgnoreCase("no")){ checkbustype=false;
            int num=Noac.showbusdetails(From,to,date);
            int busavl=Noac.checkBuslistIsAvailable();
            if(busavl==0){
                Boolean check1=true;
                while(check1){
                System.out.println("\nAbove Enetered Ticket details has no Buses\n\nIf you want to re-enter Ticket details enter \"1\"");
                System.out.println("If you want to exit enter \"9\"\nIf you want to logout enter \"0\"");
                String check=scan2.next();
                if(check.equals("1")){checkBusdetails=true;valid=true;check1=false;}
                else if(check.equals("9")){checkBusdetails=false; run=true;check1=false;}
                else if(check.equals("0")){checkBusdetails=false; run=false; check1=false;}
                else{check1=true;}
                }
            }
            else{
                checkBusdetails=false;
                Boolean checkext=true;
                while(checkext){
            System.out.println("If you want to continue enter \"1\"\nIf you want to exit enter \"2\"");
            String ext=scan2.next();
            if(ext.equals("1")){checkext=false;
            System.out.println("Enter your bus number : ");
            int busno=scan2.nextInt();
            System.out.println("Enter a number of seats needed");
            int numofseats=scan2.nextInt();
            Boolean checkconfirm=true;
            while(checkconfirm){
            System.out.println("If want to confirm your ticket enter\"1\"\nIf you want to exit enter \"2\"\nIf you want to logout enter \"0\"");
            String confirm=scan2.next();
            if(confirm.equals("1")){checkconfirm=false;
                String bustype="Non AC";
                int busfare=150;
            Noac.updatebookingdetails(busno,numofseats,num);
            Noac.getticketdetails(busno,numofseats,num,From,to,bustype,busfare);
            }
            else if(confirm.equals("2")){ run=true;checkconfirm=false;}
            else if(confirm.equals("0")){ run=false;checkconfirm=false; }
            else{checkconfirm=true;}
        }
        }
        else if(ext.equals("2")){ run=true; checkext=false;}
        else{checkext=true;}
            }
            }
          }
          else{checkbustype=true;}
        }
        }
        return run;
    }
}
