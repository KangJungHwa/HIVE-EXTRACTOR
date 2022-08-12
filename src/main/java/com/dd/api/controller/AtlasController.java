package com.dd.api.controller;

import com.dd.api.model.DefaultResponse;
import com.dd.api.model.Guid;
import com.dd.api.model.RequestParameter;
import com.dd.api.model.StatusEnum;
import com.dd.api.service.AtlasService;
import com.dd.api.util.ResponseUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.atlas.AtlasServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.nio.charset.Charset;

@Slf4j
@RestController
@RequestMapping("/atlas")
@Api("atlas rest service")
public class AtlasController {

    @Autowired
    AtlasService atlasService;

    @Autowired
    @Qualifier("mapper")
    ObjectMapper mapper;

    @ApiOperation("Get classifications guid")
    @GetMapping("/classifications/guid")
    public ResponseEntity<DefaultResponse> getClassificationGuid(@RequestBody @Valid RequestParameter param, HttpServletRequest request)
            throws AtlasServiceException {
        log.info("{} : classification guid를 이름으로 조회 합니다.","");

        long startMillis = System.currentTimeMillis();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        String strGuid=atlasService.getClassificationGuid(param.getName());
        Guid guid=Guid.builder().guid(strGuid).build();
        String endMillis = String.valueOf(System.currentTimeMillis() - startMillis);
        log.info("총 처리 시간은 {}ms 입니다.", endMillis);

        return ResponseUtils.getResponse(StatusEnum.OK,
                "classifications guid search success!!",guid);
    }

    @ApiOperation("Get hive table guid")
    @GetMapping("/hive_table/guid")
    public ResponseEntity<DefaultResponse> getHiveTableGuid(@RequestBody @Valid RequestParameter param, HttpServletRequest request)
            throws AtlasServiceException {
        log.info("{} : hive table guid를 name 파라메터로 조회 합니다.","");

        long startMillis = System.currentTimeMillis();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        String strGuid=atlasService.getTableGuid(param.getName());
        Guid guid=Guid.builder().guid(strGuid).build();
        String endMillis = String.valueOf(System.currentTimeMillis() - startMillis);
        log.info("총 처리 시간은 {}ms 입니다.", endMillis);

        return ResponseUtils.getResponse(StatusEnum.OK,
                "hive table guid search success!!",guid);
    }

    @ApiOperation("Get hive table lineage")
    @GetMapping("/hive_table/lineage")
    public ResponseEntity<DefaultResponse> getlineage(@RequestBody @Valid RequestParameter param, HttpServletRequest request)
            throws AtlasServiceException {
        log.info("{} : hive table lineage를 name 파라메터로 조회 합니다.","");

        long startMillis = System.currentTimeMillis();

        String lineage=atlasService.getLineage(param.getGuid());
        //Guid guid=Guid.builder().guid(guid).build();
        String endMillis = String.valueOf(System.currentTimeMillis() - startMillis);
        log.info("총 처리 시간은 {}ms 입니다.", endMillis);

        return ResponseUtils.getResponse(StatusEnum.OK,
                "hive table lineage search success!!",lineage);
    }
}
