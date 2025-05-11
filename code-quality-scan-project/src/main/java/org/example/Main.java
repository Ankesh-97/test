package org.example;
import org.example.services.JfrogUtil;
import org.example.services.SonarReportUtil;
import org.example.util.Config;

import java.io.IOException;


public class Main extends Config{

    public static void main(String[] args) throws IOException {

            SonarReportUtil sonarReportUtil = new SonarReportUtil();
            sonarReportUtil.start();
            JfrogUtil jfrogUtil = new JfrogUtil();
            jfrogUtil.start();

    }
}