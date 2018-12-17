package mobile.fuvh.cn.followupvisithelper.patient.bean;

import java.io.Serializable;
import java.util.List;

import cn.wowjoy.commonlibrary.bean.BaseResponse;

public class TestAnalyResponse extends BaseResponse<TestAnalyResponse.ResultsBean> implements Serializable {

    public static class ResultsBean implements Serializable{
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable{
            /**
             * create_time : 2018-04-27 17:32:00
             * critical_value_flag : null
             * test_result_unit : g/L
             * reference_lower_limit : 65.0
             * test_result_describe : null
             * read_flag : null
             * reference_upper_limit : 85.0
             * update_time : 2018-04-27 17:32:00
             * test_item_code : 0802
             * result_status : 2
             * increment_id : 15580
             * test_result_value : 64.8
             * test_item_name : 总蛋白(TP)
             * collect_time : 2018-04-27 12:19:00
             * report_no : A12007083198
             * org_code : 1001
             * collect_serial_no : A12007083198
             * report_date : 2018-04-27 12:19:00
             */

            private String create_time;
            private String critical_value_flag;
            private String test_result_unit;
            private String reference_lower_limit;
            private String test_result_describe;
            private String read_flag;
            private String reference_upper_limit;
            private String update_time;
            private String test_item_code;
            private int result_status;
            private int increment_id;
            private String test_result_value;
            private String test_item_name;
            private String collect_time;
            private String report_no;
            private String org_code;
            private String collect_serial_no;
            private String report_date;
            private String visit_type;


            public String getVisit_type() {
                return visit_type;
            }

            public void setVisit_type(String visit_type) {
                this.visit_type = visit_type;
            }
            // 1门诊 2住院 3体检
            public String getVisitTypeStr(){
                return "1".equals(visit_type) ? "门诊" : "2".equals(visit_type) ? "住院" : "体检";
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getCritical_value_flag() {
                return critical_value_flag;
            }

            public void setCritical_value_flag(String critical_value_flag) {
                this.critical_value_flag = critical_value_flag;
            }

            public String getTest_result_unit() {
                return test_result_unit;
            }

            public void setTest_result_unit(String test_result_unit) {
                this.test_result_unit = test_result_unit;
            }

            public String getReference_lower_limit() {
                return reference_lower_limit;
            }

            public void setReference_lower_limit(String reference_lower_limit) {
                this.reference_lower_limit = reference_lower_limit;
            }

            public String getTest_result_describe() {
                return test_result_describe;
            }

            public void setTest_result_describe(String test_result_describe) {
                this.test_result_describe = test_result_describe;
            }

            public String getRead_flag() {
                return read_flag;
            }

            public void setRead_flag(String read_flag) {
                this.read_flag = read_flag;
            }

            public String getReference_upper_limit() {
                return reference_upper_limit;
            }

            public void setReference_upper_limit(String reference_upper_limit) {
                this.reference_upper_limit = reference_upper_limit;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }

            public String getTest_item_code() {
                return test_item_code;
            }

            public void setTest_item_code(String test_item_code) {
                this.test_item_code = test_item_code;
            }

            public int getResult_status() {
                return result_status;
            }

            public void setResult_status(int result_status) {
                this.result_status = result_status;
            }

            public int getIncrement_id() {
                return increment_id;
            }

            public void setIncrement_id(int increment_id) {
                this.increment_id = increment_id;
            }

            public String getTest_result_value() {
                return test_result_value;
            }

            public void setTest_result_value(String test_result_value) {
                this.test_result_value = test_result_value;
            }

            public String getTest_item_name() {
                return test_item_name;
            }

            public void setTest_item_name(String test_item_name) {
                this.test_item_name = test_item_name;
            }

            public String getCollect_time() {
                return collect_time;
            }

            public void setCollect_time(String collect_time) {
                this.collect_time = collect_time;
            }

            public String getReport_no() {
                return report_no;
            }

            public void setReport_no(String report_no) {
                this.report_no = report_no;
            }

            public String getOrg_code() {
                return org_code;
            }

            public void setOrg_code(String org_code) {
                this.org_code = org_code;
            }

            public String getCollect_serial_no() {
                return collect_serial_no;
            }

            public void setCollect_serial_no(String collect_serial_no) {
                this.collect_serial_no = collect_serial_no;
            }

            public String getReport_date() {
                return report_date;
            }

            public void setReport_date(String report_date) {
                this.report_date = report_date;
            }
        }
    }
}
