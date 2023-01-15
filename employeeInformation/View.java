package employeeInformation;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Класс View реализует взаимодействие с пользователем, собирая с него необходимую информацию. 
 */
public class View implements I_View<HashMap<String, String>, Employee> {
    Scanner sc = new Scanner(System.in);
    Integer setMod(){
        System.out.println("МЕНЮ\n1. Открыть базу для просмотра\n2. Удалить сотрудника\n3. Внести изменения\n4. Добавить сотрудника\n5. Найти сотрудника"); 
        return sc.nextInt();
    }

    //Узнаем id сотрудника, которого будем удалять
    @Override
    public Integer setIdForDelete() {
        System.out.print("Введите id сотрудника для удаления из базы: ");
        Integer delId = sc.nextInt(); 
        return delId;
    }
    
    // Узнаем все поля для создания экземпляра класса Employee 
    @Override
    public Employee setNewEmployee() {
        System.out.println("Заполните поля.");
        int id = -1;
        String sName = null, fName = null, fatherName = null, phone = null, address = null, passport = null;
         
        try{
            System.out.print("id: ");
            id = sc.nextInt();
            System.out.print("Фамилия: ");
            sName = sc.nextLine();
            sName = sc.nextLine();
            System.out.print("Имя: ");
            fName = sc.nextLine();
            System.out.print("Отчество: ");
            fatherName = sc.nextLine();
            System.out.print("Телефон: ");
            phone = sc.nextLine();
            System.out.print("Адрес: ");
            address = sc.nextLine();
            System.out.print("Паспорт: ");
            passport = sc.nextLine();
            System.out.println();
            
        } catch(InputMismatchException e){
            System.out.print("Введеное значение не является числом. Задайте id заново: ");
            id = sc.nextInt();
        } catch(Exception e){
            e.printStackTrace();
        }

        return new Employee(id, sName, fName, fatherName, phone, address, passport);        
    }

    // Узнаем имеющуюся информцию о сотруднике, чтобы потом найти всю информацию о нем
    @Override
    public String setSearchInfo() {
        System.out.print("Введите любую информацию о сотруднике: ");
        String info = sc.nextLine();
        info = sc.nextLine();
        return info;
    }

    // Собираем данные: id сотрудника; солбец, в который вносим изменения; актуальные данные. 
    @Override
    public HashMap<String, String> setReplacementInfo() {
        HashMap<String, String> result = new HashMap<>();
        System.out.print("Введите id сотрудника: ");
        String id = sc.nextLine();
        id = sc.nextLine();
        System.out.print("Напишите название столбца для замены(sName, fName, patronymic, phone, address, passport): ");
        String column = sc.nextLine();
        System.out.print("Новые данные: ");
        String newData = sc.nextLine();
        System.out.println();

        result.put("id", id);
        result.put("column", column);
        result.put("newData", newData);
        return result;
    }
    
}
