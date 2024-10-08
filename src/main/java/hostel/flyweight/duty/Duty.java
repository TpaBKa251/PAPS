package hostel.flyweight.duty;

import hostel.flyweight.duty.flyweight.DutyType;
import hostel.flyweight.fabric.DutyTypeFabric;

// Контекст
public class Duty {

    private final String date; // Уникальные данные
    private final String student; // Уникальные данные
    private final DutyType dutyType; // Общие данные (Flyweight)

    public Duty(String date, String student, String dutyType) {
        this.date = date;
        this.student = student;
        this.dutyType = DutyTypeFabric.getDutyType(dutyType);
    }

    public void performDuty() {
        dutyType.performDuty(date, student);
    }
}
