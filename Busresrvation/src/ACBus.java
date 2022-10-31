import java.util.*;
import java.time.*;
public class ACBus {
    LocalDate date=LocalDate.now();
    Main det=new Main();
    static ArrayList<LocalDate> datelist=new ArrayList<>();
    static ArrayList<String> Acdet=new ArrayList<String>();
    static ArrayList<Integer> Busno=new ArrayList<>();
    static ArrayList<String> time=new ArrayList<>();
    static ArrayList<String> from=new ArrayList<>();
    static ArrayList<String> to=new ArrayList<>();
    static ArrayList<Integer> avlseats=new ArrayList<>();
    void setbuslist(ArrayList<String> Acdet){
        ACBus.Acdet=Acdet;
    }
    void setbusdetails(){
    for(int j=0;j<7;j++)
    {
        datelist.add(date.plusDays(j+1));
        for(int i=0;i<Acdet.size();i++){
            String[] strg=Acdet.get(i).split(";");
            String[] num=strg[0].split("=");
            Busno.add(Integer.parseInt(num[1]));
            String[] s=strg[1].split("=");
            time.add(s[1]);
            String[] frm=strg[2].split("=");
            from.add(frm[1]);
            String[] t=strg[3].split("=");
            to.add(t[1]);
            String[] av=strg[4].split("=");
            avlseats.add(Integer.parseInt(av[1]));
        }
    }
    }
    int setdetails(String From,String To,LocalDate date){
        int ind=0;
        System.out.println("\nAvailable bus list for "+From+" to "+To+" is \n\nBusNumber\tTiming\t\tAvailable Seats ");
        System.out.println("--------------------------------------------------------------");
        for(int i=0;i<7;i++)
        {
            if(date.compareTo(datelist.get(i))==0){
                for(int j=i*Acdet.size();j<(i+1)*Acdet.size();j++){
                    if(from.get(j).equalsIgnoreCase(From) && to.get(j).equalsIgnoreCase(To) && avlseats.get(j)!=0){
                        System.out.println(Busno.get(j)+"\t\t"+time.get(j)+"\t\t"+avlseats.get(j));
                        System.out.println("--------------------------------------------------------------");
                    }
                }
                ind=i;
                break;
            }
        }
        return ind;
    }
    void updateAvlSeatsdetails(String busno,String seats,String date){
        int index1=0,index2=Busno.indexOf(Integer.parseInt(busno));
        for(int i=0;i<7;i++){
            if(String.valueOf(datelist.get(i)).equals(date)){index1=i;}
        }
        avlseats.set(index2+(Acdet.size()*index1) , avlseats.get(index2+(Acdet.size()*index1))+Integer.parseInt(seats));
    }
    void updatebookingdetails(int busno,int seatswant,int num){
        int  index=Busno.indexOf(busno);
        System.out.println(index+(Acdet.size()*num));
        avlseats.set(index+(Acdet.size()*num) , avlseats.get(index+(Acdet.size()*num))-seatswant);
    }
    void getticketdetails(int busno,int noofseats,int num,String From,String to,String bustype,int busfare){
        UserData us=new UserData();
        us.setticketsdetails(busno,noofseats,date,datelist.get(num),From,to,time.get(Busno.indexOf(busno) + (Acdet.size()*num)),bustype,busfare);
        us.getticket();
    }
}
