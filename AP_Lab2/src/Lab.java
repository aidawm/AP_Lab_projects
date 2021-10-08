/**
 * the lab class holds laboratory's informations
 */
public class Lab {
    // list of lab's students
    private Student[] students;
    ///the average of lab grades
    private int avg;
    //when is the lab presented
    private String day;
    ////the capacity of the lab
    private int capacity;
    ///how many student are currently in the lab
    private int currentSize;

    /**
     *create a new lab with a given capacity and presented day.
     * @param cap capacity of lab
     * @param d presented day
     */
    public Lab(int cap, String d) {
        capacity=cap;
        day=d;
        students=new Student[capacity];
    }

    /**
     * add new student to lab
     * @param std get student's informarions
     */
    public void enrollStudent(Student std) {
        if (currentSize < capacity) {
            students[currentSize] = std;
            currentSize++;
        } else {
            System.out.println("Lab is full!!!");
        }
    }

    /**
     * print the student info and average of their grades
     */
    public void print() {
        for (int i=0;i<currentSize;i++){
            students[i].print();
        }
        System.out.println("avrage= "+avg);
    }

    /**
     * get the list of the lab's students
     * @return students field
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * set the list of lab's students
     * @param students set students list
     */
    public void setStudents(Student[] students) {
        this.students=students;
    }

    /**
     * get the average of students' grade
     * @return avg field
     */
    public int getAvg() {
        return avg;
    }

    /**
     * calculate and set the average of students' grade
     */
    public void calculateAvg() {
        int total=0;
        for (int i=0;i<currentSize;i++){
            total+=students[i].getGrade();
        }
        avg=total/currentSize;
    }

    /**
     * get the lab's presented day
     * @return day field
     */
    public String getDay() {
        return day;
    }

    /**
     * set the lab's presented day
     * @param day set lab's presented day
     */
    public void setDay(String day) {
        this.day=day;
    }

    /**
     * get lab's capacity
     * @return capacity field
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * set lab's capacity
     * @param capacity set the lab's capacity
     */
    public void setCapacity(int capacity) {
        this.capacity=capacity;
    }

    /**
     * get the total of lab's students
     * @return currentSize field
     */
    public int getCurrentSize(){
        return currentSize;
    }

    /**
     * set the total of lab's students
     * @param currentSize total number of lab's students
     */
    public void setCurrentSize(int currentSize){
        this.currentSize=currentSize;
    }

}

