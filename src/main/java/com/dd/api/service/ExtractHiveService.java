package com.dd.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVPrinter;

@Service
@Slf4j
public class ExtractHiveService {
//
//
//    public String extractHiveTable(String sql) {
//        ResultSet rs=null;
//        Statement stmt=null;
//        Connection con=null;
//        try {
//
//            HiveConnectionUtils connectionUtils = new HiveConnectionUtils();
//            con = connectionUtils.getConnection();
//            stmt = con.createStatement();
//
//            System.out.println("Running: " + sql);
//            rs= stmt.executeQuery(sql);
//            CSVPrinter csvPrinter = new CSVPrinter(new FileWriter("c://DEV/ABC.CSV"),  CSVFormat.DEFAULT.withHeader(rs));
//            csvPrinter.printRecords(rs);
//            csvPrinter.close();
//        } catch (Exception e) {
//            log.error("ERROR : ",e);
//        }finally {
//            if(rs!=null) {try {rs.close();} catch (Exception e) {log.error("ERROR : ",e);}}
//            if(stmt!=null) {try {stmt.close();} catch (Exception e) {log.error("ERROR : ",e);}}
//            if(con!=null) {try {con.close();} catch (Exception e) {log.error("ERROR : ",e);}}
//        }
//        return "OK";
//    }
}
