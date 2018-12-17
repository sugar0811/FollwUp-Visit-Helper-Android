package mobile.fuvh.cn.followupvisithelper.patient.bean;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.List;

import cn.wowjoy.commonlibrary.bean.BaseResponse;
import cn.wowjoy.commonlibrary.utils.DateUtils;

public class SurgeryreCodeListResponse extends BaseResponse<SurgeryreCodeListResponse.ResultsBean> implements Serializable {

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
             * anaesthesia_code : 13
             * operation_cut_heal_name : null
             * frozen_section_flag : null
             * first_assistant_user_name : null
             * medi_record_no : 60060453
             * pati_nature_code : QGYD16
             * request_dept_code : 411
             * operation_start_date : null
             * medical_card_num : 60060453
             * preoperative_infect_flag : null
             * anaesthesia_doc_eeid : null
             * operation_dept_code : 214
             * request_doc_name : 葛启斌
             * operation_type_name : null
             * increment_id : 77
             * pati_category_name : 全国异地
             * operation_cut_type_name : 清洁-污染切口
             * third_assistant_user_name : null
             * operation_plan_time : null
             * create_time : 2018-06-06 22:59:00
             * operation_cut_heal_code : null
             * operation_room : null
             * operation_dept_name : 泌尿外科
             * request_doc_code : 00336
             * document_status_flag : 0
             * operation_doc_code : 80101
             * pati_index_no : null
             * anaesthesia_name : null
             * collect_time : 2018-06-06 15:08:00
             * org_code : 1001
             * ward_id : 1009
             * collect_serial_no : 29734
             * third_assistant_user_id : null
             * operation_table : null
             * operation_transfer_time : null
             * request_no : 29734
             * visit_type : 0
             * remark : null
             * operation_code : 4733
             * sortno : null
             * first_assistant_user_id : null
             * update_time : 2018-06-08 10:31:00
             * ward_name : 十二病区
             * operation_doc_name : 王逸民
             * anaesthesia_doc_name : null
             * first_time_flag : 0
             * anaesthesia_consult_flag : 0
             * preoperative_diagnosis : null
             * cancel_flag : 0
             * request_dept_name : 泌尿外科病房
             * operation_end_date : null
             * pati_dialog_content : 软镜碎石
             * operation_name : 输尿管镜下碎石取石术，右侧(ICD10-PCS码: 0TC68ZZ)
             * second_assistant_user_id : null
             * pati_category_code : 64
             * request_date : 2018-06-10 08:00:00
             * pati_nature_name : 企业在职
             * operation_type_code : 1
             * second_assistant_user_name : null
             * visit_serial_no : 10384402
             * operation_cut_type_code : 2
             */

            private String anaesthesia_code;
            private String operation_cut_heal_name;
            private String frozen_section_flag;
            private String first_assistant_user_name;
            private String medi_record_no;
            private String pati_nature_code;
            private String request_dept_code;
            private String operation_start_date;
            private String medical_card_num;
            private String preoperative_infect_flag;
            private String anaesthesia_doc_eeid;
            private String operation_dept_code;
            private String request_doc_name;
            private String operation_type_name;
            private String increment_id;
            private String pati_category_name;
            private String operation_cut_type_name;
            private String third_assistant_user_name;
            private String operation_plan_time;
            private String create_time;
            private String operation_cut_heal_code;
            private String operation_room;
            private String operation_dept_name;
            private String request_doc_code;
            private String document_status_flag;
            private String operation_doc_code;
            private String pati_index_no;
            private String anaesthesia_name;
            private String collect_time;
            private String org_code;
            private String ward_id;
            private String collect_serial_no;
            private String third_assistant_user_id;
            private String operation_table;
            private String operation_transfer_time;
            private String request_no;
            private String visit_type;
            private String remark;
            private String operation_code;
            private String sortno;
            private String first_assistant_user_id;
            private String update_time;
            private String ward_name;
            private String operation_doc_name;
            private String anaesthesia_doc_name;
            private String first_time_flag;
            private String anaesthesia_consult_flag;
            private String preoperative_diagnosis;
            private String cancel_flag;
            private String request_dept_name;
            private String operation_end_date;
            private String pati_dialog_content;
            private String operation_name;
            private String second_assistant_user_id;
            private String pati_category_code;
            private String request_date;
            private String pati_nature_name;
            private String operation_type_code;
            private String second_assistant_user_name;
            private String visit_serial_no;
            private String operation_cut_type_code;
            private String postoperative_diagnosis;
            private String operation_course;
            private String creatername;
            private String add_time;

            public String getAnaesthesia_code() {
                return anaesthesia_code;
            }

            public void setAnaesthesia_code(String anaesthesia_code) {
                this.anaesthesia_code = anaesthesia_code;
            }

            public String getOperation_cut_heal_name() {
                return operation_cut_heal_name;
            }

            public void setOperation_cut_heal_name(String operation_cut_heal_name) {
                this.operation_cut_heal_name = operation_cut_heal_name;
            }

            public String getFrozen_section_flag() {
                return frozen_section_flag;
            }

            public void setFrozen_section_flag(String frozen_section_flag) {
                this.frozen_section_flag = frozen_section_flag;
            }

            public String getFirst_assistant_user_name() {
                return first_assistant_user_name;
            }

            public void setFirst_assistant_user_name(String first_assistant_user_name) {
                this.first_assistant_user_name = first_assistant_user_name;
            }

            public String getMedi_record_no() {
                return medi_record_no;
            }

            public void setMedi_record_no(String medi_record_no) {
                this.medi_record_no = medi_record_no;
            }

            public String getPati_nature_code() {
                return pati_nature_code;
            }

            public void setPati_nature_code(String pati_nature_code) {
                this.pati_nature_code = pati_nature_code;
            }

            public String getRequest_dept_code() {
                return request_dept_code;
            }

            public void setRequest_dept_code(String request_dept_code) {
                this.request_dept_code = request_dept_code;
            }

            public String getOperation_start_date() {
                return operation_start_date;
            }

            public void setOperation_start_date(String operation_start_date) {
                this.operation_start_date = operation_start_date;
            }

            public String getMedical_card_num() {
                return medical_card_num;
            }

            public void setMedical_card_num(String medical_card_num) {
                this.medical_card_num = medical_card_num;
            }

            public String getPreoperative_infect_flag() {
                return preoperative_infect_flag;
            }

            public void setPreoperative_infect_flag(String preoperative_infect_flag) {
                this.preoperative_infect_flag = preoperative_infect_flag;
            }

            public String getAnaesthesia_doc_eeid() {
                return anaesthesia_doc_eeid;
            }

            public void setAnaesthesia_doc_eeid(String anaesthesia_doc_eeid) {
                this.anaesthesia_doc_eeid = anaesthesia_doc_eeid;
            }

            public String getOperation_dept_code() {
                return operation_dept_code;
            }

            public void setOperation_dept_code(String operation_dept_code) {
                this.operation_dept_code = operation_dept_code;
            }

            public String getRequest_doc_name() {
                return request_doc_name;
            }

            public void setRequest_doc_name(String request_doc_name) {
                this.request_doc_name = request_doc_name;
            }

            public String getOperation_type_name() {
                return operation_type_name;
            }

            public void setOperation_type_name(String operation_type_name) {
                this.operation_type_name = operation_type_name;
            }

            public String getIncrement_id() {
                return increment_id;
            }

            public void setIncrement_id(String increment_id) {
                this.increment_id = increment_id;
            }

            public String getPati_category_name() {
                return pati_category_name;
            }

            public void setPati_category_name(String pati_category_name) {
                this.pati_category_name = pati_category_name;
            }

            public String getOperation_cut_type_name() {
                return operation_cut_type_name;
            }

            public void setOperation_cut_type_name(String operation_cut_type_name) {
                this.operation_cut_type_name = operation_cut_type_name;
            }

            public String getThird_assistant_user_name() {
                return third_assistant_user_name;
            }

            public void setThird_assistant_user_name(String third_assistant_user_name) {
                this.third_assistant_user_name = third_assistant_user_name;
            }

            public String getOperation_plan_time() {
                return operation_plan_time;
            }

            public void setOperation_plan_time(String operation_plan_time) {
                this.operation_plan_time = operation_plan_time;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getOperation_cut_heal_code() {
                return operation_cut_heal_code;
            }

            public void setOperation_cut_heal_code(String operation_cut_heal_code) {
                this.operation_cut_heal_code = operation_cut_heal_code;
            }

            public String getOperation_room() {
                return operation_room;
            }

            public void setOperation_room(String operation_room) {
                this.operation_room = operation_room;
            }

            public String getOperation_dept_name() {
                return operation_dept_name;
            }

            public void setOperation_dept_name(String operation_dept_name) {
                this.operation_dept_name = operation_dept_name;
            }

            public String getRequest_doc_code() {
                return request_doc_code;
            }

            public void setRequest_doc_code(String request_doc_code) {
                this.request_doc_code = request_doc_code;
            }

            public String getDocument_status_flag() {
                return document_status_flag;
            }

            public void setDocument_status_flag(String document_status_flag) {
                this.document_status_flag = document_status_flag;
            }

            public String getOperation_doc_code() {
                return operation_doc_code;
            }

            public void setOperation_doc_code(String operation_doc_code) {
                this.operation_doc_code = operation_doc_code;
            }

            public String getPati_index_no() {
                return pati_index_no;
            }

            public void setPati_index_no(String pati_index_no) {
                this.pati_index_no = pati_index_no;
            }

            public String getAnaesthesia_name() {
                return anaesthesia_name;
            }

            public void setAnaesthesia_name(String anaesthesia_name) {
                this.anaesthesia_name = anaesthesia_name;
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

            public String getWard_id() {
                return ward_id;
            }

            public void setWard_id(String ward_id) {
                this.ward_id = ward_id;
            }

            public String getCollect_serial_no() {
                return collect_serial_no;
            }

            public void setCollect_serial_no(String collect_serial_no) {
                this.collect_serial_no = collect_serial_no;
            }

            public String getThird_assistant_user_id() {
                return third_assistant_user_id;
            }

            public void setThird_assistant_user_id(String third_assistant_user_id) {
                this.third_assistant_user_id = third_assistant_user_id;
            }

            public String getOperation_table() {
                return operation_table;
            }

            public void setOperation_table(String operation_table) {
                this.operation_table = operation_table;
            }

            public String getOperation_transfer_time() {
                return operation_transfer_time;
            }

            public void setOperation_transfer_time(String operation_transfer_time) {
                this.operation_transfer_time = operation_transfer_time;
            }

            public String getRequest_no() {
                return request_no;
            }

            public void setRequest_no(String request_no) {
                this.request_no = request_no;
            }

            public String getVisit_type() {
                return visit_type;
            }

            public void setVisit_type(String visit_type) {
                this.visit_type = visit_type;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getOperation_code() {
                return operation_code;
            }

            public void setOperation_code(String operation_code) {
                this.operation_code = operation_code;
            }

            public String getSortno() {
                return sortno;
            }

            public void setSortno(String sortno) {
                this.sortno = sortno;
            }

            public String getFirst_assistant_user_id() {
                return first_assistant_user_id;
            }

            public void setFirst_assistant_user_id(String first_assistant_user_id) {
                this.first_assistant_user_id = first_assistant_user_id;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }

            public String getWard_name() {
                return ward_name;
            }

            public void setWard_name(String ward_name) {
                this.ward_name = ward_name;
            }

            public String getOperation_doc_name() {
                return operation_doc_name;
            }

            public void setOperation_doc_name(String operation_doc_name) {
                this.operation_doc_name = operation_doc_name;
            }

            public String getAnaesthesia_doc_name() {
                return anaesthesia_doc_name;
            }

            public void setAnaesthesia_doc_name(String anaesthesia_doc_name) {
                this.anaesthesia_doc_name = anaesthesia_doc_name;
            }

            public String getFirst_time_flag() {
                return first_time_flag;
            }

            public void setFirst_time_flag(String first_time_flag) {
                this.first_time_flag = first_time_flag;
            }

            public String getAnaesthesia_consult_flag() {
                return anaesthesia_consult_flag;
            }

            public void setAnaesthesia_consult_flag(String anaesthesia_consult_flag) {
                this.anaesthesia_consult_flag = anaesthesia_consult_flag;
            }

            public String getPreoperative_diagnosis() {
                return preoperative_diagnosis;
            }

            public void setPreoperative_diagnosis(String preoperative_diagnosis) {
                this.preoperative_diagnosis = preoperative_diagnosis;
            }

            public String getCancel_flag() {
                return cancel_flag;
            }

            public void setCancel_flag(String cancel_flag) {
                this.cancel_flag = cancel_flag;
            }

            public String getRequest_dept_name() {
                return request_dept_name;
            }

            public void setRequest_dept_name(String request_dept_name) {
                this.request_dept_name = request_dept_name;
            }

            public String getOperation_end_date() {
                return operation_end_date;
            }

            public void setOperation_end_date(String operation_end_date) {
                this.operation_end_date = operation_end_date;
            }

            public String getPati_dialog_content() {
                return pati_dialog_content;
            }

            public void setPati_dialog_content(String pati_dialog_content) {
                this.pati_dialog_content = pati_dialog_content;
            }

            public String getOperation_name() {
                return operation_name;
            }

            public void setOperation_name(String operation_name) {
                this.operation_name = operation_name;
            }

            public String getSecond_assistant_user_id() {
                return second_assistant_user_id;
            }

            public void setSecond_assistant_user_id(String second_assistant_user_id) {
                this.second_assistant_user_id = second_assistant_user_id;
            }

            public String getPati_category_code() {
                return pati_category_code;
            }

            public void setPati_category_code(String pati_category_code) {
                this.pati_category_code = pati_category_code;
            }

            public String getRequest_date() {
                return request_date;
            }

            public void setRequest_date(String request_date) {
                this.request_date = request_date;
            }

            public String getPati_nature_name() {
                return pati_nature_name;
            }

            public void setPati_nature_name(String pati_nature_name) {
                this.pati_nature_name = pati_nature_name;
            }

            public String getOperation_type_code() {
                return operation_type_code;
            }

            public void setOperation_type_code(String operation_type_code) {
                this.operation_type_code = operation_type_code;
            }

            public String getSecond_assistant_user_name() {
                return second_assistant_user_name;
            }

            public void setSecond_assistant_user_name(String second_assistant_user_name) {
                this.second_assistant_user_name = second_assistant_user_name;
            }

            public String getVisit_serial_no() {
                return visit_serial_no;
            }

            public void setVisit_serial_no(String visit_serial_no) {
                this.visit_serial_no = visit_serial_no;
            }

            public String getOperation_cut_type_code() {
                return operation_cut_type_code;
            }

            public void setOperation_cut_type_code(String operation_cut_type_code) {
                this.operation_cut_type_code = operation_cut_type_code;
            }

            public String getPostoperative_diagnosis() {
                return postoperative_diagnosis;
            }

            public void setPostoperative_diagnosis(String postoperative_diagnosis) {
                this.postoperative_diagnosis = postoperative_diagnosis;
            }

            public String getOperation_course() {
                return operation_course;
            }

            public void setOperation_course(String operation_course) {
                this.operation_course = operation_course;
            }

            public String getCreatername() {
                return creatername;
            }

            public void setCreatername(String creatername) {
                this.creatername = creatername;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public String getOperationTimeFormat() {
                if (TextUtils.isEmpty(operation_plan_time))
                    return "";
                else
                    return DateUtils.getFormateTime(operation_plan_time, "yyyy-MM-dd");
            }
        }
    }
}
