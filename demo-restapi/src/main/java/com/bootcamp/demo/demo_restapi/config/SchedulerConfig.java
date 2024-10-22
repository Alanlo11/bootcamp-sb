package com.bootcamp.demo.demo_restapi.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerConfig {
  // @Scheduled(fixedDelay = 5000) // 5000 ms = 5 seconds 每5秒做一次,end完先再行
  public void sayHello() throws Exception{
    System.out.println("Task A: Hello world! start=" + System.currentTimeMillis());
    Thread.sleep(2000);
    System.out.println("Task A: Hello world! end=" + System.currentTimeMillis());
  }

  // @Scheduled(fixedRate = 3000) // 要等上一支threat返左黎先再行，因為threat都係得一支
  public void sayBye() throws Exception{
    System.out.println("Task B: GoodBye! start=" + System.currentTimeMillis());
    Thread.sleep(4000);
    System.out.println("Task B: GoodBye! end=" + System.currentTimeMillis());
  }

  // @Scheduled(cron = "0 56 20 * * TUE")
  public void runTask(){
    System.out.println("Cron test");
  }
  
}
