package Cinema;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Show {
    private String name;
    private Date date;
    private String time;
    private ArrayList<String> clientNumbers;
    private Hall hall;

    public Show(String name,Date date,String time,Hall hall){
        this.name=name;
        this.date=date;
        this.time=time;
        clientNumbers=new ArrayList<>();
        this.hall=hall;
    }
    public void addNewCLient(Client client){

    }
    public void RemoveClient(Client client){

    }
    public ArrayList<String > getClientNumbers(){
        return clientNumbers;
    }
    public String  getTime(){
        return time;
    }
    public Date getDate(){
        return date;
    }
    public void printShowInfo(){

    }
    public void reserve(Client client,Date date,String time, ArrayList<Integer> chairs){

    }

}
