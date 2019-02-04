import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzMain {

	public static void main(String[] args) throws SchedulerException {
	
		//JOb is created
		JobDetail job = JobBuilder.newJob(QuartsJob.class).build();
		//Trigger is created
		/*Trigger t1  = TriggerBuilder.newTrigger().withIdentity("SimpleTrigger").startNow().build();*/
		
		/*Trigger t1 = TriggerBuilder.newTrigger()
			      .withIdentity("trigger1", "group1")
			      .startNow()
			      .withSchedule(SimpleScheduleBuilder.simpleSchedule()
			              .withIntervalInSeconds(40)
			              .repeatForever())
			      .build();*/
		
		Trigger t1 = TriggerBuilder.newTrigger()
			      .withIdentity("trigger1", "group1")
			      .startNow()
			      .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *"))
			      .build(); 
		
			Scheduler sc = StdSchedulerFactory.getDefaultScheduler();
			sc.start();
			sc.scheduleJob(job,t1);
	}

}
