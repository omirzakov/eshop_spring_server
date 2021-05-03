package com.csse.restapi.restapireact.pdfgenerator;

import com.itextpdf.html2pdf.HtmlConverter;

import java.io.File;
import java.io.IOException;

public class CreditPDFGenerator {

    public static void main(String[] args) throws IOException {
        HtmlConverter.convertToPdf(new File("./creditpdf.html"), new File("credit_check.pdf"));
    }
}
