package com.veken.rxjavaretrofitdemo.module.bean;

/**
 * Created by suxi on 2017/5/31.
 */

public class LoginRespond extends BaseRespond {

    /**
     * data : {"realName":null,"identification":"1","telphone":null,"sessionId":"71D84145E839239E75F6DCCBB6C8FEB0","email":null,"headerImg":null}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * realName : null
         * identification : 1
         * telphone : null
         * sessionId : 71D84145E839239E75F6DCCBB6C8FEB0
         * email : null
         * headerImg : null
         */

        private String realName;
        private String identification;
        private String telphone;
        private String sessionId;
        private String email;
        private String headerImg;
        private String bankNoState;

        public String getBankNoState() {
            return bankNoState;
        }

        public void setBankNoState(String bankNoState) {
            this.bankNoState = bankNoState;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getIdentification() {
            return identification;
        }

        public void setIdentification(String identification) {
            this.identification = identification;
        }

        public String getTelphone() {
            return telphone;
        }

        public void setTelphone(String telphone) {
            this.telphone = telphone;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getHeaderImg() {
            return headerImg;
        }

        public void setHeaderImg(String headerImg) {
            this.headerImg = headerImg;
        }
    }
}
