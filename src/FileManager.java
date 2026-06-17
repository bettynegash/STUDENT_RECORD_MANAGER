import java.util.ArrayList;
import java.io.*;
public class FileManager {
    public static void saveText(ArrayList<Student> students)
            throws Exception {

        PrintWriter pw = new PrintWriter("students.txt");

        for (Student s : students) {
            pw.println(s);
        }

        pw.close();
    }

    public static void saveBinary(ArrayList<Student> students)
            throws Exception {

        DataOutputStream dos =
                new DataOutputStream(
                        new FileOutputStream("students.dat"));

        for (Student s : students) {

            dos.writeInt(s.getId());
            dos.writeDouble(s.getGpa());
        }

        dos.close();
    }

    public static void saveObject(ArrayList<Student> students)
            throws Exception {

        ObjectOutputStream oos =
                new ObjectOutputStream(
                        new FileOutputStream("students.obj"));

        oos.writeObject(students);

        oos.close();
    }

    public static void showFileInfo() {

        File file = new File("students.txt");

        System.out.println("Name : " + file.getName());
        System.out.println("Size : " + file.length() + " bytes");
        System.out.println("Path : " + file.getAbsolutePath());
    }

    public static void createBackup()
            throws Exception {

        BufferedInputStream bis =
                new BufferedInputStream(
                        new FileInputStream("students.obj"));

        BufferedOutputStream bos =
                new BufferedOutputStream(
                        new FileOutputStream("students_backup.obj"));

        int data;

        while ((data = bis.read()) != -1) {

            bos.write(data);
        }

        bis.close();
        bos.close();

        System.out.println("Backup created.");
    }
}
