import java.util.ArrayList;
public class StudentManagement {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public Student searchStudent(int id) {

        for (Student s : students) {

            if (s.getId() == id)
                return s;
        }

        return null;
    }

    public void updateStudent(int id,
                              String name,
                              String department,
                              double gpa) {

        Student s = searchStudent(id);

        if (s != null) {

            s.setName(name);
            s.setDepartment(department);
            s.setGpa(gpa);

            System.out.println("Student updated.");
        }
        else {
            System.out.println("Student not found.");
        }
    }

    public void deleteStudent(int id) {

        Student s = searchStudent(id);

        if (s != null) {

            students.remove(s);
            System.out.println("Student deleted.");
        }
        else {
            System.out.println("Student not found.");
        }
    }

    public void displayAllStudents() {

        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void generateReport() {

        int total = students.size();

        double highest = students.get(0).getGpa();
        double lowest = students.get(0).getGpa();

        double sum = 0;

        for (Student s : students) {

            if (s.getGpa() > highest)
                highest = s.getGpa();

            if (s.getGpa() < lowest)
                lowest = s.getGpa();

            sum += s.getGpa();
        }

        System.out.println("Total Students = " + total);
        System.out.println("Highest GPA = " + highest);
        System.out.println("Lowest GPA = " + lowest);
        System.out.println("Average GPA = " + sum / total);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
