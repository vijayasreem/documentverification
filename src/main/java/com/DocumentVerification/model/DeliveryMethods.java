package com.DocumentVerification.model;

import javax.persistence.*;

@Entity
public class DeliveryMethods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String ftpUrl;

    private String sharepointUrl;

    private String deliverySchedule;

    private String fileTypeTransformation;

    private String successNotifications;

    public DeliveryMethods() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFtpUrl() {
        return ftpUrl;
    }

    public void setFtpUrl(String ftpUrl) {
        this.ftpUrl = ftpUrl;
    }

    public String getSharepointUrl() {
        return sharepointUrl;
    }

    public void setSharepointUrl(String sharepointUrl) {
        this.sharepointUrl = sharepointUrl;
    }

    public String getDeliverySchedule() {
        return deliverySchedule;
    }

    public void setDeliverySchedule(String deliverySchedule) {
        this.deliverySchedule = deliverySchedule;
    }

    public String getFileTypeTransformation() {
        return fileTypeTransformation;
    }

    public void setFileTypeTransformation(String fileTypeTransformation) {
        this.fileTypeTransformation = fileTypeTransformation;
    }

    public String getSuccessNotifications() {
        return successNotifications;
    }

    public void setSuccessNotifications(String successNotifications) {
        this.successNotifications = successNotifications;
    }
}