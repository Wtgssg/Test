package com.success;

import cn.hutool.core.date.*;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.format.FastDateFormat;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.poi.excel.*;
import cn.hutool.poi.excel.sax.handler.BeanRowHandler;
import cn.hutool.poi.excel.sax.handler.RowHandler;
import cn.hutool.poi.word.Word07Writer;
import com.success.Pojo.Employee;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.*;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler;
import org.xml.sax.InputSource;

import java.awt.Font;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        File file = new File("D:/Test/test.txt");
        File src = new File("D:/Test/A/a");
        File dest = new File("D:/Test/B");
        Predicate<String> predicate ;
        List<String> context = FileUtil.readLines(file, StandardCharsets.UTF_8);
        System.out.println(context);


        System.out.println("0.1.2");
//        File file = FileUtil.rename(src,"new",true);

//        File file =	FileUtil.copyFilesFromDir( src,  dest, false);


//        //"D:/IdeaProject/JavaSE/测试.docx"
//        Word07Writer writer = new Word07Writer();
//
//        writer.addText(new Font("方正小标宋简体", Font.PLAIN, 22), "我是第一部分", "我是第二部分");
//        writer.addText(new Font("宋体", Font.PLAIN, 22), "我是正文第一部分", "我是正文第二部分");
//        writer.flush(new File("D:/IdeaProject/JavaSE/测试.docx"));
//        writer.close();
//        TimeInterval timeInterval = DateUtil.timer();
//        sleep(3000);
//        System.out.println("从开始到当前的间隔时间："+ timeInterval.intervalPretty());
//
//        System.out.println("起始时间："+ timeInterval.start());
//        sleep(3000);
//        System.out.println("从开始到当前的间隔时间："+ timeInterval.intervalPretty());
//
//        System.out.println("起始时间："+ timeInterval.restart().intervalPretty());
//        sleep(3000);
//        System.out.println("从开始到当前的间隔时间："+ timeInterval.intervalPretty());
//        DateTime birthday = DateUtil.parseDate("2003-8-5");
//        DateTime beginTime = DateUtil.parseDate("2026-8-12 12:24:11");
//        DateTime endTime = DateUtil.parseDate("2026-7-1");
//        DateTime nullTime = null;
//        DateTime now = new DateTime();
//        System.out.println(DateUtil.year(now));

//        int headerRowIndex = 0;
//        int startRowIndex = 0;
//        int endRowIndexEmployee= 5;
//        BeanRowHandler<Employee> beanRowHandler = new BeanRowHandler<Employee>( headerRowIndex,  startRowIndex,  endRowIndexEmployee,Employee.class) {
//            @Override
//            public void handle(int sheetIndex, long rowIndex, List<Object> rowCells) {
//                // 假设日期列在第 3 列（索引 3）
//                if(rowIndex == 0){
//                    return;
//                }
//                DateTime dateStr = (DateTime)rowCells.get(4);
//
//                // 交给父类去转成 POJO
//                super.handle(sheetIndex, rowIndex, rowCells);
//            }
//
//            @Override
//            public void handleData(int sheetIndex, long rowIndex, Employee data) {
//                System.out.println(data);
//            }
//        };
//        ExcelUtil.readBySax("D:/IdeaProject/JavaSE/员工数据.xlsx",0, beanRowHandler);

//        RowHandler handler = new RowHandler() {
//            @Override
//            public void handle(int sheetIndex, long rowIndex, List<Object> rowList) {
//                // sheetIndex: 第几个 Sheet（从0开始）
//                // rowIndex: 第几行（从0开始）
//                // rowList: 这一行的所有单元格数据，按列顺序存放
//                if (rowIndex == 0) {
//                    System.out.println("表头: " + rowList);
//                    return;
//                }
//                System.out.println("Sheet " + sheetIndex + ", 第 " + rowIndex + " 行: " + rowList);
//
//                // 你的业务逻辑：转成对象、入库、校验等
//                if (rowList != null && !rowList.isEmpty()) {
//                    String id = rowList.get(0).toString();
//                    String name = rowList.get(1).toString();
//                    String dept = rowList.get(2).toString();
//                    String salary = rowList.get(3).toString();
//                    String dateTimeS = rowList.get(4).toString();
//                    DateTime dateTime = DateUtil.parse(dateTimeS);
//
//
//                    System.out.println(new Employee(id,name,dept,salary,dateTime));
//                }
//            }
//        };


//        Map<String, String> paramMaps = new HashMap<>();
//        paramMaps.put("A","setId");
//        paramMaps.put("B","setName");
//        paramMaps.put("C","setDept");
//        paramMaps.put("D","setSalary");
//        paramMaps.put("E","setDateTime");
//        List<Employee> employeeList = new ArrayList<>();
//
//
//
//
//        OPCPackage pkg = OPCPackage.open("D:/IdeaProject/JavaSE/员工数据.xlsx");
//        XSSFReader reader= new XSSFReader(pkg);
//        SharedStringsTable sst = reader.getSharedStringsTable();
//        StylesTable styles = reader.getStylesTable();
//
//        InputStream sheetStream = reader.getSheetsData().next();
//        XMLReader parser = XMLReaderFactory.createXMLReader();
//        SheetContentsHandler handler = new SheetContentsHandler(){
//            private Employee currentEmployee = new Employee();
//            private boolean isHeaderRow = true;
//
//            @Override
//            public void startRow(int rowNum) {
//                if (rowNum == 0) {
//                    isHeaderRow = true;
//                } else {
//                    isHeaderRow = false;
//                    // 2. 在这里给成员变量赋值：新建一个对象
//                    currentEmployee = new Employee();
//                }
//            }
//
//            @Override
//            public void endRow(int rowNum) {
//                if (isHeaderRow) return;
//                employeeList.add(currentEmployee);
//            }
//
//            @Override
//            public void cell(String cellReference, String formattedValue, XSSFComment comment) {
//                Class<Employee> clazz = Employee.class;
//
//                String s = cellReference.replaceAll("[0-9]", "");
//                try {
//                    Method method = clazz.getMethod(paramMaps.get(s),String.class);
//                    method.invoke(currentEmployee,formattedValue);
//                } catch (NoSuchMethodException e) {
//                    throw new RuntimeException(e);
//                } catch (InvocationTargetException e) {
//                    throw new RuntimeException(e);
//                } catch (IllegalAccessException e) {
//                    throw new RuntimeException(e);
//                }
//
//
//            }
//        };
//        XSSFSheetXMLHandler sheetHandler = new XSSFSheetXMLHandler(styles, sst, handler, false);
//        parser.setContentHandler(sheetHandler);
//        parser.parse(new InputSource(sheetStream));
//        for (Employee e : employeeList){
//            System.out.println(e);
//        }
//
//        sheetStream.close();

//        ExcelWriter writer = ExcelUtil.getWriter("D:/IdeaProject/JavaSE/员工数据.xlsx");
//        writer.setSheet("employeeList");
//        writer.setCurrentRow(0);
//
//        StyleSet styleSet = writer.getStyleSet();
//
//        styleSet.setFont((short) 0,(short)11,"Maple Mono NF CN",false);

//        styleSet.setAlign(HorizontalAlignment.LEFT, VerticalAlignment.TOP);
//        List<Employee> employeeList = new ArrayList<>();
//        employeeList.add(new Employee("1","张三","管理部门","90000",new DateTime()));
//        Row row = RowUtil.getOrCreateRow(writer.getSheet(),1);
//        List<Object> lists = RowUtil.readRow(row,((cell, value) -> {return value;}));

//        writer.write(employeeList,false);
//        writer.flush();
//        writer.close();

//        ExcelReader reader = ExcelUtil.getReader("D:/IdeaProject/JavaSE/员工数据.xlsx");
//        reader.addHeaderAlias("ID","a");
//        List<List<Object>> list = reader.read(5,8,true);
//        for(Object o : list){
//            System.out.println(o);
//        }
//
//        FileInputStream fileInputStream = new FileInputStream(new File("D:/IdeaProject/JavaSE/员工数据.xlsx"));
//        XSSFWorkbook excel = new XSSFWorkbook(fileInputStream);
//        XSSFSheet sheet = excel.getSheet("employeeList");
//        int lastRowNum = sheet.getLastRowNum();//获取有文字的最后一行行号
//        List<Employee> employeeList = new ArrayList<>();;
//        for (int i = 1 ; i<=3 ; ++i){
//            Employee employee = new Employee();
//            XSSFRow row = sheet.getRow(i);
//
//            employee.setId(row.getCell(0) == null ? "" : row.getCell(0).getStringCellValue());
//            employee.setName(row.getCell(1) == null ? "" : row.getCell(1).getStringCellValue());
//            employee.setDept(row.getCell(2) == null ? "" : row.getCell(2).getStringCellValue());
//            employee.setSalary(row.getCell(3) == null ? "" : row.getCell(3).getStringCellValue());
//
//            employeeList.add(employee);
//        }
//        XSSFRow rowf = sheet.getRow(4);
//        if (rowf != null) {
//            System.out.println(rowf.getCell(3).getCellFormula());
//        }else System.out.println("4 row is null");
//
//
//        for(Employee e : employeeList){
//            System.out.println(e);
//        }
//        fileInputStream.close();

//        String[] headers = {"ID", "姓名", "部门", "薪资"};
//
//        Object[][] data = {
//                {1, "张三", "技术部", 15000},
//                {2, "李四", "产品部", 18000},
//                {3, "王五", "市场部", 12000}
//        };
//
//        XSSFWorkbook workbook = new XSSFWorkbook();
//        XSSFSheet sheet = workbook.createSheet("employeeList");
//        XSSFRow xssfRow = sheet.createRow(0);
//
//        XSSFFont font = workbook.createFont();
//        font.setItalic(true);                  //斜体
//        XSSFCellStyle style = workbook.createCellStyle();
//        style.setFont(font);
//        sheet.addMergedRegion(new CellRangeAddress(4, 4, 0, 3));
//        XSSFRow row = sheet.createRow(4);
//        row.createCell(0).setCellValue("合并单元格");
//
//        for (int i = 0; i < headers.length; i++) {
//            XSSFCell cell = xssfRow.createCell(i);
//            cell.setCellStyle(style);
//            cell.setCellValue(headers[i]);
//
//        }
//
//        for (int i = 0; i < data.length; i++) {
//            XSSFRow xssfRows = sheet.createRow(i+1);
//            for (int j = 0; j < data[i].length; j++) {
//                xssfRows.createCell(j).setCellValue(String.valueOf(data[i][j]));
//
//            }
//        }
//
//
//        try (FileOutputStream fos = new FileOutputStream("员工数据.xlsx")) {
//            workbook.write(fos);
//        }
//
//        System.out.println("Excel 生成成功！");
    }
}