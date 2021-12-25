public class Run {
    public static void main(String[] args) {
//        Student std1 = new Student("Ehsan","Edalat", "9031066");
//        Student std2 = new Student("Seyed", "Ahmadpanah", "9031806");
//        Student std3 = new Student("Ahmad", "Asadi", "9031054");
//        Lab apLab = new Lab(30,"saterday");
//
//        std1.print();
//        std1.setGrade(15);
//        std1.print();
//
//        std2.print();
//        std2.setGrade(11);
//        std2.print();
//
//        std3.print();
//        std3.setFistName("HamidReza");
//        std3.print();
//
//        apLab.enrollStudent(std1);
//        apLab.enrollStudent(std2);
//        apLab.enrollStudent(std3);
//        apLab.calculateAvg();
//        apLab.print();

        Student std1 = new Student("ali","alavi","9931200");
        Student std2 = new Student("Ehsan","Edalat", "9031066");
        Student std3 = new Student("Seyed", "Ahmadpanah", "9031806");

        Lab apLab = new Lab(5,"saterday");
        apLab.enrollStudent(std1);
        apLab.enrollStudent(std2);
        apLab.enrollStudent(std3);
        std1.setGrade(15);
        std2.setGrade(20);
        std3.setGrade(17);
        apLab.calculateAvg();
        apLab.print();

        Student std4 = new Student("Ahmad", "Asadi", "9031054");
        Student std5 = new Student("aida","mobli","9827042");
        Student std6 = new Student("saba","javadi","9925090");

        Lab apLab2 = new Lab(4,"monday");
        apLab2.enrollStudent(std3);
        apLab2.enrollStudent(std4);
        apLab2.enrollStudent(std5);
        apLab2.enrollStudent(std6);
        apLab2.print();

        Faculty ce = new Faculty("computer Engineering",6,3);
        ce.enrollLab(apLab);
        ce.enrollLab(apLab2);
        ce.print();
    }
}
