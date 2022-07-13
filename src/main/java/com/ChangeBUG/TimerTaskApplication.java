package com.ChangeBUG;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.ChangeBUG.Mapper")
@EnableScheduling
@SpringBootApplication
public class TimerTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimerTaskApplication.class, args);
        System.out.println("  ______   __    __   ______   __    __   ______   ________         _______   __    __   ______  \n" +
                          " /      \\ /  |  /  | /      \\ /  \\  /  | /      \\ /         |      /       \\ /  |  /  | /      \\ \n" +
                          "/$$$$$$  |$$ |  $$ |/$$$$$$  |$$  \\ $$ |/$$$$$$  |$$$$$$$$/   启   $$$$$$$  |$$ |  $$ |/$$$$$$  |\n" +
                          "$$ |  $$/ $$ |__$$ |$$ |__$$ |$$$  \\$$ |$$ | _$$/ $$ |__      动   $$ |__$$ |$$ |  $$ |$$ | _$$/ \n" +
                          "$$ |      $$    $$ |$$    $$ |$$$$  $$ |$$ |/    |$$    |     成   $$    $$< $$ |  $$ |$$ |/    |\n" +
                          "$$ |   __ $$$$$$$$ |$$$$$$$$ |$$ $$ $$ |$$ |$$$$ |$$$$$/      功   $$$$$$$  |$$ |  $$ |$$ |$$$$ |\n" +
                          "$$ \\__/  |$$ |  $$ |$$ |  $$ |$$ |$$$$ |$$ \\__$$ |$$ |_____    !   $$ |__$$ |$$ \\__$$ |$$ \\__$$ |\n" +
                          "$$    $$/ $$ |  $$ |$$ |  $$ |$$ | $$$ |$$    $$/ $$       |   !   $$    $$/ $$    $$/ $$    $$/ \n" +
                          " $$$$$$/  $$/   $$/ $$/   $$/ $$/   $$/  $$$$$$/  $$$$$$$$/        $$$$$$$/   $$$$$$/   $$$$$$/");
    }

}
