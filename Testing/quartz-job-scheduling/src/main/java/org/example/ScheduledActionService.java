package org.example;

import org.springframework.stereotype.Component;

@Component
public class ScheduledActionService {

        public void execute() {
            System.out.println("Hello Quartz!");
        }
}
