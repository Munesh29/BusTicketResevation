import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class UserData {
    ArrayList<String> logindetails=new ArrayList<>();
    ArrayList<ArrayList<String>> userdetails=new ArrayList<>();
    static ArrayList<ArrayList<ArrayList<String>>> userlist=new ArrayList<>(); 
    static int id=0;
    static int userindex;
    Scanner scan1=new Scanner(System.in);
        void insertdetails() {
        boolean olduser=true;
        while(olduser){
        System.out.println("\nEnter user name : ");
        String st=scan1.next();
        int flag=0;
        for(int i=0;i<userlist.size();i++)
        {
            if(st.equals(userlist.get(i).get(0).get(0))){
                System.out.println("\nUsername is already exist ");
                flag=1;
                break;
            }
        }
        if(flag==0){
        logindetails.add(st);
        olduser=false;}
        else{
            olduser=true;
        }
        }
        System.out.println("\nEnter password : ");
        logindetails.add(scan1.next());
        System.out.println("\nEnter emailid or phone number : ");
        logindetails.add(scan1.next());
        userdetails.add(logindetails);
        userlist.add(0,userdetails);
        userindex=0;
    }
    int p=0;
    boolean checkdetails(){
        boolean reCheck=true,ForCreateNewuser=true;
        while(reCheck){
            p=0;
        System.out.println("\nEnter your user name : ");
        String username=scan1.next();
        System.out.println("\nEnter your password : ");
        String passwrd=scan1.next();
        for(int i=0;i<userlist.size();i++)
        {
            if(userlist.get(i).get(0).get(0).equals(username))
            {
                if(userlist.get(i).get(0).get(1).equals(passwrd))
                {
                    p=1;
                    userindex=i;
                }
            }
        }
            if(p==1){
                ForCreateNewuser=true;
                reCheck=false;
            }
            else{
                System.out.println("\nEntered username or password is incorrect\nIf you forget your password enter \"yes\" or \"no\" to re-enter your password");
                String str=scan1.next();
                if(str.equalsIgnoreCase("Yes"))
                {
                    System.out.println("\nEnter emailid or phone number : ");
                    String email=scan1.next();
                    for(int i=0;i<userlist.size();i++)
                    {
                        if(userlist.get(i).get(0).get(0).equals(username))
                        {
                            if(userlist.get(i).get(0).get(2).equals(email))
                            {
                                System.out.println("\nYour passsword is : "+userlist.get(i).get(0).get(1));
                                reCheck=true;
                                p=1;
                                break;
                            }
                        }
                    }
                    if(p==0){
                        System.out.println("\nInvalid emailid or phone number\nIf you want re-enter user name and password enter \"1\"\nEnetr \"2\" for create new user id");
                        int num=scan1.nextInt();
                        if(num==1)
                        {
                            reCheck=true;
                        }
                        else if(num==2){
                            ForCreateNewuser=false;
                            reCheck=false;
                        }
                    }

                }
                else if(str.equalsIgnoreCase("no"))
                {
                    reCheck=true;
                }
            }
        }
        return ForCreateNewuser;
    }
    void setticketsdetails(int busnum,int bookseat,LocalDate presentdate,LocalDate traveldate,String from,String to,String traveltime,String bustype,int busfare){
       ArrayList<String> ticketdetails=new ArrayList<>();
       id++;
       ticketdetails.add(String.valueOf(busnum));
       ticketdetails.add(String.valueOf(bookseat));
       ticketdetails.add(String.valueOf(presentdate));
       ticketdetails.add(String.valueOf(traveldate));
       ticketdetails.add(bustype);
       ticketdetails.add(from);
       ticketdetails.add(to);
       ticketdetails.add(traveltime);
       LocalTime presenttime=LocalTime.now();
       ticketdetails.add(String.valueOf(presenttime));
       ticketdetails.add("PDID000"+id);
       ticketdetails.add(String.valueOf(bookseat*busfare));
       userlist.get(userindex).add(1,ticketdetails);
    }
    void getticket(){
        System.out.println("\n------------------------------------------------------------------------");
        System.out.println("\nBooking Date : "+userlist.get(userindex).get(1).get(2)+"\tBooking Time : "+userlist.get(userindex).get(1).get(8));
        System.out.println("\nTicketID : "+userlist.get(userindex).get(1).get(9)+"\t\tUsername : "+userlist.get(userindex).get(0).get(0)+"\t\tBusType: "+userlist.get(userindex).get(1).get(4));
        System.out.println("\nDate of Traveling:"+userlist.get(userindex).get(1).get(3)+"\tBusTime : "+userlist.get(userindex).get(1).get(7)+"\t\tBus Number:"+userlist.get(userindex).get(1).get(0));
        System.out.println("\nForm :"+userlist.get(userindex).get(1).get(5)+" To :"+userlist.get(userindex).get(1).get(6)+"\tNumber of Seats:"+userlist.get(userindex).get(1).get(1)+"\t Amount : "+userlist.get(userindex).get(1).get(10));
        System.out.println("\n------------------------------------------------------------------------");
    }
    void showAllTickets(){
        int flag=0;
         for(int i=1;i<(userlist.get(userindex).size());i++){
            flag=1;
            System.out.println("\n------------------------------------------------------------------------");
            System.out.println("\nBooking Date : "+userlist.get(userindex).get(i).get(2)+"\tBooking Time : "+userlist.get(userindex).get(i).get(8));
            System.out.println("\nTicketID : "+userlist.get(userindex).get(i).get(9)+"\t\tUsername : "+userlist.get(userindex).get(0).get(0)+"\t\tBusType: "+userlist.get(userindex).get(i).get(4));
            System.out.println("\nDate of Traveling:"+userlist.get(userindex).get(i).get(3)+"\tBusTime : "+userlist.get(userindex).get(i).get(7)+"\t\tBus Number:"+userlist.get(userindex).get(i).get(0));
            System.out.println("\nForm: "+userlist.get(userindex).get(i).get(5)+" To:"+userlist.get(userindex).get(i).get(6)+"\tNumber of Seats:"+userlist.get(userindex).get(i).get(1)+"\tAmount : "+userlist.get(userindex).get(i).get(10));
            System.out.println("\n------------------------------------------------------------------------");
        }
        if(flag==0)
        {System.out.println("\nYour Ticket list is Empty");}
    }
    static int ticketindex; 
    boolean showandcheckTicketId(String id){
        int flag=0;
        for(int i=1;i<userlist.get(userindex).size();i++){
            if(userlist.get(userindex).get(i).get(9).equals(id)){flag=1;
                System.out.println("\n------------------------------------------------------------------------");
                System.out.println("\nBooking Date : "+userlist.get(userindex).get(i).get(2)+"\tBooking Time : "+userlist.get(userindex).get(i).get(8));
                System.out.println("\nTicketID : "+userlist.get(userindex).get(i).get(9)+"\t\tUsername : "+userlist.get(userindex).get(0).get(0)+"\t\tBusType: "+userlist.get(userindex).get(i).get(4));
                System.out.println("\nDate of Traveling:"+userlist.get(userindex).get(i).get(3)+"\tBusTime : "+userlist.get(userindex).get(i).get(7)+"\t\tBus Number:"+userlist.get(userindex).get(i).get(0));
                System.out.println("\nForm: "+userlist.get(userindex).get(i).get(5)+" To:"+userlist.get(userindex).get(i).get(6)+"\tNumber of Seats:"+userlist.get(userindex).get(i).get(1)+"\tAmount : "+userlist.get(userindex).get(i).get(10));
                System.out.println("\n------------------------------------------------------------------------");
                ticketindex=i;
            }
        }
        if(flag==1){return true;}
        else{return false;}
    }
    boolean checktickettime(){
        LocalTime time=LocalTime.now();
        LocalDate date=LocalDate.now();
        DateTimeFormatter timeformat=DateTimeFormatter.ofPattern("HH:mm");
        String persentime=time.format(timeformat),persentdate=String.valueOf(date);
        String[] presentime=persentime.split(":"),tickettime=userlist.get(userindex).get(ticketindex).get(7).split(":");
        String[] presentdate=persentdate.split("-"),ticketdate=userlist.get(userindex).get(ticketindex).get(3).split("-");
        if(Integer.parseInt(ticketdate[1])>Integer.parseInt(presentdate[1])){return true;}
        else if(Integer.parseInt(ticketdate[1])==Integer.parseInt(presentdate[1])){
            if(Integer.parseInt(ticketdate[2])>Integer.parseInt(presentdate[2])){return true;}
            else if(Integer.parseInt(ticketdate[2])==Integer.parseInt(presentdate[2])){
                if((Integer.parseInt(tickettime[0])-Integer.parseInt(presentime[0]))>4){return true;}
                else{return false;}
            }
            else{return false;}
        }
        else{return false;}
    }
    ACBus ac=new ACBus();
    NonACBus nonac=new NonACBus();
    void cancelTicket(){
        if(userlist.get(userindex).get(ticketindex).get(4).equalsIgnoreCase("AC")){
        ac.updateAvlSeatsdetails(userlist.get(userindex).get(ticketindex).get(0),userlist.get(userindex).get(ticketindex).get(1),userlist.get(userindex).get(ticketindex).get(3));
        }
        else{
            nonac.updateAvlSeatdetails(userlist.get(userindex).get(ticketindex).get(0),userlist.get(userindex).get(ticketindex).get(1),userlist.get(userindex).get(ticketindex).get(3));
        }
        userlist.get(userindex).remove(ticketindex);
    }
    void reduceseats(int seatcount){
        if(userlist.get(userindex).get(ticketindex).get(4).equalsIgnoreCase("AC")){
            ac.updateAvlSeatsdetails(userlist.get(userindex).get(ticketindex).get(0),String.valueOf(seatcount),userlist.get(userindex).get(ticketindex).get(3));
            userlist.get(userindex).get(ticketindex).set(10,String.valueOf(Integer.parseInt(userlist.get(userindex).get(ticketindex).get(10))-seatcount*300));    
        }
            else{
                nonac.updateAvlSeatdetails(userlist.get(userindex).get(ticketindex).get(0),String.valueOf(seatcount),userlist.get(userindex).get(ticketindex).get(3));
                userlist.get(userindex).get(ticketindex).set(10,String.valueOf(Integer.parseInt(userlist.get(userindex).get(ticketindex).get(10))-seatcount*150));
            }
            userlist.get(userindex).get(ticketindex).set(1,String.valueOf(Integer.parseInt(userlist.get(userindex).get(ticketindex).get(1))-seatcount));
           
            System.out.println("\n------------------------------------------------------------------------");
            System.out.println("\nBooking Date : "+userlist.get(userindex).get(ticketindex).get(2)+"\tBooking Time : "+userlist.get(userindex).get(ticketindex).get(8));
            System.out.println("\nTicketID : "+userlist.get(userindex).get(ticketindex).get(9)+"\t\tUsername : "+userlist.get(userindex).get(0).get(0)+"\t\tBusType: "+userlist.get(userindex).get(ticketindex).get(4));
            System.out.println("\nDate of Traveling:"+userlist.get(userindex).get(ticketindex).get(3)+"\tBusTime : "+userlist.get(userindex).get(ticketindex).get(7)+"\t\tBus Number:"+userlist.get(userindex).get(ticketindex).get(0));
            System.out.println("\nForm: "+userlist.get(userindex).get(ticketindex).get(5)+" To:"+userlist.get(userindex).get(ticketindex).get(6)+"\tNumber of Seats:"+userlist.get(userindex).get(ticketindex).get(1)+"\tAmount : "+userlist.get(userindex).get(1).get(10));
            System.out.println("\n------------------------------------------------------------------------");
    }
    }
