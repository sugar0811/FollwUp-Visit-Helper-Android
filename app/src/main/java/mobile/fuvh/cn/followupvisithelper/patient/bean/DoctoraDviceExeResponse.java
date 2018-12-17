package mobile.fuvh.cn.followupvisithelper.patient.bean;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.List;

import cn.wowjoy.commonlibrary.bean.BaseResponse;
import cn.wowjoy.commonlibrary.utils.DateUtils;

public class DoctoraDviceExeResponse extends BaseResponse<DoctoraDviceExeResponse.ResultsBean> implements Serializable {

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
             * nurse_execute_time : 2018-06-06 11:24:00
             * medi_record_no : 60189519
             * request_amount : 1
             * inpat_ward_name : 2-2B病区
             * execute_update_time : 2018-06-06 11:24:00
             * remark : null
             * docadvise_request_no : 0
             * dispensing_code : 10
             * dispensing_name : null
             * update_time : 2018-06-06 15:04:00
             * docadvise_dispensing_no : 0
             * increment_id : 260880
             * execute_user_code : 7239
             * curr_bed_num : 2B60
             * administration_time : 2018-06-06 10:56:00
             * docadvise_generate_time : 2018-06-06 00:00:00
             * execute_dept_code : 505
             * create_time : 2018-06-06 15:04:00
             * execute_user_name : 周群
             * docadvise_no : 5649480
             * inpatient_serial_no : 10385275
             * inpat_ward_num : 1167
             * execute_no : 30201811
             * inpatient_times : 1
             * execute_dept_name : CT室
             * pati_index_no : null
             * collect_time : 2018-06-06 11:24:00
             * org_code : 1001
             * collect_serial_no : 30201811
             */

            private String nurse_execute_time;
            private String medi_record_no;
            private String request_amount;
            private String inpat_ward_name;
            private String execute_update_time;
            private String remark;
            private String docadvise_request_no;
            private String dispensing_code;
            private String dispensing_name;
            private String update_time;
            private String docadvise_dispensing_no;
            private String increment_id;
            private String execute_user_code;
            private String curr_bed_num;
            private String administration_time;
            private String docadvise_generate_time;
            private String execute_dept_code;
            private String create_time;
            private String execute_user_name;
            private String docadvise_no;
            private String inpatient_serial_no;
            private String inpat_ward_num;
            private String execute_no;
            private String inpatient_times;
            private String execute_dept_name;
            private String pati_index_no;
            private String collect_time;
            private String org_code;
            private String collect_serial_no;

            public String getFormatTime() {
                if (TextUtils.isEmpty(nurse_execute_time))
                    return "";
                else
                    return DateUtils.getFormateTime(nurse_execute_time, "yyyy-MM-dd HH:mm");
            }

            public String getNurse_execute_time() {
                return nurse_execute_time;
            }

            public void setNurse_execute_time(String nurse_execute_time) {
                this.nurse_execute_time = nurse_execute_time;
            }

            public String getMedi_record_no() {
                return medi_record_no;
            }

            public void setMedi_record_no(String medi_record_no) {
                this.medi_record_no = medi_record_no;
            }

            public String getRequest_amount() {
                return request_amount;
            }

            public void setRequest_amount(String request_amount) {
                this.request_amount = request_amount;
            }

            public String getInpat_ward_name() {
                return inpat_ward_name;
            }

            public void setInpat_ward_name(String inpat_ward_name) {
                this.inpat_ward_name = inpat_ward_name;
            }

            public String getExecute_update_time() {
                return execute_update_time;
            }

            public void setExecute_update_time(String execute_update_time) {
                this.execute_update_time = execute_update_time;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getDocadvise_request_no() {
                return docadvise_request_no;
            }

            public void setDocadvise_request_no(String docadvise_request_no) {
                this.docadvise_request_no = docadvise_request_no;
            }

            public String getDispensing_code() {
                return dispensing_code;
            }

            public void setDispensing_code(String dispensing_code) {
                this.dispensing_code = dispensing_code;
            }

            public String getDispensing_name() {
                return dispensing_name;
            }

            public void setDispensing_name(String dispensing_name) {
                this.dispensing_name = dispensing_name;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }

            public String getDocadvise_dispensing_no() {
                return docadvise_dispensing_no;
            }

            public void setDocadvise_dispensing_no(String docadvise_dispensing_no) {
                this.docadvise_dispensing_no = docadvise_dispensing_no;
            }

            public String getIncrement_id() {
                return increment_id;
            }

            public void setIncrement_id(String increment_id) {
                this.increment_id = increment_id;
            }

            public String getExecute_user_code() {
                return execute_user_code;
            }

            public void setExecute_user_code(String execute_user_code) {
                this.execute_user_code = execute_user_code;
            }

            public String getCurr_bed_num() {
                return TextUtils.isEmpty(curr_bed_num) ? "" : curr_bed_num;
            }

            public void setCurr_bed_num(String curr_bed_num) {
                this.curr_bed_num = curr_bed_num;
            }

            public String getAdministration_time() {
                return administration_time;
            }

            public void setAdministration_time(String administration_time) {
                this.administration_time = administration_time;
            }

            public String getDocadvise_generate_time() {
                return docadvise_generate_time;
            }

            public void setDocadvise_generate_time(String docadvise_generate_time) {
                this.docadvise_generate_time = docadvise_generate_time;
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

            public String getExecute_user_name() {
                return execute_user_name;
            }

            public void setExecute_user_name(String execute_user_name) {
                this.execute_user_name = execute_user_name;
            }

            public String getDocadvise_no() {
                return docadvise_no;
            }

            public void setDocadvise_no(String docadvise_no) {
                this.docadvise_no = docadvise_no;
            }

            public String getInpatient_serial_no() {
                return inpatient_serial_no;
            }

            public void setInpatient_serial_no(String inpatient_serial_no) {
                this.inpatient_serial_no = inpatient_serial_no;
            }

            public String getInpat_ward_num() {
                return inpat_ward_num;
            }

            public void setInpat_ward_num(String inpat_ward_num) {
                this.inpat_ward_num = inpat_ward_num;
            }

            public String getExecute_no() {
                return execute_no;
            }

            public void setExecute_no(String execute_no) {
                this.execute_no = execute_no;
            }

            public String getInpatient_times() {
                return inpatient_times;
            }

            public void setInpatient_times(String inpatient_times) {
                this.inpatient_times = inpatient_times;
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

            public String getCollect_serial_no() {
                return collect_serial_no;
            }

            public void setCollect_serial_no(String collect_serial_no) {
                this.collect_serial_no = collect_serial_no;
            }
        }
    }
}
