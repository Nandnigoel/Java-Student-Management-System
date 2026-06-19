public class Main {

    public static void main(String[] args) {
        StudentManagementSystem sms=new StudentManagementSystem();

        Student s1 = new Student(
                101,
                "Nandni",
                20, 
                "CSE-DS"
        );

        Student s2 = new Student(
                102,
                "Rahul",
                21,
                "CSE"
        );

        sms.addStudent(s1);
        sms.addStudent(s2);

        sms.displayStudents();

        Student foundStudent = sms.searchStudent(102);
        System.out.println("\nSearch Result:");
        if(foundStudent != null) {
            System.out.println(foundStudent);
        }
        else {
            System.out.println("Student not found!");
        }

        System.out.println("\nDeleting Student:");
        sms.deleteStudent(102);
        System.out.println("\nStudents After Deletion:");
        sms.displayStudents();

        System.out.println("\nUpdating Student:");
        sms.updateStudent(
            101,
            "Nandni Goel",
            21,
            "CSE-DS"
        );
        System.out.println("\nStudents After Update:");
        sms.displayStudents();
    }
}