import java.util.*;
import java.time.*;
public class NonACBus extends Main{
    LocalDate date1=LocalDate.now();
    Main det=new Main();
    static ArrayList<LocalDate> datelist1=new ArrayList<>();
    static ArrayList<String> noAcdet=new ArrayList<String>();
    static ArrayList<Integer> Busno1=new ArrayList<>();
    static ArrayList<String> time1=new ArrayList<>();
    static ArrayList<String> from1=new ArrayList<>();
    static ArrayList<String> to1=new ArrayList<>();
    static ArrayList<Integer> avlseats1=new ArrayList<>();
    void setbuslist(ArrayList<String> noAcdet){
        NonACBus.noAcdet=noAcdet;
    }
    void setbusdetails(){
    for(int j=0;j<7;j++)
    {
        datelist1.add(date1.plusDays(j+1));
        for(int i=0;i<noAcdet.size();i++){
            String[] strg=noAcdet.get(i).split(";");
            String[] num=strg[0].split("=");
            Busno1.add(Integer.parseInt(num[1]));
            String[] s=strg[1].split("=");
            time1.add(s[1]);
            String[] frm=strg[2].split("=");
            from1.add(frm[1]);
            String[] t=strg[3].split("=");
            to1.add(t[1]);
            String[] av=strg[4].split("=");
            avlseats1.add(Integer.parseInt(av[1]));
        }
    }
    }
    int setdetails(String From,String To,LocalDate date){
        int ind=0;
        System.out.println("\nAvailable bus list for "+From+" to "+To+" is \n\nBusNumber\tTiming\t\tAvailable Seats ");
        System.out.println("--------------------------------------------------------------");
        for(int i=0;i<7;i++)
        {
            if(date.compareTo(datelist1.get(i))==0){
                for(int j=i*noAcdet.size();j<(i+1)*noAcdet.size();j++){
                    if(from1.get(j).equalsIgnoreCase(From) && to1.get(j).equalsIgnoreCase(To) && avlseats1.get(j)!=0){
                        System.out.println(Busno1.get(j)+"\t\t"+time1.get(j)+"\t\t"+avlseats1.get(j));
                        System.out.println("--------------------------------------------------------------");
                    }
                }
                ind=i;
                break;
            }
        }
        return ind;
    }
    void updateAvlSeatdetails(String busno,String seats,String date){
        int index1=0,index2=Busno1.indexOf(Integer.parseInt(busno));
        for(int i=0;i<7;i++){
            if(String.valueOf(datelist1.get(i)).equals(date)){index1=i;}
        }
        avlseats1.set(index2+(noAcdet.size()*index1) , avlseats1.get(index2+(noAcdet.size()*index1))+Integer.parseInt(seats));
    }
    void updatebookingdetails(int busno,int seatswant,int num){
        int index=Busno1.indexOf(busno);
        avlseats1.set(index+(noAcdet.size()*num) , avlseats1.get(index+(noAcdet.size()*num))-seatswant);
    }
    void getticketdetails(int busno,int noofseats,int num,String From,String to,String bustype,int busfare){
        UserData us=new UserData();
        us.setticketsdetails(busno,noofseats,date1,datelist1.get(num),From,to,time1.get(Busno1.indexOf(busno) + (noAcdet.size()*num)),bustype,busfare);
        us.getticket();
    }
}
