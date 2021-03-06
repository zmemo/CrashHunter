package com.memo.captor;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;

/**
 * title:崩溃信息
 * describe:
 *
 * @author zhou
 * @date 2019-02-12 19:59
 */
public class CrashInfo implements Parcelable {

    /**
     * 崩溃主信息
     */
    private String exceptionMsg;

    /**
     * 崩溃类名
     */
    private String className;

    /**
     * 崩溃文件名
     */
    private String fileName;

    /**
     * 崩溃方法
     */
    private String methodName;

    /**
     * 崩溃行数
     */
    private int lineNumber;

    /**
     * 崩溃类型
     */
    private String exceptionType;

    /**
     * 全部信息
     */
    private String fullException;

    /**
     * 设备名
     */
    private String model = Build.MODEL;

    /**
     * 设备厂商
     */
    private String brand = Build.BRAND;

    /**
     * 崩溃时间
     */
    @SuppressLint("SimpleDateFormat")
    private String time =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());

    public static final Creator<CrashInfo> CREATOR = new Creator<CrashInfo>() {
        @Override
        public CrashInfo createFromParcel(Parcel source) {return new CrashInfo(source);}

        @Override
        public CrashInfo[] newArray(int size) {return new CrashInfo[size];}
    };

    CrashInfo() {}

    public String getExceptionMsg() { return exceptionMsg; }

    public void setExceptionMsg(String exceptionMsg) { this.exceptionMsg = exceptionMsg; }

    public String getClassName() { return className; }

    public void setClassName(String className) { this.className = className; }

    public String getFileName() { return fileName; }

    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getMethodName() { return methodName; }

    public void setMethodName(String methodName) { this.methodName = methodName; }

    public int getLineNumber() { return lineNumber; }

    public void setLineNumber(int lineNumber) { this.lineNumber = lineNumber; }

    public String getExceptionType() { return exceptionType; }

    public void setExceptionType(String exceptionType) { this.exceptionType = exceptionType; }

    public String getFullException() { return fullException; }

    public void setFullException(String fullException) { this.fullException = fullException; }

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }

    public String getModel() { return model; }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() { return brand; }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "崩溃信息: " + "\n" + this.getExceptionMsg() + "\n" +
                "文件: " + this.getFileName() + "\n" +
                "类名: " + this.getClassName() + "\n" +
                "方法: " + this.getMethodName() + "\n" +
                "行数: " + this.getLineNumber() + "\n" +
                "类型: " + this.getExceptionType() + "\n" +
                "时间: " + this.getTime() + "\n" +
                "设备名称: " + this.getModel() + "\n" +
                "设备厂商: " + this.getBrand() + "\n" +
                "系统版本: " + this.getVersion() + "\n" +
                "全部信息: " + "\n" + this.getFullException() + "\n";
    }
    /**
     * 系统版本号
     */
    private String version = "Api " + Build.VERSION.SDK_INT;

    private CrashInfo(Parcel in) {
        this.exceptionMsg = in.readString();
        this.className = in.readString();
        this.fileName = in.readString();
        this.methodName = in.readString();
        this.lineNumber = in.readInt();
        this.exceptionType = in.readString();
        this.fullException = in.readString();
        this.time = in.readString();
        this.model = in.readString();
        this.brand = in.readString();
        this.version = in.readString();
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.exceptionMsg);
        dest.writeString(this.className);
        dest.writeString(this.fileName);
        dest.writeString(this.methodName);
        dest.writeInt(this.lineNumber);
        dest.writeString(this.exceptionType);
        dest.writeString(this.fullException);
        dest.writeString(this.time);
        dest.writeString(this.model);
        dest.writeString(this.brand);
        dest.writeString(this.version);
    }
}
