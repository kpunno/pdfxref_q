package org.acme;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.multipdf.Splitter;
import org.jboss.resteasy.reactive.multipart.FileUpload;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UploadService {
    public String handleUpload(FileUpload fileUpload) throws IOException {
        // Unpack file from request
        Path filepath = fileUpload.uploadedFile();
        File file = filepath.toFile();
        try (PDDocument doc = Loader.loadPDF(file)) {
            // Split pages
            PDFTextStripper pdf_ts = new PDFTextStripper();
            Splitter splitter = new Splitter();
            List<PDDocument> pages = splitter.split(doc);
            // Get first page
            PDDocument page = pages.get(0);
            // Return text as HTTP response
            return pdf_ts.getText(page);
        }
    }
}
