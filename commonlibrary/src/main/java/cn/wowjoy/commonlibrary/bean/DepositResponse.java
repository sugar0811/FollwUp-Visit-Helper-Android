package cn.wowjoy.commonlibrary.bean;

import java.math.BigDecimal;
import java.util.List;

public class DepositResponse extends BaseResponse<DepositResponse.DepositData>{

    public class DepositData {
        public List<DepositBank> deposit_bank;
    }

    public static class DepositBank {

        /**
         * code : 001
         * value : 中国工商银行
         * order : 1
         */

        private String code;
        private String value;
        private BigDecimal order;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public BigDecimal getOrder() {
            return order;
        }

        public void setOrder(BigDecimal order) {
            this.order = order;
        }

        public DepositBank() {
        }

        public DepositBank(String code, String value, BigDecimal order) {
            this.code = code;
            this.value = value;
            this.order = order;
        }
    }


}
