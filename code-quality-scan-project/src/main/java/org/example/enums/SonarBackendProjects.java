package org.example.enums;

import java.util.Arrays;
import java.util.List;

public enum SonarBackendProjects {

    TENANT_MANAGEMENT_SERVICE("tenant-management-service"),
    ACCOUNTS_SERVICE("accounts-service"),
    BILLING_CARE("billing-care"),
    COMMON_BACKEND_APP("common-backend-app"),
    DATA_PIPELINE_API("data-pipeline-api"),
    DATA_INGESTION("data-ingestion"),
    MAPL_COMMONS("mapl-commons"),
    MAPL_FLOW("mapl-flow"),
    MEDIATION("mediation"),
    MONETIZE360_COMMONS("monetize360-commons"),
    OBJECT_MANAGEMENT_SERVICE("object-management-service"),
    RATING_SERVICE("rating-service"),
    REPORTS_DASHBOARDS("reports-dashboards"),
    SCHEDULER_API("scheduler-api"),
    SVC_DESIGNER("svc-designer");

    private String name;

    SonarBackendProjects(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static List<String> getBackendNames(){
        List<SonarBackendProjects> sonarUIProjects = Arrays.stream(SonarBackendProjects.values()).toList();
        return sonarUIProjects.stream().map(SonarBackendProjects::getName).toList();
    }
}
