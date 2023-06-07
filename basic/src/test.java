//안좋은 예시
interface Vehicle {
    void drive();
    void fly();
}
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car...");
    }
    @Override
    public void fly() {
        // 자동차는 비행할 수 없으므로 빈 메서드로 구현
    }
}
class Airplane implements Vehicle {
    @Override
    public void drive() {
        // 비행기는 주행할 수 없으므로 빈 메서드로 구현
    }
    @Override
    public void fly() {
        System.out.println("Flying an airplane...");
    }
}
public class test {
    public static void main(String[] args) {
        Car car = new Car();
        car.drive();  // "Driving a car..."

        Airplane airplane = new Airplane();
        airplane.fly();    // "Flying an airplane..."
    }
}
