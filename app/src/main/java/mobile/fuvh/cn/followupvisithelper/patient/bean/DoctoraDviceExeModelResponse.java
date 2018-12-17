package mobile.fuvh.cn.followupvisithelper.patient.bean;

import java.io.Serializable;

import cn.wowjoy.commonlibrary.bean.BaseResponse;

public class DoctoraDviceExeModelResponse extends BaseResponse<DoctoraDviceExeModelResponse.ResultsBean> implements Serializable {

    public static class ResultsBean implements Serializable {
        /**
         * mode : {"execute_date":"2018-06-09 18:35:00","medi_record_no":"60034126","request_dept_code":"341","visit_type":2,"remark":null,"check_doc_name":null,"requestion_no":"2800922","test_type_name":"粪便常规+OB+寄生虫、虫卵镜检+虫卵计数","request_doc_name":null,"update_time":"2018-06-14 19:59:00","execute_doc_name":null,"increment_id":408506,"check_date":"2018-06-13 09:36:00","report_no":"A12007192962","barcode":"A12007192962","report_date":"2018-06-13 09:36:00","request_dept_name":"消化内科病房","deliver_time":"2018-06-13 07:58:00","execute_dept_code":null,"create_time":"2018-06-14 19:59:00","sample_type_desc":"粪便","test_type_code":"14503","docadvise_no":"5680141","request_doc_code":null,"check_doc_code":null,"receive_date":"2018-06-13 08:24:00","request_date":"2018-06-10 06:00:00","execute_dept_name":"临检组","pati_index_no":"f6e0cbe60f234d3eb27ec8c11e218e3b","mic_inspection_sign":null,"sample_type_code":null,"execute_doc_code":null,"collect_time":"2018-06-13 09:36:00","org_code":"1001","visit_serial_no":"10385480","collect_serial_no":"A12007192962A12007192962"}
         */

        private ModeBean mode;

        public ModeBean getMode() {
            return mode;
        }

        public void setMode(ModeBean mode) {
            this.mode = mode;
        }

        public static class ModeBean implements Serializable {
            /**
             * execute_date : 2018-06-09 18:35:00
             * medi_record_no : 60034126
             * request_dept_code : 341
             * visit_type : 2
             * remark : null
             * check_doc_name : null
             * requestion_no : 2800922
             * test_type_name : 粪便常规+OB+寄生虫、虫卵镜检+虫卵计数
             * request_doc_name : null
             * update_time : 2018-06-14 19:59:00
             * execute_doc_name : null
             * increment_id : 408506
             * check_date : 2018-06-13 09:36:00
             * report_no : A12007192962
             * barcode : A12007192962
             * report_date : 2018-06-13 09:36:00
             * request_dept_name : 消化内科病房
             * deliver_time : 2018-06-13 07:58:00
             * execute_dept_code : null
             * create_time : 2018-06-14 19:59:00
             * sample_type_desc : 粪便
             * test_type_code : 14503
             * docadvise_no : 5680141
             * request_doc_code : null
             * check_doc_code : null
             * receive_date : 2018-06-13 08:24:00
             * request_date : 2018-06-10 06:00:00
             * execute_dept_name : 临检组
             * pati_index_no : f6e0cbe60f234d3eb27ec8c11e218e3b
             * mic_inspection_sign : null
             * sample_type_code : null
             * execute_doc_code : null
             * collect_time : 2018-06-13 09:36:00
             * org_code : 1001
             * visit_serial_no : 10385480
             * collect_serial_no : A12007192962A12007192962
             */

            private String execute_date;
            private String appoint_range;
            private String medi_record_no;
            private String critical_value_flag;
            private String request_dept_code;
            private String operating_part_name;
            private int visit_type;
            private String remark;
            private String requestion_status;
            private String exam_item_code;
            private String check_doc_name;
            private String requestion_no;
            private String register_time;
            private String exam_result;
            private String device_name;
            private String exam_describe;
            private String exam_type_name;
            private String picture_path;
            private String exam_item_name;
            private String exam_type_code;
            private String finish_time;
            private String read_flag;
            private String appoint_order_num;
            private String operating_part_code;
            private String device_code;
            private String appoint_date;
            private String check_time;
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

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
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

            public String getDeliver_time() {
                return deliver_time;
            }

            public void setDeliver_time(String deliver_time) {
                this.deliver_time = deliver_time;
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

            public String getDocadvise_no() {
                return docadvise_no;
            }

            public void setDocadvise_no(String docadvise_no) {
                this.docadvise_no = docadvise_no;
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

            public String getAppoint_range() {
                return appoint_range;
            }

            public void setAppoint_range(String appoint_range) {
                this.appoint_range = appoint_range;
            }

            public String getCritical_value_flag() {
                return critical_value_flag;
            }

            public void setCritical_value_flag(String critical_value_flag) {
                this.critical_value_flag = critical_value_flag;
            }

            public String getOperating_part_name() {
                return operating_part_name;
            }

            public void setOperating_part_name(String operating_part_name) {
                this.operating_part_name = operating_part_name;
            }

            public String getRequestion_status() {
                return requestion_status;
            }

            public void setRequestion_status(String requestion_status) {
                this.requestion_status = requestion_status;
            }

            public String getExam_item_code() {
                return exam_item_code;
            }

            public void setExam_item_code(String exam_item_code) {
                this.exam_item_code = exam_item_code;
            }

            public String getRegister_time() {
                return register_time;
            }

            public void setRegister_time(String register_time) {
                this.register_time = register_time;
            }

            public String getExam_result() {
                return exam_result;
            }

            public void setExam_result(String exam_result) {
                this.exam_result = exam_result;
            }

            public String getDevice_name() {
                return device_name;
            }

            public void setDevice_name(String device_name) {
                this.device_name = device_name;
            }

            public String getExam_describe() {
                return exam_describe;
            }

            public void setExam_describe(String exam_describe) {
                this.exam_describe = exam_describe;
            }

            public String getExam_type_name() {
                return exam_type_name;
            }

            public void setExam_type_name(String exam_type_name) {
                this.exam_type_name = exam_type_name;
            }

            public String getPicture_path() {
                return picture_path;
            }

            public void setPicture_path(String picture_path) {
                this.picture_path = picture_path;
            }

            public String getExam_item_name() {
                return exam_item_name;
            }

            public void setExam_item_name(String exam_item_name) {
                this.exam_item_name = exam_item_name;
            }

            public String getExam_type_code() {
                return exam_type_code;
            }

            public void setExam_type_code(String exam_type_code) {
                this.exam_type_code = exam_type_code;
            }

            public String getFinish_time() {
                return finish_time;
            }

            public void setFinish_time(String finish_time) {
                this.finish_time = finish_time;
            }

            public String getRead_flag() {
                return read_flag;
            }

            public void setRead_flag(String read_flag) {
                this.read_flag = read_flag;
            }

            public String getAppoint_order_num() {
                return appoint_order_num;
            }

            public void setAppoint_order_num(String appoint_order_num) {
                this.appoint_order_num = appoint_order_num;
            }

            public String getOperating_part_code() {
                return operating_part_code;
            }

            public void setOperating_part_code(String operating_part_code) {
                this.operating_part_code = operating_part_code;
            }

            public String getDevice_code() {
                return device_code;
            }

            public void setDevice_code(String device_code) {
                this.device_code = device_code;
            }

            public String getAppoint_date() {
                return appoint_date;
            }

            public void setAppoint_date(String appoint_date) {
                this.appoint_date = appoint_date;
            }

            public String getCheck_time() {
                return check_time;
            }

            public void setCheck_time(String check_time) {
                this.check_time = check_time;
            }
        }
    }
}
