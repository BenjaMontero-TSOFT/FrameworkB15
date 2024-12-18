package framework.engine.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

public class DataDriven {

    static Properties properties;

    public static ArrayList<String> getTestData(String nameCp, String pathToExcel, String tittleOfCps) {
        ArrayList<String> data = new ArrayList<String>();

        FileInputStream file = null;
        try {
            file = new FileInputStream(System.getProperty("user.dir")+"/"+pathToExcel);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        XSSFWorkbook excel = null;
        try {
            excel = new XSSFWorkbook(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int sheets = excel.getNumberOfSheets();
        String[] partsOfNameCP = nameCp.split("-");

        for(int i =0; i< sheets;i++){
            String sheetName = excel.getSheetName(i).toLowerCase();
            if(sheetName.toLowerCase().charAt(0) == partsOfNameCP[1].toLowerCase().charAt(0)){
                XSSFSheet hojaExcel = excel.getSheetAt(i);

                Iterator<Row> filas = hojaExcel.iterator();

                Row fila = filas.next();

                Iterator<Cell> celdas = fila.cellIterator();

                int k=0;
                int columna =0;
                while(celdas.hasNext()){
                    Cell celdaSelecciona = celdas.next();
                    if(celdaSelecciona.getStringCellValue().equalsIgnoreCase(tittleOfCps)){
                        //Encontre la columna con los nombres de los casos de prueba
                        columna = k;
                    }
                    k++;
                }

                while(filas.hasNext()){
                    Row r = filas.next();

                    if(r.getCell(columna).getStringCellValue().equalsIgnoreCase(nameCp)){

                        Iterator<Cell> cv =r.cellIterator();

                        while(cv.hasNext()){
                            Cell cell = cv.next();

                            if(cell.getCellType() == CellType.STRING){
                                //System.out.println(cell.getStringCellValue());
                                data.add(cell.getStringCellValue());
                            }else if(cell.getCellType() == CellType.NUMERIC){
                                String valorCelda = NumberToTextConverter.toText(cell.getNumericCellValue());
                                //System.out.println(valorCelda);
                                data.add(valorCelda);
                            }
                        }
                    }

                }

            }
        }
        return data;
    }

}
