package com.kruma.core.notification.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by John on 27/06/2016.
 */
public class MailEntry {

    //region VARIABLES
    @SerializedName("To")
    public String to;

    @SerializedName("From")
    public String from;

    @SerializedName("CC")
    public String cc;

    @SerializedName("BCC")
    public String bcc;

    @SerializedName("Subject")
    public String subject;

    @SerializedName("Body")
    public String body;

    @SerializedName("IdTipoCorreo")
    public MailType idTipoCorreo;

    @SerializedName("IsHTML")
    public Boolean isHTML;

    //region PROPIEDADES
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public MailType getIdTipoCorreo() {
        return idTipoCorreo;
    }

    public void setIdTipoCorreo(MailType idTipoCorreo) {
        this.idTipoCorreo = idTipoCorreo;
    }

    public Boolean getIsHTML() {
        return isHTML;
    }

    public void setIsHTML(Boolean isHTML) {
        this.isHTML = isHTML;
    }
    //endregion

}
