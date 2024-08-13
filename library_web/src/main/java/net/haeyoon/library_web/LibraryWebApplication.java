package net.haeyoon.library_web;

import net.haeyoon.library_core.common.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(AppConfig.class)
@SpringBootApplication(scanBasePackages = {"net.haeyoon.library_core","net.haeyoon.library_web"})
public class LibraryWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryWebApplication.class, args);
        System.out.println("Spring Boot Application - library_web Started");
    }

}
