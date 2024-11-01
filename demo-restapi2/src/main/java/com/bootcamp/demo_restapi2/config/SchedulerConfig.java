package com.bootcamp.demo_restapi2.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerConfig {
  public void sayHello() throws Exception {
  //   System.out.println("Task A: Hello World! start=" + System.currentTimeMillis());
  //   Thread.sleep(6000);
  //   System.out.println("Task A: Hello World! end=" + System.currentTimeMillis());
  // }

  // // @Scheduled(fixedRate = 3000)
  // public void sayBye() throws Exception {
  //   System.out.println("Task B: GoodBye! start=" + System.currentTimeMillis());
  //   Thread.sleep(4000);
  //   System.out.println("Task B: GoodBye! end=" + System.currentTimeMillis());
  // }

  // @Scheduled(cron = "0 55 20 * * TUE") // Run every weekday at 12 PM and 6 PM.
  //   public void runTask() {
  //       System.out.println("Cron Job Test");
    }
}
