package com.myPortfolioGramback.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Success {
    private boolean success = false;
    private Object result = null;
    private Error error = new Error();

    public Success() {
    }

    public Success(boolean flag) {
        success = flag;
    }


    @Getter
    @Setter
    class Error {
        private String code;
        private String msg;
    }

    public void setErrorMsg(String msg) {
        this.error.setMsg(msg);
    }

    public void setErrorCode(String code) {
        this.error.setCode(code);
    }

    public String getErrorCode() {
        return this.error.getCode();
    }

    public String getErrorMsg() {
        return this.error.getMsg();
    }
}

