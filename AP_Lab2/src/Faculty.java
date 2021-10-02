public class Faculty {
    private int calssNum;
    private Student[] students;
    private String[] teachers;
    private String[] courses;
    private int teacherNum;
    private int coursesNum;

    public Faculty(int teacherNum,int coursesNum){
        this.teacherNum=teacherNum;
        this.coursesNum=coursesNum;
        teachers=new String[teacherNum];
        courses=new String[coursesNum];
    }

    



}
