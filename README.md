# I. Brief Project Overview
Fitjourney is an executable program designed to help fitness enthusiasts track their workouts and fitness progress. It's main purpose is to provide a simple and organized way for users to log different types of exercises, set fitness goals, and monitor their activity. The program aims to make fitness tracking more convenient and efficient by focusing on usability and stability
# II. Explanation of how OOP principles were applied
* Encapsulation
  - Encapsulation is used in FitJourney by combining data and methods into one unit while restricting access to private fields. For instance, the FitnessUser class has private fields like height, weight, fitnessGoal, and workoutHistory. In addition, these fields can only be accessed or modified using public methods such as setFitnessDetails(), logWorkout(), and displayWorkoutHistory(). Moreover, the Workout class encapsulates data related to specific exercises, such as reps or minutes, and provides public methods for interacting with this data. Furthermore, this ensures that all data is securely handled and prevents unauthorized access. Lastly, encapsulation helps organize the program and makes it easier to maintain.

* Polymorphism:
  - Polymorphism is demonstrated in FitJourney through method overriding and flexibility. The displayDetails() method in the Workout class is overridden by the subclasses StrengthWorkout and CardioWorkout to provide specific details for each workout type. In addition, the program uses polymorphism to handle different workout types in a single list (workoutHistory) as Workout objects. Moreover, when the displayDetails() method is called, the program automatically determines the correct version to use based on the object type. Furthermore, this approach allows the program to adapt to different workout types without requiring separate handling for each. Lastly, polymorphism makes the program more flexible and easier to extend in the future.

* Inheritance:
  - Inheritance is applied in FitJourney by reusing and extending functionality from a parent class. For example, the Workout class acts as a parent class for StrengthWorkout and CardioWorkout. In addition, these subclasses inherit the structure of the parent class but provide specific implementations for their methods, such as tracking reps or minutes. Moreover, the FitnessUser class inherits common methods like getUsername() and verifyPassword() from the User class while adding fitness-specific features like logging workouts and setting fitness goals. Furthermore, inheritance reduces code duplication and allows for a cleaner program design. Lastly, it makes it easier to add new workout types in the future.

* Abstraction:
  - The idea of abstraction is to reveal only the most important parts of the program while hiding its complexity. In FitJourney, abstraction is applied through the use of the Workout class and its method displayDetails(). This method is defined in the Workout class but is implemented differently in the subclasses StrengthWorkout and CardioWorkout. Moreover, the Workout class serves as a blueprint for all workout types, while the specific details, like reps or minutes, are handled by the subclasses. Furthermore, this ensures that users only see the necessary details when logging or viewing workouts. Lastly, the abstraction hides how workout details are stored and displayed, simplifying the program for the user.

# III. SDG and Its Integration into the Project

* Good Health and Well-being
  - This System helps people live healthier lives by making it easy to track workouts and set fitness goals. It encourages regular exercise, which not only improves physical health but also boosts mental well-being by reducing stress and anxiety. With personalized progress tracking, users can stay motivated and see real improvements in their fitness. Ultimately, FitJourney supports users in building habits that lead to long-term health and wellness.

* Quality Education
  - FitJourney also helps people learn more about fitness. In addition, it shows users how to plan their workouts and explains the different types of exercises. Moreover, the program encourages users to understand how physical activity can improve their health. Lastly, FitJourney helps users make better choices when it comes to exercise, making them more confident in their fitness journey.

* Decent Work and Economic Growth
  - FitJourney also supports better productivity and economic growth by helping people become healthier. In addition, regular exercise boosts energy levels, which helps people perform better at work and in daily life. Moreover, when people are healthier, they take fewer sick days, reducing healthcare costs and benefiting both individuals and businesses. Lastly, FitJourney saves users time by automating fitness tracking, so they can focus on other important tasks.

* Reduced Inequalities
  - FitJourney is designed to be inclusive and accessible for everyone, no matter where they’re starting from in their fitness journey. In addition, it provides a variety of workouts that cater to different goals and fitness levels, so anyone can get involved. Moreover, the app is simple to use, making it easier for users to stay on track and overcome obstacles to getting fit. Lastly, FitJourney removes barriers, giving everyone, regardless of their background, the chance to improve their health.

# IV. Instructions for Running the Program
* Step 1: Install JAVA JDK:
  - Install Java JDK: Download and install the JDK from here if not already installed.
  - IDE or Text Editor: Use any editor (VSCode, IntelliJ, Notepad++) to write and compile the Java code.

* Step 2: Creating A File
  - Create a File:
  - Open your text editor.
  - Create a new file named FitJourney.java.
  - Copy and paste the code provided.

* Step 3:  Run the Program
  - Use this command in your terminal:
  - java FitJourney;

* Step 4: Register and Login
  - Enter Inputs:
  - The program will ask for your username, password, height, weight, original key, and and fitness goal (such as "Lose Weight", "Build Muscle", or "Stay Fit").
  - Enter the details as requested.

* Step 5: Interact with the Menu
* 1. Choose From the Menu:
     - Log Workout: Select this option to log a new workout (choose from different types like "Legs", "Chest", "Back", "Arms", or "Cardio").
     - View Workout History: Choose this option to view all the workouts you've logged.
     - Logout: Choose this option to log out of the application.

* Step 6: Input Details for Workouts
  - Depending on the workout type you select, you will be prompted to:
  - Strength Workout: Choose an exercise (e.g., Squats, Push-ups) and enter the number of reps.
  - Cardio Workout: Enter the number of minutes for your cardio activity.
 
* Step 7: View and Manage Workout History
  - After logging workouts, you can always view your workout history.
  - If no workouts have been logged yet, it will display a message indicating no workouts have been logged.

* Step 8: Exit the Program
  -  When you are done, you can choose the "Exit" option to leave the program.

  











