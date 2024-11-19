package top.xg.springboot.task.timer;

import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;

@Slf4j
public class ReminderTimer {
    public static void main(String[] args) {
        //定时器
        Timer timer = new Timer();
        //任务
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                //要做的事情
                log.info("该休息了");
            }
        };
        //程序启动立刻执行,每隔5秒执行一次
        timer.schedule(task,0,5000);
    }
}
