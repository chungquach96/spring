package com.viettel.demo.schedule_tasks;

import com.viettel.demo.models.Client;
import com.viettel.demo.service.ClientService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class auto_export_report {

    @Autowired
    private ClientService clientService;

    @Scheduled(fixedRate = 10000)
    public void ScheduleTaskWithFixedRate(){
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet sheet = xssfWorkbook.createSheet("Client_Info");
        int rowNum = 0;
        List<Client> clients = clientService.getAllClient();
        for (Client c : clients){
            Row row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(c.getCliNo());

            Cell cell2 = row.createCell(1);
            cell2.setCellValue(c.getFullName());

            Cell cell3 = row.createCell(2);
            cell3.setCellValue(c.getBirthDay());
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(new File("Client_Info.xlsx"));
            xssfWorkbook.write(outputStream);
            xssfWorkbook.close();
            System.out.println("Done");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
