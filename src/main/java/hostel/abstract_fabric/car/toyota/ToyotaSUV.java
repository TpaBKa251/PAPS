package hostel.abstract_fabric.car.toyota;

import hostel.abstract_fabric.car.Car;

// Внедорожник от Toyota
public class ToyotaSUV implements Car {

    @Override
    public void drive() {
        System.out.println("За рулем внедорожника от Toyota");
    }
}
