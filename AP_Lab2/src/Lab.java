/**
 * the lab class hold laboratory's informations
 */
public class Lab {
    // list of lab's students
    private Student[] students;
    ///the average of class grades
    private int avg;
    //when is the class presented
    private String day;
    ////the capacity of the class
    private int capacity;
    ///how many student are in the class
    private int currentSize;

    /**
     *
     * @param cap capacity of class
     * @param d presented day
     */
    public Lab(int cap, String d) {
        capacity=cap;
        day=d;
        students=new Student[capacity];
    }

    /**
     * add new student to class
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
        for (Student s:students){
            if (s!=null)
                s.print();
        }
        System.out.println("avrage= "+avg);
    }


    public Student[] getStudents() {
        return students;
    }
    public void setStudents(Student[] students) {
        this.students=students;
    }
    public int getAvg() {
        return avg;
    }
    public void calculateAvg() {
        int total=0;
        for (Student s:students){
            total+=s.getGrade();
        }
        avg=total/students.length;
    }

    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day=day;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity=capacity;
    }
}

