import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Document document = new Document(1, "123456");
        ReportService reportService = new ReportService();

        // Формирование PDF-файла
        byte[] pdfReport = reportService.createReport(document, "pdf-1");
        System.out.println("PDF Report: " + new String(pdfReport));

        // Формирование JSON-файла
        byte[] jsonReport = reportService.createReport(document, "json");
        System.out.println("JSON Report: " + new String(jsonReport));

        // Формирование XML-файла
        byte[] xmlReport = reportService.createReport(document, "xml");
        System.out.println("XML Report: " + new String(xmlReport));

        // Формирование другого типа отчета
        byte[] customReport = reportService.createReport(document, "custom");
        System.out.println("Custom Report: " + new String(customReport));
    }

    static class ReportService {
        private Map<String, ReportGenerator> reportGenerators;

        public ReportService() {
            reportGenerators = new HashMap<>();
            reportGenerators.put("pdf-1", new PDFReportGenerator());
            reportGenerators.put("json", new JSONReportGenerator());
            reportGenerators.put("xml", new XMLReportGenerator());
        }

        public byte[] createReport(Document document, String reportType) {
            ReportGenerator reportGenerator = reportGenerators.get(reportType);
            if (reportGenerator == null) {
                throw new UnsupportedOperationException("Unsupported report type: " + reportType);
            }
            return reportGenerator.generateReport(document);
        }
    }

    static interface ReportGenerator {
        byte[] generateReport(Document document);
    }

    static class PDFReportGenerator implements ReportGenerator {
        public byte[] generateReport(Document document) {
            // Логика формирования PDF-отчета
            String report = "PDF Report for document with id " + document.getId();
            return report.getBytes();
        }
    }

    static class JSONReportGenerator implements ReportGenerator {
        public byte[] generateReport(Document document) {
            // Логика формирования JSON-отчета
            String report = "JSON Report for document with number " + document.getNumber();
            return report.getBytes();
        }
    }

    static class XMLReportGenerator implements ReportGenerator {
        public byte[] generateReport(Document document) {
            // Логика формирования XML-отчета
            String report = "XML Report for document with id " + document.getId() + " and number " + document.getNumber();
            return report.getBytes();
        }
    }

    static class Document {
        private long id;
        private String number;

        public Document(long id, String number) {
            this.id = id;
            this.number = number;
        }

        public long getId() {
            return id;
        }

        public String getNumber() {
            return number;
        }
    }

}