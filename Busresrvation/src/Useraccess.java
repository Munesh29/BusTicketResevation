import java.util.*;;
public class Useraccess {
    Scanner scan=new Scanner(System.in); 
    void useracessing(){
        boolean run=true;
        while(run)
        {
            
        //Scanner scan=new Scanner(System.in); 
            
        UserData u=new UserData();
        System.out.println("\nIf you are new user type \"yes\" or \"no\"");
        //String st=getuserstring();
            String st=scan.next();
        if(st.equalsIgnoreCase("Yes"))
        {
            u.insertdetails();
        }
        else if(st.equalsIgnoreCase("no"))
        {
            boolean c=u.checkdetails();
            if(c){}
            else{u.insertdetails();}
        }
        boolean again=true;
        while(again){
            
        System.out.println("\nIf you want to booking ticket enter \"1\"\nIf you want to cancel Ticket enter \"2\"");
        System.out.println("If you want to see your previous Ticket Booking list enter \"3\"\nIf you want to logout enter \"0\"");
      
        //int n=getuserchoice();
        String p=scan.next().trim();
        //System.out.println("shidsjf");
            if(p.equals("1")){
            TicketBooking tk=new TicketBooking();
            again=tk.ticketbooking();
            //System.out.println("run "+again);

            
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
    }
    
        }  
       // scan.close();
    }
    
}

