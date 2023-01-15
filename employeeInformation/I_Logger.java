package employeeInformation;
/*
 * Интерфейс I_Logger, задающий методы для сохранения и загрузки сотрудников в файл
 */
public interface I_Logger<T> {

    void save(String path, T data);
    T load(String path);

}
