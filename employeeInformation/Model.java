package employeeInformation;

import java.util.HashSet;

/**
 * класс Model, реализующий интерфейс I_Model. Реализуются модели работы с базой данных. 
 */
public class Model implements I_Model<String, String, HashSet<Employee>> {

    Logger log = new Logger();

    // Добавление нового сотрудника
    @Override
    public void addNewEmployee(Employee man, String path) {
        HashSet<Employee> staff = log.load(path);
        staff.add(man);
        log.save(path, staff);
    }

    // Поиск сотрудника по имеющейся информации 
    @Override
    public HashSet<Employee> employeeSearch(String criteria, String path) {
        HashSet<Employee> staff = log.load(path);
        HashSet<Employee> result = new HashSet<>();
        for(Employee man : staff){
            if(Integer.toString(man.getId()).equals(criteria) || man.getfName().equals(criteria) || man.getsName().equals(criteria) ||
            man.getPatronymic().equals(criteria) || man.getPhone().equals(criteria) || man.getAddress().equals(criteria) ||
            man.getPassport().equals(criteria)){
                result.add(man);
            }
        }
        return result;
    }

    // Удаление сотрудника из базы данных
    @Override
    public void deleteEmployee(Integer id, String path) {
        HashSet<Employee> staff = log.load(path);
        Employee manDel = null;
        for(Employee man : staff){
            if(id.equals(man.getId())){
                manDel = man;
            }
        }
        staff.remove(manDel);
        log.save(path, staff);
        System.out.println("Сотрудник успешно удален.");
    }

    // Замена какой-либо информации на новую у сотрудника
    @Override
    public void replaceInfo(Integer id, String info1, String info2, String path) {
        HashSet<Employee> staff = log.load(path); 

        for(Employee man : staff){
            if(id.equals(man.getId())){
                switch(info1){
                    case "id":
                        System.out.println("id нельзя поменять.");
                        break;
                    case "sName":
                        man.setsName(info2);
                        break;
                    case "fName":
                        man.setfName(info2);
                        break;
                    case "patronymic":
                        man.setPatronymic(info2);
                        break;
                    case "phone":
                        man.setPhone(info2);
                        break;
                    case "address":
                        man.setAddress(info2);
                        break;
                    case "passport":
                        man.setPassport(info2);
                        break;
                    default:
                        System.out.println("Столбец не найден, попробуйте заново.");
                }
            }
        }

        log.save(path, staff);
        System.out.println("Данные успешно изменены.");
    }

    // Загрузка базы данных
    @Override
    public void loadData(String path) {
        HashSet<Employee> staff = log.load(path);
        for(Employee man : staff){
            System.out.println(man);
        }
    }
}