import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class StudentManagementSystem {

    private ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        loadStudentsFromFile();
    }

    public void addStudent(Student student) {
        students.add(student);
        saveStudentToFile(student);
        System.out.println("Student added successfully!");
    }

    public void saveStudentToFile(Student student) {
        try {
            BufferedWriter writer =
                new BufferedWriter(
                    new FileWriter("students.txt", true)
                );
            writer.write(
                student.getId() + "," +
                student.getName() + "," +
                student.getAge() + "," +
                student.getCourse()
            );
            writer.newLine();
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void loadStudentsFromFile() {
        students.clear();
        try {
            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("students.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.trim().isEmpty()) {
                    continue;
                }
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String course = data[3];
                Student student = new Student(id, name, age, course);
                students.add(student);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("No previous data found.");
        }
    }

    public void saveAllStudentsToFile() {
        try {
            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter("students.txt"));
            for(Student student : students) {
                writer.write(
                        student.getId() + "," +
                        student.getName() + "," +
                        student.getAge() + "," +
                        student.getCourse()
                );
                writer.newLine();
            }
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
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
            saveAllStudentsToFile();
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
            saveAllStudentsToFile();
            System.out.println("Student updated successfully!");
        }
        else {
            System.out.println("Student not found!");
        }
    }
}