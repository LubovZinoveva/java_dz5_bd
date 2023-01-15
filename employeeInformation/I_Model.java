package employeeInformation;
/*
 * Интерфейс I_Model, задающий методы моделей работы с сотрудниками. 
 * Это Добавление нового сотрудника, поиск сотрудника по имеющейся о нем информации, 
 * замена/обновление инофрмации о сотруднике, удаление сотрудника и загрузка списка сотрудников. 
 */
public interface I_Model<T, E, V> {
    void addNewEmployee(Employee man, String path);

    V employeeSearch(T criteria, String path);

    void replaceInfo(Integer id, E info1, E info2, String path);

    void deleteEmployee(Integer id, String path);

    void loadData(String path);
}
