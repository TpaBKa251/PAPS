package hostel.abstract_fabric.car.tesla;

import hostel.abstract_fabric.car.Car;

// Седан от Tesla
public class TeslaSedan implements Car {

    @Override
    public void drive() {
        System.out.println("За рулем седана от Tesla");
    }
}
