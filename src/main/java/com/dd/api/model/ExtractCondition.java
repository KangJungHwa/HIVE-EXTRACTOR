package com.dd.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtractCondition {

    @ApiModelProperty(name = "selectColumn", value = "selectColumn")
    @JsonProperty("selectColumn")
    List<String> selectColumn;

    @ApiModelProperty(name = "fromTable", value = "fromTable")
    @JsonProperty("fromTable")
    String fromTable;

    @ApiModelProperty(name = "whereFrom", value = "whereFrom")
    @JsonProperty("whereFrom")
    Condition whereFrom;

    @ApiModelProperty(name = "whereTo", value = "whereTo")
    @JsonProperty("whereTo")
    Condition whereTo;

    @ApiModelProperty(name = "whereIn", value = "whereIn")
    @JsonProperty("whereIn")
    List<Condition> whereIn;

    @ApiModelProperty(name = "whereEqual", value = "whereEqual")
    @JsonProperty("whereEqual")
    List<Condition> whereEqual;

}
