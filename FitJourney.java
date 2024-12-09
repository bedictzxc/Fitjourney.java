import java.util.*;

// Abstract class demonstrating abstraction
abstract class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }

    public abstract void displayMenu();
}

// Subclass for fitness-related data (Inheritance)
class FitnessUser extends User {
    private double height; // in cm
    private double weight; // in kg
    private String fitnessGoal;
    private List<Workout> workoutHistory;

    public FitnessUser(String username, String password) {
        super(username, password);
        this.workoutHistory = new ArrayList<>();
    }

    public void setFitnessDetails(double height, double weight, String fitnessGoal) {
        this.height = height;
        this.weight = weight;
        this.fitnessGoal = fitnessGoal;
    }

    public void logWorkout(Workout workout) {
        workoutHistory.add(workout);
    }

    @Override
    public void displayMenu() {
        System.out.println("Welcome, " + getUsername() + "! Here is your menu:");
        System.out.println("1. Log Workout");
        System.out.println("2. View Workout History");
        System.out.println("3. Exit");
    }

    public void displayWorkoutHistory() {
        System.out.println("\n=== Workout History ===");
        if (workoutHistory.isEmpty()) {
            System.out.println("No workouts logged yet!");
        } else {
            for (Workout workout : workoutHistory) {
                workout.displayDetails();
            }
        }
        System.out.println("========================\n");
    }
}

// Abstract class for workouts (Encapsulation + Abstraction)
abstract class Workout {
    private String exerciseType;

    public Workout(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public abstract void displayDetails();
}

// Polymorphism via subclasses of Workout
class StrengthWorkout extends Workout {
    private int reps;

    public StrengthWorkout(String exerciseType, int reps) {
        super(exerciseType);
        this.reps = reps;
    }

    @Override
    public void displayDetails() {
        System.out.println(getExerciseType() + ": " + reps + " reps");
    }
}

class CardioWorkout extends Workout {
    private int minutes;

    public CardioWorkout(String exerciseType, int minutes) {
        super(exerciseType);
        this.minutes = minutes;
    }

    @Override
    public void displayDetails() {
        System.out.println(getExerciseType() + ": " + minutes + " minutes");
    }
}

// Main class
public class FitJourney {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, FitnessUser> users = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to FitJourney!");
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> register();
                case 2 -> login();
                case 3 -> {
                    System.out.println("Exiting... Stay fit!");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already exists. Try a different one.");
        } else {
            FitnessUser user = new FitnessUser(username, password);
            System.out.print("Enter your height (cm): ");
            double height = scanner.nextDouble();
            System.out.print("Enter your weight (kg): ");
            double weight = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter your fitness goal (Lose Weight, Build Muscle, Stay Fit): ");
            String goal = scanner.nextLine();
            user.setFitnessDetails(height, weight, goal);
            users.put(username, user);
            System.out.println("Registration successful!");
        }
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        FitnessUser user = users.get(username);
        if (user != null && user.verifyPassword(password)) {
            System.out.println("Login successful!");
            userMenu(user);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void userMenu(FitnessUser user) {
        while (true) {
            user.displayMenu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> logWorkout(user);
                case 2 -> {
                    user.displayWorkoutHistory();
                    System.out.print("Press Enter to return to the menu...");
                    scanner.nextLine();
                }
                case 3 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void logWorkout(FitnessUser user) {
        System.out.println("Workout Types:");
        System.out.println("1. Legs");
        System.out.println("2. Chest");
        System.out.println("3. Back");
        System.out.println("4. Arms");
        System.out.println("5. Cardio");
        System.out.print("Choose a workout type: ");
        int type = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (type) {
            case 1 -> logStrengthWorkout(user, "Legs", new String[]{"Squats", "Leg Press", "Leg Curls"});
            case 2 -> logStrengthWorkout(user, "Chest", new String[]{"Bench Press", "Push-ups", "Chest Fly", "Incline Press"});
            case 3 -> logStrengthWorkout(user, "Back", new String[]{"Pull-ups", "Deadlifts", "Lat Pulldowns", "Rows"});
            case 4 -> logStrengthWorkout(user, "Arms", new String[]{"Bicep Curls", "Tricep Dips", "Barbell Curl", "Hammer Curl"});
            case 5 -> {
                System.out.print("Enter minutes: ");
                int minutes = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                user.logWorkout(new CardioWorkout("Cardio", minutes));
            }
            default -> System.out.println("Invalid workout type.");
        }
    }

    private static void logStrengthWorkout(FitnessUser user, String category, String[] exercises) {
        System.out.println(category + " Exercises:");
        for (int i = 0; i < exercises.length; i++) {
            System.out.println((i + 1) + ". " + exercises[i]);
        }
        System.out.print("Choose an exercise: ");
        int exerciseChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (exerciseChoice > 0 && exerciseChoice <= exercises.length) {
            System.out.print("Enter reps: ");
            int reps = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            user.logWorkout(new StrengthWorkout(exercises[exerciseChoice - 1], reps));
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
