public class Java_Activity_1 {
	public static void main(String[] args) {
		Java_Car_Act1 toyota = new Java_Car_Act1();
        toyota.make = 2014;
        toyota.color = "Black";
        toyota.transmission = "Manual";
    
        //Using Car class method
        toyota.displayCharacterstics();
        toyota.accelerate();
        toyota.brake();
    }

}
