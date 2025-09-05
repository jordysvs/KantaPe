package com.kruma.core.log.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by John on 27/06/2016.
 */
public class LogEntry {

    //region VARIABLES
    @SerializedName("Title")
    private String title;

    @SerializedName("Message")
    private String message;

    @SerializedName("Date")
    private java.util.Date date;

    @SerializedName("Type")
    private LogEntryType type;
    //endregion

    //region CONSTRUCTORES
    public LogEntry(String str_pTitle, String str_pMessage) {
        this(str_pTitle, str_pMessage, LogEntryType.Information);

    }

    public LogEntry(String str_pTitle, String str_pMessage, LogEntryType obj_pLogEntryType) {
        this.title = str_pTitle;
        this.message = str_pMessage;
        this.date = new Date();
        this.type = obj_pLogEntryType;
    }
    //endregion

    //region PROPIEDADES
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LogEntryType getType() {
        return type;
    }

    public void setType(LogEntryType type) {
        this.type = type;
    }
    //endregion
}
