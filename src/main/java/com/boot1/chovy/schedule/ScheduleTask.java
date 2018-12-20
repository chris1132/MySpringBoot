package com.boot1.chovy.schedule;

import com.boot1.chovy.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangchaohui on 2018/10/9.
 */
@Component
public class ScheduleTask {
    @Autowired
    private UserRedPacketService userRedPacketService;

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    private static int userid = 1;

//    @Scheduled(cron = "55 * * * * ?")
//    public void redpacketTask() {
//        // ÇÀºì°ü
//        System.out.println("START----------------redpacket");
//        for (int i = 1; i < 3000; i++) {
//            userid = i;
//            executorService.submit(new Runnable() {
//                @Override
//                public void run() {
//                    int result = userRedPacketService.grapRedPacket(1L, Long.valueOf(userid));
//                    System.out.println(result > 0 ? "redpacket success:" + userid : "redpacket faild" + userid);
//                }
//            });
//        }
//
//    }
}
