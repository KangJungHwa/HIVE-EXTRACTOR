package com.dd.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestParameter {

    /**
     * name
     */
    @ApiModelProperty(name = "name", value = "name")
    @JsonProperty("name")
    String name;

    /**
     * guid
     */
    @ApiModelProperty(name = "guid", value = "guid")
    @JsonProperty("guid")
    String guid;
}
