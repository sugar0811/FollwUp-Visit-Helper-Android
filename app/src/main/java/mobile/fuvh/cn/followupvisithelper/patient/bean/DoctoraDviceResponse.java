package mobile.fuvh.cn.followupvisithelper.patient.bean;

import java.io.Serializable;

import cn.wowjoy.commonlibrary.bean.BaseResponse;

public class DoctoraDviceResponse extends BaseResponse<DoctoraDviceResponse.ResultsBean> implements Serializable {

    public static class ResultsBean implements Serializable {
        /**
         * mode : {"docadvise_cate_name":"长期","medi_record_no":"60067412","way_drug_name":null,"drug_spec":"0","drug_dosage_from_code":null,"drug_abbr":null,"increment_id":3381,"packet_amount":null,"open_doct_name":"牟海波","last_execute_date":"2018-06-06 00:00:00","docadvise_recipel_type":true,"open_date":"2018-06-04 15:01:00","drug_name":null,"way_drug_code":null,"create_time":"2018-06-06 14:29:00","drug_dosage_from_name":null,"emergency_flag":0,"drug_unit":null,"docadvise_item_code":"5343","cancel_durg_flag":0,"start_time":"2018-06-04 08:00:00","open_dept_code":"375","docadvise_current_state":5,"pati_index_no":null,"docadvise_group_num":"5630338","collect_time":"2018-06-06 10:55:00","org_code":"1001","collect_serial_no":"5630338","docadvise_item_name":"肿瘤内科护理常规","drug_use_frequency_num":"-02","item_type_name":"诊疗","main_sec_drug_flag":0,"inpat_ward_name":"2-2C病区","decoction_flag":null,"drug_code":null,"remark":null,"drug_use_dose":1,"doc_advise":null,"update_time":"2018-06-06 14:29:00","open_dept_name":"肿瘤内科病房","drug_price":null,"item_type_code":"2","drug_use_frequency_name":"ALWAYS","discharge_order_flag":null,"drug_quantity":0,"docadvise_cate_code":"2","docadvise_no":"5630338","inpatient_serial_no":10384414,"end_time":null,"inpat_ward_num":"1168","drug_use_dose_unit":null,"docadvise_state":3,"inpatient_times":null,"open_doct_eeid":"00625"}
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
             * docadvise_cate_name : 长期
             * medi_record_no : 60067412
             * way_drug_name : null
             * drug_spec : 0
             * drug_dosage_from_code : null
             * drug_abbr : null
             * increment_id : 3381
             * packet_amount : null
             * open_doct_name : 牟海波
             * last_execute_date : 2018-06-06 00:00:00
             * docadvise_recipel_type : true
             * open_date : 2018-06-04 15:01:00
             * drug_name : null
             * way_drug_code : null
             * create_time : 2018-06-06 14:29:00
             * drug_dosage_from_name : null
             * emergency_flag : 0
             * drug_unit : null
             * docadvise_item_code : 5343
             * cancel_durg_flag : 0
             * start_time : 2018-06-04 08:00:00
             * open_dept_code : 375
             * docadvise_current_state : 5
             * pati_index_no : null
             * docadvise_group_num : 5630338
             * collect_time : 2018-06-06 10:55:00
             * org_code : 1001
             * collect_serial_no : 5630338
             * docadvise_item_name : 肿瘤内科护理常规
             * drug_use_frequency_num : -02
             * item_type_name : 诊疗
             * main_sec_drug_flag : 0
             * inpat_ward_name : 2-2C病区
             * decoction_flag : null
             * drug_code : null
             * remark : null
             * drug_use_dose : 1
             * doc_advise : null
             * update_time : 2018-06-06 14:29:00
             * open_dept_name : 肿瘤内科病房
             * drug_price : null
             * item_type_code : 2
             * drug_use_frequency_name : ALWAYS
             * discharge_order_flag : null
             * drug_quantity : 0
             * docadvise_cate_code : 2
             * docadvise_no : 5630338
             * inpatient_serial_no : 10384414
             * end_time : null
             * inpat_ward_num : 1168
             * drug_use_dose_unit : null
             * docadvise_state : 3
             * inpatient_times : null
             * open_doct_eeid : 00625
             */

            private String docadvise_cate_name;
            private String medi_record_no;
            private String way_drug_name;
            private String drug_spec;
            private String drug_dosage_from_code;
            private String drug_abbr;
            private int increment_id;
            private String packet_amount;
            private String open_doct_name;
            private String last_execute_date;
            private boolean docadvise_recipel_type;
            private String open_date;
            private String drug_name;
            private String way_drug_code;
            private String create_time;
            private String drug_dosage_from_name;
            private int emergency_flag;
            private String drug_unit;
            private String docadvise_item_code;
            private int cancel_durg_flag;
            private String start_time;
            private String open_dept_code;
            private String docadvise_current_state;
            private String pati_index_no;
            private String docadvise_group_num;
            private String collect_time;
            private String org_code;
            private String collect_serial_no;
            private String docadvise_item_name;
            private String drug_use_frequency_num;
            private String item_type_name;
            private int main_sec_drug_flag;
            private String inpat_ward_name;
            private String decoction_flag;
            private String drug_code;
            private String remark;
            private String drug_use_dose;
            private String doc_advise;
            private String update_time;
            private String open_dept_name;
            private String drug_price;
            private String item_type_code;
            private String drug_use_frequency_name;
            private String discharge_order_flag;
            private int drug_quantity;
            private String docadvise_cate_code;
            private String docadvise_no;
            private String inpatient_serial_no;
            private String end_time;
            private String inpat_ward_num;
            private String drug_use_dose_unit;
            private String docadvise_state;
            private String inpatient_times;
            private String open_doct_eeid;

            public String getDocadvise_cate_name() {
                return docadvise_cate_name;
            }

            public void setDocadvise_cate_name(String docadvise_cate_name) {
                this.docadvise_cate_name = docadvise_cate_name;
            }

            public String getMedi_record_no() {
                return medi_record_no;
            }

            public void setMedi_record_no(String medi_record_no) {
                this.medi_record_no = medi_record_no;
            }

            public String getWay_drug_name() {
                return way_drug_name;
            }

            public void setWay_drug_name(String way_drug_name) {
                this.way_drug_name = way_drug_name;
            }

            public String getDrug_spec() {
                return drug_spec;
            }

            public void setDrug_spec(String drug_spec) {
                this.drug_spec = drug_spec;
            }

            public String getDrug_dosage_from_code() {
                return drug_dosage_from_code;
            }

            public void setDrug_dosage_from_code(String drug_dosage_from_code) {
                this.drug_dosage_from_code = drug_dosage_from_code;
            }

            public String getDrug_abbr() {
                return drug_abbr;
            }

            public void setDrug_abbr(String drug_abbr) {
                this.drug_abbr = drug_abbr;
            }

            public int getIncrement_id() {
                return increment_id;
            }

            public void setIncrement_id(int increment_id) {
                this.increment_id = increment_id;
            }

            public String getPacket_amount() {
                return packet_amount;
            }

            public void setPacket_amount(String packet_amount) {
                this.packet_amount = packet_amount;
            }

            public String getOpen_doct_name() {
                return open_doct_name;
            }

            public void setOpen_doct_name(String open_doct_name) {
                this.open_doct_name = open_doct_name;
            }

            public String getLast_execute_date() {
                return last_execute_date;
            }

            public void setLast_execute_date(String last_execute_date) {
                this.last_execute_date = last_execute_date;
            }

            public boolean isDocadvise_recipel_type() {
                return docadvise_recipel_type;
            }

            public void setDocadvise_recipel_type(boolean docadvise_recipel_type) {
                this.docadvise_recipel_type = docadvise_recipel_type;
            }

            public String getOpen_date() {
                return open_date;
            }

            public void setOpen_date(String open_date) {
                this.open_date = open_date;
            }

            public String getDrug_name() {
                return drug_name;
            }

            public void setDrug_name(String drug_name) {
                this.drug_name = drug_name;
            }

            public String getWay_drug_code() {
                return way_drug_code;
            }

            public void setWay_drug_code(String way_drug_code) {
                this.way_drug_code = way_drug_code;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getDrug_dosage_from_name() {
                return drug_dosage_from_name;
            }

            public void setDrug_dosage_from_name(String drug_dosage_from_name) {
                this.drug_dosage_from_name = drug_dosage_from_name;
            }

            public int getEmergency_flag() {
                return emergency_flag;
            }

            public void setEmergency_flag(int emergency_flag) {
                this.emergency_flag = emergency_flag;
            }

            public String getDrug_unit() {
                return drug_unit;
            }

            public void setDrug_unit(String drug_unit) {
                this.drug_unit = drug_unit;
            }

            public String getDocadvise_item_code() {
                return docadvise_item_code;
            }

            public void setDocadvise_item_code(String docadvise_item_code) {
                this.docadvise_item_code = docadvise_item_code;
            }

            public int getCancel_durg_flag() {
                return cancel_durg_flag;
            }

            public void setCancel_durg_flag(int cancel_durg_flag) {
                this.cancel_durg_flag = cancel_durg_flag;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getOpen_dept_code() {
                return open_dept_code;
            }

            public void setOpen_dept_code(String open_dept_code) {
                this.open_dept_code = open_dept_code;
            }

            public String getDocadvise_current_state() {
                return docadvise_current_state;
            }

            public void setDocadvise_current_state(String docadvise_current_state) {
                this.docadvise_current_state = docadvise_current_state;
            }

            public String getPati_index_no() {
                return pati_index_no;
            }

            public void setPati_index_no(String pati_index_no) {
                this.pati_index_no = pati_index_no;
            }

            public String getDocadvise_group_num() {
                return docadvise_group_num;
            }

            public void setDocadvise_group_num(String docadvise_group_num) {
                this.docadvise_group_num = docadvise_group_num;
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

            public String getDocadvise_item_name() {
                return docadvise_item_name;
            }

            public void setDocadvise_item_name(String docadvise_item_name) {
                this.docadvise_item_name = docadvise_item_name;
            }

            public String getDrug_use_frequency_num() {
                return drug_use_frequency_num;
            }

            public void setDrug_use_frequency_num(String drug_use_frequency_num) {
                this.drug_use_frequency_num = drug_use_frequency_num;
            }

            public String getItem_type_name() {
                return item_type_name;
            }

            public void setItem_type_name(String item_type_name) {
                this.item_type_name = item_type_name;
            }

            public int getMain_sec_drug_flag() {
                return main_sec_drug_flag;
            }

            public void setMain_sec_drug_flag(int main_sec_drug_flag) {
                this.main_sec_drug_flag = main_sec_drug_flag;
            }

            public String getInpat_ward_name() {
                return inpat_ward_name;
            }

            public void setInpat_ward_name(String inpat_ward_name) {
                this.inpat_ward_name = inpat_ward_name;
            }

            public String getDecoction_flag() {
                return decoction_flag;
            }

            public void setDecoction_flag(String decoction_flag) {
                this.decoction_flag = decoction_flag;
            }

            public String getDrug_code() {
                return drug_code;
            }

            public void setDrug_code(String drug_code) {
                this.drug_code = drug_code;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getDrug_use_dose() {
                return drug_use_dose;
            }

            public void setDrug_use_dose(String drug_use_dose) {
                this.drug_use_dose = drug_use_dose;
            }

            public String getDoc_advise() {
                return doc_advise;
            }

            public void setDoc_advise(String doc_advise) {
                this.doc_advise = doc_advise;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }

            public String getOpen_dept_name() {
                return open_dept_name;
            }

            public void setOpen_dept_name(String open_dept_name) {
                this.open_dept_name = open_dept_name;
            }

            public String getDrug_price() {
                return drug_price;
            }

            public void setDrug_price(String drug_price) {
                this.drug_price = drug_price;
            }

            public String getItem_type_code() {
                return item_type_code;
            }

            public void setItem_type_code(String item_type_code) {
                this.item_type_code = item_type_code;
            }

            public String getDrug_use_frequency_name() {
                return drug_use_frequency_name;
            }

            public void setDrug_use_frequency_name(String drug_use_frequency_name) {
                this.drug_use_frequency_name = drug_use_frequency_name;
            }

            public String getDischarge_order_flag() {
                return discharge_order_flag;
            }

            public void setDischarge_order_flag(String discharge_order_flag) {
                this.discharge_order_flag = discharge_order_flag;
            }

            public int getDrug_quantity() {
                return drug_quantity;
            }

            public void setDrug_quantity(int drug_quantity) {
                this.drug_quantity = drug_quantity;
            }

            public String getDocadvise_cate_code() {
                return docadvise_cate_code;
            }

            public void setDocadvise_cate_code(String docadvise_cate_code) {
                this.docadvise_cate_code = docadvise_cate_code;
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

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public String getInpat_ward_num() {
                return inpat_ward_num;
            }

            public void setInpat_ward_num(String inpat_ward_num) {
                this.inpat_ward_num = inpat_ward_num;
            }

            public String getDrug_use_dose_unit() {
                return drug_use_dose_unit;
            }

            public void setDrug_use_dose_unit(String drug_use_dose_unit) {
                this.drug_use_dose_unit = drug_use_dose_unit;
            }

            public String getDocadvise_state() {
                return docadvise_state;
            }

            public void setDocadvise_state(String docadvise_state) {
                this.docadvise_state = docadvise_state;
            }

            public String getInpatient_times() {
                return inpatient_times;
            }

            public void setInpatient_times(String inpatient_times) {
                this.inpatient_times = inpatient_times;
            }

            public String getOpen_doct_eeid() {
                return open_doct_eeid;
            }

            public void setOpen_doct_eeid(String open_doct_eeid) {
                this.open_doct_eeid = open_doct_eeid;
            }
        }
    }
}
