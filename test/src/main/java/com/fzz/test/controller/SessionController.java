package com.fzz.test.controller;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

@RestController
public class SessionController {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @RequestMapping("uid")
    String uid(HttpSession httpSession) {
        UUID uuid = (UUID) httpSession.getAttribute("uid");
        if (uuid == null) {


            uuid = UUID.randomUUID();
            System.out.println("asdf");

        }
        httpSession.setAttribute("uid", uuid);
        return httpSession.getId();
    }

    @RequestMapping("asdf")
    String asdf() {
        String sql;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File("G:\\标准库.xls"));
            //fileInputStream = new FileInputStream(new File("G:\\test.xls"));
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);
                int rowNum = sheet.getLastRowNum() + 1;
                for (int i1 = 0; i1 < rowNum; i1++) {
                    Row row = sheet.getRow(i1);
                    if (row == null) continue;
                    sql = row.getCell(12).toString();
                    String aj="";
                    if (row.getCell(6) != null) {
                        aj = row.getCell(6).toString();
                    }



                    try {
                        jdbcTemplate.execute(sql);

                    } catch (Exception e) {

                        //System.out.println("qwerqwer");
                        if (!sql.equals("对应SQL")  ) {

                            System.out.println(i + "   " + i1);
                            System.out.println(sql);
                            sheet.removeRow(row);
                        }

                    }





                }
            }
            FileOutputStream os = new FileOutputStream("G:\\test.xls");
            workbook.write(os);
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "fadfs";
    }

}
