import java.util.Scanner;
public class Greeting {

        public static void main(String[] args) {
            // Get user's name
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your name: ");
            String userName = scanner.nextLine();

            // Get user's input for hour
            System.out.print("Enter the current hour in 24-hour format (0-23): ");
            int currentHour = scanner.nextInt();

            // Validate the entered hour
            if (isValidHour(currentHour)) {
                // Greet the user with their name and the entered hour
                String greeting = generateGreeting(userName, currentHour);
                System.out.println(greeting);
            } else {
                System.out.println("Invalid hour. Please enter a valid hour in the range of 0-23.");
            }

            // Close the scanner
            scanner.close();
        }

        // Method to validate the entered hour
       static boolean isValidHour(int hour) {
            return hour >= 0 && hour <= 23;
        }

        // Method to generate a greeting message
        private static String generateGreeting(String name, int hour) {
            String timeOfDay;

            if (hour >= 0 && hour < 12) {
                timeOfDay = "morning";
            } else if (hour >= 12 && hour < 18) {
                timeOfDay = "afternoon";
            } else {
                timeOfDay = "evening";
            }

            return "Good " + timeOfDay + ", " + name + "! Have a great day.";
        }
    }


