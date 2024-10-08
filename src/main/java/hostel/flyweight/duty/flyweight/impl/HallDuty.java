package hostel.flyweight.duty.flyweight.impl;

import hostel.flyweight.duty.flyweight.DutyType;

// Конкретный класс дежурства в зале
public class HallDuty implements DutyType {

    @Override
    public void performDuty(String date, String student) {
        System.out.println("Дежурство в зале: Студент " + student + " дежурит " + date);
    }
}
