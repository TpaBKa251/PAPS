package hostel.abstract_fabric.fabric.impl;

import hostel.abstract_fabric.enums.CarType;
import hostel.abstract_fabric.car.Car;
import hostel.abstract_fabric.car.tesla.TeslaSUV;
import hostel.abstract_fabric.car.tesla.TeslaSedan;
import hostel.abstract_fabric.fabric.CarFabric;

// Фабрика Tesla
public class TeslaFabric implements CarFabric {

    @Override
    public Car getCar(CarType type) {
        return switch (type) {
            case SUV -> new TeslaSUV();
            case SEDAN -> new TeslaSedan();
        };
    }
}