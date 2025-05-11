package org.example.enums;

import java.util.Arrays;
import java.util.List;

public enum SonarUIProjects {

    ADMINISTRATION_UI("administration-ui"),
    BILLING_ANALYTICS_UI("billing-analytics-ui"),
    BILLING_CENTER_UI("billing-center-ui"),
    DEAL_STUDIO_UI("deal-studio-ui"),
    M360_UI_HOME("m360-ui-home"),
    M360_UI_SERVER("m360-ui-server"),
    MEDIATION_UI("mediation_ui"),
    SERVICE_DESIGNER_UI("service-designer-ui");

    private String name;

    SonarUIProjects(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static List<String> getUINames(){
        List<SonarUIProjects> sonarUIProjects = Arrays.stream(SonarUIProjects.values()).toList();
        return sonarUIProjects.stream().map(SonarUIProjects::getName).toList();
    }
}
