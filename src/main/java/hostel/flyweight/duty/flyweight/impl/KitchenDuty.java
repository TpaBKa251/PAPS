package hostel.flyweight.duty.flyweight.impl;

import hostel.flyweight.duty.flyweight.DutyType;

// Конкретный класс дежурства на кухне
public class KitchenDuty implements DutyType {

    @Override
    public void performDuty(String date, String student) {
        System.out.println("Дежурство на кухне: Студент " + student + " дежурит " + date);
    }
}
