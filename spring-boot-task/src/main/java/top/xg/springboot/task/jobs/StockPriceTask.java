package top.xg.springboot.task.jobs;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.xg.springboot.task.entity.StockPrice;
import top.xg.springboot.task.mapper.StockPriceMapper;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author Lenovo
 */
@Slf4j
//@Component
@AllArgsConstructor
public class StockPriceTask {
    private final StockPriceMapper stockPriceMapper;
    private final Random random = new Random();

    @Scheduled(fixedRate = 5000)
    public void updateStockPrice() {
        double price = random.nextDouble() * 50 + 100;

        DecimalFormat df = new DecimalFormat("#.00");
        String priceStr = df.format(price);

        StockPrice stockPrice = new StockPrice();
        stockPrice.setPrice(Double.parseDouble(priceStr));

        stockPrice.setName("小米");
        stockPrice.setUpdateTime(LocalDateTime.now());

        stockPriceMapper.insert(stockPrice);
        log.info("股票价格已更新:{},时间:{}",priceStr,LocalDateTime.now());
    }
}
