package proyecto.sheintap;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*; 
import javax.swing.JOptionPane;

/**
 * Example of using the iText library to work with PDF documents on Java, 
 * lets you create, analyze, modify and maintain documents in this format.
 * Ejemplo de uso de la librería iText para trabajar con documentos PDF en Java, 
 * nos permite crear, analizar, modificar y mantener documentos en este formato.
 *
 * @author xules You can follow me on my website http://www.codigoxules.org/en
 * Puedes seguirme en mi web http://www.codigoxules.org
 */
public class GeneratePDFFileIText {
    // Fonts definitions (Definición de fuentes).
    private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);   
    private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);    
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private static final String iTextExampleImage = "C:\\shein.png";
    ClaseDatosPedidos clasedatos= new ClaseDatosPedidos();
    
    //Variables que se usan dentro del proyecto para generar correctamente el pdf
    public String nombre, numcel, nociclo; 
    public String consultapedidos[][];
    public int total, cantidadart, conteo;
    BaseDatosPedidosPendientes p;
    
    public void recibirDatos(String nombre, String numcel, String nociclo){
        this.nombre= nombre;
        this.numcel= numcel;
        this.nociclo= nociclo;
    }
    
    
    /**
     * We create a PDF document with iText using different elements to learn 
     * to use this library.
     * Creamos un documento PDF con iText usando diferentes elementos para aprender 
     * a usar esta librería.
     * @param pdfNewFile  <code>String</code> 
     *      pdf File we are going to write. 
     *      Fichero pdf en el que vamos a escribir. 
     */
    public void createPDF(File pdfNewFile) {
        //Inicializamos para conexión de base datos+
        p= new BaseDatosPedidosPendientes();
        
        
        
        // We create the document and set the file name.        
        // Creamos el documento e indicamos el nombre del fichero.
        try {
            Document documento = new Document();
            try {

                PdfWriter.getInstance(documento, new FileOutputStream(pdfNewFile));

            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("No such file was found to generate the PDF "
                        + "(No se encontró el fichero para generar el pdf)" + fileNotFoundException);
            }
            documento.open();
            // We add metadata to PDF
            // Añadimos los metadatos del PDF
            documento.addTitle("Table export to PDF (Exportamos la tabla a PDF)");
            documento.addSubject("Using iText (usando iText)");
            documento.addKeywords("Java, PDF, iText");
            
            
            
            // We add an image (Añadimos una imagen)
            Image image;
            try {
                //se da formato a la imagen y se agrega primero la imagen
                image = Image.getInstance(iTextExampleImage);  
                image.scalePercent(35f);
                image.setAlignment(Element.ALIGN_MIDDLE);
                documento.add(image);
                
                //Titulo se le da formato
                Paragraph titulo = new Paragraph("Documento pedidos sheintap \n\n",
                    FontFactory.getFont("arial",
                        22,
                        java.awt.Font.BOLD,
                        BaseColor.PINK 
                        
                        )
                
                );
                titulo.setAlignment(Chunk.ALIGN_CENTER);
                //Se agrega después de la foto el título
                documento.add(titulo);
                
                
            } catch (BadElementException ex) {
                System.out.println("Image BadElementException" +  ex);
            } catch (IOException ex) {
                System.out.println("Image IOException " +  ex);
            }
            
            
        total=0;
        consultapedidos= p.buscarPedido("nombreciclo", nombre, nociclo); //lama al método de buscar pedido
        conteo= consultapedidos[0].length;
       
        for (String consultapedido : consultapedidos[4]) {
            total = total + Integer.parseInt(consultapedido);
        }
        

                //Se agrega nombre y número de teléfono+
                documento.add((new Paragraph("Nombre del cliente: " +nombre+ "\n",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD))));
                documento.add((new Paragraph("Numero de celular: " +clasedatos.getNumcel()+"\n",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD))));
                documento.add((new Paragraph("Numero de Ciclo: " +nociclo+"\n \n \n",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD))));
                documento.add((new Paragraph("Total a pagar: " +total+"\n ",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD))));
                documento.add((new Paragraph("Cantidad de artículos: " +conteo+"\n \n \n",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD))));
                //se agrega numero de piezas y total
                
                // Creamos una tabla
                PdfPTable tabla = new PdfPTable(4);
                tabla.addCell("Nombre articulo");
                tabla.addCell("Color");
                tabla.addCell("Precio");
                tabla.addCell("Talla");
                
                
                consultapedidos =p.buscarPedido("nombreciclo",nombre, nociclo);
        
            for(int x=0;x<consultapedidos[0].length;x++) {
                tabla.addCell(consultapedidos[1][x]);
                tabla.addCell(consultapedidos[5][x]);
                tabla.addCell(consultapedidos[4][x]);
                tabla.addCell(consultapedidos[2][x]);
            }
        
            // Añadimos la tabla al documento
            documento.add(tabla);
            
                JOptionPane.showMessageDialog(null,"Pdf creado con éxito","Crear pdf",JOptionPane.INFORMATION_MESSAGE);
            
            documento.close();
            System.out.println("Your PDF file has been generated!(¡Se ha generado tu hoja PDF!");
        } catch (DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
        }
    }
    /**
     * @param args the command line arguments
     */
    
}
