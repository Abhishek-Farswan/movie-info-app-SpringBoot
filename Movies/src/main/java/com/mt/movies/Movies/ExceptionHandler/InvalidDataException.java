package com.mt.movies.Movies.ExceptionHandler;

public class InvalidDataException extends RuntimeException{

    private String errCode;
    private String errMsg;

    public InvalidDataException(){}

    public InvalidDataException(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
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
        return "InvalidDataException:\n" +
                "Error Code='" + errCode + '\'' +
                "\nError Messages='" + errMsg + '\'';
    }

}
