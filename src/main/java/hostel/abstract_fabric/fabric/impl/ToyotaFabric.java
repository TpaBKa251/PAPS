package hostel.abstract_fabric.fabric.impl;

import hostel.abstract_fabric.enums.CarType;
import hostel.abstract_fabric.car.Car;
import hostel.abstract_fabric.car.toyota.ToyotaSUV;
import hostel.abstract_fabric.car.toyota.ToyotaSedan;
import hostel.abstract_fabric.fabric.CarFabric;

// Фабрика Toyota
public class ToyotaFabric implements CarFabric {

    @Override
    public Car getCar(CarType type) {
        return switch (type) {
            case SUV -> new ToyotaSUV();
            case SEDAN -> new ToyotaSedan();
        };
    }
}
