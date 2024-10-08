package hostel.flyweight.duty.flyweight.impl;

import hostel.flyweight.duty.flyweight.DutyType;

// Конкретный класс дежурства санитарной проверки
public class SanitaryDuty implements DutyType {

    @Override
    public void performDuty(String date, String student) {
        System.out.println("Санитарная проверка: Студент " + student + " дежурит " + date);
    }
}
