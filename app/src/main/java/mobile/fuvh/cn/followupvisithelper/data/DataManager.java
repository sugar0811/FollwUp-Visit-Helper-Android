package mobile.fuvh.cn.followupvisithelper.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import mobile.fuvh.cn.followupvisithelper.patient.bean.DoctoraDviceExeResponse;
import mobile.fuvh.cn.followupvisithelper.patient.bean.DoctoraDviceListResponse;
import mobile.fuvh.cn.followupvisithelper.patient.bean.ExamListResponse;
import mobile.fuvh.cn.followupvisithelper.patient.bean.InpatientAdmisResponse;
import mobile.fuvh.cn.followupvisithelper.patient.bean.InpatientListResponse;
import mobile.fuvh.cn.followupvisithelper.patient.bean.SurgeryreCodeListResponse;
import mobile.fuvh.cn.followupvisithelper.patient.bean.TestAnalyResponse;
import mobile.fuvh.cn.followupvisithelper.patient.bean.TestDetailResponse;
import mobile.fuvh.cn.followupvisithelper.patient.bean.TestrepMasteResponse;

/**
 *
 * @author sugar
 * @date 2018/12/4
 *
 */


public class DataManager {

    static String inPatientBasicPageData = " {\n" +
            "                \"brief_illness\": null,\n" +
            "                \"medi_record_no\": \"60160133\",\n" +
            "                \"contact_tel\": null,\n" +
            "                \"admis_dept_name\": \"肾脏病科病房\",\n" +
            "                \"medical_card_no\": \"60160133\",\n" +
            "                \"outcome_code\": null,\n" +
            "                \"infectious_diseases_history\": null,\n" +
            "                \"curr_ward_code\": \"1007\",\n" +
            "                \"inpat_physician_name\": null,\n" +
            "                \"pati_contact_addr\": null,\n" +
            "                \"increment_id\": 88053,\n" +
            "                \"pati_source_name\": \"门诊\",\n" +
            "                \"pati_dietetic_advice\": \"低盐低脂优质蛋白饮食 \",\n" +
            "                \"curr_bed_num\": \"1008\",\n" +
            "                \"blood_transfusion_history\": \"1\",\n" +
            "                \"out_diagnosis_code\": null,\n" +
            "                \"handling_opinions\": null,\n" +
            "                \"family_history\": \"中国\",\n" +
            "                \"contact_relation\": null,\n" +
            "                \"pati_tel\": null,\n" +
            "                \"create_time\": \"2018-11-02 10:19:00\",\n" +
            "                \"isnewpatient\": 0,\n" +
            "                \"pat_tel\": \"18767016009\",\n" +
            "                \"out_diagnosis_name\": null,\n" +
            "                \"pati_name\": \"刘建国\",\n" +
            "                \"curr_ward_name\": \"十病区\",\n" +
            "                \"self_history\": null,\n" +
            "                \"admis_ward_code\": \"1007\",\n" +
            "                \"inhospital_flag\": 2,\n" +
            "                \"pati_index_no\": \"7604fea4ad284624be3350eb7e85f3dc\",\n" +
            "                \"collect_time\": \"2018-11-02 10:16:00\",\n" +
            "                \"org_code\": \"1001\",\n" +
            "                \"admis_date\": \"2018-09-26 15:06:00\",\n" +
            "                \"isseverepatient\": 0,\n" +
            "                \"collect_serial_no\": \"10393994\",\n" +
            "                \"admitting_diagnosis_code\": \"26383\",\n" +
            "                \"chief_physician_name\": null,\n" +
            "                \"doctor_group\": \"242\",\n" +
            "                \"pati_sex_name\": \"男\",\n" +
            "                \"disease_history\": null,\n" +
            "                \"att_physician_code\": \"00345\",\n" +
            "                \"allergy_history\": null,\n" +
            "                \"out_date\": null,\n" +
            "                \"past_history\": null,\n" +
            "                \"recept_physician_code\": null,\n" +
            "                \"pati_complaint\": null,\n" +
            "                \"out_situation\": null,\n" +
            "                \"physical_examination\": null,\n" +
            "                \"att_physician_name\": \"张浩杰\",\n" +
            "                \"update_time\": \"2018-11-02 10:19:00\",\n" +
            "                \"isarrearspatient\": 1,\n" +
            "                \"marriage_bearing_history\": \"未婚\",\n" +
            "                \"disease_reportcard_flag\": null,\n" +
            "                \"curr_dept_code\": \"363\",\n" +
            "                \"admitting_diagnosis_name\": \"慢性肾脏病5期\",\n" +
            "                \"pati_source_sn\": \"1\",\n" +
            "                \"present_medical_history\": null,\n" +
            "                \"curr_ward_num\": null,\n" +
            "                \"recept_physician_name\": null,\n" +
            "                \"contact_name\": null,\n" +
            "                \"admis_condition\": null,\n" +
            "                \"outcome_name\": null,\n" +
            "                \"pati_id_card_num\": \"330802198808143231\",\n" +
            "                \"admis_days\": 70,\n" +
            "                \"admis_ward_name\": \"十病区\",\n" +
            "                \"inpatient_serial_no\": 10393994,\n" +
            "                \"chief_physician_code\": null,\n" +
            "                \"out_type_name\": null,\n" +
            "                \"nurse_level\": null,\n" +
            "                \"pati_sex_code\": 1,\n" +
            "                \"admis_dept_code\": \"363\",\n" +
            "                \"inpat_physician_code\": null,\n" +
            "                \"out_type_code\": null,\n" +
            "                \"operation_history\": null,\n" +
            "                \"pati_birthday\": \"1988-08-14 00:00:00\",\n" +
            "                \"inpatient_times\": 2,\n" +
            "                \"cycle_desc\": \"\",\n" +
            "                \"age\": \"30岁\",\n" +
            "                \"curr_dept_name\": \"肾脏病科病房\"\n" +
            "            }";

    public static InpatientListResponse.ResultsBean.ListBean getInPatientData(){

        Gson gson = new Gson();

        return gson.fromJson(inPatientBasicPageData, InpatientListResponse.ResultsBean.ListBean.class);
    }

   static String patientInMsg = " {\n" +
            "            \"brief_illness\": null,\n" +
            "            \"medi_record_no\": \"60160133\",\n" +
            "            \"admis_dept_name\": \"肾脏病科病房\",\n" +
            "            \"medical_card_no\": \"60160133\",\n" +
            "            \"outcome_code\": null,\n" +
            "            \"nation_code\": \"01\",\n" +
            "            \"infectious_diseases_history\": null,\n" +
            "            \"curr_ward_code\": \"1007\",\n" +
            "            \"inpat_physician_name\": null,\n" +
            "            \"contacts_tel\": null,\n" +
            "            \"increment_id\": 25960,\n" +
            "            \"live_addr_detail\": \"浙江省衢州市衢江区\",\n" +
            "            \"pati_source_name\": \"其他\",\n" +
            "            \"pati_dietetic_advice\": null,\n" +
            "            \"live_addr_code\": null,\n" +
            "            \"curr_bed_num\": \"10+1\",\n" +
            "            \"blood_transfusion_history\": null,\n" +
            "            \"out_diagnosis_code\": null,\n" +
            "            \"handling_opinions\": null,\n" +
            "            \"pati_tel\": \"18767016119\",\n" +
            "            \"create_time\": \"2018-09-26 15:59:00\",\n" +
            "            \"pat_tel\": \"18767016009\",\n" +
            "            \"out_diagnosis_name\": null,\n" +
            "            \"pati_name\": \"刘建国\",\n" +
            "            \"curr_ward_name\": \"十病区\",\n" +
            "            \"self_history\": \" 出生于浙江省衢州市衢江区浮石街道塔底村上岩头１０４号，其他，初中学历，成长于浙江省衢州市，长期居住于浙江省衢州市，时间29年。无疫区居留史。无冶游史。无饮酒习惯。无吸烟习惯。无毒物及放射性物质接触史。\",\n" +
            "            \"admis_ward_code\": \"1007\",\n" +
            "            \"pati_index_no\": \"7604fea4ad284624be3350eb7e85f3dc\",\n" +
            "            \"collect_time\": \"2018-09-26 15:53:00\",\n" +
            "            \"org_code\": \"1001\",\n" +
            "            \"admis_date\": \"2018-09-26 15:06:00\",\n" +
            "            \"collect_serial_no\": \"82849533\",\n" +
            "            \"admitting_diagnosis_code\": null,\n" +
            "            \"chief_physician_name\": null,\n" +
            "            \"pati_sex_name\": \"男性\",\n" +
            "            \"disease_history\": \"患者过去体质良好。有肾病史为详见现病史；2018-02-01行深静脉透析导管置入术。无高血压史、糖尿病史、心脏病史、急性心肌梗塞史；无肺结核史、病毒性肝炎史、其他传染病史；否认食物药物过敏史；无外伤史；无输血史；无中毒史；无长期用药史；无可能成瘾药物。疫苗接种史不详。\",\n" +
            "            \"att_physician_code\": \"00345\",\n" +
            "            \"allergy_history\": null,\n" +
            "            \"out_date\": null,\n" +
            "            \"past_history\": \"患者过去体质良好。有肾病史为详见现病史；2018-02-01行深静脉透析导管置入术。无高血压史、糖尿病史、心脏病史、急性心肌梗塞史；无肺结核史、病毒性肝炎史、其他传染病史；否认食物药物过敏史；无外伤史；无输血史；无中毒史；无长期用药史；无可能成瘾药物。疫苗接种史不详。\",\n" +
            "            \"contacts_name\": null,\n" +
            "            \"recept_physician_code\": null,\n" +
            "            \"pati_complaint\": \"间断血尿13年，血液透析7月\",\n" +
            "            \"profession_name\": \"\",\n" +
            "            \"profession_code\": null,\n" +
            "            \"out_situation\": null,\n" +
            "            \"physical_examination\": null,\n" +
            "            \"att_physician_name\": \"张浩杰\",\n" +
            "            \"update_time\": \"2018-09-26 15:59:00\",\n" +
            "            \"disease_reportcard_flag\": null,\n" +
            "            \"curr_dept_code\": \"363\",\n" +
            "            \"admitting_diagnosis_name\": null,\n" +
            "            \"pati_source_sn\": null,\n" +
            "            \"present_medical_history\": \"患者于13年前无明显诱因下出现血尿，肌酐正常，患者无明显不适主诉，于当地医院就诊，诊断为“急性肾小球肾炎”，予以药物治疗(具体药物不详)。后行肾脏穿刺检查结果为“膜性肾病”，予以激素治疗，后转为中药治疗。7年前患者于浙江省中医院查血肌酐为130umol/L，予以“保肾康、百令片”等药物配合中药治疗，定期监测肾功能。7月前患者因着凉感冒，感全身乏力，流鼻血于当地医院就诊，查血肌酐为1300+umol/L，血气结果pH 7.1，于2018-02-01行深静脉透析导管置入术（临时管），术后予以血液透析治疗，行肾移植配型。2018-02-12拔除颈内临时管+行血透长期导管置入术，术后规律血液透析治疗，现患者无胸闷气急，无畏寒寒战，无腹痛腹泻等其他不适，为行肾移植术入我院，门诊拟“膜性肾病 慢性肾脏病5期 肾血液透析状态”收住入院。 \\r\\n患者病来，神志清，精神尚可，夜寐胃纳可，小便500~1000ml/d，大便无殊，近期体重未见明显增减，日常生活能自理。\",\n" +
            "            \"curr_ward_num\": null,\n" +
            "            \"recept_physician_name\": null,\n" +
            "            \"admis_condition\": \"患者于13年前无明显诱因下出现血尿，肌酐正常，患者无明显不适主诉，于当地医院就诊，诊断为“急性肾小球肾炎”，予以药物治疗(具体药物不详)。后行肾脏穿刺检查结果为“膜性肾病”，予以激素治疗，后转为中药治疗。7年前患者于浙江省中医院查血肌酐为130umol/L，予以“保肾康、百令片”等药物配合中药治疗，定期监测肾功能。7月前患者因着凉感冒，感全身乏力，流鼻血于当地医院就诊，查血肌酐为1300+umol/L，血气结果pH 7.1，于2018-02-01行深静脉透析导管置入术（临时管），术后予以血液透析治疗，行肾移植配型。2018-02-12拔除颈内临时管+行血透长期导管置入术，术后规律血液透析治疗，现患者无胸闷气急，无畏寒寒战，无腹痛腹泻等其他不适，为行肾移植术入我院，门诊拟“膜性肾病 慢性肾脏病5期 肾血液透析状态”收住入院。 \\r\\n患者病来，神志清，精神尚可，夜寐胃纳可，小便500~1000ml/d，大便无殊，近期体重未见明显增减，日常生活能自理。\",\n" +
            "            \"outcome_name\": null,\n" +
            "            \"pati_id_card_num\": \"330802198808143231\",\n" +
            "            \"admis_ward_name\": \"十病区\",\n" +
            "            \"inpatient_serial_no\": 10393994,\n" +
            "            \"chief_physician_code\": null,\n" +
            "            \"out_type_name\": \"其他\",\n" +
            "            \"pati_sex_code\": 1,\n" +
            "            \"admis_dept_code\": \"363\",\n" +
            "            \"inpat_physician_code\": null,\n" +
            "            \"out_type_code\": null,\n" +
            "            \"nation_name\": \"汉族\",\n" +
            "            \"contacts_relation\": null,\n" +
            "            \"operation_history\": null,\n" +
            "            \"pati_birthday\": \"1988-08-14 00:00:00\",\n" +
            "            \"live_addr_name\": null,\n" +
            "            \"inpatient_times\": 2,\n" +
            "            \"cycle_desc\": null,\n" +
            "            \"curr_dept_name\": \"肾脏病科病房\"\n" +
            "        }";
    public static InpatientAdmisResponse.ResultsBean.ModeBean getPatInMsg(){
      return new Gson().fromJson(patientInMsg, InpatientAdmisResponse.ResultsBean.ModeBean.class);
    }

    static String surgeryListData = "{\"anaesthesia_code\":null,\"operation_cut_heal_name\":null,\"frozen_section_flag\":\"\",\"first_assistant_user_name\":\"张浩杰(主治)\",\"medi_record_no\":\"60173009\",\"request_dept_code\":\"\",\"pati_nature_code\":\"\",\"operation_start_date\":\"2018-10-15 18:54:00\",\"medical_card_num\":\"60173009\",\"preoperative_infect_flag\":\"\",\"anaesthesia_doc_eeid\":null,\"operation_dept_code\":\"\",\"request_doc_name\":\"\",\"operation_type_name\":null,\"pati_category_name\":\"\",\"operation_cut_type_name\":\"Ⅱ类切口\",\"creatername\":\"张浩杰\",\"third_assistant_user_name\":null,\"operation_plan_time\":\"2018-10-15 18:54:00\",\"operation_cut_heal_code\":null,\"operation_room\":\"\",\"operation_dept_name\":\"\",\"request_doc_code\":\"\",\"document_status_flag\":\"\",\"operation_doc_code\":\"00018\",\"postoperative_diagnosis\":\"1.慢性肾小球肾炎 慢性肾脏病5期 肾移植状态 2. 左前臂自体动-静脉内瘘（闭塞） 3.高血压病 4.右颈内静脉留置长期透析导管  \\r\\n\",\"operation_course\":\"患者平卧位，常规消毒铺巾，沿原右下腹原弧形切口12cm，切开皮肤、皮下、分离肌层。\\r\\n髂窝内存在少量澄清液体，吸引器吸引干净。\\r\\n腹膜：无破口； 输尿管 、膀胱：移植肾输尿管与膀胱吻合较好，外界清楚。  \\r\\n移植肾：\\r\\n术中见移植肾下级约1/5血供欠佳，张力差，观察血管，移植肾动脉共袢细支搏动欠佳，取出移植肾，调整移植肾位置，血供无明显改善，阻断细动脉两端，离断细动脉，见血管内血栓形成，予取出血栓，尿激酶冲管溶栓，6-0滑线端端间断吻合离断动脉，重新开放血供，见细动脉搏动可，下级张力明显改善，严密止血，重新摆放肾脏位置，见移植肾血供可，逐层关闭肌层，皮下脂肪，皮肤。\\r\\n手术失血量约50ml。  \\r\\n手术者结语：术程顺利，安返病房，清点器械纱布无误。  \",\"anaesthesia_name\":\"气管插管全身麻醉\",\"createrid\":\"00345\",\"collect_time\":\"2018-10-15 23:04:00\",\"org_code\":\"1001\",\"ward_id\":\"\",\"collect_serial_no\":\"2439803\",\"third_assistant_user_id\":null,\"operation_table\":\"\",\"operation_transfer_time\":\"\",\"request_no\":\"2439803\",\"visit_type\":2,\"remark\":\"\",\"operation_code\":null,\"sortno\":\"\",\"first_assistant_user_id\":\"00345\",\"ward_name\":\"\",\"operation_doc_name\":\"寿张飞\",\"anaesthesia_doc_name\":\"李俊,范英,李丹丹\",\"first_time_flag\":\"\",\"anaesthesia_consult_flag\":\"\",\"preoperative_diagnosis\":\"1.慢性肾小球肾炎 慢性肾脏病5期 肾移植状态 2. 左前臂自体动-静脉内瘘（闭塞） 3.高血压病 4.右颈内静脉留置长期透析导管  \\r\\n\",\"cancel_flag\":0,\"request_dept_name\":\"\",\"operation_end_date\":\"2018-10-15 22:28:00\",\"pati_dialog_content\":\"\",\"operation_name\":\"移植肾探查术\",\"second_assistant_user_id\":\"01003\",\"pati_category_code\":\"\",\"request_date\":\"2018-10-15 18:54:00\",\"pati_nature_name\":\"\",\"operation_type_code\":null,\"second_assistant_user_name\":\"王何炜(住院)\",\"add_time\":\"2018-10-15 23:04:00\",\"visit_serial_no\":10395271,\"operation_cut_type_code\":\"3\"}";

    public static List<SurgeryreCodeListResponse.ResultsBean.ListBean> getSurgeryList(){
        ArrayList<SurgeryreCodeListResponse.ResultsBean.ListBean> listBeans = new ArrayList<>();
        SurgeryreCodeListResponse.ResultsBean.ListBean listBean = new Gson().fromJson(surgeryListData, SurgeryreCodeListResponse.ResultsBean.ListBean.class);
        listBeans.add(listBean);
        return listBeans;
    }

    public static List<DoctoraDviceListResponse.ResultsBean.ListBean> getAdviceList(){
         return new Gson().fromJson(adviceListData, new TypeToken<List<DoctoraDviceListResponse.ResultsBean.ListBean>>(){}.getType());
    };

    static String adviceListData = " [\n" +
            "            {\n" +
            "                \"docadvise_cate_name\": \"长期\",\n" +
            "                \"medi_record_no\": \"60230967\",\n" +
            "                \"way_drug_name\": \"口服\",\n" +
            "                \"drug_spec\": \"16421\",\n" +
            "                \"drug_dosage_from_code\": \"0\",\n" +
            "                \"drug_abbr\": null,\n" +
            "                \"children\": [],\n" +
            "                \"increment_id\": 2478558,\n" +
            "                \"packet_amount\": null,\n" +
            "                \"open_doct_name\": \"张浩杰\",\n" +
            "                \"last_execute_date\": \"2018-12-04 00:00:00\",\n" +
            "                \"docadvise_recipel_type\": true,\n" +
            "                \"open_date\": \"2018-12-04 10:51:00\",\n" +
            "                \"drug_name\": null,\n" +
            "                \"way_drug_code\": \"51\",\n" +
            "                \"create_time\": \"2018-12-04 10:59:00\",\n" +
            "                \"drug_dosage_from_name\": \"口服\",\n" +
            "                \"emergency_flag\": 0,\n" +
            "                \"drug_unit\": \"支\",\n" +
            "                \"docadvise_item_code\": \"0\",\n" +
            "                \"cancel_durg_flag\": 0,\n" +
            "                \"doc_flag\": true,\n" +
            "                \"start_time\": \"2018-12-04 10:51:00\",\n" +
            "                \"open_dept_code\": \"363\",\n" +
            "                \"docadvise_current_state\": 4,\n" +
            "                \"pati_index_no\": \"7a8e1c61fce546d796de053a84f1106c\",\n" +
            "                \"docadvise_group_num\": \"7457972\",\n" +
            "                \"collect_time\": \"2018-12-05 00:12:00\",\n" +
            "                \"org_code\": \"1001\",\n" +
            "                \"collect_serial_no\": \"7457972\",\n" +
            "                \"docadvise_item_name\": \"氯化钾针（科伦）[基] 1克/10毫升*1支\",\n" +
            "                \"drug_use_frequency_num\": \"102\",\n" +
            "                \"item_type_name\": \"药品\",\n" +
            "                \"matching_drug\": \"0\",\n" +
            "                \"main_sec_drug_flag\": 0,\n" +
            "                \"inpat_ward_name\": \"十病区\",\n" +
            "                \"decoction_flag\": null,\n" +
            "                \"drug_code\": null,\n" +
            "                \"remark\": \"产地:湖北科伦药业有限公司  单价:1.22/支\",\n" +
            "                \"danger_drug\": \"0\",\n" +
            "                \"drug_use_dose\": 1,\n" +
            "                \"doc_advise\": null,\n" +
            "                \"pat_condition\": 0,\n" +
            "                \"update_time\": \"2018-12-05 00:19:00\",\n" +
            "                \"open_dept_name\": \"肾脏病科病房\",\n" +
            "                \"may_fall_drug\": \"0\",\n" +
            "                \"drug_price\": null,\n" +
            "                \"item_type_code\": \"1\",\n" +
            "                \"drug_use_frequency_name\": \"TID\",\n" +
            "                \"discharge_order_flag\": 0,\n" +
            "                \"drug_quantity\": 1,\n" +
            "                \"docadvise_cate_code\": \"2\",\n" +
            "                \"docadvise_no\": \"7457972\",\n" +
            "                \"inpatient_serial_no\": 10399620,\n" +
            "                \"end_time\": null,\n" +
            "                \"inpat_ward_num\": \"1007\",\n" +
            "                \"drug_use_dose_unit\": \"克\",\n" +
            "                \"docadvise_state\": 3,\n" +
            "                \"inpatient_times\": 1,\n" +
            "                \"open_doct_eeid\": \"00345\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"docadvise_cate_name\": \"长期\",\n" +
            "                \"medi_record_no\": \"60230967\",\n" +
            "                \"way_drug_name\": null,\n" +
            "                \"drug_spec\": \"0\",\n" +
            "                \"drug_dosage_from_code\": null,\n" +
            "                \"drug_abbr\": null,\n" +
            "                \"children\": [],\n" +
            "                \"increment_id\": 2457549,\n" +
            "                \"packet_amount\": null,\n" +
            "                \"open_doct_name\": \"张浩杰\",\n" +
            "                \"last_execute_date\": \"2018-12-04 00:00:00\",\n" +
            "                \"docadvise_recipel_type\": true,\n" +
            "                \"open_date\": \"2018-12-02 10:25:00\",\n" +
            "                \"drug_name\": null,\n" +
            "                \"way_drug_code\": null,\n" +
            "                \"create_time\": \"2018-12-02 10:29:00\",\n" +
            "                \"drug_dosage_from_name\": null,\n" +
            "                \"emergency_flag\": 0,\n" +
            "                \"drug_unit\": null,\n" +
            "                \"docadvise_item_code\": \"4722\",\n" +
            "                \"cancel_durg_flag\": 0,\n" +
            "                \"doc_flag\": false,\n" +
            "                \"start_time\": \"2018-12-01 08:00:00\",\n" +
            "                \"open_dept_code\": \"363\",\n" +
            "                \"docadvise_current_state\": 4,\n" +
            "                \"pati_index_no\": \"7a8e1c61fce546d796de053a84f1106c\",\n" +
            "                \"docadvise_group_num\": \"7435803\",\n" +
            "                \"collect_time\": \"2018-12-05 00:12:00\",\n" +
            "                \"org_code\": \"1001\",\n" +
            "                \"collect_serial_no\": \"7435803\",\n" +
            "                \"docadvise_item_name\": \"腹膜透析用碘伏帽（百洛普）\",\n" +
            "                \"drug_use_frequency_num\": \"105\",\n" +
            "                \"item_type_name\": \"诊疗\",\n" +
            "                \"matching_drug\": \"0\",\n" +
            "                \"main_sec_drug_flag\": 0,\n" +
            "                \"inpat_ward_name\": \"十病区\",\n" +
            "                \"decoction_flag\": null,\n" +
            "                \"drug_code\": null,\n" +
            "                \"remark\": \"单价：1.55/个\",\n" +
            "                \"danger_drug\": \"0\",\n" +
            "                \"drug_use_dose\": 3,\n" +
            "                \"doc_advise\": null,\n" +
            "                \"pat_condition\": 0,\n" +
            "                \"update_time\": \"2018-12-05 00:18:00\",\n" +
            "                \"open_dept_name\": \"肾脏病科病房\",\n" +
            "                \"may_fall_drug\": \"0\",\n" +
            "                \"drug_price\": null,\n" +
            "                \"item_type_code\": \"2\",\n" +
            "                \"drug_use_frequency_name\": \"QD\",\n" +
            "                \"discharge_order_flag\": null,\n" +
            "                \"drug_quantity\": 0,\n" +
            "                \"docadvise_cate_code\": \"2\",\n" +
            "                \"docadvise_no\": \"7435803\",\n" +
            "                \"inpatient_serial_no\": 10399620,\n" +
            "                \"end_time\": null,\n" +
            "                \"inpat_ward_num\": \"1007\",\n" +
            "                \"drug_use_dose_unit\": null,\n" +
            "                \"docadvise_state\": 3,\n" +
            "                \"inpatient_times\": 1,\n" +
            "                \"open_doct_eeid\": \"00345\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"docadvise_cate_name\": \"长期\",\n" +
            "                \"medi_record_no\": \"60230967\",\n" +
            "                \"way_drug_name\": null,\n" +
            "                \"drug_spec\": \"0\",\n" +
            "                \"drug_dosage_from_code\": null,\n" +
            "                \"drug_abbr\": null,\n" +
            "                \"children\": [],\n" +
            "                \"increment_id\": 2444080,\n" +
            "                \"packet_amount\": null,\n" +
            "                \"open_doct_name\": \"张浩杰\",\n" +
            "                \"last_execute_date\": \"2018-12-04 00:00:00\",\n" +
            "                \"docadvise_recipel_type\": true,\n" +
            "                \"open_date\": \"2018-11-30 15:03:00\",\n" +
            "                \"drug_name\": null,\n" +
            "                \"way_drug_code\": null,\n" +
            "                \"create_time\": \"2018-11-30 15:09:00\",\n" +
            "                \"drug_dosage_from_name\": null,\n" +
            "                \"emergency_flag\": 0,\n" +
            "                \"drug_unit\": null,\n" +
            "                \"docadvise_item_code\": \"4722\",\n" +
            "                \"cancel_durg_flag\": 0,\n" +
            "                \"doc_flag\": false,\n" +
            "                \"start_time\": \"2018-11-30 08:00:00\",\n" +
            "                \"open_dept_code\": \"363\",\n" +
            "                \"docadvise_current_state\": 4,\n" +
            "                \"pati_index_no\": \"7a8e1c61fce546d796de053a84f1106c\",\n" +
            "                \"docadvise_group_num\": \"7421491\",\n" +
            "                \"collect_time\": \"2018-12-05 00:12:00\",\n" +
            "                \"org_code\": \"1001\",\n" +
            "                \"collect_serial_no\": \"7421491\",\n" +
            "                \"docadvise_item_name\": \"腹膜透析用碘伏帽（百洛普）\",\n" +
            "                \"drug_use_frequency_num\": \"105\",\n" +
            "                \"item_type_name\": \"诊疗\",\n" +
            "                \"matching_drug\": \"0\",\n" +
            "                \"main_sec_drug_flag\": 0,\n" +
            "                \"inpat_ward_name\": \"十病区\",\n" +
            "                \"decoction_flag\": null,\n" +
            "                \"drug_code\": null,\n" +
            "                \"remark\": \"单价：1.55/个\",\n" +
            "                \"danger_drug\": \"0\",\n" +
            "                \"drug_use_dose\": 3,\n" +
            "                \"doc_advise\": null,\n" +
            "                \"pat_condition\": 0,\n" +
            "                \"update_time\": \"2018-12-05 00:18:00\",\n" +
            "                \"open_dept_name\": \"肾脏病科病房\",\n" +
            "                \"may_fall_drug\": \"0\",\n" +
            "                \"drug_price\": null,\n" +
            "                \"item_type_code\": \"2\",\n" +
            "                \"drug_use_frequency_name\": \"QD\",\n" +
            "                \"discharge_order_flag\": null,\n" +
            "                \"drug_quantity\": 0,\n" +
            "                \"docadvise_cate_code\": \"2\",\n" +
            "                \"docadvise_no\": \"7421491\",\n" +
            "                \"inpatient_serial_no\": 10399620,\n" +
            "                \"end_time\": null,\n" +
            "                \"inpat_ward_num\": \"1007\",\n" +
            "                \"drug_use_dose_unit\": null,\n" +
            "                \"docadvise_state\": 3,\n" +
            "                \"inpatient_times\": 1,\n" +
            "                \"open_doct_eeid\": \"00345\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"docadvise_cate_name\": \"长期\",\n" +
            "                \"medi_record_no\": \"60230967\",\n" +
            "                \"way_drug_name\": null,\n" +
            "                \"drug_spec\": \"0\",\n" +
            "                \"drug_dosage_from_code\": null,\n" +
            "                \"drug_abbr\": null,\n" +
            "                \"children\": [],\n" +
            "                \"increment_id\": 2444079,\n" +
            "                \"packet_amount\": null,\n" +
            "                \"open_doct_name\": \"张浩杰\",\n" +
            "                \"last_execute_date\": \"2018-12-04 00:00:00\",\n" +
            "                \"docadvise_recipel_type\": true,\n" +
            "                \"open_date\": \"2018-11-30 15:03:00\",\n" +
            "                \"drug_name\": null,\n" +
            "                \"way_drug_code\": null,\n" +
            "                \"create_time\": \"2018-11-30 15:09:00\",\n" +
            "                \"drug_dosage_from_name\": null,\n" +
            "                \"emergency_flag\": 0,\n" +
            "                \"drug_unit\": null,\n" +
            "                \"docadvise_item_code\": \"13630\",\n" +
            "                \"cancel_durg_flag\": 0,\n" +
            "                \"doc_flag\": false,\n" +
            "                \"start_time\": \"2018-11-30 08:00:00\",\n" +
            "                \"open_dept_code\": \"363\",\n" +
            "                \"docadvise_current_state\": 4,\n" +
            "                \"pati_index_no\": \"7a8e1c61fce546d796de053a84f1106c\",\n" +
            "                \"docadvise_group_num\": \"7421485\",\n" +
            "                \"collect_time\": \"2018-12-05 00:12:00\",\n" +
            "                \"org_code\": \"1001\",\n" +
            "                \"collect_serial_no\": \"7421485\",\n" +
            "                \"docadvise_item_name\": \"腹膜透析（手工）\",\n" +
            "                \"drug_use_frequency_num\": \"105\",\n" +
            "                \"item_type_name\": \"诊疗\",\n" +
            "                \"matching_drug\": \"0\",\n" +
            "                \"main_sec_drug_flag\": 0,\n" +
            "                \"inpat_ward_name\": \"十病区\",\n" +
            "                \"decoction_flag\": null,\n" +
            "                \"drug_code\": null,\n" +
            "                \"remark\": \"单价：91.00/次\",\n" +
            "                \"danger_drug\": \"0\",\n" +
            "                \"drug_use_dose\": 1,\n" +
            "                \"doc_advise\": null,\n" +
            "                \"pat_condition\": 0,\n" +
            "                \"update_time\": \"2018-12-05 00:18:00\",\n" +
            "                \"open_dept_name\": \"肾脏病科病房\",\n" +
            "                \"may_fall_drug\": \"0\",\n" +
            "                \"drug_price\": null,\n" +
            "                \"item_type_code\": \"2\",\n" +
            "                \"drug_use_frequency_name\": \"QD\",\n" +
            "                \"discharge_order_flag\": null,\n" +
            "                \"drug_quantity\": 0,\n" +
            "                \"docadvise_cate_code\": \"2\",\n" +
            "                \"docadvise_no\": \"7421485\",\n" +
            "                \"inpatient_serial_no\": 10399620,\n" +
            "                \"end_time\": null,\n" +
            "                \"inpat_ward_num\": \"1007\",\n" +
            "                \"drug_use_dose_unit\": null,\n" +
            "                \"docadvise_state\": 3,\n" +
            "                \"inpatient_times\": 1,\n" +
            "                \"open_doct_eeid\": \"00345\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"docadvise_cate_name\": \"长期\",\n" +
            "                \"medi_record_no\": \"60230967\",\n" +
            "                \"way_drug_name\": null,\n" +
            "                \"drug_spec\": \"0\",\n" +
            "                \"drug_dosage_from_code\": null,\n" +
            "                \"drug_abbr\": null,\n" +
            "                \"children\": [],\n" +
            "                \"increment_id\": 2444076,\n" +
            "                \"packet_amount\": null,\n" +
            "                \"open_doct_name\": \"张浩杰\",\n" +
            "                \"last_execute_date\": \"2018-12-04 00:00:00\",\n" +
            "                \"docadvise_recipel_type\": true,\n" +
            "                \"open_date\": \"2018-11-30 14:52:00\",\n" +
            "                \"drug_name\": null,\n" +
            "                \"way_drug_code\": null,\n" +
            "                \"create_time\": \"2018-11-30 15:09:00\",\n" +
            "                \"drug_dosage_from_name\": null,\n" +
            "                \"emergency_flag\": 0,\n" +
            "                \"drug_unit\": null,\n" +
            "                \"docadvise_item_code\": \"4989\",\n" +
            "                \"cancel_durg_flag\": 0,\n" +
            "                \"doc_flag\": false,\n" +
            "                \"start_time\": \"2018-11-29 14:50:00\",\n" +
            "                \"open_dept_code\": \"363\",\n" +
            "                \"docadvise_current_state\": 4,\n" +
            "                \"pati_index_no\": \"7a8e1c61fce546d796de053a84f1106c\",\n" +
            "                \"docadvise_group_num\": \"7421340\",\n" +
            "                \"collect_time\": \"2018-12-05 00:12:00\",\n" +
            "                \"org_code\": \"1001\",\n" +
            "                \"collect_serial_no\": \"7421340\",\n" +
            "                \"docadvise_item_name\": \"持续血压监测（无创）\",\n" +
            "                \"drug_use_frequency_num\": \"102\",\n" +
            "                \"item_type_name\": \"诊疗\",\n" +
            "                \"matching_drug\": \"0\",\n" +
            "                \"main_sec_drug_flag\": 0,\n" +
            "                \"inpat_ward_name\": \"十病区\",\n" +
            "                \"decoction_flag\": null,\n" +
            "                \"drug_code\": null,\n" +
            "                \"remark\": \"单价：1.00/小时\",\n" +
            "                \"danger_drug\": \"0\",\n" +
            "                \"drug_use_dose\": 1,\n" +
            "                \"doc_advise\": null,\n" +
            "                \"pat_condition\": 0,\n" +
            "                \"update_time\": \"2018-12-05 00:18:00\",\n" +
            "                \"open_dept_name\": \"肾脏病科病房\",\n" +
            "                \"may_fall_drug\": \"0\",\n" +
            "                \"drug_price\": null,\n" +
            "                \"item_type_code\": \"2\",\n" +
            "                \"drug_use_frequency_name\": \"TID\",\n" +
            "                \"discharge_order_flag\": null,\n" +
            "                \"drug_quantity\": 0,\n" +
            "                \"docadvise_cate_code\": \"2\",\n" +
            "                \"docadvise_no\": \"7421340\",\n" +
            "                \"inpatient_serial_no\": 10399620,\n" +
            "                \"end_time\": null,\n" +
            "                \"inpat_ward_num\": \"1007\",\n" +
            "                \"drug_use_dose_unit\": null,\n" +
            "                \"docadvise_state\": 3,\n" +
            "                \"inpatient_times\": 1,\n" +
            "                \"open_doct_eeid\": \"00345\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"docadvise_cate_name\": \"长期\",\n" +
            "                \"medi_record_no\": \"60230967\",\n" +
            "                \"way_drug_name\": null,\n" +
            "                \"drug_spec\": \"0\",\n" +
            "                \"drug_dosage_from_code\": null,\n" +
            "                \"drug_abbr\": null,\n" +
            "                \"children\": [],\n" +
            "                \"increment_id\": 2444072,\n" +
            "                \"packet_amount\": null,\n" +
            "                \"open_doct_name\": \"张浩杰\",\n" +
            "                \"last_execute_date\": \"2018-12-04 00:00:00\",\n" +
            "                \"docadvise_recipel_type\": true,\n" +
            "                \"open_date\": \"2018-11-30 14:51:00\",\n" +
            "                \"drug_name\": null,\n" +
            "                \"way_drug_code\": null,\n" +
            "                \"create_time\": \"2018-11-30 15:09:00\",\n" +
            "                \"drug_dosage_from_name\": null,\n" +
            "                \"emergency_flag\": 0,\n" +
            "                \"drug_unit\": null,\n" +
            "                \"docadvise_item_code\": \"4924\",\n" +
            "                \"cancel_durg_flag\": 0,\n" +
            "                \"doc_flag\": false,\n" +
            "                \"start_time\": \"2018-11-29 14:50:00\",\n" +
            "                \"open_dept_code\": \"363\",\n" +
            "                \"docadvise_current_state\": 4,\n" +
            "                \"pati_index_no\": \"7a8e1c61fce546d796de053a84f1106c\",\n" +
            "                \"docadvise_group_num\": \"7421318\",\n" +
            "                \"collect_time\": \"2018-12-05 00:12:00\",\n" +
            "                \"org_code\": \"1001\",\n" +
            "                \"collect_serial_no\": \"7421318\",\n" +
            "                \"docadvise_item_name\": \"血氧饱和度监测\",\n" +
            "                \"drug_use_frequency_num\": \"102\",\n" +
            "                \"item_type_name\": \"诊疗\",\n" +
            "                \"matching_drug\": \"0\",\n" +
            "                \"main_sec_drug_flag\": 0,\n" +
            "                \"inpat_ward_name\": \"十病区\",\n" +
            "                \"decoction_flag\": null,\n" +
            "                \"drug_code\": null,\n" +
            "                \"remark\": \"单价：2.00/小时\",\n" +
            "                \"danger_drug\": \"0\",\n" +
            "                \"drug_use_dose\": 1,\n" +
            "                \"doc_advise\": null,\n" +
            "                \"pat_condition\": 0,\n" +
            "                \"update_time\": \"2018-12-05 00:18:00\",\n" +
            "                \"open_dept_name\": \"肾脏病科病房\",\n" +
            "                \"may_fall_drug\": \"0\",\n" +
            "                \"drug_price\": null,\n" +
            "                \"item_type_code\": \"2\",\n" +
            "                \"drug_use_frequency_name\": \"TID\",\n" +
            "                \"discharge_order_flag\": null,\n" +
            "                \"drug_quantity\": 0,\n" +
            "                \"docadvise_cate_code\": \"2\",\n" +
            "                \"docadvise_no\": \"7421318\",\n" +
            "                \"inpatient_serial_no\": 10399620,\n" +
            "                \"end_time\": null,\n" +
            "                \"inpat_ward_num\": \"1007\",\n" +
            "                \"drug_use_dose_unit\": null,\n" +
            "                \"docadvise_state\": 3,\n" +
            "                \"inpatient_times\": 1,\n" +
            "                \"open_doct_eeid\": \"00345\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"docadvise_cate_name\": \"长期\",\n" +
            "                \"medi_record_no\": \"60230967\",\n" +
            "                \"way_drug_name\": \"腹透\",\n" +
            "                \"drug_spec\": \"16008\",\n" +
            "                \"drug_dosage_from_code\": \"2\",\n" +
            "                \"drug_abbr\": null,\n" +
            "                \"children\": [],\n" +
            "                \"increment_id\": 2440034,\n" +
            "                \"packet_amount\": null,\n" +
            "                \"open_doct_name\": \"王彬达\",\n" +
            "                \"last_execute_date\": \"2018-12-04 00:00:00\",\n" +
            "                \"docadvise_recipel_type\": true,\n" +
            "                \"open_date\": \"2018-11-30 09:57:00\",\n" +
            "                \"drug_name\": null,\n" +
            "                \"way_drug_code\": \"210\",\n" +
            "                \"create_time\": \"2018-11-30 09:59:00\",\n" +
            "                \"drug_dosage_from_name\": \"大输液\",\n" +
            "                \"emergency_flag\": 0,\n" +
            "                \"drug_unit\": \"袋\",\n" +
            "                \"docadvise_item_code\": \"0\",\n" +
            "                \"cancel_durg_flag\": 0,\n" +
            "                \"doc_flag\": true,\n" +
            "                \"start_time\": \"2018-11-30 09:58:00\",\n" +
            "                \"open_dept_code\": \"363\",\n" +
            "                \"docadvise_current_state\": 4,\n" +
            "                \"pati_index_no\": \"7a8e1c61fce546d796de053a84f1106c\",\n" +
            "                \"docadvise_group_num\": \"7417075\",\n" +
            "                \"collect_time\": \"2018-12-05 00:12:00\",\n" +
            "                \"org_code\": \"1001\",\n" +
            "                \"collect_serial_no\": \"7417075\",\n" +
            "                \"docadvise_item_name\": \"（G2.5%）低钙腹膜透析液[基] 2.5% 2L*1袋\",\n" +
            "                \"drug_use_frequency_num\": \"105\",\n" +
            "                \"item_type_name\": \"配置\",\n" +
            "                \"matching_drug\": \"1\",\n" +
            "                \"main_sec_drug_flag\": 0,\n" +
            "                \"inpat_ward_name\": \"十病区\",\n" +
            "                \"decoction_flag\": null,\n" +
            "                \"drug_code\": null,\n" +
            "                \"remark\": \"产地:广州百特医疗  单价:30/袋\",\n" +
            "                \"danger_drug\": \"0\",\n" +
            "                \"drug_use_dose\": 12,\n" +
            "                \"doc_advise\": null,\n" +
            "                \"pat_condition\": 0,\n" +
            "                \"update_time\": \"2018-12-05 00:19:00\",\n" +
            "                \"open_dept_name\": \"肾脏病科病房\",\n" +
            "                \"may_fall_drug\": \"0\",\n" +
            "                \"drug_price\": null,\n" +
            "                \"item_type_code\": \"7\",\n" +
            "                \"drug_use_frequency_name\": \"QD\",\n" +
            "                \"discharge_order_flag\": 0,\n" +
            "                \"drug_quantity\": 6,\n" +
            "                \"docadvise_cate_code\": \"2\",\n" +
            "                \"docadvise_no\": \"7417075\",\n" +
            "                \"inpatient_serial_no\": 10399620,\n" +
            "                \"end_time\": null,\n" +
            "                \"inpat_ward_num\": \"1007\",\n" +
            "                \"drug_use_dose_unit\": \"L\",\n" +
            "                \"docadvise_state\": 3,\n" +
            "                \"inpatient_times\": 1,\n" +
            "                \"open_doct_eeid\": \"01184\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"docadvise_cate_name\": \"长期\",\n" +
            "                \"medi_record_no\": \"60230967\",\n" +
            "                \"way_drug_name\": null,\n" +
            "                \"drug_spec\": \"0\",\n" +
            "                \"drug_dosage_from_code\": null,\n" +
            "                \"drug_abbr\": null,\n" +
            "                \"children\": [],\n" +
            "                \"increment_id\": 2435968,\n" +
            "                \"packet_amount\": null,\n" +
            "                \"open_doct_name\": \"张浩杰\",\n" +
            "                \"last_execute_date\": \"2018-12-04 00:00:00\",\n" +
            "                \"docadvise_recipel_type\": true,\n" +
            "                \"open_date\": \"2018-11-29 17:20:00\",\n" +
            "                \"drug_name\": null,\n" +
            "                \"way_drug_code\": null,\n" +
            "                \"create_time\": \"2018-11-29 17:29:00\",\n" +
            "                \"drug_dosage_from_name\": null,\n" +
            "                \"emergency_flag\": 0,\n" +
            "                \"drug_unit\": null,\n" +
            "                \"docadvise_item_code\": \"4926\",\n" +
            "                \"cancel_durg_flag\": 0,\n" +
            "                \"doc_flag\": false,\n" +
            "                \"start_time\": \"2018-11-29 15:00:00\",\n" +
            "                \"open_dept_code\": \"363\",\n" +
            "                \"docadvise_current_state\": 4,\n" +
            "                \"pati_index_no\": \"7a8e1c61fce546d796de053a84f1106c\",\n" +
            "                \"docadvise_group_num\": \"7412372\",\n" +
            "                \"collect_time\": \"2018-12-05 00:12:00\",\n" +
            "                \"org_code\": \"1001\",\n" +
            "                \"collect_serial_no\": \"7412372\",\n" +
            "                \"docadvise_item_name\": \"陪客躺椅费\",\n" +
            "                \"drug_use_frequency_num\": \"107\",\n" +
            "                \"item_type_name\": \"诊疗\",\n" +
            "                \"matching_drug\": \"0\",\n" +
            "                \"main_sec_drug_flag\": 0,\n" +
            "                \"inpat_ward_name\": \"十病区\",\n" +
            "                \"decoction_flag\": null,\n" +
            "                \"drug_code\": null,\n" +
            "                \"remark\": \"单价：2.00/日\",\n" +
            "                \"danger_drug\": \"0\",\n" +
            "                \"drug_use_dose\": 1,\n" +
            "                \"doc_advise\": null,\n" +
            "                \"pat_condition\": 0,\n" +
            "                \"update_time\": \"2018-12-05 00:18:00\",\n" +
            "                \"open_dept_name\": \"肾脏病科病房\",\n" +
            "                \"may_fall_drug\": \"0\",\n" +
            "                \"drug_price\": null,\n" +
            "                \"item_type_code\": \"2\",\n" +
            "                \"drug_use_frequency_name\": \"QN\",\n" +
            "                \"discharge_order_flag\": null,\n" +
            "                \"drug_quantity\": 0,\n" +
            "                \"docadvise_cate_code\": \"2\",\n" +
            "                \"docadvise_no\": \"7412372\",\n" +
            "                \"inpatient_serial_no\": 10399620,\n" +
            "                \"end_time\": null,\n" +
            "                \"inpat_ward_num\": \"1007\",\n" +
            "                \"drug_use_dose_unit\": null,\n" +
            "                \"docadvise_state\": 3,\n" +
            "                \"inpatient_times\": 1,\n" +
            "                \"open_doct_eeid\": \"00345\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"docadvise_cate_name\": \"长期\",\n" +
            "                \"medi_record_no\": \"60230967\",\n" +
            "                \"way_drug_name\": null,\n" +
            "                \"drug_spec\": \"0\",\n" +
            "                \"drug_dosage_from_code\": null,\n" +
            "                \"drug_abbr\": null,\n" +
            "                \"children\": [],\n" +
            "                \"increment_id\": 2435966,\n" +
            "                \"packet_amount\": null,\n" +
            "                \"open_doct_name\": \"张浩杰\",\n" +
            "                \"last_execute_date\": \"2018-12-04 00:00:00\",\n" +
            "                \"docadvise_recipel_type\": true,\n" +
            "                \"open_date\": \"2018-11-29 17:20:00\",\n" +
            "                \"drug_name\": null,\n" +
            "                \"way_drug_code\": null,\n" +
            "                \"create_time\": \"2018-11-29 17:29:00\",\n" +
            "                \"drug_dosage_from_name\": null,\n" +
            "                \"emergency_flag\": 0,\n" +
            "                \"drug_unit\": null,\n" +
            "                \"docadvise_item_code\": \"4598\",\n" +
            "                \"cancel_durg_flag\": 0,\n" +
            "                \"doc_flag\": false,\n" +
            "                \"start_time\": \"2018-11-29 15:00:00\",\n" +
            "                \"open_dept_code\": \"363\",\n" +
            "                \"docadvise_current_state\": 4,\n" +
            "                \"pati_index_no\": \"7a8e1c61fce546d796de053a84f1106c\",\n" +
            "                \"docadvise_group_num\": \"7412369\",\n" +
            "                \"collect_time\": \"2018-12-05 00:12:00\",\n" +
            "                \"org_code\": \"1001\",\n" +
            "                \"collect_serial_no\": \"7412369\",\n" +
            "                \"docadvise_item_name\": \"一般专项护理\",\n" +
            "                \"drug_use_frequency_num\": \"102\",\n" +
            "                \"item_type_name\": \"诊疗\",\n" +
            "                \"matching_drug\": \"0\",\n" +
            "                \"main_sec_drug_flag\": 0,\n" +
            "                \"inpat_ward_name\": \"十病区\",\n" +
            "                \"decoction_flag\": null,\n" +
            "                \"drug_code\": null,\n" +
            "                \"remark\": \"单价：4.00/次\",\n" +
            "                \"danger_drug\": \"0\",\n" +
            "                \"drug_use_dose\": 1,\n" +
            "                \"doc_advise\": null,\n" +
            "                \"pat_condition\": 0,\n" +
            "                \"update_time\": \"2018-12-05 00:18:00\",\n" +
            "                \"open_dept_name\": \"肾脏病科病房\",\n" +
            "                \"may_fall_drug\": \"0\",\n" +
            "                \"drug_price\": null,\n" +
            "                \"item_type_code\": \"2\",\n" +
            "                \"drug_use_frequency_name\": \"TID\",\n" +
            "                \"discharge_order_flag\": null,\n" +
            "                \"drug_quantity\": 0,\n" +
            "                \"docadvise_cate_code\": \"2\",\n" +
            "                \"docadvise_no\": \"7412369\",\n" +
            "                \"inpatient_serial_no\": 10399620,\n" +
            "                \"end_time\": null,\n" +
            "                \"inpat_ward_num\": \"1007\",\n" +
            "                \"drug_use_dose_unit\": null,\n" +
            "                \"docadvise_state\": 3,\n" +
            "                \"inpatient_times\": 1,\n" +
            "                \"open_doct_eeid\": \"00345\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"docadvise_cate_name\": \"长期\",\n" +
            "                \"medi_record_no\": \"60230967\",\n" +
            "                \"way_drug_name\": null,\n" +
            "                \"drug_spec\": \"0\",\n" +
            "                \"drug_dosage_from_code\": null,\n" +
            "                \"drug_abbr\": null,\n" +
            "                \"children\": [],\n" +
            "                \"increment_id\": 2435965,\n" +
            "                \"packet_amount\": null,\n" +
            "                \"open_doct_name\": \"张浩杰\",\n" +
            "                \"last_execute_date\": \"2018-12-04 00:00:00\",\n" +
            "                \"docadvise_recipel_type\": true,\n" +
            "                \"open_date\": \"2018-11-29 17:20:00\",\n" +
            "                \"drug_name\": null,\n" +
            "                \"way_drug_code\": null,\n" +
            "                \"create_time\": \"2018-11-29 17:29:00\",\n" +
            "                \"drug_dosage_from_name\": null,\n" +
            "                \"emergency_flag\": 0,\n" +
            "                \"drug_unit\": null,\n" +
            "                \"docadvise_item_code\": \"4924\",\n" +
            "                \"cancel_durg_flag\": 0,\n" +
            "                \"doc_flag\": false,\n" +
            "                \"start_time\": \"2018-11-29 15:00:00\",\n" +
            "                \"open_dept_code\": \"363\",\n" +
            "                \"docadvise_current_state\": 4,\n" +
            "                \"pati_index_no\": \"7a8e1c61fce546d796de053a84f1106c\",\n" +
            "                \"docadvise_group_num\": \"7412368\",\n" +
            "                \"collect_time\": \"2018-12-05 00:12:00\",\n" +
            "                \"org_code\": \"1001\",\n" +
            "                \"collect_serial_no\": \"7412368\",\n" +
            "                \"docadvise_item_name\": \"血氧饱和度监测\",\n" +
            "                \"drug_use_frequency_num\": \"102\",\n" +
            "                \"item_type_name\": \"诊疗\",\n" +
            "                \"matching_drug\": \"0\",\n" +
            "                \"main_sec_drug_flag\": 0,\n" +
            "                \"inpat_ward_name\": \"十病区\",\n" +
            "                \"decoction_flag\": null,\n" +
            "                \"drug_code\": null,\n" +
            "                \"remark\": \"单价：2.00/小时\",\n" +
            "                \"danger_drug\": \"0\",\n" +
            "                \"drug_use_dose\": 1,\n" +
            "                \"doc_advise\": null,\n" +
            "                \"pat_condition\": 0,\n" +
            "                \"update_time\": \"2018-12-05 00:18:00\",\n" +
            "                \"open_dept_name\": \"肾脏病科病房\",\n" +
            "                \"may_fall_drug\": \"0\",\n" +
            "                \"drug_price\": null,\n" +
            "                \"item_type_code\": \"2\",\n" +
            "                \"drug_use_frequency_name\": \"TID\",\n" +
            "                \"discharge_order_flag\": null,\n" +
            "                \"drug_quantity\": 0,\n" +
            "                \"docadvise_cate_code\": \"2\",\n" +
            "                \"docadvise_no\": \"7412368\",\n" +
            "                \"inpatient_serial_no\": 10399620,\n" +
            "                \"end_time\": null,\n" +
            "                \"inpat_ward_num\": \"1007\",\n" +
            "                \"drug_use_dose_unit\": null,\n" +
            "                \"docadvise_state\": 3,\n" +
            "                \"inpatient_times\": 1,\n" +
            "                \"open_doct_eeid\": \"00345\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"docadvise_cate_name\": \"长期\",\n" +
            "                \"medi_record_no\": \"60230967\",\n" +
            "                \"way_drug_name\": null,\n" +
            "                \"drug_spec\": \"0\",\n" +
            "                \"drug_dosage_from_code\": null,\n" +
            "                \"drug_abbr\": null,\n" +
            "                \"children\": [],\n" +
            "                \"increment_id\": 2433759,\n" +
            "                \"packet_amount\": null,\n" +
            "                \"open_doct_name\": \"张浩杰\",\n" +
            "                \"last_execute_date\": \"2018-12-04 00:00:00\",\n" +
            "                \"docadvise_recipel_type\": true,\n" +
            "                \"open_date\": \"2018-11-29 15:09:00\",\n" +
            "                \"drug_name\": null,\n" +
            "                \"way_drug_code\": null,\n" +
            "                \"create_time\": \"2018-11-29 15:09:00\",\n" +
            "                \"drug_dosage_from_name\": null,\n" +
            "                \"emergency_flag\": 0,\n" +
            "                \"drug_unit\": null,\n" +
            "                \"docadvise_item_code\": \"15352\",\n" +
            "                \"cancel_durg_flag\": 0,\n" +
            "                \"doc_flag\": true,\n" +
            "                \"start_time\": \"2018-11-29 14:44:00\",\n" +
            "                \"open_dept_code\": \"363\",\n" +
            "                \"docadvise_current_state\": 4,\n" +
            "                \"pati_index_no\": \"7a8e1c61fce546d796de053a84f1106c\",\n" +
            "                \"docadvise_group_num\": \"7410308\",\n" +
            "                \"collect_time\": \"2018-12-05 00:12:00\",\n" +
            "                \"org_code\": \"1001\",\n" +
            "                \"collect_serial_no\": \"7410308\",\n" +
            "                \"docadvise_item_name\": \"低盐低脂优质蛋白饮食\",\n" +
            "                \"drug_use_frequency_num\": \"-02\",\n" +
            "                \"item_type_name\": \"诊疗\",\n" +
            "                \"matching_drug\": \"0\",\n" +
            "                \"main_sec_drug_flag\": 0,\n" +
            "                \"inpat_ward_name\": \"十病区\",\n" +
            "                \"decoction_flag\": null,\n" +
            "                \"drug_code\": null,\n" +
            "                \"remark\": null,\n" +
            "                \"danger_drug\": \"0\",\n" +
            "                \"drug_use_dose\": 1,\n" +
            "                \"doc_advise\": null,\n" +
            "                \"pat_condition\": 0,\n" +
            "                \"update_time\": \"2018-12-05 00:18:00\",\n" +
            "                \"open_dept_name\": \"肾脏病科病房\",\n" +
            "                \"may_fall_drug\": \"0\",\n" +
            "                \"drug_price\": null,\n" +
            "                \"item_type_code\": \"2\",\n" +
            "                \"drug_use_frequency_name\": \"ALWAYS\",\n" +
            "                \"discharge_order_flag\": null,\n" +
            "                \"drug_quantity\": 0,\n" +
            "                \"docadvise_cate_code\": \"2\",\n" +
            "                \"docadvise_no\": \"7410308\",\n" +
            "                \"inpatient_serial_no\": 10399620,\n" +
            "                \"end_time\": null,\n" +
            "                \"inpat_ward_num\": \"1007\",\n" +
            "                \"drug_use_dose_unit\": null,\n" +
            "                \"docadvise_state\": 3,\n" +
            "                \"inpatient_times\": 1,\n" +
            "                \"open_doct_eeid\": \"00345\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"docadvise_cate_name\": \"长期\",\n" +
            "                \"medi_record_no\": \"60230967\",\n" +
            "                \"way_drug_name\": null,\n" +
            "                \"drug_spec\": \"0\",\n" +
            "                \"drug_dosage_from_code\": null,\n" +
            "                \"drug_abbr\": null,\n" +
            "                \"children\": [],\n" +
            "                \"increment_id\": 2433758,\n" +
            "                \"packet_amount\": null,\n" +
            "                \"open_doct_name\": \"张浩杰\",\n" +
            "                \"last_execute_date\": \"2018-12-04 00:00:00\",\n" +
            "                \"docadvise_recipel_type\": true,\n" +
            "                \"open_date\": \"2018-11-29 15:09:00\",\n" +
            "                \"drug_name\": null,\n" +
            "                \"way_drug_code\": null,\n" +
            "                \"create_time\": \"2018-11-29 15:09:00\",\n" +
            "                \"drug_dosage_from_name\": null,\n" +
            "                \"emergency_flag\": 0,\n" +
            "                \"drug_unit\": null,\n" +
            "                \"docadvise_item_code\": \"0\",\n" +
            "                \"cancel_durg_flag\": 0,\n" +
            "                \"doc_flag\": true,\n" +
            "                \"start_time\": \"2018-11-29 14:44:00\",\n" +
            "                \"open_dept_code\": \"363\",\n" +
            "                \"docadvise_current_state\": 4,\n" +
            "                \"pati_index_no\": \"7a8e1c61fce546d796de053a84f1106c\",\n" +
            "                \"docadvise_group_num\": \"7410301\",\n" +
            "                \"collect_time\": \"2018-12-05 00:12:00\",\n" +
            "                \"org_code\": \"1001\",\n" +
            "                \"collect_serial_no\": \"7410301\",\n" +
            "                \"docadvise_item_name\": \"测体重\",\n" +
            "                \"drug_use_frequency_num\": \"105\",\n" +
            "                \"item_type_name\": \"文本\",\n" +
            "                \"matching_drug\": \"0\",\n" +
            "                \"main_sec_drug_flag\": 0,\n" +
            "                \"inpat_ward_name\": \"十病区\",\n" +
            "                \"decoction_flag\": null,\n" +
            "                \"drug_code\": null,\n" +
            "                \"remark\": \"文本医嘱\",\n" +
            "                \"danger_drug\": \"0\",\n" +
            "                \"drug_use_dose\": 1,\n" +
            "                \"doc_advise\": null,\n" +
            "                \"pat_condition\": 0,\n" +
            "                \"update_time\": \"2018-12-05 00:18:00\",\n" +
            "                \"open_dept_name\": \"肾脏病科病房\",\n" +
            "                \"may_fall_drug\": \"0\",\n" +
            "                \"drug_price\": null,\n" +
            "                \"item_type_code\": \"3\",\n" +
            "                \"drug_use_frequency_name\": \"QD\",\n" +
            "                \"discharge_order_flag\": null,\n" +
            "                \"drug_quantity\": 0,\n" +
            "                \"docadvise_cate_code\": \"2\",\n" +
            "                \"docadvise_no\": \"7410301\",\n" +
            "                \"inpatient_serial_no\": 10399620,\n" +
            "                \"end_time\": null,\n" +
            "                \"inpat_ward_num\": \"1007\",\n" +
            "                \"drug_use_dose_unit\": null,\n" +
            "                \"docadvise_state\": 3,\n" +
            "                \"inpatient_times\": 1,\n" +
            "                \"open_doct_eeid\": \"00345\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"docadvise_cate_name\": \"长期\",\n" +
            "                \"medi_record_no\": \"60230967\",\n" +
            "                \"way_drug_name\": null,\n" +
            "                \"drug_spec\": \"0\",\n" +
            "                \"drug_dosage_from_code\": null,\n" +
            "                \"drug_abbr\": null,\n" +
            "                \"children\": [],\n" +
            "                \"increment_id\": 2433757,\n" +
            "                \"packet_amount\": null,\n" +
            "                \"open_doct_name\": \"张浩杰\",\n" +
            "                \"last_execute_date\": \"2018-12-04 00:00:00\",\n" +
            "                \"docadvise_recipel_type\": true,\n" +
            "                \"open_date\": \"2018-11-29 15:08:00\",\n" +
            "                \"drug_name\": null,\n" +
            "                \"way_drug_code\": null,\n" +
            "                \"create_time\": \"2018-11-29 15:09:00\",\n" +
            "                \"drug_dosage_from_name\": null,\n" +
            "                \"emergency_flag\": 0,\n" +
            "                \"drug_unit\": null,\n" +
            "                \"docadvise_item_code\": \"4916\",\n" +
            "                \"cancel_durg_flag\": 0,\n" +
            "                \"doc_flag\": true,\n" +
            "                \"start_time\": \"2018-11-29 14:44:00\",\n" +
            "                \"open_dept_code\": \"363\",\n" +
            "                \"docadvise_current_state\": 4,\n" +
            "                \"pati_index_no\": \"7a8e1c61fce546d796de053a84f1106c\",\n" +
            "                \"docadvise_group_num\": \"7410296\",\n" +
            "                \"collect_time\": \"2018-12-05 00:12:00\",\n" +
            "                \"org_code\": \"1001\",\n" +
            "                \"collect_serial_no\": \"7410296\",\n" +
            "                \"docadvise_item_name\": \"Ⅰ级护理\",\n" +
            "                \"drug_use_frequency_num\": \"105\",\n" +
            "                \"item_type_name\": \"诊疗\",\n" +
            "                \"matching_drug\": \"0\",\n" +
            "                \"main_sec_drug_flag\": 0,\n" +
            "                \"inpat_ward_name\": \"十病区\",\n" +
            "                \"decoction_flag\": null,\n" +
            "                \"drug_code\": null,\n" +
            "                \"remark\": \"单价：20.00/日\",\n" +
            "                \"danger_drug\": \"0\",\n" +
            "                \"drug_use_dose\": 1,\n" +
            "                \"doc_advise\": null,\n" +
            "                \"pat_condition\": 0,\n" +
            "                \"update_time\": \"2018-12-05 00:18:00\",\n" +
            "                \"open_dept_name\": \"肾脏病科病房\",\n" +
            "                \"may_fall_drug\": \"0\",\n" +
            "                \"drug_price\": null,\n" +
            "                \"item_type_code\": \"2\",\n" +
            "                \"drug_use_frequency_name\": \"QD\",\n" +
            "                \"discharge_order_flag\": null,\n" +
            "                \"drug_quantity\": 0,\n" +
            "                \"docadvise_cate_code\": \"2\",\n" +
            "                \"docadvise_no\": \"7410296\",\n" +
            "                \"inpatient_serial_no\": 10399620,\n" +
            "                \"end_time\": null,\n" +
            "                \"inpat_ward_num\": \"1007\",\n" +
            "                \"drug_use_dose_unit\": null,\n" +
            "                \"docadvise_state\": 3,\n" +
            "                \"inpatient_times\": 1,\n" +
            "                \"open_doct_eeid\": \"00345\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"docadvise_cate_name\": \"长期\",\n" +
            "                \"medi_record_no\": \"60230967\",\n" +
            "                \"way_drug_name\": null,\n" +
            "                \"drug_spec\": \"0\",\n" +
            "                \"drug_dosage_from_code\": null,\n" +
            "                \"drug_abbr\": null,\n" +
            "                \"children\": [],\n" +
            "                \"increment_id\": 2433756,\n" +
            "                \"packet_amount\": null,\n" +
            "                \"open_doct_name\": \"张浩杰\",\n" +
            "                \"last_execute_date\": \"2018-12-04 00:00:00\",\n" +
            "                \"docadvise_recipel_type\": true,\n" +
            "                \"open_date\": \"2018-11-29 15:08:00\",\n" +
            "                \"drug_name\": null,\n" +
            "                \"way_drug_code\": null,\n" +
            "                \"create_time\": \"2018-11-29 15:09:00\",\n" +
            "                \"drug_dosage_from_name\": null,\n" +
            "                \"emergency_flag\": 0,\n" +
            "                \"drug_unit\": null,\n" +
            "                \"docadvise_item_code\": \"5332\",\n" +
            "                \"cancel_durg_flag\": 0,\n" +
            "                \"doc_flag\": true,\n" +
            "                \"start_time\": \"2018-11-29 14:44:00\",\n" +
            "                \"open_dept_code\": \"363\",\n" +
            "                \"docadvise_current_state\": 4,\n" +
            "                \"pati_index_no\": \"7a8e1c61fce546d796de053a84f1106c\",\n" +
            "                \"docadvise_group_num\": \"7410294\",\n" +
            "                \"collect_time\": \"2018-12-05 00:12:00\",\n" +
            "                \"org_code\": \"1001\",\n" +
            "                \"collect_serial_no\": \"7410294\",\n" +
            "                \"docadvise_item_name\": \"测血压\",\n" +
            "                \"drug_use_frequency_num\": \"102\",\n" +
            "                \"item_type_name\": \"诊疗\",\n" +
            "                \"matching_drug\": \"0\",\n" +
            "                \"main_sec_drug_flag\": 0,\n" +
            "                \"inpat_ward_name\": \"十病区\",\n" +
            "                \"decoction_flag\": null,\n" +
            "                \"drug_code\": null,\n" +
            "                \"remark\": null,\n" +
            "                \"danger_drug\": \"0\",\n" +
            "                \"drug_use_dose\": 1,\n" +
            "                \"doc_advise\": null,\n" +
            "                \"pat_condition\": 0,\n" +
            "                \"update_time\": \"2018-12-05 00:18:00\",\n" +
            "                \"open_dept_name\": \"肾脏病科病房\",\n" +
            "                \"may_fall_drug\": \"0\",\n" +
            "                \"drug_price\": null,\n" +
            "                \"item_type_code\": \"2\",\n" +
            "                \"drug_use_frequency_name\": \"TID\",\n" +
            "                \"discharge_order_flag\": null,\n" +
            "                \"drug_quantity\": 0,\n" +
            "                \"docadvise_cate_code\": \"2\",\n" +
            "                \"docadvise_no\": \"7410294\",\n" +
            "                \"inpatient_serial_no\": 10399620,\n" +
            "                \"end_time\": null,\n" +
            "                \"inpat_ward_num\": \"1007\",\n" +
            "                \"drug_use_dose_unit\": null,\n" +
            "                \"docadvise_state\": 3,\n" +
            "                \"inpatient_times\": 1,\n" +
            "                \"open_doct_eeid\": \"00345\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"docadvise_cate_name\": \"长期\",\n" +
            "                \"medi_record_no\": \"60230967\",\n" +
            "                \"way_drug_name\": null,\n" +
            "                \"drug_spec\": \"0\",\n" +
            "                \"drug_dosage_from_code\": null,\n" +
            "                \"drug_abbr\": null,\n" +
            "                \"children\": [],\n" +
            "                \"increment_id\": 2433755,\n" +
            "                \"packet_amount\": null,\n" +
            "                \"open_doct_name\": \"张浩杰\",\n" +
            "                \"last_execute_date\": \"2018-12-04 00:00:00\",\n" +
            "                \"docadvise_recipel_type\": true,\n" +
            "                \"open_date\": \"2018-11-29 15:08:00\",\n" +
            "                \"drug_name\": null,\n" +
            "                \"way_drug_code\": null,\n" +
            "                \"create_time\": \"2018-11-29 15:09:00\",\n" +
            "                \"drug_dosage_from_name\": null,\n" +
            "                \"emergency_flag\": 0,\n" +
            "                \"drug_unit\": null,\n" +
            "                \"docadvise_item_code\": \"14098\",\n" +
            "                \"cancel_durg_flag\": 0,\n" +
            "                \"doc_flag\": true,\n" +
            "                \"start_time\": \"2018-11-29 14:44:00\",\n" +
            "                \"open_dept_code\": \"363\",\n" +
            "                \"docadvise_current_state\": 4,\n" +
            "                \"pati_index_no\": \"7a8e1c61fce546d796de053a84f1106c\",\n" +
            "                \"docadvise_group_num\": \"7410291\",\n" +
            "                \"collect_time\": \"2018-12-05 00:12:00\",\n" +
            "                \"org_code\": \"1001\",\n" +
            "                \"collect_serial_no\": \"7410291\",\n" +
            "                \"docadvise_item_name\": \"肾病中心护理常规\",\n" +
            "                \"drug_use_frequency_num\": \"105\",\n" +
            "                \"item_type_name\": \"诊疗\",\n" +
            "                \"matching_drug\": \"0\",\n" +
            "                \"main_sec_drug_flag\": 0,\n" +
            "                \"inpat_ward_name\": \"十病区\",\n" +
            "                \"decoction_flag\": null,\n" +
            "                \"drug_code\": null,\n" +
            "                \"remark\": null,\n" +
            "                \"danger_drug\": \"0\",\n" +
            "                \"drug_use_dose\": 1,\n" +
            "                \"doc_advise\": null,\n" +
            "                \"pat_condition\": 0,\n" +
            "                \"update_time\": \"2018-12-05 00:18:00\",\n" +
            "                \"open_dept_name\": \"肾脏病科病房\",\n" +
            "                \"may_fall_drug\": \"0\",\n" +
            "                \"drug_price\": null,\n" +
            "                \"item_type_code\": \"2\",\n" +
            "                \"drug_use_frequency_name\": \"QD\",\n" +
            "                \"discharge_order_flag\": null,\n" +
            "                \"drug_quantity\": 0,\n" +
            "                \"docadvise_cate_code\": \"2\",\n" +
            "                \"docadvise_no\": \"7410291\",\n" +
            "                \"inpatient_serial_no\": 10399620,\n" +
            "                \"end_time\": null,\n" +
            "                \"inpat_ward_num\": \"1007\",\n" +
            "                \"drug_use_dose_unit\": null,\n" +
            "                \"docadvise_state\": 3,\n" +
            "                \"inpatient_times\": 1,\n" +
            "                \"open_doct_eeid\": \"00345\"\n" +
            "            }\n" +
            "        ]";


    public static List<DoctoraDviceExeResponse.ResultsBean.ListBean> getAdvicExeList(){
        return new Gson().fromJson(adviceExeData, new TypeToken<List<DoctoraDviceExeResponse.ResultsBean.ListBean>>(){}.getType());

    }

    static String adviceExeData = "[\n" +
            "            {\n" +
            "                \"nurse_execute_time\": \"2018-12-05 11:05:00\",\n" +
            "                \"medi_record_no\": \"60230967\",\n" +
            "                \"request_amount\": 1,\n" +
            "                \"inpat_ward_name\": \"十病区\",\n" +
            "                \"execute_update_time\": \"2018-12-05 11:05:00\",\n" +
            "                \"remark\": null,\n" +
            "                \"docadvise_request_no\": \"10330137\",\n" +
            "                \"dispensing_code\": \"2\",\n" +
            "                \"dispensing_name\": \"长口服西药\",\n" +
            "                \"update_time\": \"2018-12-05 11:09:00\",\n" +
            "                \"docadvise_dispensing_no\": \"0\",\n" +
            "                \"increment_id\": 14345942,\n" +
            "                \"execute_user_code\": \"759\",\n" +
            "                \"curr_bed_num\": \"1017\",\n" +
            "                \"administration_time\": \"2018-12-05 16:00:00\",\n" +
            "                \"docadvise_generate_time\": \"2018-12-05 00:00:00\",\n" +
            "                \"execute_dept_code\": \"363\",\n" +
            "                \"create_time\": \"2018-12-05 11:09:00\",\n" +
            "                \"execute_user_name\": \"曾静\",\n" +
            "                \"docadvise_no\": \"7457972\",\n" +
            "                \"inpatient_serial_no\": 10399620,\n" +
            "                \"inpat_ward_num\": \"1007\",\n" +
            "                \"execute_no\": \"40536320\",\n" +
            "                \"inpatient_times\": 1,\n" +
            "                \"execute_dept_name\": \"肾脏病科病房\",\n" +
            "                \"pati_index_no\": \"7a8e1c61fce546d796de053a84f1106c\",\n" +
            "                \"collect_time\": \"2018-12-05 11:05:00\",\n" +
            "                \"org_code\": \"1001\",\n" +
            "                \"collect_serial_no\": \"40536320\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"nurse_execute_time\": \"2018-12-05 11:05:00\",\n" +
            "                \"medi_record_no\": \"60230967\",\n" +
            "                \"request_amount\": 1,\n" +
            "                \"inpat_ward_name\": \"十病区\",\n" +
            "                \"execute_update_time\": \"2018-12-05 11:05:00\",\n" +
            "                \"remark\": null,\n" +
            "                \"docadvise_request_no\": \"10330138\",\n" +
            "                \"dispensing_code\": \"2\",\n" +
            "                \"dispensing_name\": \"长口服西药\",\n" +
            "                \"update_time\": \"2018-12-05 11:09:00\",\n" +
            "                \"docadvise_dispensing_no\": \"0\",\n" +
            "                \"increment_id\": 14345943,\n" +
            "                \"execute_user_code\": \"759\",\n" +
            "                \"curr_bed_num\": \"1017\",\n" +
            "                \"administration_time\": \"2018-12-06 08:00:00\",\n" +
            "                \"docadvise_generate_time\": \"2018-12-05 00:00:00\",\n" +
            "                \"execute_dept_code\": \"363\",\n" +
            "                \"create_time\": \"2018-12-05 11:09:00\",\n" +
            "                \"execute_user_name\": \"曾静\",\n" +
            "                \"docadvise_no\": \"7457972\",\n" +
            "                \"inpatient_serial_no\": 10399620,\n" +
            "                \"inpat_ward_num\": \"1007\",\n" +
            "                \"execute_no\": \"40536321\",\n" +
            "                \"inpatient_times\": 1,\n" +
            "                \"execute_dept_name\": \"肾脏病科病房\",\n" +
            "                \"pati_index_no\": \"7a8e1c61fce546d796de053a84f1106c\",\n" +
            "                \"collect_time\": \"2018-12-05 11:05:00\",\n" +
            "                \"org_code\": \"1001\",\n" +
            "                \"collect_serial_no\": \"40536321\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"nurse_execute_time\": \"2018-12-05 11:05:00\",\n" +
            "                \"medi_record_no\": \"60230967\",\n" +
            "                \"request_amount\": 1,\n" +
            "                \"inpat_ward_name\": \"十病区\",\n" +
            "                \"execute_update_time\": \"2018-12-05 11:05:00\",\n" +
            "                \"remark\": null,\n" +
            "                \"docadvise_request_no\": \"10330138\",\n" +
            "                \"dispensing_code\": \"2\",\n" +
            "                \"dispensing_name\": \"长口服西药\",\n" +
            "                \"update_time\": \"2018-12-05 11:09:00\",\n" +
            "                \"docadvise_dispensing_no\": \"0\",\n" +
            "                \"increment_id\": 14345944,\n" +
            "                \"execute_user_code\": \"759\",\n" +
            "                \"curr_bed_num\": \"1017\",\n" +
            "                \"administration_time\": \"2018-12-06 12:00:00\",\n" +
            "                \"docadvise_generate_time\": \"2018-12-05 00:00:00\",\n" +
            "                \"execute_dept_code\": \"363\",\n" +
            "                \"create_time\": \"2018-12-05 11:09:00\",\n" +
            "                \"execute_user_name\": \"曾静\",\n" +
            "                \"docadvise_no\": \"7457972\",\n" +
            "                \"inpatient_serial_no\": 10399620,\n" +
            "                \"inpat_ward_num\": \"1007\",\n" +
            "                \"execute_no\": \"40536322\",\n" +
            "                \"inpatient_times\": 1,\n" +
            "                \"execute_dept_name\": \"肾脏病科病房\",\n" +
            "                \"pati_index_no\": \"7a8e1c61fce546d796de053a84f1106c\",\n" +
            "                \"collect_time\": \"2018-12-05 11:05:00\",\n" +
            "                \"org_code\": \"1001\",\n" +
            "                \"collect_serial_no\": \"40536322\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"nurse_execute_time\": \"2018-12-04 11:17:00\",\n" +
            "                \"medi_record_no\": \"60230967\",\n" +
            "                \"request_amount\": 1,\n" +
            "                \"inpat_ward_name\": \"十病区\",\n" +
            "                \"execute_update_time\": \"2018-12-04 11:17:00\",\n" +
            "                \"remark\": null,\n" +
            "                \"docadvise_request_no\": \"10316678\",\n" +
            "                \"dispensing_code\": \"2\",\n" +
            "                \"dispensing_name\": \"长口服西药\",\n" +
            "                \"update_time\": \"2018-12-04 11:19:00\",\n" +
            "                \"docadvise_dispensing_no\": \"0\",\n" +
            "                \"increment_id\": 14301668,\n" +
            "                \"execute_user_code\": \"340\",\n" +
            "                \"curr_bed_num\": \"1017\",\n" +
            "                \"administration_time\": \"2018-12-04 16:00:00\",\n" +
            "                \"docadvise_generate_time\": \"2018-12-04 00:00:00\",\n" +
            "                \"execute_dept_code\": \"363\",\n" +
            "                \"create_time\": \"2018-12-04 11:19:00\",\n" +
            "                \"execute_user_name\": \"王可瑞\",\n" +
            "                \"docadvise_no\": \"7457972\",\n" +
            "                \"inpatient_serial_no\": 10399620,\n" +
            "                \"inpat_ward_num\": \"1007\",\n" +
            "                \"execute_no\": \"40475104\",\n" +
            "                \"inpatient_times\": 1,\n" +
            "                \"execute_dept_name\": \"肾脏病科病房\",\n" +
            "                \"pati_index_no\": \"7a8e1c61fce546d796de053a84f1106c\",\n" +
            "                \"collect_time\": \"2018-12-04 11:17:00\",\n" +
            "                \"org_code\": \"1001\",\n" +
            "                \"collect_serial_no\": \"40475104\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"nurse_execute_time\": \"2018-12-04 11:17:00\",\n" +
            "                \"medi_record_no\": \"60230967\",\n" +
            "                \"request_amount\": 1,\n" +
            "                \"inpat_ward_name\": \"十病区\",\n" +
            "                \"execute_update_time\": \"2018-12-04 11:17:00\",\n" +
            "                \"remark\": null,\n" +
            "                \"docadvise_request_no\": \"10316679\",\n" +
            "                \"dispensing_code\": \"2\",\n" +
            "                \"dispensing_name\": \"长口服西药\",\n" +
            "                \"update_time\": \"2018-12-04 11:19:00\",\n" +
            "                \"docadvise_dispensing_no\": \"0\",\n" +
            "                \"increment_id\": 14301669,\n" +
            "                \"execute_user_code\": \"340\",\n" +
            "                \"curr_bed_num\": \"1017\",\n" +
            "                \"administration_time\": \"2018-12-05 08:00:00\",\n" +
            "                \"docadvise_generate_time\": \"2018-12-04 00:00:00\",\n" +
            "                \"execute_dept_code\": \"363\",\n" +
            "                \"create_time\": \"2018-12-04 11:19:00\",\n" +
            "                \"execute_user_name\": \"王可瑞\",\n" +
            "                \"docadvise_no\": \"7457972\",\n" +
            "                \"inpatient_serial_no\": 10399620,\n" +
            "                \"inpat_ward_num\": \"1007\",\n" +
            "                \"execute_no\": \"40475105\",\n" +
            "                \"inpatient_times\": 1,\n" +
            "                \"execute_dept_name\": \"肾脏病科病房\",\n" +
            "                \"pati_index_no\": \"7a8e1c61fce546d796de053a84f1106c\",\n" +
            "                \"collect_time\": \"2018-12-04 11:17:00\",\n" +
            "                \"org_code\": \"1001\",\n" +
            "                \"collect_serial_no\": \"40475105\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"nurse_execute_time\": \"2018-12-04 11:17:00\",\n" +
            "                \"medi_record_no\": \"60230967\",\n" +
            "                \"request_amount\": 1,\n" +
            "                \"inpat_ward_name\": \"十病区\",\n" +
            "                \"execute_update_time\": \"2018-12-04 11:17:00\",\n" +
            "                \"remark\": null,\n" +
            "                \"docadvise_request_no\": \"10316679\",\n" +
            "                \"dispensing_code\": \"2\",\n" +
            "                \"dispensing_name\": \"长口服西药\",\n" +
            "                \"update_time\": \"2018-12-04 11:19:00\",\n" +
            "                \"docadvise_dispensing_no\": \"0\",\n" +
            "                \"increment_id\": 14301670,\n" +
            "                \"execute_user_code\": \"340\",\n" +
            "                \"curr_bed_num\": \"1017\",\n" +
            "                \"administration_time\": \"2018-12-05 12:00:00\",\n" +
            "                \"docadvise_generate_time\": \"2018-12-04 00:00:00\",\n" +
            "                \"execute_dept_code\": \"363\",\n" +
            "                \"create_time\": \"2018-12-04 11:19:00\",\n" +
            "                \"execute_user_name\": \"王可瑞\",\n" +
            "                \"docadvise_no\": \"7457972\",\n" +
            "                \"inpatient_serial_no\": 10399620,\n" +
            "                \"inpat_ward_num\": \"1007\",\n" +
            "                \"execute_no\": \"40475106\",\n" +
            "                \"inpatient_times\": 1,\n" +
            "                \"execute_dept_name\": \"肾脏病科病房\",\n" +
            "                \"pati_index_no\": \"7a8e1c61fce546d796de053a84f1106c\",\n" +
            "                \"collect_time\": \"2018-12-04 11:17:00\",\n" +
            "                \"org_code\": \"1001\",\n" +
            "                \"collect_serial_no\": \"40475106\"\n" +
            "            }\n" +
            "        ]";

    public static String MedicalTestListData = "[{\n" +
            "        \"execute_date\": \"2018-12-14 20:22:00\",\n" +
            "        \"medi_record_no\": \"60190484\",\n" +
            "        \"request_dept_code\": \"1026\",\n" +
            "        \"visit_type\": 2,\n" +
            "        \"remark\": null,\n" +
            "        \"check_doc_name\": \"赵慧丽\",\n" +
            "        \"requestion_no\": null,\n" +
            "        \"test_type_name\": \"降钙素原定量检测\",\n" +
            "        \"request_doc_name\": null,\n" +
            "        \"update_time\": \"2018-12-15 10:29:00\",\n" +
            "        \"execute_doc_name\": \"周盼盼\",\n" +
            "        \"increment_id\": 1025465,\n" +
            "        \"check_date\": \"2018-12-15 10:24:00\",\n" +
            "        \"report_no\": \"A12007727882\",\n" +
            "        \"barcode\": \"A12007727882\",\n" +
            "        \"report_date\": \"2018-12-15 10:24:00\",\n" +
            "        \"request_dept_name\": \"重症医学科（ICU）\",\n" +
            "        \"picture_path\": \"http://10.31.96.39:8089/report/pdfview?reporttype=1&patienttype=1&patientid=10399917&sampleid=A12007727882\",\n" +
            "        \"deliver_time\": \"2018-12-15 05:17:00\",\n" +
            "        \"execute_dept_code\": null,\n" +
            "        \"create_time\": \"2018-12-15 10:29:00\",\n" +
            "        \"sample_type_desc\": \"血清\",\n" +
            "        \"test_type_code\": \"24731\",\n" +
            "        \"docadvise_no\": null,\n" +
            "        \"request_doc_code\": null,\n" +
            "        \"check_doc_code\": null,\n" +
            "        \"receive_date\": \"2018-12-15 08:13:00\",\n" +
            "        \"request_date\": null,\n" +
            "        \"execute_dept_name\": \"免疫组\",\n" +
            "        \"pati_index_no\": null,\n" +
            "        \"mic_inspection_sign\": 0,\n" +
            "        \"sample_type_code\": null,\n" +
            "        \"execute_doc_code\": null,\n" +
            "        \"collect_time\": \"2018-12-15 10:24:00\",\n" +
            "        \"org_code\": \"1001\",\n" +
            "        \"visit_serial_no\": \"10399917\",\n" +
            "        \"collect_serial_no\": \"A12007727882A12007727882\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"execute_date\": \"2018-12-14 20:22:00\",\n" +
            "        \"medi_record_no\": \"60190484\",\n" +
            "        \"request_dept_code\": \"1026\",\n" +
            "        \"visit_type\": 2,\n" +
            "        \"remark\": null,\n" +
            "        \"check_doc_name\": \"杜宁宁\",\n" +
            "        \"requestion_no\": null,\n" +
            "        \"test_type_name\": \"肝肾脂糖电解质测定＋镁\",\n" +
            "        \"request_doc_name\": null,\n" +
            "        \"update_time\": \"2018-12-15 09:49:00\",\n" +
            "        \"execute_doc_name\": \"王雅梅\",\n" +
            "        \"increment_id\": 1025229,\n" +
            "        \"check_date\": \"2018-12-15 09:40:00\",\n" +
            "        \"report_no\": \"A12007727885\",\n" +
            "        \"barcode\": \"A12007727885\",\n" +
            "        \"report_date\": \"2018-12-15 09:40:00\",\n" +
            "        \"request_dept_name\": \"重症医学科（ICU）\",\n" +
            "        \"picture_path\": \"http://10.31.96.39:8089/report/pdfview?reporttype=1&patienttype=1&patientid=10399917&sampleid=A12007727885\",\n" +
            "        \"deliver_time\": \"2018-12-15 05:17:00\",\n" +
            "        \"execute_dept_code\": null,\n" +
            "        \"create_time\": \"2018-12-15 09:49:00\",\n" +
            "        \"sample_type_desc\": \"血清\",\n" +
            "        \"test_type_code\": \"15784\",\n" +
            "        \"docadvise_no\": null,\n" +
            "        \"request_doc_code\": null,\n" +
            "        \"check_doc_code\": null,\n" +
            "        \"receive_date\": \"2018-12-15 08:24:00\",\n" +
            "        \"request_date\": null,\n" +
            "        \"execute_dept_name\": \"生化组\",\n" +
            "        \"pati_index_no\": null,\n" +
            "        \"mic_inspection_sign\": 0,\n" +
            "        \"sample_type_code\": null,\n" +
            "        \"execute_doc_code\": null,\n" +
            "        \"collect_time\": \"2018-12-15 09:40:00\",\n" +
            "        \"org_code\": \"1001\",\n" +
            "        \"visit_serial_no\": \"10399917\",\n" +
            "        \"collect_serial_no\": \"A12007727885A12007727885\"\n" +
            "    }]";
    public static List<TestrepMasteResponse.ResultsBean.ListBean> getMedicalTestList(){
        return new Gson().fromJson(MedicalTestListData, new TypeToken<List<TestrepMasteResponse.ResultsBean.ListBean>>(){}.getType());

    }

    public static String examinationData = " {\n" +
            "        \"execute_date\": \"2018-12-14 19:36:00\",\n" +
            "        \"appoint_range\": \"0:00-23:59\",\n" +
            "        \"medi_record_no\": \"60190484\",\n" +
            "        \"critical_value_flag\": null,\n" +
            "        \"request_dept_code\": \"1026\",\n" +
            "        \"operating_part_name\": \"床边摄影\",\n" +
            "        \"visit_type\": 2,\n" +
            "        \"remark\": null,\n" +
            "        \"exam_item_code\": \"910\",\n" +
            "        \"requestion_no\": \"1856654\",\n" +
            "        \"register_time\": \"2018-12-14 20:36:00\",\n" +
            "        \"exam_result\": \"两肺间质性水肿？心影增大，比较2018-11-21图像水肿、炎症好转。\\r右颈部置管，头端位于T8椎体上缘水平。\",\n" +
            "        \"request_doc_name\": \"李晨\",\n" +
            "        \"device_name\": null,\n" +
            "        \"exam_describe\": \"两侧胸廓对称，气管居中。两肺纹理增多，两肺门增浓。心影普遍增大，心腰变直，两膈面光整，肋膈角锐利。\\r右颈部置管，头端位于T8椎体上缘水平。\",\n" +
            "        \"update_time\": \"2018-12-15 11:09:00\",\n" +
            "        \"increment_id\": 315295,\n" +
            "        \"report_no\": \"DXZY1856654\",\n" +
            "        \"exam_type_name\": \"DX\",\n" +
            "        \"report_date\": \"2018-12-15 11:01:00\",\n" +
            "        \"request_dept_name\": \"重症医学科（ICU）\",\n" +
            "        \"picture_path\": \"http://wpacs.shulan.com/hiswebview/60190484/DXZY1856654?studyUidEnc=DXZY1856654HIS60190484&uidEnc=43b57c10c97a2a3fa46c03ea00b14237&accessionNumber=DXZY1856654\",\n" +
            "        \"execute_dept_code\": \"277\",\n" +
            "        \"create_time\": \"2018-12-15 11:09:00\",\n" +
            "        \"docadvise_no\": \"7579973\",\n" +
            "        \"request_doc_code\": \"00617\",\n" +
            "        \"exam_item_name\": \"胸部床边摄片\",\n" +
            "        \"finish_time\": \"2018-12-15 11:01:00\",\n" +
            "        \"read_flag\": 0,\n" +
            "        \"appoint_order_num\": \"8\",\n" +
            "        \"operating_part_code\": \"26\",\n" +
            "        \"device_code\": null,\n" +
            "        \"request_date\": \"2018-12-14 00:00:00\",\n" +
            "        \"execute_dept_name\": \"重症医学科（ICU）\",\n" +
            "        \"pati_index_no\": null,\n" +
            "        \"exam_type_code\": \"DX\",\n" +
            "        \"collect_time\": \"2018-12-15 11:01:00\",\n" +
            "        \"appoint_date\": \"2018-12-14 00:00:00\",\n" +
            "        \"org_code\": \"1001\",\n" +
            "        \"visit_serial_no\": 10399917,\n" +
            "        \"collect_serial_no\": \"DXZY1856654910\",\n" +
            "        \"check_time\": \"2018-12-15 11:01:00\"\n" +
            "    }";

    public static ExamListResponse.ResultsBean.ListBean getExaminationMsg(){
        return new Gson().fromJson(examinationData, ExamListResponse.ResultsBean.ListBean.class);
    }

    public static String medicalTestDetailList = "{\"execute_date\":\"2018-12-14 20:22:00\",\"critical_value_flag\":0,\"medi_record_no\":\"60190484\",\"request_dept_code\":\"1026\",\"reference_lower_limit\":\"0.00\",\"visit_type\":2,\"remark\":null,\"test_result_describe\":null,\"check_doc_name\":\"赵慧丽\",\"requestion_no\":null,\"test_type_name\":\"降钙素原定量检测\",\"request_doc_name\":null,\"reference_upper_limit\":\"0.50\",\"update_time\":\"2018-12-15 10:29:00\",\"test_item_code\":\"0519\",\"execute_doc_name\":\"周盼盼\",\"increment_id\":13341290,\"check_date\":\"2018-12-15 10:24:00\",\"report_no\":\"A12007727882\",\"barcode\":\"A12007727882\",\"report_date\":\"2018-12-15 10:24:00\",\"request_dept_name\":\"重症医学科（ICU）\",\"picture_path\":\"http://10.31.96.39:8089/report/pdfview?reporttype=1&patienttype=1&patientid=10399917&sampleid=A12007727882\",\"deliver_time\":\"2018-12-15 05:17:00\",\"execute_dept_code\":null,\"result_serial_no\":\"A120077278820519\",\"create_time\":\"2018-12-15 10:29:00\",\"sample_type_desc\":\"血清\",\"test_type_code\":\"24731\",\"docadvise_no\":null,\"test_result_unit\":\"ng/ml\",\"request_doc_code\":null,\"check_doc_code\":null,\"read_flag\":null,\"receive_date\":\"2018-12-15 08:13:00\",\"result_status\":1,\"test_result_value\":\"0.60\",\"test_item_name\":\"降钙素原定量(PCT)测定\",\"request_date\":null,\"execute_dept_name\":\"免疫组\",\"collect_time\":\"2018-12-15 10:24:00\",\"pati_index_no\":null,\"mic_inspection_sign\":0,\"sample_type_code\":null,\"execute_doc_code\":null,\"org_code\":\"1001\",\"collect_serial_no\":\"A12007727882A120077278820519\",\"visit_serial_no\":\"10399917\"}";


    public static TestDetailResponse.ResultsBean.ListBean getTestDetailData(){
        return new Gson().fromJson(medicalTestDetailList, TestDetailResponse.ResultsBean.ListBean.class);
    }

    public static String indicatorDetailList = "[\n" +
            "    {\n" +
            "        \"result_serial_no\": \"A120072427060519\",\n" +
            "        \"create_time\": \"2018-06-30 10:14:00\",\n" +
            "        \"critical_value_flag\": 0,\n" +
            "        \"test_result_unit\": \"ng/ml\",\n" +
            "        \"reference_lower_limit\": \"0.00\",\n" +
            "        \"visit_type\": 2,\n" +
            "        \"test_result_describe\": null,\n" +
            "        \"read_flag\": null,\n" +
            "        \"reference_upper_limit\": \"0.50\",\n" +
            "        \"update_time\": \"2018-06-30 10:14:00\",\n" +
            "        \"test_item_code\": \"0519\",\n" +
            "        \"result_status\": 1,\n" +
            "        \"increment_id\": 6186685,\n" +
            "        \"test_result_value\": \"0.87\",\n" +
            "        \"test_item_name\": \"降钙素原定量(PCT)测定\",\n" +
            "        \"collect_time\": \"2018-06-30 10:14:00\",\n" +
            "        \"report_no\": \"A12007242706\",\n" +
            "        \"org_code\": \"1001\",\n" +
            "        \"collect_serial_no\": \"A12007242706A120072427060519\",\n" +
            "        \"report_date\": \"2018-06-30 10:14:00\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"result_serial_no\": \"A120072485610519\",\n" +
            "        \"create_time\": \"2018-07-04 04:39:00\",\n" +
            "        \"critical_value_flag\": 0,\n" +
            "        \"test_result_unit\": \"ng/ml\",\n" +
            "        \"reference_lower_limit\": \"0.00\",\n" +
            "        \"visit_type\": 2,\n" +
            "        \"test_result_describe\": null,\n" +
            "        \"read_flag\": null,\n" +
            "        \"reference_upper_limit\": \"0.50\",\n" +
            "        \"update_time\": \"2018-07-04 04:39:00\",\n" +
            "        \"test_item_code\": \"0519\",\n" +
            "        \"result_status\": 1,\n" +
            "        \"increment_id\": 6315465,\n" +
            "        \"test_result_value\": \"4.21\",\n" +
            "        \"test_item_name\": \"降钙素原定量(PCT)测定\",\n" +
            "        \"collect_time\": \"2018-07-04 04:35:00\",\n" +
            "        \"report_no\": \"A12007248561\",\n" +
            "        \"org_code\": \"1001\",\n" +
            "        \"collect_serial_no\": \"A12007248561A120072485610519\",\n" +
            "        \"report_date\": \"2018-07-04 04:35:00\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"result_serial_no\": \"A120072534750519\",\n" +
            "        \"create_time\": \"2018-07-04 14:44:00\",\n" +
            "        \"critical_value_flag\": 0,\n" +
            "        \"test_result_unit\": \"ng/ml\",\n" +
            "        \"reference_lower_limit\": \"0.00\",\n" +
            "        \"visit_type\": 2,\n" +
            "        \"test_result_describe\": null,\n" +
            "        \"read_flag\": null,\n" +
            "        \"reference_upper_limit\": \"0.50\",\n" +
            "        \"update_time\": \"2018-07-04 14:44:00\",\n" +
            "        \"test_item_code\": \"0519\",\n" +
            "        \"result_status\": 1,\n" +
            "        \"increment_id\": 6348859,\n" +
            "        \"test_result_value\": \"11.62\",\n" +
            "        \"test_item_name\": \"降钙素原定量(PCT)测定\",\n" +
            "        \"collect_time\": \"2018-07-04 14:40:00\",\n" +
            "        \"report_no\": \"A12007253475\",\n" +
            "        \"org_code\": \"1001\",\n" +
            "        \"collect_serial_no\": \"A12007253475A120072534750519\",\n" +
            "        \"report_date\": \"2018-07-04 14:40:00\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"result_serial_no\": \"A120072875920519\",\n" +
            "        \"create_time\": \"2018-07-20 15:00:00\",\n" +
            "        \"critical_value_flag\": 0,\n" +
            "        \"test_result_unit\": \"ng/ml\",\n" +
            "        \"reference_lower_limit\": \"0.00\",\n" +
            "        \"visit_type\": 2,\n" +
            "        \"test_result_describe\": null,\n" +
            "        \"read_flag\": null,\n" +
            "        \"reference_upper_limit\": \"0.50\",\n" +
            "        \"update_time\": \"2018-07-20 15:00:00\",\n" +
            "        \"test_item_code\": \"0519\",\n" +
            "        \"result_status\": 1,\n" +
            "        \"increment_id\": 7138941,\n" +
            "        \"test_result_value\": \"0.55\",\n" +
            "        \"test_item_name\": \"降钙素原定量(PCT)测定\",\n" +
            "        \"collect_time\": \"2018-07-17 11:36:00\",\n" +
            "        \"report_no\": \"A12007287592\",\n" +
            "        \"org_code\": \"1001\",\n" +
            "        \"collect_serial_no\": \"A12007287592A120072875920519\",\n" +
            "        \"report_date\": \"2018-07-17 11:36:00\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"result_serial_no\": \"A120073093720519\",\n" +
            "        \"create_time\": \"2018-07-24 13:24:00\",\n" +
            "        \"critical_value_flag\": 0,\n" +
            "        \"test_result_unit\": \"ng/ml\",\n" +
            "        \"reference_lower_limit\": \"0.00\",\n" +
            "        \"visit_type\": 2,\n" +
            "        \"test_result_describe\": null,\n" +
            "        \"read_flag\": null,\n" +
            "        \"reference_upper_limit\": \"0.50\",\n" +
            "        \"update_time\": \"2018-07-24 13:24:00\",\n" +
            "        \"test_item_code\": \"0519\",\n" +
            "        \"result_status\": 0,\n" +
            "        \"increment_id\": 7376627,\n" +
            "        \"test_result_value\": \"0.43\",\n" +
            "        \"test_item_name\": \"降钙素原定量(PCT)测定\",\n" +
            "        \"collect_time\": \"2018-07-24 13:23:00\",\n" +
            "        \"report_no\": \"A12007309372\",\n" +
            "        \"org_code\": \"1001\",\n" +
            "        \"collect_serial_no\": \"A12007309372A120073093720519\",\n" +
            "        \"report_date\": \"2018-07-24 13:23:00\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"result_serial_no\": \"A120073960600519\",\n" +
            "        \"create_time\": \"2018-08-24 12:13:00\",\n" +
            "        \"critical_value_flag\": 0,\n" +
            "        \"test_result_unit\": \"ng/ml\",\n" +
            "        \"reference_lower_limit\": \"0.00\",\n" +
            "        \"visit_type\": 2,\n" +
            "        \"test_result_describe\": null,\n" +
            "        \"read_flag\": null,\n" +
            "        \"reference_upper_limit\": \"0.50\",\n" +
            "        \"update_time\": \"2018-08-24 12:13:00\",\n" +
            "        \"test_item_code\": \"0519\",\n" +
            "        \"result_status\": 1,\n" +
            "        \"increment_id\": 8638309,\n" +
            "        \"test_result_value\": \"0.66\",\n" +
            "        \"test_item_name\": \"降钙素原定量(PCT)测定\",\n" +
            "        \"collect_time\": \"2018-08-24 12:09:00\",\n" +
            "        \"report_no\": \"A12007396060\",\n" +
            "        \"org_code\": \"1001\",\n" +
            "        \"collect_serial_no\": \"A12007396060A120073960600519\",\n" +
            "        \"report_date\": \"2018-08-24 12:09:00\"\n" +
            "    }\n" +
            "]";

    public static List<TestAnalyResponse.ResultsBean.ListBean> getTestIndicatorList(){
        return new Gson().fromJson(indicatorDetailList, new TypeToken<List<TestAnalyResponse.ResultsBean.ListBean>>(){}.getType());

    }

    public static String wardRoundData = "昨天 体温 37 ，血压150/80mmHg，心率 107次/分，上消化道出血，双下肢未水肿，少量出汗肌肝 30umol/L, C反应蛋白 35.7mg/L，血红蛋白62g/L, 淋巴细胞(%) 18.9%";
}
