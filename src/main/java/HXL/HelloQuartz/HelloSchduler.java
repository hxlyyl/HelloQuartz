package HXL.HelloQuartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class HelloSchduler {

	public static void main(String[] args) {
		//main执行的时间：
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("程序运行时间" + sdf.format(date));
		//创建JobDetail实例与任务类进行绑定
		JobDetail jobDetail = (JobDetail) JobBuilder.newJob(HelloJob.class)
				.withIdentity("myJob", "group1")
				.build();
		//创建触发器
		CronTrigger ctrigger = TriggerBuilder.newTrigger()
				.withIdentity("myTrigger", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule("0 0 11 ? * * 2018"))
				.build();
		//调度器
		SchedulerFactory sfact = new StdSchedulerFactory();
		try {
			Scheduler scheduler = sfact.getScheduler();
			//开始执行：
			scheduler.scheduleJob(jobDetail, ctrigger);
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		

	}

}
