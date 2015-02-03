package br.com.dotbuild;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.FilteredTextRenderListener;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.RegionTextRenderFilter;
import com.itextpdf.text.pdf.parser.RenderFilter;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class TesteLocalizado2 {

	/** The original PDF that will be parsed. */
    public static final String PREFACE = "C:\\Projetos - arquivos locais\\Vila Velha\\txt\\2010\\Ficha Financeira 2010.pdf";
    /** The resulting text file. */
    public static final String RESULT = "C:\\Projetos - arquivos locais\\Vila Velha\\txt\\2009\\teste\\teste3.txt";
 
    /**
     * Parses a PDF to a plain text file.
     * @param pdf the original PDF
     * @param txt the resulting text
     * @throws IOException
     */
    public void parsePdf(String pdf, String txt) throws IOException {
    	PdfReader reader = new PdfReader(pdf);
    	PdfReaderContentParser parser = new PdfReaderContentParser(reader);
    	PrintWriter out = new PrintWriter(new FileOutputStream(txt));
    	TextExtractionStrategy strategy;
    	for (int i = 1; i <= reader.getNumberOfPages(); i++) {
    	strategy = parser.processContent(i, new LocationTextExtractionStrategy());
    	out.println(strategy.getResultantText());
    	}
    	out.flush();
    	out.close();
    }
    
    public static void main(String[] args) throws IOException {
        new TesteLocalizado().parsePdf(PREFACE, RESULT);
    }
}
