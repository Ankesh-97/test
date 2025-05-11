package org.example.enums;

import java.util.Arrays;
import java.util.List;

public enum JfrogProjects {

    TENANT_MANAGEMENT_SERVICE("tenant-management-service"),
    ACCOUNTS_SERVICE("acc-svc-rest"),
    BILLING_CARE("billing-care-rest"),
    COMMON_BACKEND_APP("common-backend-api"),
    DATA_PIPELINE_API("data-pipeline-api"),
    DATA_INGESTION("dataingestion-rest"),
    // MAPL_COMMONS("mapl-commons"),//not done
    MAPL_FLOW("mapl-worker"),
    MEDIATION("mediation-worker"),
    //MONETIZE360_COMMONS("monetize360-commons"),//not done
    OBJECT_MANAGEMENT_SERVICE("object-management-rest-api"),
    RATING_SERVICE("rating-rest"),
    REPORTS_DASHBOARDS("reports-dashboards-rest"),
    SCHEDULER_API("scheduler-rest"),
    SVC_DESIGNER("svc-designer-rest"),
    // ADMINISTRATION_UI("administration-ui"),//not done
    // BILLING_ANALYTICS_UI("billing-analytics-ui"),//not done
    // BILLING_CENTER_UI("billing-center-ui"),//not done
    //DEAL_STUDIO_UI("deal-studio-ui"),//not done
    // M360_UI_HOME("m360-ui-home"),//not done
    M360_UI_SERVER("m360-ui-server"),
    STATIC_SERVER("static-server"),
    // MEDIATION_UI("mediation_ui"),//not done
    //SERVICE_DESIGNER_UI("service-designer-ui"),//not done
    ;
    private String name;

    JfrogProjects(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static List<String> getJfrogNames(){
        List<JfrogProjects> jfrogProjects = Arrays.stream(JfrogProjects.values()).toList();
        return jfrogProjects.stream().map(JfrogProjects::getName).toList();
    }
}
