package com.liuhao.bishe.easypoiUtil;

import cn.afterturn.easypoi.excel.ExcelExportUtil;

import cn.afterturn.easypoi.excel.entity.ExportParams;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;


import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Collection;
@Slf4j
public class EasyPoiUtil {
    public static void exportExcel(Collection<?> data, String title, String sheetName,  String fileName,Class<?> pojoClass, boolean isCreateHeader, boolean isNeedSignature , HttpServletResponse response) throws Exception {
        ExportParams exportParams = new ExportParams(title, sheetName);
        exportParams.setCreateHeadRows(isCreateHeader);
        exportParams.setStyle(KscExcelStyle.class);
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, data);
        //如果需页底要有签名，则需要合并单元格并为其设置样式和签名模板内容
        if (isNeedSignature) {
            Sheet sheet = workbook.getSheet(sheetName);
            int lastRowNum = sheet.getLastRowNum();
            short lastCellNum = sheet.getRow(2).getLastCellNum();
            CellRangeAddress rangeAddress = new CellRangeAddress(lastRowNum+1 , lastRowNum+2 , 0, lastCellNum-1);
            sheet.addMergedRegion(rangeAddress);
            Cell signatureCell = sheet.createRow(lastRowNum + 1).createCell(0);
            CellStyle signatureCellStyle = workbook.createCellStyle();
            signatureCellStyle.setAlignment(HorizontalAlignment.RIGHT);
            signatureCell.setCellStyle(signatureCellStyle);
            signatureCell.setCellValue("签名：             日期:               ");
            workbook.write(new FileOutputStream("E:/excel/e.xls"));
        }
        //使用response将workbook内容写回浏览器
        //downLoadExcel(fileName,response,workbook);

    }


    private static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) throws Exception {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            System.out.println("导出异常");
        }
    }





}
