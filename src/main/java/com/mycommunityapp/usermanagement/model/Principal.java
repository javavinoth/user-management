package com.mycommunityapp.usermanagement.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;

@Data
@JsonIgnoreProperties({"creationDate", "lastUpdate", "passwordChangeDate", "failedLoginCount", "password", "unLock"})
public class Principal {

    @ApiModelProperty(hidden = true)
    @Setter(value = AccessLevel.NONE)
    @Id
    private String id;
    private String email;
    @ApiModelProperty(hidden = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @ApiModelProperty(hidden = true)
    private Date creationDate;
    @ApiModelProperty(hidden = true)
    private Date lastUpdate;
    @ApiModelProperty(hidden = true)
    private Boolean isActive;
    @ApiModelProperty(hidden = true)
    private Boolean isLocked;
    @ApiModelProperty(hidden = true)
    private Boolean accountExpired;
    @ApiModelProperty(hidden = true)
    private Date unLock;
    @ApiModelProperty(hidden = true)
    private Date passwordChangeDate;
    @ApiModelProperty(hidden = true)
    private Integer failedLoginCount;


}
