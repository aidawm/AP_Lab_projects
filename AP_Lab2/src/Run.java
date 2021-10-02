public class Run {
    public static void main(String[] args) {
        Student std1 = new Student("Ehsan","Edalat", "9031066");
        Student std2 = new Student("Seyed", "Ahmadpanah", "9031806");
        Student std3 = new Student("Ahmad", "Asadi", "9031054");
        Lab apLab = new Lab(30,"saterday");

        std1.print();
        std1.setGrade(15);
        std1.print();

        std2.print();
        std2.setGrade(11);
        std2.print();

        std3.print();
        std3.setFistName("HamidReza");
        std3.print();

        apLab.enrollStudent(std1);
        apLab.enrollStudent(std2);
        apLab.enrollStudent(std3);
        apLab.print();
    }
}
