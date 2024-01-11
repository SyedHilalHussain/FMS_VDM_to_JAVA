import java.util.Scanner;

// Enumeration for fever control signals enum
enum Signal {
    COOLING, MEDICATION, NO_ACTION
}

// Class representing the Fever Controller
class FeverController {

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
}

// Tester class for FeverController class
class FeverControllerTester {
    public static void main(String[] args) {
        char choice;
        Scanner scanner = new Scanner(System.in);
        FeverController feverController = new FeverController();

        do {
            System.out.println("\n\t\tFeverController Tester\n");
            System.out.println("1. Display temperature");
            System.out.println("2. Measure temperature");
            System.out.println("3. Control fever");
            System.out.println("4. Quit");
            System.out.println("Enter choice 1-4");
            choice = scanner.next().charAt(0);
            System.out.println(); // blank line

            switch (choice) {
                case '1':
                    option1(feverController);
                    break;
                case '2':
                    option2(feverController, scanner);
                    break;
                case '3':
                    option3(feverController);
                    break;
                default:
                    break;
            }
        } while (choice != '4');

        scanner.close();
    }

    // Test case to display the current temperature
    private static void option1(FeverController feverController) {
        Signal result = feverController.controlFever();
        System.out.println("Current temperature is: " + result);
    }

    // Test case to measure a new temperature
    private static void option2(FeverController feverController, Scanner scanner) {
        System.out.print("Enter body temperature in Celsius: ");
        int temp = scanner.nextInt();
        feverController.measureTemperature(temp);
    }

    // Test case to control fever and display recommended action
    private static void option3(FeverController feverController) {
        Signal action = feverController.controlFever();
        System.out.println("Recommended Action: " + action);
    }
}
