package HXL.HelloQuartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		//����ʱ��
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("��ǰʱ��" + sf.format(date));
		System.out.println("��ã�����");

	}

}
