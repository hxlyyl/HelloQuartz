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
		//mainִ�е�ʱ�䣺
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("��������ʱ��" + sdf.format(date));
		//����JobDetailʵ������������а�
		JobDetail jobDetail = (JobDetail) JobBuilder.newJob(HelloJob.class)
				.withIdentity("myJob", "group1")
				.build();
		//����������
		CronTrigger ctrigger = TriggerBuilder.newTrigger()
				.withIdentity("myTrigger", "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule("0 0 11 ? * * 2018"))
				.build();
		//������
		SchedulerFactory sfact = new StdSchedulerFactory();
		try {
			Scheduler scheduler = sfact.getScheduler();
			//��ʼִ�У�
			scheduler.scheduleJob(jobDetail, ctrigger);
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		

	}

}
