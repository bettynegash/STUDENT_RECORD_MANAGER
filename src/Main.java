import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        StudentManagement manager =
                new StudentManagement();

        int choice;

        do {

            System.out.println("\n===== Student record manager=====");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Display Students");
            System.out.println("6. Generate Report");
            System.out.println("7. Save Files");
            System.out.println("8. Show File Info");
            System.out.println("9. Create Backup");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Name: ");
                    String name = input.nextLine();

                    System.out.print("Department: ");
                    String dep = input.nextLine();

                    System.out.print("GPA: ");
                    double gpa = input.nextDouble();

                    manager.addStudent(
                            new Student(id, name, dep, gpa));

                    break;

                case 2:

                    System.out.print("Enter ID: ");
                    int searchId = input.nextInt();

                    System.out.println(
                            manager.searchStudent(searchId));

                    break;

                case 3:

                    System.out.print("Enter ID: ");
                    int updateId = input.nextInt();
                    input.nextLine();

                    System.out.print("New Name: ");
                    String newName = input.nextLine();

                    System.out.print("New Department: ");
                    String newDep = input.nextLine();

                    System.out.print("New GPA: ");
                    double newGpa = input.nextDouble();

                    manager.updateStudent(
                            updateId,
                            newName,
                            newDep,
                            newGpa);

                    break;

                case 4:

                    System.out.print("Enter ID: ");
                    int deleteId = input.nextInt();

                    manager.deleteStudent(deleteId);

                    break;

                case 5:

                    manager.displayAllStudents();

                    break;

                case 6:

                    manager.generateReport();

                    break;

                case 7:

                    try {

                        FileManager.saveText(manager.getStudents());
                        FileManager.saveBinary(manager.getStudents());
                        FileManager.saveObject(manager.getStudents());

                        System.out.println("Files saved.");

                    } catch (Exception e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 8:

                    FileManager.showFileInfo();

                    break;

                case 9:

                    try {

                        FileManager.createBackup();

                    } catch (Exception e) {

                        System.out.println(e.getMessage());
                    }

                    break;

            }

        } while (choice != 0);

        input.close();
    }
}
