package APSEC;

import org.apache.pdfbox.cos.*;
import org.apache.pdfbox.io.*;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.*;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;

/**
 * Created by INSRSAI1 on 6/3/2016.
 */
public class PurchaseOrderParser {

    public static void extractPONumber(String po){
        String temp = po.substring(po.indexOf("PO Number"),po.indexOf("Kind Attention"));
        int currency = temp.indexOf("Currency");
        temp = temp.substring(currency, currency+25);
        temp = temp.replaceAll("Currency", "");
        temp=temp.trim();
        System.out.println("Purchase Order Number : " + temp);
    }

    public static void extractTermsOfDelivery(String po){
        String temp = po.substring(po.indexOf("Terms of Delivery:"),po.indexOf("ECC No.:"));
        temp = temp.replaceAll("Terms of Delivery:","");
        temp = temp.trim();
        System.out.println("Terms of Delivery : " + temp);
    }

    public static void extractTermsOfPayment(String po){
        String temp = po.substring(po.indexOf("Terms of Payment:"),po.indexOf("Phone"));
        temp = temp.replaceAll("Terms of Payment:","");
        temp = temp.trim();
        System.out.println("Terms of Payment : " + temp);
    }

    public static void extractDeliveryDate(String po){
        String temp = po.substring(po.indexOf("Deliv. Date:"), po.indexOf("Deliv. Date:")+31);
        temp = temp.replace("Deliv. Date:", "");
        System.out.println("Delivery Date : " + temp.trim());
    }

    public static void extractVAT(String po){
        String temp = po.substring(po.indexOf("VAT"), po.indexOf("VAT")+21);
        temp = temp.replace("VAT", "");
        System.out.println("VAT : " + temp.trim());
    }

    public static void main(String[] args) {
        PDFTextStripper pdfStripper = null;
        PDDocument pdDoc = null;
        COSDocument cosDoc = null;
        File file = new File("C:\\Users\\insrsai1\\Documents\\011-APSEC\\3.pdf");
        try {
            PDFParser parser = new PDFParser(new RandomAccessFile(file, "r"));
            parser.parse();
            cosDoc = parser.getDocument();
            pdfStripper = new PDFTextStripper();
            pdDoc = new PDDocument(cosDoc);
            pdfStripper.setStartPage(1);
            pdfStripper.setEndPage(2);
            String parsedText = pdfStripper.getText(pdDoc);
            //System.out.println(parsedText);
            extractPONumber(parsedText);
            System.out.println();
            extractTermsOfDelivery(parsedText);
            System.out.println();
            extractTermsOfPayment(parsedText);
            System.out.println();
            extractDeliveryDate(parsedText);
            System.out.println();
            extractVAT(parsedText);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
