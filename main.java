import java.util.Scanner;

// Enumeration for fever control signals
enum Signal {
    COOLING, MEDICATION, NO_ACTION
}

// Class representing the Fever Controller
public class FeverController {

    // Current body temperature
    private int temperature;

    // Constructor to initialize temperature
    public FeverController() {
        this.temperature = 0;
    }

    // Check if the given temperature is considered feverish
    private boolean isFeverish(int temp) {
        return temp >= 38;  // Fever threshold is considered at 38 degrees Celsius
    }

    // Measure and update the current body temperature
    public void measureTemperature(int temp) {
        if (temp >= 0) {
            this.temperature = temp;
            System.out.println("Body temperature measured and updated to: " + temp);
        } else {
            System.out.println("Invalid temperature. Please enter a non-negative value.");
        }
    }

    // Determine the action to control fever based on the current temperature
    public Signal controlFever() {
        return determineAction(this.temperature);
    }

    // Helper function to determine the appropriate action based on the temperature
    private Signal determineAction(int temp) {
        if (isFeverish(temp)) {
            System.out.println("Fever detected! Recommended action: Cooling");
            return Signal.COOLING;
        } else if (temp == 0) {
            System.out.println("No temperature recorded. No specific action recommended.");
            return Signal.NO_ACTION;
        } else if (temp < 38) {
            System.out.println("Temperature below fever threshold. No specific action recommended.");
            return Signal.NO_ACTION;
        } else {
            System.out.println("Fever detected! Recommended action: Medication");
            return Signal.MEDICATION;
        }
    }

    // Main method to demonstrate the Fever Controller
    public static void main(String[] args) {
        FeverController feverController = new FeverController();
        Scanner scanner = new Scanner(System.in);

        // Measure temperature
        System.out.print("Enter the body temperature in Celsius: ");
        int inputTemperature = scanner.nextInt();
        feverController.measureTemperature(inputTemperature);

        // Control fever and get recommended action
        Signal recommendedAction = feverController.controlFever();
        System.out.println("Recommended Action: " + recommendedAction);

        // Close the scanner
        scanner.close();
    }
}
