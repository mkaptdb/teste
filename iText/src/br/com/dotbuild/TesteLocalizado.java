package br.com.dotbuild;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
 
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.FilteredTextRenderListener;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.RegionTextRenderFilter;
import com.itextpdf.text.pdf.parser.RenderFilter;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class TesteLocalizado {

	/** The original PDF that will be parsed. */
    public static final String PREFACE = "C:\\Projetos - arquivos locais\\Vila Velha2\\11_2009.pdf";
    /** The resulting text file. */
    public static final String RESULT = "C:\\Projetos - arquivos locais\\Vila Velha2\\teste.txt";
 
    /**
     * Parses a PDF to a plain text file.
     * @param pdf the original PDF
     * @param txt the resulting text
     * @throws IOException
     */
    public void parsePdf(String pdf, String txt) throws IOException {
        PdfReader reader = new PdfReader(pdf);
        PrintWriter out = new PrintWriter(new FileOutputStream(txt));
        
     //   Rectangle rect = new Rectangle(60, 100, 438, 1000);
     //   RenderFilter filter = new RegionTextRenderFilter(rect);
        TextExtractionStrategy strategy;
        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy()/*, filter*/);
            out.println(PdfTextExtractor.getTextFromPage(reader, i, strategy));
        }
        out.flush();
        out.close();
        reader.close();
    }
    
    public static void main(String[] args) throws IOException {
        new TesteLocalizado().parsePdf(PREFACE, RESULT);
    }

}
