package common.utilities.CSV;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.opencsv.CSVWriter;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.MappingIterator;
import lombok.experimental.UtilityClass;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static com.myntra.constants.ServiceabilityDataFileUploadsPaths.UserDirectory;

@UtilityClass
public class CSVUtils {
    public final static String UserDirectory = System.getProperty("user.dir");

    /**
     * Generate CSV file
     *
     * @param csvData      Csv actual records
     * @param absolutePath of CSV
     * @throws IOException
     */
    public void CreateCSV(List<String[]> csvData, String absolutePath, boolean isAppend) throws IOException {
        FileWriter outputfile = null;
        CSVWriter writer = null;
        try {
            System.out.println("Creating csv file :" + absolutePath);
            outputfile = new FileWriter(UserDirectory + File.separator+ absolutePath, isAppend);
            writer = new CSVWriter(outputfile,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.RFC4180_LINE_END);
            writer.writeAll(csvData);
        } finally {
            if (null != writer)
                writer.close();
            if (null != outputfile)
                outputfile.close();
        }
    }

    public List<Map<String, String>> ReadCSVAsList(String filePath) {
        Map<String, String> record = null;
        List<Map<String, String>> records = new ArrayList<>();
        Path pathToFile = Paths.get(System.getProperty("user.dir") + File.separator + filePath);
        int index = 0;
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            int lineNumber = 0;
            List<String> headers = new ArrayList<>();
            while (line != null) {
                if (lineNumber++ == 0) {
                    headers = Arrays.asList(line.split(",")).stream().map(String::trim).collect(Collectors.toList());
                } else {
                    record = new HashMap<>();
                    index = 0;
                    for (String value : line.split(",")) {
                        record.put(headers.get(index++), value.trim());
                    }
                    records.add(record);
                }
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return records;
    }

    /**
     * Used to Read all the lines in csv file and return List of map
     */
    public List<Map<String, String>> ReadCsvAsListOfMap(String filePath) {
        Map<String, String> record = null;
        List<Map<String, String>> records = new ArrayList<>();
        Path pathToFile = Paths.get(filePath);
        int index = 0;
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            int lineNumber = 0;
            List<String> headers = new ArrayList<>();
            while (line != null) {
                if (lineNumber++ == 0) {
                    headers = Arrays.asList(line.split(","));
                } else {
                    record = new HashMap<>();
                    index = 0;
                    for (String value : line.split(",")) {
                        record.put(headers.get(index++), value);
                    }
                    records.add(record);
                }
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return records;
    }

    /**
     * @param classType should have @JsonPropertyOrder({"col1", "col2"s}) in the pojo to maintain order
     */
    public <T> List<T> ConvertCsvToObject(Class<T> classType, String csvFilePath) throws IOException {
        MappingIterator<T> readValues =null;
        List<T>  csvObjectList = null;
        try (FileInputStream fileInputStream = new FileInputStream(csvFilePath)) {
            CsvMapper mapper = new CsvMapper();
            mapper.enable(CsvParser.Feature.TRIM_SPACES);
            CsvSchema bootstrapSchema = mapper
                    .schemaFor(classType)
                    .withSkipFirstDataRow(true)
                    .withoutHeader()
                    .withColumnSeparator(',');
            readValues = mapper.readerFor(classType).with(bootstrapSchema).readValues(fileInputStream);
            csvObjectList = readValues.readAll();
        }
        return csvObjectList;
    }
}
