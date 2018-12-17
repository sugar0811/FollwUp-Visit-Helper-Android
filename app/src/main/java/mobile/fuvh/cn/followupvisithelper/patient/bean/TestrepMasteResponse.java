package mobile.fuvh.cn.followupvisithelper.patient.bean;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.List;

import cn.wowjoy.commonlibrary.bean.BaseResponse;
import cn.wowjoy.commonlibrary.utils.DateUtils;


public class TestrepMasteResponse extends BaseResponse<TestrepMasteResponse.ResultsBean> implements Serializable {

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
             * execute_date : 2018-03-30 11:45:00
             * medi_record_no : 60171081
             * request_dept_code : 1
             * visit_type : 5
             * remark : null
             * check_doc_name : 王医生
             * requestion_no : 1
             * test_type_name : 血常规（五分类）
             * request_doc_name : 李医生
             * update_time : 2018-04-27 11:33:00
             * execute_doc_name : 刘医生
             * increment_id : 1
             * check_date : 2018-03-30 11:45:00
             * report_no : 231201
             * barcode : 5
             * report_date : 2018-03-30 11:45:00
             * request_dept_name : 内科
             * execute_dept_code : 1
             * create_time : 2018-03-30 11:43:00
             * sample_type_desc : 全血
             * test_type_code : 1
             * request_doc_code : 1
             * check_doc_code : 1
             * receive_date : 2018-03-30 11:45:00
             * request_date : 2018-03-30 11:45:00
             * execute_dept_name : 检验科
             * pati_index_no :
             * mic_inspection_sign : 0
             * sample_type_code : 5
             * execute_doc_code : 2
             * collect_time : null
             * org_code : 1001
             * visit_serial_no : 683519
             * collect_serial_no : 0
             */

            private String execute_date;
            private String medi_record_no;
            private String request_dept_code;
            private int visit_type;
            private Object remark;
            private String check_doc_name;
            private String requestion_no;
            private String test_type_name;
            private String request_doc_name;
            private String update_time;
            private String execute_doc_name;
            private int increment_id;
            private String check_date;
            private String report_no;
            private String barcode;
            private String report_date;
            private String request_dept_name;
            private String deliver_time;
            private String execute_dept_code;
            private String create_time;
            private String sample_type_desc;
            private String test_type_code;
            private String docadvise_no;
            private String request_doc_code;
            private String check_doc_code;
            private String receive_date;
            private String request_date;
            private String execute_dept_name;
            private String pati_index_no;
            private int mic_inspection_sign;
            private String sample_type_code;
            private String execute_doc_code;
            private String collect_time;
            private String org_code;
            private String visit_serial_no;
            private String collect_serial_no;

            public String getExecute_date() {
                return execute_date;
            }

            public void setExecute_date(String execute_date) {
                this.execute_date = execute_date;
            }

            public String getMedi_record_no() {
                return medi_record_no;
            }

            public void setMedi_record_no(String medi_record_no) {
                this.medi_record_no = medi_record_no;
            }

            public String getRequest_dept_code() {
                return request_dept_code;
            }

            public void setRequest_dept_code(String request_dept_code) {
                this.request_dept_code = request_dept_code;
            }

            public int getVisit_type() {
                return visit_type;
            }

            public void setVisit_type(int visit_type) {
                this.visit_type = visit_type;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public String getCheck_doc_name() {
                return check_doc_name;
            }

            public void setCheck_doc_name(String check_doc_name) {
                this.check_doc_name = check_doc_name;
            }

            public String getRequestion_no() {
                return requestion_no;
            }

            public void setRequestion_no(String requestion_no) {
                this.requestion_no = requestion_no;
            }

            public String getTest_type_name() {
                return test_type_name;
            }

            public void setTest_type_name(String test_type_name) {
                this.test_type_name = test_type_name;
            }

            public String getRequest_doc_name() {
                return request_doc_name;
            }

            public void setRequest_doc_name(String request_doc_name) {
                this.request_doc_name = request_doc_name;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }

            public String getExecute_doc_name() {
                return execute_doc_name;
            }

            public void setExecute_doc_name(String execute_doc_name) {
                this.execute_doc_name = execute_doc_name;
            }

            public int getIncrement_id() {
                return increment_id;
            }

            public void setIncrement_id(int increment_id) {
                this.increment_id = increment_id;
            }

            public String getCheck_date() {
                return check_date;
            }

            public void setCheck_date(String check_date) {
                this.check_date = check_date;
            }

            public String getReport_no() {
                return report_no;
            }

            public void setReport_no(String report_no) {
                this.report_no = report_no;
            }

            public String getBarcode() {
                return barcode;
            }

            public void setBarcode(String barcode) {
                this.barcode = barcode;
            }

            public String getReport_date() {
                return report_date;
            }

            public void setReport_date(String report_date) {
                this.report_date = report_date;
            }

            public String getRequest_dept_name() {
                return request_dept_name;
            }

            public void setRequest_dept_name(String request_dept_name) {
                this.request_dept_name = request_dept_name;
            }

            public String getExecute_dept_code() {
                return execute_dept_code;
            }

            public void setExecute_dept_code(String execute_dept_code) {
                this.execute_dept_code = execute_dept_code;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getSample_type_desc() {
                return sample_type_desc;
            }

            public void setSample_type_desc(String sample_type_desc) {
                this.sample_type_desc = sample_type_desc;
            }

            public String getTest_type_code() {
                return test_type_code;
            }

            public void setTest_type_code(String test_type_code) {
                this.test_type_code = test_type_code;
            }

            public String getRequest_doc_code() {
                return request_doc_code;
            }

            public void setRequest_doc_code(String request_doc_code) {
                this.request_doc_code = request_doc_code;
            }

            public String getCheck_doc_code() {
                return check_doc_code;
            }

            public void setCheck_doc_code(String check_doc_code) {
                this.check_doc_code = check_doc_code;
            }

            public String getReceive_date() {
                return receive_date;
            }

            public void setReceive_date(String receive_date) {
                this.receive_date = receive_date;
            }

            public String getRequest_date() {
                return request_date;
            }

            public void setRequest_date(String request_date) {
                this.request_date = request_date;
            }

            public String getExecute_dept_name() {
                return execute_dept_name;
            }

            public void setExecute_dept_name(String execute_dept_name) {
                this.execute_dept_name = execute_dept_name;
            }

            public String getPati_index_no() {
                return pati_index_no;
            }

            public void setPati_index_no(String pati_index_no) {
                this.pati_index_no = pati_index_no;
            }

            public int getMic_inspection_sign() {
                return mic_inspection_sign;
            }

            public void setMic_inspection_sign(int mic_inspection_sign) {
                this.mic_inspection_sign = mic_inspection_sign;
            }

            public String getSample_type_code() {
                return sample_type_code;
            }

            public void setSample_type_code(String sample_type_code) {
                this.sample_type_code = sample_type_code;
            }

            public String getExecute_doc_code() {
                return execute_doc_code;
            }

            public void setExecute_doc_code(String execute_doc_code) {
                this.execute_doc_code = execute_doc_code;
            }

            public String getCollect_time() {
                return collect_time;
            }

            public void setCollect_time(String collect_time) {
                this.collect_time = collect_time;
            }

            public String getOrg_code() {
                return org_code;
            }

            public void setOrg_code(String org_code) {
                this.org_code = org_code;
            }

            public String getVisit_serial_no() {
                return visit_serial_no;
            }

            public void setVisit_serial_no(String visit_serial_no) {
                this.visit_serial_no = visit_serial_no;
            }

            public String getCollect_serial_no() {
                return collect_serial_no;
            }

            public void setCollect_serial_no(String collect_serial_no) {
                this.collect_serial_no = collect_serial_no;
            }

            public String getDeliver_time() {
                return deliver_time;
            }

            public void setDeliver_time(String deliver_time) {
                this.deliver_time = deliver_time;
            }

            public String getDocadvise_no() {
                return docadvise_no;
            }

            public void setDocadvise_no(String docadvise_no) {
                this.docadvise_no = docadvise_no;
            }

            public String getFormatDate() {
                if (TextUtils.isEmpty(check_date))
                    return "";
                else
                    return DateUtils.getFormateTime(check_date, "yyyy-MM-dd HH:mm");
            }
        }
    }
}
