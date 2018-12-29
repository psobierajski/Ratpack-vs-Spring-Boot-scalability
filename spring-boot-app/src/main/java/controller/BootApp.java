package controller;

import io.BlockingOperationSimulator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BootApp {

    private final BlockingOperationSimulator simulator = new BlockingOperationSimulator();

    public static void main(String[] args) {
        SpringApplication.run(BootApp.class, args);
    }

    @GetMapping("blockFor/{milliseconds}")
    public int blockFor(@PathVariable int milliseconds) throws InterruptedException {
        return simulator.blockFor(milliseconds);
    }
}
