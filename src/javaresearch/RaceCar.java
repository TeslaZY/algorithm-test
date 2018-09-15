package javaresearch;

class RaceCar extends Car {
    @Override
    public int speed() {
        return 150;
    }

    public static void main(String[] args){
        RaceCar racer = new RaceCar();
        Car car = new RaceCar();
        Vehicle vehicle = new RaceCar();
        System.out.println(racer.speed() + ", " + car.speed() + ", " + vehicle.speed());
    }
}

