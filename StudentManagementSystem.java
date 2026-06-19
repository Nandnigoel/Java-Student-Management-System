import java.util.ArrayList;

public class StudentManagementSystem {

    private ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void displayStudents() {
        for(Student student : students) {
            System.out.println(student);
        }
    }

    public Student searchStudent(int id) {
        for(Student student : students) {
            if(student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void deleteStudent(int id) {
        Student student = searchStudent(id);
        if(student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully!");
        }
        else {
            System.out.println("Student not found!");
        }
    }

    public void updateStudent(int id, String name, int age, String course) {
        Student student = searchStudent(id);
        if(student != null) {
            student.setName(name);
            student.setAge(age);
            student.setCourse(course);
            System.out.println("Student updated successfully!");
        }
        else {
            System.out.println("Student not found!");
        }
    }
}