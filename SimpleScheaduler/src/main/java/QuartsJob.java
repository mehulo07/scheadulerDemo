import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartsJob implements Job{

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Hello World From Quartz Scheadular");
		System.out.println(new Date());
	}
	
}
