package employeeInformation;

import java.io.File;
/*
 * Через класс Program осуществляется запуск прокграммы. Задается путь к файлу и вызывается метод для начала работы
 * программы с базой данных. 
 */
public class Program {
    public static void main(String[] args) {
        Presenter app = new Presenter();
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat("/Employee.txt");
        File f = new File(pathFile);
        app.startWork(f.getAbsolutePath());

    }
}
