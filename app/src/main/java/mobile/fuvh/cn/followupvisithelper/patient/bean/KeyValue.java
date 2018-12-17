package mobile.fuvh.cn.followupvisithelper.patient.bean;

import java.io.Serializable;
import java.util.List;

import cn.wowjoy.commonlibrary.bean.BaseResponse;

public class KeyValue extends BaseResponse<KeyValue.ResultsBean> implements Serializable {

    public static class ResultsBean implements Serializable {
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable {
            private String key;
            private String value;

            public ListBean(String key, String value) {
                this.key = key;
                this.value = value;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }

}
