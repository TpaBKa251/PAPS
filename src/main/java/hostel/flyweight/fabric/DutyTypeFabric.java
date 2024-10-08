package hostel.flyweight.fabric;

import hostel.flyweight.duty.flyweight.DutyType;
import hostel.flyweight.duty.flyweight.impl.HallDuty;
import hostel.flyweight.duty.flyweight.impl.KitchenDuty;
import hostel.flyweight.duty.flyweight.impl.SanitaryDuty;

import java.util.HashMap;
import java.util.Map;

// Фабрика для управления экземплярами дежурств
public class DutyTypeFabric {

    private static final Map<String, DutyType> dutyTypes = new HashMap<>();

    public static DutyType getDutyType(String type) {

        return dutyTypes.computeIfAbsent(type, t -> switch (t) {
            case "KITCHEN" -> new KitchenDuty();
            case "HALL" -> new HallDuty();
            case "SANITARY" -> new SanitaryDuty();
            default -> null;
        });
    }
}
