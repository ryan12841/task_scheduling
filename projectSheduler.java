import java.util.*;

public class ProjectScheduler {

    public List<Project> generateOptimalSchedule(List<Project> projects) {

        int maxWorkingDays = 5;

        projects.sort((a, b) ->
                Double.compare(b.getExpectedRevenue(), a.getExpectedRevenue()));

        Project[] schedule = new Project[maxWorkingDays];

        for (Project project : projects) {

            for (int day = maxWorkingDays - 1; day >= 0; day--) {

                if (schedule[day] == null) {

                    int completionDay = day + getCompletionOffset(day);

                    if (completionDay <= project.getDeadline()) {
                        schedule[day] = project;
                        break;
                    }
                }
            }
        }

        return Arrays.stream(schedule)
                .filter(Objects::nonNull)
                .toList();
    }

   
    private int getCompletionOffset(int workingDayIndex) {
        if (workingDayIndex == 4) { // Friday
            return 3;
        }
        return 1;
    }
}
