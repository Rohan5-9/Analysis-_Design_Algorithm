import java.util.*;

class Job {
    int id, deadline, profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {
    public static void main(String[] args) {

        Job[] jobs = {
            new Job(1, 2, 100),
            new Job(2, 1, 19),
            new Job(3, 2, 27),
            new Job(4, 1, 25),
            new Job(5, 3, 15)
        };

        // Sort by profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (Job job : jobs)
            maxDeadline = Math.max(maxDeadline, job.deadline);

        int[] slot = new int[maxDeadline];
        Arrays.fill(slot, -1);

        int totalProfit = 0;

        for (Job job : jobs) {
            for (int j = job.deadline - 1; j >= 0; j--) {
                if (slot[j] == -1) {
                    slot[j] = job.id;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        System.out.println("Selected Jobs:");
        for (int i : slot) {
            if (i != -1)
                System.out.print("Job" + i + " ");
        }

        System.out.println("\nTotal Profit = " + totalProfit);
    }
}
