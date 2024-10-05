package hostel.abstract_fabric.fabric;

import hostel.abstract_fabric.enums.CarType;
import hostel.abstract_fabric.car.Car;

// Абстрактная фабрика
public interface CarFabric {

    Car getCar(CarType type);
}
