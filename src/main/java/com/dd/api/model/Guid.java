package com.dd.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Guid {

    /**
     * guid
     */
    @ApiModelProperty(name = "guid", value = "guid")
    @JsonProperty("guid")
    String guid;
}
