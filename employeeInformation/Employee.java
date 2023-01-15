package employeeInformation;

import java.io.Serializable;
/*
 * Класс Employee - экземпляры данного класса являются сотрудниками некой компании. 
 * У сотрудника есть id, ФИО, телефон, адрес и номер паспорта.
 */
public class Employee implements Serializable {
    private Integer id;
    private String sName;
    private String fName;
    private String patronymic;
    private String phone;
    private String address;
    private String passport;

    public Employee(Integer id, String sName, String fName, String patronymic, String phoneNumber, String address,
            String passportNumber) {
        this.id = id;
        this.sName = sName;
        this.fName = fName;
        this.patronymic = patronymic;
        this.phone = phoneNumber;
        this.address = address;
        this.passport = passportNumber;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPhone(String phoneNumber) {
        this.phone = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassport(String passportNumber) {
        this.passport = passportNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getsName() {
        return sName;
    }

    public String getfName() {
        return fName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getPassport() {
        return passport;
    }
    
    @Override
    public String toString() {
        return String.format("id: %d, Фамилия: %s, Имя: %s, Отчество: %s, телефон: %s, адрес: %s, паспорт: %s", 
        this.getId(), this.getsName(), this.getfName(), this.getPatronymic(), this.getPhone(), 
        this.getAddress(), this.getPassport());
    }
}
