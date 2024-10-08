package hostel.flyweight.duty.flyweight;

// Интерфейс для всех типов дежурств
public interface DutyType {

    void performDuty(String date, String student);
}