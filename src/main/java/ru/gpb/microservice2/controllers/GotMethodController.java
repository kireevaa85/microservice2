package ru.gpb.microservice2.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GotMethodController {

    private static final Logger logger = LoggerFactory.getLogger(GotMethodController.class);

    @GetMapping("/")
    public String index() {
        logger.info("got indexRequest in Microservice2");
        return "Greetings from Microservice2";
    }

    //http://localhost:8080/1
    @GetMapping(value = "/{methodNumber}")
    public String callMethod(@PathVariable("methodNumber") String name) {
        switch (name) {
            case "1":
                method1();
                return "Greetings from Microservice2::method1";
            case "2":
                method2();
                return "Greetings from Microservice2::method2";
            case "3":
                method3();
                return "Greetings from Microservice2::method3";
            default:
                logger.info("Not got any method :(");
                break;
        }
        return "Not got any method in Microservice2 :(";
    }

    @GetMapping("/exit")
    public void exit() {
        System.exit(0);
    }

    private void method1() {
        logger.info("got method1 in Microservice2");
    }

    private void method2() {
        logger.info("got method2 in Microservice2");
    }

    private void method3() {
        logger.info("got method3 in Microservice2");
    }

}
