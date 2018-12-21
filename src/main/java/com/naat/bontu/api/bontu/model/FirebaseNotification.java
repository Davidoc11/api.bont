package com.naat.bontu.api.bontu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class FirebaseNotification {

    @JsonProperty("registration_ids")
    List<String> registrationIds;
    @JsonProperty("data")
    Map<String,String> data;
}
