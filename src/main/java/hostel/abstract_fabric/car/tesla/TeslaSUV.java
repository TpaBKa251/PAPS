package hostel.abstract_fabric.car.tesla;

import hostel.abstract_fabric.car.Car;

// Внедорожник от Tesla
public class TeslaSUV implements Car {

    @Override
    public void drive() {
        System.out.println("За рулем Tesla Cybertruck");
    }
}
