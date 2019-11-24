package com.reymond.trac_insta.database;

import androidx.annotation.Keep;

@Keep
public class installation {

    private String installationId;
    private String Datetime;
    private String vehicle_type;
    private String vehicle_no;
    private String device_name;
    private String device_imei_no;
    private String sim_name;
    private String sim_imei_no;
    private String sim_no;
    private String location;
    private String service_time;
    private String service_engineer_name;
    private String site_incharge_name;
    private String authorised_person;


    public String getInstallationId() {
        return installationId;
    }

    public String getDatetime() {
        return Datetime;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public String getVehicle_no() {
        return vehicle_no;
    }

    public String getDevice_name() {
        return device_name;
    }

    public String getDevice_imei_no() {
        return device_imei_no;
    }

    public String getSim_name() {
        return sim_name;
    }

    public String getSim_imei_no() {
        return sim_imei_no;
    }

    public String getSim_no() {
        return sim_no;
    }

    public String getLocation() {
        return location;
    }

    public String getService_time() {
        return service_time;
    }

    public String getService_engineer_name() {
        return service_engineer_name;
    }

    public String getSite_incharge_name() {
        return site_incharge_name;
    }

    public String getAuthorised_person() {
        return authorised_person;
    }



    public installation(String installationId, String datetime, String vehicle_type, String vehicle_no, String device_name, String device_imei_no, String sim_name, String sim_imei_no, String sim_no, String location, String service_time, String service_engineer_name, String site_incharge_name, String authorised_person) {
        this.installationId = installationId;
        this.Datetime = datetime;
        this.vehicle_type = vehicle_type;
        this.vehicle_no = vehicle_no;
        this.device_name = device_name;
        this.device_imei_no = device_imei_no;
        this.sim_name = sim_name;
        this.sim_imei_no = sim_imei_no;
        this.sim_no = sim_no;
        this.location = location;
        this.service_time = service_time;
        this.service_engineer_name = service_engineer_name;
        this.site_incharge_name = site_incharge_name;
        this.authorised_person = authorised_person;
    }



    public installation() {
        //required constructor
    }





}
