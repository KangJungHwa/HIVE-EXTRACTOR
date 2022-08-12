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
public class DefaultResponse {

    /**
     * resultCode
     */
    @ApiModelProperty(name = "resultCode", value = "resultCode")
    @JsonProperty("resultCode")
    private String resultCode;

    /**
     * result
     */
    @ApiModelProperty(name = "result", value = "result")
    @JsonProperty("result")
    private String result;

    /**
     * data
     */
    @ApiModelProperty(name = "data", value = "리턴 데이터")
    @JsonProperty("data")
    private Object data;
}
