public class project {

    private int projectId;
    private String title;
    private int deadline;   // working days (can be > 5)
    private double expectedRevenue;

    // Predictive scheduling fields
    private double score;
    private int maxAllowedSlot;

    public project(String title, int deadline, double expectedRevenue) {
        this.title = title;
        this.deadline = deadline;
        this.expectedRevenue = expectedRevenue;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public int getDeadline() {
        return deadline;
    }

    public double getExpectedRevenue() {
        return expectedRevenue;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getMaxAllowedSlot() {
        return maxAllowedSlot;
    }

    public void setMaxAllowedSlot(int maxAllowedSlot) {
        this.maxAllowedSlot = maxAllowedSlot;
    }

    @Override
    public String toString() {
        return "Project{" +
                "ID=" + projectId +
                ", Title='" + title + '\'' +
                ", Deadline=" + deadline +
                ", Revenue=" + expectedRevenue +
                '}';
    }
}
