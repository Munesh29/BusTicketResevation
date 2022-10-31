import java.util.*;;
public class CancelTicket extends UserData {
    Scanner scan3=new Scanner(System.in);
    boolean cancelticket(){
        boolean again=true;
        UserData u1=new UserData();
        
        boolean checkId=true;
        while(checkId){
            System.out.println("\nËnter your ticket ID : ");
        String ticketid=scan3.next();
        if(u1.showandcheckTicketId(ticketid)){checkId=false;}
        else{
            System.out.println("\nEntered Ticket Id is invalid");
            System.out.println("\nIf you want to re-enter your ticket id enter \"1\"\nIf you want to exit enter \"9\"");
            int check=scan3.nextInt(); 
            if(check==1){checkId=true;}
            else if(check==9){return true;}
        }
        }
        if(u1.checktickettime()){}
        else{
            System.out.println("\nEntered ticket id is not valid for cancellation\nEnter \"9\" to exit");
            int exit=scan3.nextInt();
            if(exit==9){return true;}
            else{return true;}
        }
        System.out.println("\nIf you want to cancel your ticket enter \"1\"\nIf you want to reduce your seats enter \"2\"\nIf you want to exit enter \"9\"");
        int decide=scan3.nextInt();
        if(decide==1){
            u1.cancelTicket();
        }
        else if(decide==2){
            System.out.println("\nEnter a number of seats you want to reduce : ");
            int seatcount=scan3.nextInt();
            u1.reduceseats(seatcount);
        }
        else if(decide==9){again=true;}
        return again;
    }
}
