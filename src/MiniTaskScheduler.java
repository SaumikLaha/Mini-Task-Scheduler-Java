import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String title;
    String description;
    String deadline;

    Task(String title, String description, String deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }
}

public class MiniTaskScheduler {
    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("🗓️ Welcome to Mini Task Scheduler!");
        System.out.println("-----------------------------------");

        boolean running = true;
        while (running) {
            System.out.println("\n📋 Choose an option:");
            System.out.println("1️⃣  Add New Task");
            System.out.println("2️⃣  View All Tasks");
            System.out.println("3️⃣  Delete a Task");
            System.out.println("4️⃣  Exit");
            System.out.print("👉 Enter your choice: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    running = false;
                    System.out.println("\n✅ Exiting... Thank you for using Mini Task Scheduler! 👋");
                    break;
                default:
                    System.out.println("⚠️ Invalid choice! Please try again.");
            }
        }
    }

    public static void addTask() {
        System.out.print("\n🆕 Enter Task Title: ");
        String title = sc.nextLine();

        System.out.print("📝 Enter Task Description (optional): ");
        String description = sc.nextLine();

        System.out.print("⏰ Enter Task Deadline/Time (optional): ");
        String deadline = sc.nextLine();

        tasks.add(new Task(title, description, deadline));
        System.out.println("✅ Task added successfully!");
    }

    public static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("\n📭 No tasks available.");
            return;
        }

        System.out.println("\n📋 Your Tasks:");
        System.out.println("-----------------------------------");
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            System.out.println((i + 1) + ". " + t.title);
            if (!t.description.isEmpty()) System.out.println("   📝 " + t.description);
            if (!t.deadline.isEmpty()) System.out.println("   ⏰ Deadline: " + t.deadline);
            System.out.println("-----------------------------------");
        }
    }

    public static void deleteTask() {
        if (tasks.isEmpty()) {
            System.out.println("\n❌ No tasks to delete.");
            return;
        }

        viewTasks();
        System.out.print("🗑️ Enter the task number to delete: ");
        int num = getIntInput();

        if (num > 0 && num <= tasks.size()) {
            tasks.remove(num - 1);
            System.out.println("✅ Task deleted successfully!");
        } else {
            System.out.println("⚠️ Invalid task number!");
        }
    }

    public static int getIntInput() {
        while (true) {
            try {
                int num = Integer.parseInt(sc.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.print("❌ Invalid input! Please enter a number: ");
            }
        }
    }
}
