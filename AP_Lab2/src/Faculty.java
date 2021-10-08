/**
 * in Faculty class holds the faculty's presented laboratories ,faculty's students informations
 * it manages and checks time conflicts of students
 */
public class Faculty {
    ///list of faculty's laboratories
    private Lab[] laboratories;
    ///list of faculty's students
    private Student[] facultystudents;
    ///the maximum number of presented classes
    private int classesNum;
    ///the faculty's name
    private String facultyName;
    ///The maximum number of students in faculty
    private int facultyCapacity;
    ///how many labs are currently presented in faculty
    private int currentClasses;
    ///how many students are currently in faculty
    private int totalStudents;

    /**
     * create a new faculty with name ,The maximum number of students,the maximum number of presented labs
     * @param facultyName faculty's name
     * @param facultyCapacity The maximum number of students
     * @param classesNum the maximum number of presented labs
     */
    public Faculty(String facultyName,int facultyCapacity, int classesNum){
        this.facultyName=facultyName;
        this.facultyCapacity=facultyCapacity;
        this.classesNum=classesNum;
        laboratories = new  Lab[classesNum];
        facultystudents =new Student[facultyCapacity];
    }

    /**
     * get faculty's student list
     * @return facultystudents field
     */
    public Student[] getFacultystudents(){
        return facultystudents;
    }

    /**
     * set faculty's student list
     * @param facultystudents faculty's student list
     */
    public void setFacultystudents(Student[] facultystudents){
        this.facultystudents=facultystudents;
    }

    /**
     * get faculty's lab list
     * @return laboratories field
     */
    public Lab[] getLaboratories(){
        return laboratories;
    }

    /**
     * set faculty's lab list
     * @param laboratories faculty's lab list
     */
    public void setLaboratories(Lab[] laboratories){
        this.laboratories=laboratories;
    }

    /**
     * get faculty's name
     * @return facultyName field
     */
    public String getFacultyName(){
        return facultyName;
    }

    /**
     * set faculty's name
     * @param facultyName faculty's name
     */
    public void setFacultyName(String facultyName){
        this.facultyName=facultyName;
    }

    /**
     * get the maximum number of presented classes
     * @return classesNum field
     */
    public int getClassesNum(){
        return classesNum;
    }

    /**
     * set the maximum number of presented classes
     * @param classesNum the maximum number of presented classes
     */
    public void setClassesNum(int classesNum){
        this.classesNum=classesNum;
    }

    /**
     * get The maximum number of students in faculty
     * @return facultyCapacity
     */
    public int getFacultyCapacity(){
        return facultyCapacity;
    }

    /**
     *set The maximum number of students in faculty
     * @param facultyCapacity The maximum number of students in faculty
     */
    public void setFacultyCapacity(int facultyCapacity){
        this.facultyCapacity=facultyCapacity;
    }

    /**
     * get total labs that presented in faculty
     * @return currentClasses
     */
    public int getCurrentClasses(){
        return currentClasses;
    }

    /**
     * set the total labs that presented in faculty
     * @param currentClasses the total labs that presented in faculty
     */
    public void setCurrentClasses(int currentClasses){
        this.currentClasses=currentClasses;
    }

    /**
     * get the total faculty's students
     * @return totalStudents
     */
    public int getTotalStudents(){
        return totalStudents;
    }

    /**
     * set the total faculty's students
     * @param totalStudents the total faculty's students
     */
    public void setTotalStudents(int totalStudents){
        this.totalStudents=totalStudents;
    }

    /**
     * add new lab to faculty
     * @param lab laboratory information
     */
    public void enrollLab(Lab lab){
        if(currentClasses<classesNum){
            checkConflict(lab);
            addNewStudents(lab);
            laboratories[currentClasses]=lab;
            currentClasses++;
        }
        else {
            System.out.println("haven't any classes!");
        }
    }

    /**
     * check the lab's students don't have time conflict
     * @param lab a new laboratory that we want to add it to the faculty
     */
    private void checkConflict(Lab lab){
        for(Lab l:laboratories){
            if (l==null)
                continue;
            if(l==lab)
                continue;
            if(lab.getDay().equals(l.getDay())){
                for(int std1=0;std1<lab.getCurrentSize();std1++){
                    for (int std2=0; std2<l.getCurrentSize();std2++){
                        if(lab.getStudents()[std1].equals(l.getStudents()[std2])){
                            System.out.println("student: "+lab.getStudents()[std1].getId()+" couldnt be in this lab");
                            deleteElementOfArray(lab,std1,lab.getCurrentSize());

                        }
                    }
                }
            }
        }
    }


    /**
     * if a student have time conflict , we remove it from the new lab
     * @param lab the lab that we want to add it to faculty
     * @param element Student element in the list of lab students
     * @param currentSize how many students are currently in the lab
     */
    private void deleteElementOfArray(Lab lab,int element,int currentSize){
        Student invalidStd =lab.getStudents()[element];
        Student[] student=lab.getStudents();
        for (int i=element;i<currentSize-1;i++){
            student[i]=student[i+1];
        }
        student[currentSize-1]=null;
        lab.setCurrentSize(lab.getCurrentSize()-1);
        System.out.println("student: "+invalidStd.getId()+" is deleted");
    }

    /**
     *add new students to the faculty's list
     * @param lab the lab that we want to add it to faculty
     */
    private void addNewStudents(Lab lab){
        boolean flag;
        for (int i=0;i<lab.getCurrentSize();i++){
            Student std =lab.getStudents()[i];
            flag=false;
            for(int j=0;j<totalStudents;j++){
                Student s=facultystudents[i];
                if(std.equals(s)){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                if(totalStudents<facultyCapacity) {
                    facultystudents[totalStudents] = std;
                    totalStudents++;
                }
                else {
                    System.out.println("faculty is full!");
                    deleteElementOfArray(lab,i,lab.getCurrentSize());

                }
            }
        }
    }

    /**
     * print the faculty informations
     */
    public void print(){
        System.out.println("--------------------------------------");
        System.out.println("Faculty info:");
        System.out.println("faculty's name : "+facultyName+" total presented labs: "+currentClasses+" total students: "+totalStudents);
        System.out.println("laboratories info:");
        for (int i=0;i<currentClasses;i++){
            System.out.println("lab"+(i+1)+":");
            laboratories[i].print();
        }
        System.out.println("students info:");
        for (int i=0;i<totalStudents;i++){
            System.out.println("student"+i+":");
            facultystudents[i].print();
        }
        System.out.println("--------------------------------------");
    }


}
