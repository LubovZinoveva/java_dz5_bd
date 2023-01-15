package employeeInformation;

import java.util.HashMap;
import java.util.HashSet;

/*
 * В класс Presenter 1 метод startWork, который берет данные из класса View и применяет их в классе Model. 
 */
public class Presenter {
    public void startWork(String path){
        View view = new View();
        Model mod = new Model();
        int chooseMod = view.setMod();
        System.out.println();
        switch (chooseMod) {
            case 1:
                System.out.println("     СПИСОК СОТРУДНИКОВ");
                System.out.println("------------------------------");
                mod.loadData(path);
                break;
            case 2:
                mod.deleteEmployee(view.setIdForDelete(), path);
                break;
            case 3:
                HashMap<String, String> re = view.setReplacementInfo();
                mod.replaceInfo(Integer.parseInt(re.get("id")), re.get("column"), re.get("newData"), path);
                break;
            case 4:
                mod.addNewEmployee(view.setNewEmployee(), path);
                break;
            case 5:
                HashSet<Employee> result = mod.employeeSearch(view.setSearchInfo(), path);
                for(Employee man : result){
                    System.out.println(man);
                }
                break;
            default:
                System.out.println("Неверный режим, попробуйте заново.");
                break;
        }
    }
}
