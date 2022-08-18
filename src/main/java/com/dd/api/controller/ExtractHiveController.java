package com.dd.api.controller;


import com.dd.api.model.DefaultResponse;
import com.dd.api.model.ExtractCondition;
import com.dd.api.model.StatusEnum;
import com.dd.api.service.ExtractHiveService;
import com.dd.api.service.QueryGenerator;
import com.dd.api.util.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/hive")
@Api("hive extract service")
public class ExtractHiveController {

    @Autowired
    QueryGenerator queryGenerator;

    @Autowired
    ExtractHiveService extractHiveService;

    @ApiOperation("Get classifications guid")
    @GetMapping("/extract")
    public ResponseEntity<DefaultResponse> getClassificationGuid(@RequestBody @Valid ExtractCondition extractCondition,
                                                                 HttpServletRequest request)
             {
        log.info("{} : hive 테이블 에서 데이터를 추출합니다.",extractCondition.getFromTable());

        long startMillis = System.currentTimeMillis();
        String query = queryGenerator.genFullQuery(extractCondition);
        extractHiveService.extractHiveTable(query);
        String endMillis = String.valueOf(System.currentTimeMillis() - startMillis);
        log.info("총 처리 시간은 {}ms 입니다.", endMillis);

        return ResponseUtils.getResponse(StatusEnum.OK,
                "classifications guid search success!!",query);
    }
}

