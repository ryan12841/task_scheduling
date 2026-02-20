import java.util.*;

public class projectScheduler {

    public project[][] generateOptimalSchedule(List<project> projects,
                                               int numberOfWeeks) {

        int totalCapacity = numberOfWeeks * 5;

        projects.removeIf(p ->
                p.getDeadline() <= 0 ||
                        p.getExpectedRevenue() <= 0);

        if (projects.isEmpty()) {
            return new project[numberOfWeeks][5];
        }

        // STEP 1: Calculate average revenue
        double totalRevenue = 0;
        for (project p : projects) {
            totalRevenue += p.getExpectedRevenue();
        }

        double avgRevenue = totalRevenue / projects.size();

        // STEP 2: Predictive scoring
        for (project p : projects) {

            int maxAllowedSlot =
                    Math.min(p.getDeadline(), totalCapacity);

            p.setMaxAllowedSlot(maxAllowedSlot);

            double efficiency =
                    p.getExpectedRevenue() / p.getDeadline();

            double urgency =
                    1.0 / p.getDeadline();

            double trendFactor =
                    p.getExpectedRevenue() / avgRevenue;

            double score =
                    0.5 * efficiency +
                            0.3 * trendFactor +
                            0.2 * urgency;

            p.setScore(score);
        }

        // STEP 3: Sort by predictive score
        projects.sort((a, b) -> {

            if (Double.compare(b.getScore(),
                    a.getScore()) != 0)
                return Double.compare(b.getScore(),
                        a.getScore());

            if (Double.compare(b.getExpectedRevenue(),
                    a.getExpectedRevenue()) != 0)
                return Double.compare(b.getExpectedRevenue(),
                        a.getExpectedRevenue());

            if (a.getDeadline() != b.getDeadline())
                return Integer.compare(a.getDeadline(),
                        b.getDeadline());

            return Integer.compare(a.getProjectId(),
                    b.getProjectId());
        });

        project[][] calendar =
                new project[numberOfWeeks][5];

        // STEP 4: Assign projects
        for (project p : projects) {

            boolean assigned = false;

            for (int week = 0;
                 week < numberOfWeeks && !assigned;
                 week++) {

                for (int day = 0; day < 5; day++) {

                    int slotNumber =
                            week * 5 + day + 1;

                    if (slotNumber <= p.getMaxAllowedSlot()
                            && calendar[week][day] == null) {

                        calendar[week][day] = p;
                        assigned = true;
                        break;
                    }
                }
            }
        }

        return calendar;
    }
}
