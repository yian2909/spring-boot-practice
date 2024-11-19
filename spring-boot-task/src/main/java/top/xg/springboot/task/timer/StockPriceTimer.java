package top.xg.springboot.task.timer;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Lenovo
 */
@Slf4j
public class StockPriceTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            double price = 100;
            final Random random = new Random();
            @Override
            public void run() {
                price += (random.nextDouble() - 0.5) * 3;
                log.info("当前股票价格为:{}", price);
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}
