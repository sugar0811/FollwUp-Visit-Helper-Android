package mobile.fuvh.cn.followupvisithelper.patient.bean;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.List;

import cn.wowjoy.commonlibrary.bean.BaseResponse;

public class TestDetailResponse extends BaseResponse<TestDetailResponse.ResultsBean> implements Serializable {

    public static class ResultsBean implements Serializable {
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable {
            /**
             * result_serial_no : A120071929600440
             * create_time : 2018-06-11 09:48:00
             * critical_value_flag : 0
             * test_result_unit : nmol/L
             * reference_lower_limit : 0.92
             * test_result_describe : null
             * read_flag : null
             * reference_upper_limit : 2.79
             * update_time : 2018-06-11 09:48:00
             * test_item_code : 0440
             * result_status : 0
             * increment_id : 6234768
             * test_result_value : 1.68
             * test_item_name : 三碘甲状原氨酸(T3)测定
             * collect_time : 2018-06-10 09:47:00
             * report_no : A12007192960
             * org_code : 1001
             * collect_serial_no : A12007192960
             * medi_record_no": "60213543",
             * pati_index_no": "b0fc554940b94484b4677605f95a3284",
             */

            private String result_serial_no;
            private String create_time;
            private int critical_value_flag;
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
            private String medi_record_no;
            private String pati_index_no;


            public String getMedi_record_no() {
                return medi_record_no;
            }

            public void setMedi_record_no(String medi_record_no) {
                this.medi_record_no = medi_record_no;
            }

            public String getPati_index_no() {
                return pati_index_no;
            }

            public void setPati_index_no(String pati_index_no) {
                this.pati_index_no = pati_index_no;
            }

            public String getResult_serial_no() {
                return result_serial_no;
            }

            public void setResult_serial_no(String result_serial_no) {
                this.result_serial_no = result_serial_no;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public int getCritical_value_flag() {
                return critical_value_flag;
            }

            public void setCritical_value_flag(int critical_value_flag) {
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

            public String getRange() {
                return (TextUtils.isEmpty(reference_lower_limit) ? "-" : reference_lower_limit) + "~" + (TextUtils.isEmpty(reference_upper_limit) ? "-" : reference_upper_limit);
            }
        }
    }
}
