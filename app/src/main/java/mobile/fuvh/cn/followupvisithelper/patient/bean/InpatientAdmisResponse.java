package mobile.fuvh.cn.followupvisithelper.patient.bean;

import android.text.TextUtils;

import java.io.Serializable;

import cn.wowjoy.commonlibrary.bean.BaseResponse;

public class InpatientAdmisResponse extends BaseResponse<InpatientAdmisResponse.ResultsBean> implements Serializable {

    public static class ResultsBean implements Serializable{
        /**
         * mode : {"brief_illness":null,"medi_record_no":"60107687","admis_dept_name":"肾脏病科病房","medical_card_no":"60107687","outcome_code":null,"nation_code":"01","infectious_diseases_history":null,"curr_ward_code":"1014","inpat_physician_name":null,"contacts_tel":null,"increment_id":1664,"live_addr_detail":null,"pati_source_name":"门诊","pati_dietetic_advice":null,"live_addr_code":null,"curr_bed_num":"1736","blood_transfusion_history":null,"out_diagnosis_code":null,"handling_opinions":null,"pati_tel":null,"create_time":"2018-04-09 11:41:00","pat_tel":"13735286950","out_diagnosis_name":null,"pati_name":"洪利萍","curr_ward_name":"十七病区","admis_ward_code":"1014","pati_index_no":"ba2a4389a2c147d482ae5fc9655dbfe1","collect_time":"2018-04-10 17:13:00","org_code":"1001","admis_date":"2018-04-04 16:09:00","collect_serial_no":"10380643","admitting_diagnosis_code":"26383","chief_physician_name":null,"pati_sex_name":"女","disease_history":null,"att_physician_code":"00669","allergy_history":null,"out_date":null,"contacts_name":null,"recept_physician_code":null,"pati_complaint":null,"profession_name":null,"profession_code":null,"out_situation":null,"physical_examination":null,"att_physician_name":"邹庆玲","update_time":"2018-04-12 16:30:00","disease_reportcard_flag":null,"curr_dept_code":"363","admitting_diagnosis_name":"慢性肾脏病5期","pati_source_sn":"1","present_medical_history":null,"curr_ward_num":null,"recept_physician_name":null,"admis_condition":null,"outcome_name":null,"pati_id_card_num":"330621197606220167","admis_ward_name":"十七病区","inpatient_serial_no":10380643,"chief_physician_code":null,"out_type_name":null,"pati_sex_code":2,"admis_dept_code":"363","inpat_physician_code":null,"out_type_code":null,"nation_name":"汉族","contacts_relation":null,"operation_history":null,"pati_birthday":"1976-06-22 00:00:00","live_addr_name":null,"inpatient_times":1,"cycle_desc":null,"curr_dept_name":"肾脏病科病房"}
         */

        private ModeBean mode;

        public ModeBean getMode() {
            return mode;
        }

        public void setMode(ModeBean mode) {
            this.mode = mode;
        }

        public static class ModeBean implements Serializable{
            /**
             * brief_illness : null
             * medi_record_no : 60107687
             * admis_dept_name : 肾脏病科病房
             * medical_card_no : 60107687
             * outcome_code : null
             * nation_code : 01
             * infectious_diseases_history : null
             * curr_ward_code : 1014
             * inpat_physician_name : null
             * contacts_tel : null
             * increment_id : 1664
             * live_addr_detail : null
             * pati_source_name : 门诊
             * pati_dietetic_advice : null
             * live_addr_code : null
             * curr_bed_num : 1736
             * blood_transfusion_history : null
             * out_diagnosis_code : null
             * handling_opinions : null
             * pati_tel : null
             * create_time : 2018-04-09 11:41:00
             * pat_tel : 13735286950
             * out_diagnosis_name : null
             * pati_name : 洪利萍
             * curr_ward_name : 十七病区
             * admis_ward_code : 1014
             * pati_index_no : ba2a4389a2c147d482ae5fc9655dbfe1
             * collect_time : 2018-04-10 17:13:00
             * org_code : 1001
             * admis_date : 2018-04-04 16:09:00
             * collect_serial_no : 10380643
             * admitting_diagnosis_code : 26383
             * chief_physician_name : null
             * pati_sex_name : 女
             * disease_history : null
             * att_physician_code : 00669
             * allergy_history : null
             * out_date : null
             * contacts_name : null
             * recept_physician_code : null
             * pati_complaint : null
             * profession_name : null
             * profession_code : null
             * out_situation : null
             * physical_examination : null
             * att_physician_name : 邹庆玲
             * update_time : 2018-04-12 16:30:00
             * disease_reportcard_flag : null
             * curr_dept_code : 363
             * admitting_diagnosis_name : 慢性肾脏病5期
             * pati_source_sn : 1
             * present_medical_history : null
             * curr_ward_num : null
             * recept_physician_name : null
             * admis_condition : null
             * outcome_name : null
             * pati_id_card_num : 330621197606220167
             * admis_ward_name : 十七病区
             * inpatient_serial_no : 10380643
             * chief_physician_code : null
             * out_type_name : null
             * pati_sex_code : 2
             * admis_dept_code : 363
             * inpat_physician_code : null
             * out_type_code : null
             * nation_name : 汉族
             * contacts_relation : null
             * operation_history : null
             * pati_birthday : 1976-06-22 00:00:00
             * live_addr_name : null
             * inpatient_times : 1
             * cycle_desc : null
             * curr_dept_name : 肾脏病科病房
             */

            private String brief_illness;
            private String medi_record_no;
            private String admis_dept_name;
            private String medical_card_no;
            private String outcome_code;
            private String nation_code;
            private String infectious_diseases_history;
            private String curr_ward_code;
            private String inpat_physician_name;
            private String contacts_tel;
            private int increment_id;
            private String live_addr_detail;
            private String pati_source_name;
            private String pati_dietetic_advice;
            private String live_addr_code;
            private String curr_bed_num;
            private String blood_transfusion_history;
            private String out_diagnosis_code;
            private String handling_opinions;
            private String pati_tel;
            private String create_time;
            private String pat_tel;
            private String out_diagnosis_name;
            private String pati_name;
            private String curr_ward_name;
            private String admis_ward_code;
            private String pati_index_no;
            private String collect_time;
            private String org_code;
            private String admis_date;
            private String collect_serial_no;
            private String admitting_diagnosis_code;
            private String chief_physician_name;
            private String pati_sex_name;
            private String disease_history;
            private String att_physician_code;
            private String allergy_history;
            private String out_date;
            private String contacts_name;
            private String recept_physician_code;
            private String pati_complaint;
            private String profession_name;
            private String profession_code;
            private String out_situation;
            private String physical_examination;
            private String att_physician_name;
            private String update_time;
            private String disease_reportcard_flag;
            private String curr_dept_code;
            private String admitting_diagnosis_name;
            private String pati_source_sn;
            private String present_medical_history;
            private String curr_ward_num;
            private String recept_physician_name;
            private String admis_condition;
            private String outcome_name;
            private String pati_id_card_num;
            private String admis_ward_name;
            private int inpatient_serial_no;
            private String chief_physician_code;
            private String out_type_name;
            private int pati_sex_code;
            private String admis_dept_code;
            private String inpat_physician_code;
            private String out_type_code;
            private String nation_name;
            private String contacts_relation;
            private String operation_history;
            private String pati_birthday;
            private String live_addr_name;
            private int inpatient_times;
            private String cycle_desc;
            private String curr_dept_name;
            private String past_history;
            private String self_history;

            public String getBrief_illness() {
                return brief_illness;
            }

            public void setBrief_illness(String brief_illness) {
                this.brief_illness = brief_illness;
            }

            public String getMedi_record_no() {
                return medi_record_no;
            }

            public void setMedi_record_no(String medi_record_no) {
                this.medi_record_no = medi_record_no;
            }

            public String getAdmis_dept_name() {
                return admis_dept_name;
            }

            public void setAdmis_dept_name(String admis_dept_name) {
                this.admis_dept_name = admis_dept_name;
            }

            public String getMedical_card_no() {
                return medical_card_no;
            }

            public void setMedical_card_no(String medical_card_no) {
                this.medical_card_no = medical_card_no;
            }

            public String getOutcome_code() {
                return outcome_code;
            }

            public void setOutcome_code(String outcome_code) {
                this.outcome_code = outcome_code;
            }

            public String getNation_code() {
                return nation_code;
            }

            public void setNation_code(String nation_code) {
                this.nation_code = nation_code;
            }

            public String getInfectious_diseases_history() {
                return infectious_diseases_history;
            }

            public void setInfectious_diseases_history(String infectious_diseases_history) {
                this.infectious_diseases_history = infectious_diseases_history;
            }

            public String getCurr_ward_code() {
                return curr_ward_code;
            }

            public void setCurr_ward_code(String curr_ward_code) {
                this.curr_ward_code = curr_ward_code;
            }

            public String getInpat_physician_name() {
                return inpat_physician_name;
            }

            public void setInpat_physician_name(String inpat_physician_name) {
                this.inpat_physician_name = inpat_physician_name;
            }

            public String getContacts_tel() {
                return contacts_tel;
            }

            public void setContacts_tel(String contacts_tel) {
                this.contacts_tel = contacts_tel;
            }

            public int getIncrement_id() {
                return increment_id;
            }

            public void setIncrement_id(int increment_id) {
                this.increment_id = increment_id;
            }

            public String getLive_addr_detail() {
                return live_addr_detail;
            }

            public void setLive_addr_detail(String live_addr_detail) {
                this.live_addr_detail = live_addr_detail;
            }

            public String getPati_source_name() {
                return pati_source_name;
            }

            public void setPati_source_name(String pati_source_name) {
                this.pati_source_name = pati_source_name;
            }

            public String getPati_dietetic_advice() {
                return pati_dietetic_advice;
            }

            public void setPati_dietetic_advice(String pati_dietetic_advice) {
                this.pati_dietetic_advice = pati_dietetic_advice;
            }

            public String getLive_addr_code() {
                return live_addr_code;
            }

            public void setLive_addr_code(String live_addr_code) {
                this.live_addr_code = live_addr_code;
            }

            public String getCurr_bed_num() {
                return TextUtils.isEmpty(curr_bed_num) ? "" : curr_bed_num;
            }

            public void setCurr_bed_num(String curr_bed_num) {
                this.curr_bed_num = curr_bed_num;
            }

            public String getBlood_transfusion_history() {
                return blood_transfusion_history;
            }

            public void setBlood_transfusion_history(String blood_transfusion_history) {
                this.blood_transfusion_history = blood_transfusion_history;
            }

            public String getOut_diagnosis_code() {
                return out_diagnosis_code;
            }

            public void setOut_diagnosis_code(String out_diagnosis_code) {
                this.out_diagnosis_code = out_diagnosis_code;
            }

            public String getHandling_opinions() {
                return handling_opinions;
            }

            public void setHandling_opinions(String handling_opinions) {
                this.handling_opinions = handling_opinions;
            }

            public String getPati_tel() {
                return pati_tel;
            }

            public void setPati_tel(String pati_tel) {
                this.pati_tel = pati_tel;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getPat_tel() {
                return pat_tel;
            }

            public void setPat_tel(String pat_tel) {
                this.pat_tel = pat_tel;
            }

            public String getOut_diagnosis_name() {
                return out_diagnosis_name;
            }

            public void setOut_diagnosis_name(String out_diagnosis_name) {
                this.out_diagnosis_name = out_diagnosis_name;
            }

            public String getPati_name() {
                return pati_name;
            }

            public void setPati_name(String pati_name) {
                this.pati_name = pati_name;
            }

            public String getCurr_ward_name() {
                return curr_ward_name;
            }

            public void setCurr_ward_name(String curr_ward_name) {
                this.curr_ward_name = curr_ward_name;
            }

            public String getAdmis_ward_code() {
                return admis_ward_code;
            }

            public void setAdmis_ward_code(String admis_ward_code) {
                this.admis_ward_code = admis_ward_code;
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

            public String getAdmis_date() {
                return admis_date;
            }

            public void setAdmis_date(String admis_date) {
                this.admis_date = admis_date;
            }

            public String getCollect_serial_no() {
                return collect_serial_no;
            }

            public void setCollect_serial_no(String collect_serial_no) {
                this.collect_serial_no = collect_serial_no;
            }

            public String getAdmitting_diagnosis_code() {
                return admitting_diagnosis_code;
            }

            public void setAdmitting_diagnosis_code(String admitting_diagnosis_code) {
                this.admitting_diagnosis_code = admitting_diagnosis_code;
            }

            public String getChief_physician_name() {
                return chief_physician_name;
            }

            public void setChief_physician_name(String chief_physician_name) {
                this.chief_physician_name = chief_physician_name;
            }

            public String getPati_sex_name() {
                return pati_sex_name;
            }

            public void setPati_sex_name(String pati_sex_name) {
                this.pati_sex_name = pati_sex_name;
            }

            public String getDisease_history() {
                return disease_history;
            }

            public void setDisease_history(String disease_history) {
                this.disease_history = disease_history;
            }

            public String getAtt_physician_code() {
                return att_physician_code;
            }

            public void setAtt_physician_code(String att_physician_code) {
                this.att_physician_code = att_physician_code;
            }

            public String getAllergy_history() {
                return allergy_history;
            }

            public void setAllergy_history(String allergy_history) {
                this.allergy_history = allergy_history;
            }

            public String getOut_date() {
                return out_date;
            }

            public void setOut_date(String out_date) {
                this.out_date = out_date;
            }

            public String getContacts_name() {
                return contacts_name;
            }

            public void setContacts_name(String contacts_name) {
                this.contacts_name = contacts_name;
            }

            public String getRecept_physician_code() {
                return recept_physician_code;
            }

            public void setRecept_physician_code(String recept_physician_code) {
                this.recept_physician_code = recept_physician_code;
            }

            public String getPati_complaint() {
                return pati_complaint;
            }

            public void setPati_complaint(String pati_complaint) {
                this.pati_complaint = pati_complaint;
            }

            public String getProfession_name() {
                return profession_name;
            }

            public void setProfession_name(String profession_name) {
                this.profession_name = profession_name;
            }

            public String getProfession_code() {
                return profession_code;
            }

            public void setProfession_code(String profession_code) {
                this.profession_code = profession_code;
            }

            public String getOut_situation() {
                return out_situation;
            }

            public void setOut_situation(String out_situation) {
                this.out_situation = out_situation;
            }

            public String getPhysical_examination() {
                return physical_examination;
            }

            public void setPhysical_examination(String physical_examination) {
                this.physical_examination = physical_examination;
            }

            public String getAtt_physician_name() {
                return att_physician_name;
            }

            public void setAtt_physician_name(String att_physician_name) {
                this.att_physician_name = att_physician_name;
            }

            public String getUpdate_time() {
                return update_time;
            }

            public void setUpdate_time(String update_time) {
                this.update_time = update_time;
            }

            public String getDisease_reportcard_flag() {
                return disease_reportcard_flag;
            }

            public void setDisease_reportcard_flag(String disease_reportcard_flag) {
                this.disease_reportcard_flag = disease_reportcard_flag;
            }

            public String getCurr_dept_code() {
                return curr_dept_code;
            }

            public void setCurr_dept_code(String curr_dept_code) {
                this.curr_dept_code = curr_dept_code;
            }

            public String getAdmitting_diagnosis_name() {
                return admitting_diagnosis_name;
            }

            public void setAdmitting_diagnosis_name(String admitting_diagnosis_name) {
                this.admitting_diagnosis_name = admitting_diagnosis_name;
            }

            public String getPati_source_sn() {
                return pati_source_sn;
            }

            public void setPati_source_sn(String pati_source_sn) {
                this.pati_source_sn = pati_source_sn;
            }

            public String getPresent_medical_history() {
                return present_medical_history;
            }

            public void setPresent_medical_history(String present_medical_history) {
                this.present_medical_history = present_medical_history;
            }

            public String getCurr_ward_num() {
                return curr_ward_num;
            }

            public void setCurr_ward_num(String curr_ward_num) {
                this.curr_ward_num = curr_ward_num;
            }

            public String getRecept_physician_name() {
                return recept_physician_name;
            }

            public void setRecept_physician_name(String recept_physician_name) {
                this.recept_physician_name = recept_physician_name;
            }

            public String getAdmis_condition() {
                return admis_condition;
            }

            public void setAdmis_condition(String admis_condition) {
                this.admis_condition = admis_condition;
            }

            public String getOutcome_name() {
                return outcome_name;
            }

            public void setOutcome_name(String outcome_name) {
                this.outcome_name = outcome_name;
            }

            public String getPati_id_card_num() {
                return pati_id_card_num;
            }

            public void setPati_id_card_num(String pati_id_card_num) {
                this.pati_id_card_num = pati_id_card_num;
            }

            public String getAdmis_ward_name() {
                return admis_ward_name;
            }

            public void setAdmis_ward_name(String admis_ward_name) {
                this.admis_ward_name = admis_ward_name;
            }

            public int getInpatient_serial_no() {
                return inpatient_serial_no;
            }

            public void setInpatient_serial_no(int inpatient_serial_no) {
                this.inpatient_serial_no = inpatient_serial_no;
            }

            public String getChief_physician_code() {
                return chief_physician_code;
            }

            public void setChief_physician_code(String chief_physician_code) {
                this.chief_physician_code = chief_physician_code;
            }

            public String getOut_type_name() {
                return out_type_name;
            }

            public void setOut_type_name(String out_type_name) {
                this.out_type_name = out_type_name;
            }

            public int getPati_sex_code() {
                return pati_sex_code;
            }

            public void setPati_sex_code(int pati_sex_code) {
                this.pati_sex_code = pati_sex_code;
            }

            public String getAdmis_dept_code() {
                return admis_dept_code;
            }

            public void setAdmis_dept_code(String admis_dept_code) {
                this.admis_dept_code = admis_dept_code;
            }

            public String getInpat_physician_code() {
                return inpat_physician_code;
            }

            public void setInpat_physician_code(String inpat_physician_code) {
                this.inpat_physician_code = inpat_physician_code;
            }

            public String getOut_type_code() {
                return out_type_code;
            }

            public void setOut_type_code(String out_type_code) {
                this.out_type_code = out_type_code;
            }

            public String getNation_name() {
                return nation_name;
            }

            public void setNation_name(String nation_name) {
                this.nation_name = nation_name;
            }

            public String getContacts_relation() {
                return contacts_relation;
            }

            public void setContacts_relation(String contacts_relation) {
                this.contacts_relation = contacts_relation;
            }

            public String getOperation_history() {
                return operation_history;
            }

            public void setOperation_history(String operation_history) {
                this.operation_history = operation_history;
            }

            public String getPati_birthday() {
                return pati_birthday;
            }

            public void setPati_birthday(String pati_birthday) {
                this.pati_birthday = pati_birthday;
            }

            public String getLive_addr_name() {
                return live_addr_name;
            }

            public void setLive_addr_name(String live_addr_name) {
                this.live_addr_name = live_addr_name;
            }

            public int getInpatient_times() {
                return inpatient_times;
            }

            public void setInpatient_times(int inpatient_times) {
                this.inpatient_times = inpatient_times;
            }

            public String getCycle_desc() {
                return cycle_desc;
            }

            public void setCycle_desc(String cycle_desc) {
                this.cycle_desc = cycle_desc;
            }

            public String getCurr_dept_name() {
                return curr_dept_name;
            }

            public void setCurr_dept_name(String curr_dept_name) {
                this.curr_dept_name = curr_dept_name;
            }

            public String getPast_history() {
                return past_history;
            }

            public void setPast_history(String past_history) {
                this.past_history = past_history;
            }

            public String getSelf_history() {
                return self_history;
            }

            public void setSelf_history(String self_history) {
                this.self_history = self_history;
            }
        }
    }
}
