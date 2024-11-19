package top.xg.springboot.task.jobs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

//@Component
@Slf4j
public class ScheduledJobs {

//    @Scheduled(fixedRate = 3000)
//    public void fixedRateJob() throws InterruptedException {
//        log.info("fixedRateJob start:{}",new Date());
//        Thread.sleep(5000);
//        log.info("fixedRateJob end:{}",new Date());
//    }

//    @Scheduled(fixedDelay = 5000)
//    public void fixeddRateJob() throws InterruptedException {
//        log.info("fixedRateJob start:{}",new Date());
//        Thread.sleep(5000);
//        log.info("fixedRateJob end:{}",new Date());
//    }

    //每隔10秒
    @Scheduled(cron = "0/5 * * * * ?")
    public void fixedddRateJob() throws InterruptedException {
        log.info("---------cron 执行：{}",new Date());
    }
}
