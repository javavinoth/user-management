package com.mycommunityapp.usermanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@JsonIgnoreProperties({"geoLocation"})
public class User extends Principal {

    private String userName;
    private String phoneNumber;
    @ApiModelProperty(hidden = true)
    private String geoLocation;
    private Date dateOfBirth;

}
