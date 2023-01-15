package employeeInformation;
/*
 * Интерфейс I_View, задающий методы для сбора информации от пользователя. 
 */
public interface I_View <T, E> {
    Integer setIdForDelete();
    T setReplacementInfo();
    E setNewEmployee();
    String setSearchInfo();
}
