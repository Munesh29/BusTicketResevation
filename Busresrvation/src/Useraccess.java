import java.util.*;;
public class Useraccess {
    Scanner scan=new Scanner(System.in); 
    void useracessing(){
        boolean run=true;
        while(run)
        {
        UserData u=new UserData();
        Boolean check=true;
        while(check){
        System.out.println("\nIf you are new user type \"yes\" or \"no\"");
            String st=scan.next();
        if(st.equalsIgnoreCase("Yes"))
        {
            check=false;
            u.insertdetails();
        }
        else if(st.equalsIgnoreCase("no"))
        {
            check=false;
            boolean c=u.checkdetails();
            if(c){}
            else{u.insertdetails();}
        }
        else{check=true;}}
        boolean again=true;
        while(again){ 
        System.out.println("\nIf you want to booking ticket enter \"1\"\nIf you want to cancel Ticket enter \"2\"");
        System.out.println("If you want to see your previous Ticket Booking list enter \"3\"\nIf you want to logout enter \"0\"");
        String p=scan.next().trim();
            if(p.equals("1")){
            TicketBooking tk=new TicketBooking();
            again=tk.ticketbooking();
        }
        else if(p.equals("2")){
            CancelTicket cl=new CancelTicket();
            again=cl.cancelticket();
        }
        else if(p.equals("3")){
            u.showAllTickets();
        }
        else if(p.equals("0")){
            again=false;
        }
        else{again=true;}
    }
    }  
    }
}

