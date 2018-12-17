package mobile.fuvh.cn.followupvisithelper.patient.bean;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.List;

import cn.wowjoy.commonlibrary.bean.BaseResponse;
import cn.wowjoy.commonlibrary.utils.DateUtils;

public class ExamListResponse extends BaseResponse<ExamListResponse.ResultsBean> implements Serializable {

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
             * execute_date : 2018-06-12 16:16:00
             * medi_record_no : 60009889
             * critical_value_flag : null
             * request_dept_code : 411
             * operating_part_name : 胸部
             * visit_type : 2
             * remark : null
             * exam_item_code : 736
             * requestion_no : 2809810
             * register_time : 2018-06-12 16:06:00
             * exam_result : 两肺纹理清。两肺内未见明显异常密度影。各叶、段支气管未见明显狭窄。两肺门及纵隔未见明显肿大淋巴结影。
             * request_doc_name : 李忠孝
             * device_name : null
             * exam_describe : 胸部CT平扫未见明显异常。
             * update_time : 2018-06-12 23:59:00
             * increment_id : 82255
             * report_no : CTZY1374366
             * exam_type_name : CT
             * report_date : 2018-06-12 21:39:00
             * request_dept_name : 泌尿外科病房
             * picture_path : http://wpacs.shulan.com/hiswebview/60009889/CTZY1374366?studyUidEnc=CTZY1374366HIS60009889&uidEnc=a1eb9974c6d83f9f5c2908e147037332&accessionNumber=CTZY1374366
             * execute_dept_code : null
             * create_time : 2018-06-12 23:59:00
             * request_doc_code : 00318
             * exam_item_name : CT肺部HR平扫
             * finish_time : 2018-06-12 21:39:00
             * read_flag : 0
             * operating_part_code : 48
             * device_code : null
             * request_date : 2018-06-12 00:00:00
             * execute_dept_name : null
             * pati_index_no : null
             * exam_type_code : CT
             * collect_time : 2018-06-12 21:39:00
             * org_code : 1001
             * visit_serial_no : 10385688
             * collect_serial_no : CTZY1374366
             * check_time : 2018-06-12 21:39:00
             */

            private String execute_date;
            private String medi_record_no;
            private String critical_value_flag;
            private String request_dept_code;
            private String operating_part_name;
            private int visit_type;
            private String remark;
            private String exam_item_code;
            private String requestion_no;
            private String register_time;
            private String exam_result;
            private String request_doc_name;
            private String device_name;
            private String exam_describe;
            private String update_time;
            private int increment_id;
            private String report_no;
            private String exam_type_name;
            private String report_date;
            private String request_dept_name;
            private String picture_path;
            private String execute_dept_code;
            private String create_time;
            private String request_doc_code;
            private String exam_item_name;
            private String finish_time;
            private int read_flag;
            private String operating_part_code;
            private String device_code;
            private String request_date;
            private String execute_dept_name;
            private String pati_index_no;
            private String exam_type_code;
            private String collect_time;
            private String org_code;
            private String visit_serial_no;
            private String collect_serial_no;
            private String check_time;

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

            public String getCritical_value_flag() {
                return critical_value_flag;
            }

            public void setCritical_value_flag(String critical_value_flag) {
                this.critical_value_flag = critical_value_flag;
            }

            public String getRequest_dept_code() {
                return request_dept_code;
            }

            public void setRequest_dept_code(String request_dept_code) {
                this.request_dept_code = request_dept_code;
            }

            public String getOperating_part_name() {
                return operating_part_name;
            }

            public void setOperating_part_name(String operating_part_name) {
                this.operating_part_name = operating_part_name;
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

            public String getExam_item_code() {
                return exam_item_code;
            }

            public void setExam_item_code(String exam_item_code) {
                this.exam_item_code = exam_item_code;
            }

            public String getRequestion_no() {
                return requestion_no;
            }

            public void setRequestion_no(String requestion_no) {
                this.requestion_no = requestion_no;
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

            public String getRequest_doc_name() {
                return request_doc_name;
            }

            public void setRequest_doc_name(String request_doc_name) {
                this.request_doc_name = request_doc_name;
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

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }

            public int getIncrement_id() {
                return increment_id;
            }

            public void setIncrement_id(int increment_id) {
                this.increment_id = increment_id;
            }

            public String getReport_no() {
                return report_no;
            }

            public void setReport_no(String report_no) {
                this.report_no = report_no;
            }

            public String getExam_type_name() {
                return exam_type_name;
            }

            public void setExam_type_name(String exam_type_name) {
                this.exam_type_name = exam_type_name;
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

            public String getPicture_path() {
                return picture_path;
            }

            public void setPicture_path(String picture_path) {
                this.picture_path = picture_path;
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

            public String getRequest_doc_code() {
                return request_doc_code;
            }

            public void setRequest_doc_code(String request_doc_code) {
                this.request_doc_code = request_doc_code;
            }

            public String getExam_item_name() {
                return exam_item_name;
            }

            public void setExam_item_name(String exam_item_name) {
                this.exam_item_name = exam_item_name;
            }

            public String getFinish_time() {
                return finish_time;
            }

            public void setFinish_time(String finish_time) {
                this.finish_time = finish_time;
            }

            public int getRead_flag() {
                return read_flag;
            }

            public void setRead_flag(int read_flag) {
                this.read_flag = read_flag;
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

            public String getExam_type_code() {
                return exam_type_code;
            }

            public void setExam_type_code(String exam_type_code) {
                this.exam_type_code = exam_type_code;
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

            public String getCheck_time() {
                return check_time;
            }

            public void setCheck_time(String check_time) {
                this.check_time = check_time;
            }

            public String getFormatDate() {
                if (TextUtils.isEmpty(check_time))
                    return "";
                else
                    return DateUtils.getFormateTime(check_time, "yyyy-MM-dd HH:mm");
            }
        }
    }
}
