package HealthSystem;

import java.util.ArrayList;
import java.util.Date;

public class Case {
    private boolean publication;
    private String illnessName;
    private ArrayList<String > drugs;
    private String description;
    private String drsDiagnosis;
    private Date date;
    private Docter doctor;
    private int securityLevel;


    public Case(String illnessName,String description,Docter doctor){
        this.illnessName=illnessName;
        this.description=description;
        this.doctor=doctor;
        setSecurityLevel();
    }


    public void setDoctor(Docter firstDoctor,Docter secondDoctor){
        if(isDoctorValid(firstDoctor)){

        }
    }

    public void setNewDeclaring(Docter doctor,Date date,String drsDiagnosis,ArrayList<String > drugs){

    }
    private boolean isIllnessValid(){}

    private void setSecurityLevel(){}
    private Boolean isDoctorValid(Object o){
        if(o instanceof Docter){
            if(o.equals(this.doctor))
                return true;
        }
        return false;
    }

    public void printInfo(){

    }

}
