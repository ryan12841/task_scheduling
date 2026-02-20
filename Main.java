import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ProjectDoa dao = new ProjectDoa();
    static projectScheduler scheduler = new projectScheduler();

    public static void main(String[] args) throws Exception {

        while (true) {

            System.out.println("\n1. Add Project");
            System.out.println("2. View Projects");
            System.out.println("3. Generate Schedule");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1 -> addProject();
                case 2 -> viewProjects();
                case 3 -> generateSchedule();
                case 4 -> exitfunct();
            }
        }
    }

    static void exitfunct() {
        System.out.println("Thank You For Using The Project Scheduler");
        System.exit(0);
    }

    static void addProject() throws Exception {

        scanner.nextLine();

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Deadline (working days): ");
        int deadline = scanner.nextInt();

        System.out.print("Revenue: ");
        double revenue = scanner.nextDouble();

        project project = new project(title, deadline, revenue);
        dao.addProject(project);
    }

    static void viewProjects() throws Exception {
        List<project> projects = dao.getAllProjects();
        projects.forEach(System.out::println);
    }

    static void generateSchedule() throws Exception {

        System.out.print("Enter number of planning weeks: ");
        int numberOfWeeks = scanner.nextInt();

        List<project> projects = dao.getAllProjects();

        project[][] calendar =
                scheduler.generateOptimalSchedule(projects, numberOfWeeks);

        System.out.println("\nFinal Schedule:\n");

        for (int week = 0; week < numberOfWeeks; week++) {

            System.out.println("Week " + (week + 1));

            for (int day = 0; day < 5; day++) {

                if (calendar[week][day] != null) {
                    System.out.println("  Day " + (day + 1)
                            + " -> " +
                            calendar[week][day].getTitle());
                } else {
                    System.out.println("  Day " + (day + 1)
                            + " -> No Project");
                }
            }
            System.out.println();
        }
    }
}
