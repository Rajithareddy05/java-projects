import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;
    private boolean isCompleted;
    private String deadline;
    private int priority;

    public Task(String description, String deadline, int priority) {
        this.description = description;
        this.isCompleted = false;
        this.deadline = deadline;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getDeadline() {
        return deadline;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", isCompleted=" + isCompleted +
                ", deadline='" + deadline + '\'' +
                ", priority=" + priority +
                '}';
    }
}

public class TodoListApp {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    deleteTask();
                    break;
                case 3:
                    editTask();
                    break;
                case 4:
                    listTasks();
                    break;
                case 5:
                    markAsCompleted();
                    break;
                case 6:
                    setDeadline();
                    break;
                case 7:
                    organizeByPriority();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nTodo List Application Menu:");
        System.out.println("1. Add a task");
        System.out.println("2. Delete a task");
        System.out.println("3. Edit a task");
        System.out.println("4. List all tasks");
        System.out.println("5. Mark a task as completed");
        System.out.println("6. Set deadline for a task");
        System.out.println("7. Organize tasks by priority");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter task deadline: ");
        String deadline = scanner.nextLine();
        System.out.print("Enter task priority (1-5): ");
        int priority = scanner.nextInt();
        tasks.add(new Task(description, deadline, priority));
        System.out.println("Task added successfully.");
    }

    private static void deleteTask() {
        System.out.print("Enter index of task to delete: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Invalid index. No task deleted.");
        }
    }

    private static void editTask() {
        System.out.print("Enter index of task to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            System.out.print("Enter new task description: ");
            String description = scanner.nextLine();
            System.out.print("Enter new task deadline: ");
            String deadline = scanner.nextLine();
            System.out.print("Enter new task priority (1-5): ");
            int priority = scanner.nextInt();
            task = new Task(description, deadline, priority);
            tasks.set(index, task);
            System.out.println("Task edited successfully.");
        } else {
            System.out.println("Invalid index. No task edited.");
        }
    }

    private static void listTasks() {
        System.out.println("\nAll Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ". " + tasks.get(i));
        }
    }

    private static void markAsCompleted() {
        System.out.print("Enter index of task to mark as completed: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setCompleted(true);
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid index. No task marked as completed.");
        }
    }

    private static void setDeadline() {
        System.out.print("Enter index of task to set deadline for: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            System.out.print("Enter new deadline: ");
            String deadline = scanner.nextLine();
            task = new Task(task.getDescription(), deadline, task.getPriority());
            tasks.set(index, task);
            System.out.println("Deadline set successfully.");
        } else {
            System.out.println("Invalid index. No deadline set.");
        }
    }

    private static void organizeByPriority() {
        tasks.sort((t1, t2) -> t2.getPriority() - t1.getPriority());
        System.out.println("Tasks organized by priority.");
    }
}
