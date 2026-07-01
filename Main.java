import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms=new StudentManagementSystem();
        StudentDAO dao = new StudentDAO();

        while(true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            int choice;
            try{
                choice = sc.nextInt();
            }
            catch(Exception e){
                System.out.println("Invalid Input! Please enter a number.");
                sc.nextLine();
                continue;
            }
            switch(choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id;
                    try{
                        id = sc.nextInt();
                    }catch(Exception e){
                        System.out.println("Invalid ID!");
                        sc.nextLine();
                        break;
                    }
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    if(name.trim().isEmpty()){
                        System.out.println("Name cannot be empty!");
                        break;
                    }

                    System.out.print("Enter Age: ");
                    int age;
                    try{
                        age = sc.nextInt();
                        if(age <= 0){
                            System.out.println("Age must be greater than 0!");
                            break;
                        }
                    }catch(Exception e){
                        System.out.println("Invalid AGE!");
                        sc.nextLine();
                        break;
                    }

                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    if(course.trim().isEmpty()){
                        System.out.println("Course cannot be empty!");
                        break;
                    }

                    Student student=new Student(id, name, age, course);

                    dao.addStudent(student);
                    break;

                case 2:
                    dao.displayStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to Search: ");
                    int searchId;
                    try{
                        searchId = sc.nextInt();
                    }catch(Exception e){
                        System.out.println("Invalid ID!");
                        sc.nextLine();
                        break;
                    }

                    dao.searchStudent(searchId);
                    break;

                case 4:
                    System.out.print("Enter Student ID to Update: ");
                    int updated_ID;
                    try{
                        updated_ID=sc.nextInt();
                    }catch(Exception e){
                        System.out.println("Invalid ID!");
                        sc.nextLine();
                        break;
                    }
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String updated_name=sc.nextLine();
                    if(updated_name.trim().isEmpty()){
                        System.out.println("Name cannot be empty!");
                        break;
                    }
                    System.out.print("Enter New Age: ");
                    int updated_age;
                    try{
                        updated_age=sc.nextInt();
                        if(updated_age<=0){
                            System.out.println("Age must be greater than 0!");
                            break;
                        }
                    }catch(Exception e){
                        System.out.println("Invalid AGE!");
                        sc.nextLine();
                        break;
                    }
                    sc.nextLine();
                    System.out.print("Enter New Course: ");
                    String updated_course=sc.nextLine();
                    if(updated_course.trim().isEmpty()){
                        System.out.println("Course cannot be empty!");
                        break;
                    }
                    Student st=new Student(updated_ID, updated_name, updated_age, updated_course);
                    dao.updateStudent(st);
                    break;

                case 5:
                    System.out.print("Enter Student ID to Delete: ");
                    int ID;
                    try{
                        ID=sc.nextInt();
                    }catch(Exception e){
                        System.out.println("Invalid ID!");
                        sc.nextLine();
                        break;
                    }
                    dao.deleteStudent(ID);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}