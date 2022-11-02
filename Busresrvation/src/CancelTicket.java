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
            boolean check1=true;
            while(check1){
            System.out.println("\nIf you want to re-enter your ticket id enter \"1\"\nIf you want to exit enter \"9\"");
            String check=scan3.next(); 
            if(check.equals("1")){checkId=true; check1=false;}
            else if(check.equals("9")){ check1=false; return true;}
            else{check1=true;}
            }
        }
        }
        if(u1.checktickettime()){}
        else{
            System.out.println("\nEntered ticket id is not valid for cancellation\nEnter \"9\" to exit");
            String exit=scan3.next();
            if(exit.equals("9")){return true;}
            else{return true;}
        }
        boolean check2=true;
        while(check2){
        System.out.println("\nIf you want to cancel your ticket enter \"1\"\nIf you want to reduce your seats enter \"2\"\nIf you want to exit enter \"9\"");
        int decide=scan3.nextInt();
        if(decide==1){check2=false;
            u1.cancelTicket();
        }
        else if(decide==2){check2=false;
            System.out.println("\nEnter a number of seats you want to reduce : ");
            int seatcount=scan3.nextInt();
            u1.reduceseats(seatcount);
        }
        else if(decide==9){again=true;check2=false;}
        else{check2=true;}
        System.out.println("\nTicket Cancellation is successfully updated");
        }
        return again;
    }
}
