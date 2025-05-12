package org.example.util;

import java.io.File;

import static org.example.util.Utility.deleteFolder;

public class Config {

    /*
    JFROG CONFIGURATIONS
     */
    public static final String JFROG_TAG = "rel_3.6.3";
    //public static final String JFROG_COOKIE = "jf_sh=W3sic2VydmVybmFtZSI6Im1vbmV0aXplMzYwIiwiZmlyc3RMb2dpbiI6IjIwMjMtMTItMDVUMDY6NDM6MzAuMjc5WiJ9XQ==; __Host-ACCESSTOKEN=eyJ2ZXIiOiIyIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYiLCJraWQiOiIxTkpYMHNrMmowVDAzTkN5YjNpRHpiNVNDSlBWUVZiTkNKOUNfRExyT293In0.eyJleHQiOiJ7XCJycHBcIjp0cnVlLFwicnB1XCI6dHJ1ZSxcInJsbVwiOlwiaW50ZXJuYWxcIixcInNpZFwiOlwiWHhqeTVrQ1F5MlJ1QkE2SC05MXRQOFBhS2NIWDVKY2VcIixcInJldm9jYWJsZVwiOnRydWUsXCJsbHRcIjoxNzA2Njg0MTY4MjA2LFwicHVkXCI6dHJ1ZX0iLCJzdWIiOiJqZmZlQDAxaDFzZHlhbW1zNnNwMW44bWRmOGUxYzZwL3VzZXJzL2Fua2VzaC5rdW1hckBtb25ldGl6ZTM2MC5pbyIsInNjcCI6ImFwcGxpZWQtcGVybWlzc2lvbnMvdXNlciIsImF1ZCI6ImpmZmVAMDFoMXNkeWFtbXM2c3AxbjhtZGY4ZTFjNnAiLCJpc3MiOiJqZmZlQDAxaDFzZHlhbW1zNnNwMW44bWRmOGUxYzZwIiwiZXhwIjoxNzA2Njg5NjE0LCJpYXQiOjE3MDY2ODc4MTQsImp0aSI6IjcyMjI5M2Y3LTJiNWEtNGZiNy05OTI1LWMwNzIzYjBmZTljOCJ9.uJnZgAbZ7v3jCeO74ARa8V8uN0mZfpPn17W3W9nhvBJaA9uV8L1_rTbUATua7KFROU0ZenALVtDsgVgnC-nt_i_CheWd-mPcuWon3tXy9hkll0nlWITfbvv8j5F0P4Er4zaF84dCwc_H55_akRr6SYp6qpb2591tQ9elw57MH9H4buCUibDFZmiz_lxjLBVLtr95GLnnd1V0prfJ69b_MnlczcC6HmQLebsbY_JrXJig7um132ifS8uuGQLWDvFYOqkP4Xkh_UKGiv3VsS7p_HSmOEpiNlDJbF6QJBZnqFQew5QI_yruFyvq3EZWSo0UuRtZEOdL_eM2NsLGBsy7oA; __Host-REFRESHTOKEN=b8e886ed-308d-4df1-9669-d7f304c95b64; _hp2_id.1502104954=%7B%22userId%22%3A%225443323684824037%22%2C%22pageviewId%22%3A%221714535546262852%22%2C%22sessionId%22%3A%227662068094602467%22%2C%22identity%22%3A%22a29c975e683c0449d349999f40d464db-a0psrnms6gccd%22%2C%22trackerVersion%22%3A%224.0%22%2C%22identityField%22%3Anull%2C%22isIdentified%22%3A1%2C%22oldIdentity%22%3Anull%7D; _hp2_ses_props.1502104954=%7B%22ts%22%3A1706688035158%2C%22d%22%3A%22monetize360.jfrog.io%22%2C%22h%22%3A%22%2Fui%2Fpackages%22%7D";

    /*
    SONAR CONFIGURATIONS
     */
    public static final String BRANCH = "origin/qa";
    //public static final String SONAR_COOKIE = "XSRF-TOKEN=uvadi95l24gu75gqccsk9r556s; JWT-SESSION=eyJhbGciOiJIUzI1NiJ9.eyJsYXN0UmVmcmVzaFRpbWUiOjE3MDY2ODc5ODY1NjYsInhzcmZUb2tlbiI6InV2YWRpOTVsMjRndTc1Z3FjY3NrOXI1NTZzIiwianRpIjoiQVkxWkRJTHFLQTZQVjZ5ZVd5QVIiLCJzdWIiOiJBWWo3Z2RCQmpEWXpWRVBCMlZxeSIsImlhdCI6MTcwNjU5NjAwOCwiZXhwIjoxNzA2OTQ3MTg2fQ.hYM2ob8iRZNcj_lv_TQCWLVU4tESDkDfRyPx_kqin5g";

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
