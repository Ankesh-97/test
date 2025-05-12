package org.example.util;

import java.io.File;

import static org.example.util.Utility.deleteFolder;

public class Config {

    /*
    JFROG CONFIGURATIONS
     */
    public static final String JFROG_TAG = "rel_3.6.3";
    //public static final String JFROG_COOKIE = "";
    /*
    SONAR CONFIGURATIONS
     */
    public static final String BRANCH = "origin/qa";
    //public static final String SONAR_COOKIE = "";
    /*
    COMMON CONFIGURATIONS
     */
    public static final String OUTPUT_DIRECTORY = "C:/Users/Admin/Downloads";
    public static final String RELEASE  = "3.6.0";

    /*
    MERGED FILE CONFIGURATIONS
     */

    public static final String SONAR_REPORT_MERGED_FILE_NAME = RELEASE + "_Sonar_Report.pdf";
    public static final String JFROG_REPORT_MERGED_FILE_NAME = JFROG_TAG + "_Jfrog_Report.pdf";

    public static final String SONAR_FAILED_REPORT_MERGED_FILE_NAME = RELEASE + "_Sonar_Failed_Report.pdf";
    public static final String JFROG_HIGH_SEVERITY_REPORT_MERGED_FILE_NAME = RELEASE + "_Jfrog_High_Severity_Report.pdf";


    /*
    BELOW CONFIGURATIONS ARE DERIVED FROM ABOVE CONFIGURATIONS
     */
    public static final String OUTPUT_FOLDER = OUTPUT_DIRECTORY +"/" + RELEASE;
    public static final String SONAR_OUTPUT_FOLDER = OUTPUT_FOLDER + "/SONAR";
    public static final String JFROG_OUTPUT_FOLDER = OUTPUT_FOLDER + "/JFROG";
    public static final String SONAR_OUTPUT_FILE = SONAR_OUTPUT_FOLDER + "/" + SONAR_REPORT_MERGED_FILE_NAME;
    public static final String JFROG_OUTPUT_FILE = JFROG_OUTPUT_FOLDER + "/" + JFROG_REPORT_MERGED_FILE_NAME;
    public static final String SONAR_FAILED_OUTPUT_FILE = SONAR_OUTPUT_FOLDER + "/" + SONAR_FAILED_REPORT_MERGED_FILE_NAME;
    public static final String JFROG_HIGH_SEVERITY_OUTPUT_FILE = JFROG_OUTPUT_FOLDER + "/" + JFROG_HIGH_SEVERITY_REPORT_MERGED_FILE_NAME;

    static{
        if(new File(OUTPUT_FOLDER).exists()){
            deleteFolder(new File(OUTPUT_FOLDER));
        }
        new File(OUTPUT_FOLDER).mkdir();
        new File(SONAR_OUTPUT_FOLDER).mkdir();
        new File(JFROG_OUTPUT_FOLDER).mkdir();
    }

}
