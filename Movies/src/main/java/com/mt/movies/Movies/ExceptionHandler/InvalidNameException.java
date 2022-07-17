package com.mt.movies.Movies.ExceptionHandler;

public class InvalidNameException extends RuntimeException{

    private String errCode;
    private String errMsg;
    private String data;

    public InvalidNameException(){}

    public InvalidNameException(String errCode, String errMsg,String data) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.data=data;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "InvalidNameException:\n" +
                "Error Code='" + errCode + '\'' +
                "\nError Message='" + errMsg +
                "\nFull Movie Details:\n"+data;
    }
}
