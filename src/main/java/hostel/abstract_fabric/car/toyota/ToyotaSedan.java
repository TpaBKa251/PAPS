package hostel.abstract_fabric.car.toyota;

import hostel.abstract_fabric.car.Car;

// Седан от Toyota
public class ToyotaSedan implements Car {

    @Override
    public void drive() {
        System.out.println("За рулем седана от Toyota");
    }
}