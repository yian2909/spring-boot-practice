package top.xg.springboot.task.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.xg.springboot.task.jobs.ExportJob;
import top.xg.springboot.task.jobs.SimpleQuartzTask;

/**
 * @author Lenovo
 */
//@Configuration
public class ExportQuartzConfig {
    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(ExportJob.class)
                .withIdentity("ExportTask")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(jobDetail())
                .withIdentity("ExportTask")
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}
