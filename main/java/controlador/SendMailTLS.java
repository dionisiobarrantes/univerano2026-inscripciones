/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.util.Locale;
import java.util.Properties;
import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;

/**
 *
 * @author dionisio.barrantes
 */
public class SendMailTLS {
    
    

String username = "universidadverano.anticapitalistas.org";
String password = "Democrito";

String filename;
String path = "/home/ec2-user/glassfish4/glassfish/domains/domain1/applications/WebUniVerano/ficheros/";
final String path2 = "C:\\Users\\dioni\\Documents\\NetBeansProjects13\\exportnetbeans\\";
Properties props = new Properties();
Properties fich_props = new Properties();
Properties fich_propiedades = new Properties();
InputStream input = null;
        
          
             
      
 public SendMailTLS(Locale lang) throws IOException, AddressException, MessagingException, ConnectException {
 

InputStream in;

     path = "/home/ec2-user/payara5/glassfish/domains/domain1/applications/2024-formulario/ficheros/";
 //    path = "C:\\Users\\dioni\\Documents\\payara-5.2022.2\\payara5\\glassfish\\domains\\domain1\\applications\\univerano2022-1.0-SNAPSHOT\\ficheros\\";
     

     
    Authenticator authenticator = new Authenticator() {
     @Override
     protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(username, password);
} 
    }    ; 

}
 public void enviaCorreo(String texto, String correo_electronico, String importe, Locale lang) throws IOException, AddressException, MessagingException {
  
 ResourceBundle bundle = ResourceBundle.getBundle("resources.mensajes", FacesContext.getCurrentInstance().getViewRoot().getLocale());
        
 String valuekeyMensconfirmacion1 = bundle.getString("mens_confirmacion1");   
 
 System.out.println("€€€€€€€€€€€€€€€€€€€€€€€€");
 //System.out.println(valuekeyMensconfirmacion1); 
 System.out.println("€€€€€€€€€€€€€€€€€€€€€€€€");
        String valuekeyMensconfirmacion2 = bundle.getString("mens_confirmacion2"); 
        String valuekeyMensconfirmacion3 = bundle.getString("mens_confirmacion3"); 
        String valuekeyMensconfirmacion4 = bundle.getString("mens_confirmacion4"); 
        String valuekeyMensconfirmacion5 = bundle.getString("mens_confirmacion5"); 
        String valuekeyIBAN = bundle.getString("IBAN"); 
        String valuekeyConvocatoria = bundle.getString("convocatoria"); 
         
     username = "universidadverano.anticapitalistas.org";
     password = "Democrito";

     props.put("mail.smtp.host", "panel.anticapitalistas.org");
     props.put("mail.smtp.ssl.protocols", "TLSv1.2");
     props.setProperty("mail.smtp.port", "465");

     props.setProperty("mail.smtp.auth", "true");
     props.put("mail.smtp.socketFactory.port", "465");
     props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
     props.setProperty("mail.smtp.starttls.enable", "true");
     props.put("mail.smtp.ssl.trust", "*");
     props.setProperty("mail.smtp.ssl.enable", "true");
     props.put("mail.smtp.starttls.enable", "true");
           


   String lenguaje= lang.toString();
     
    
    

     
     
Authenticator authenticator = new Authenticator() {
     @Override
     protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(username, password);
} 
    }    ; 

   Session session = Session.getInstance(props,
		  new jakarta.mail.Authenticator() {
                        @Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);

//                        message.setFrom(new InternetAddress("contacto@unianticapi.info"));
                        message.setFrom(new InternetAddress("universidadverano@anticapitalistas.org"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(correo_electronico));
                        message.addRecipient(Message.RecipientType.CC,
                                new InternetAddress("universidadverano@anticapitalistas.org"));
                        
                        
//message.setSubject("Confirmacion "+valuekeyConvocatoria);
message.setSubject("Confirmacion "+valuekeyConvocatoria);
                        MimeBodyPart messageBodyPart = new MimeBodyPart();
                      
//                        messageBodyPart.setText(texto);
                        messageBodyPart.setText(valuekeyMensconfirmacion1 +  texto + valuekeyMensconfirmacion5  +  importe + " €." + valuekeyMensconfirmacion3 + valuekeyIBAN + valuekeyMensconfirmacion4 );

//                     + valuekeyIBAN + valuekeyMensconfirmacion4) ;        
//			messageBodyPart.setText("Tu inscripción se ha realizado correctamente, tienes que indicar este número en la transferencia bancaria:"
//				+ texto + " .El importe total de la inscripción, salvo error u omisión, es de "+ importe + " euros. Adjunto al presente mensaje te enviamos un fichero pdf con información de interés sobre la XIV Universidad de Verano." + "\r\n" + "La cuenta bancaria bancaria donde debes hacer el ingreso es: ES40 0081 0085 6500 0255 6859  Titular Asociación Anticapitalistas - Movimiento por el Poder popular\n" +
//                              "\r\n" + "Si tienes papeles (DNI, pasaporte) no olvides traértelos contigo, no te olvides tampoco traer la tarjeta sanitaria.");
 			
                       
                        
                     
                        Multipart multipart = new MimeMultipart();
                        multipart.addBodyPart(messageBodyPart);
                        // Second part is attachment
                        messageBodyPart = new MimeBodyPart();
                       
                        
                         FacesContext contexto = FacesContext.getCurrentInstance();
                        ServletContext servletContexto= (ServletContext) contexto.getExternalContext().getContext(); 
                       
                       String path3 = servletContexto.getRealPath("")+"/ficheros/";
                      
                       String filename = path3+"confirmacion_inscripcion.pdf";
                        
                     
                        if (lenguaje.equals("eu"))
                        filename = path3+"confirmacion_inscripcion_eu.pdf";
                        else
                        if (lenguaje.equals("ca"))    
                            filename = path3+"confirmacion_inscripcion_ca.pdf";   
                        else
                            if (lenguaje.equals("gl"))
                                 filename = path3+"confirmacion_inscripcion_gl.pdf"; 
                            else
                            filename = path3+"confirmacion_inscripcion.pdf";
                        
                        DataSource source = new FileDataSource(filename);
                        messageBodyPart.setDataHandler(new DataHandler(source));
                        messageBodyPart.setFileName(filename);
                        multipart.addBodyPart(messageBodyPart);
 
                        // Send the complete message parts
                        message.setContent(multipart);
                        
                        // message.addRecipient(Message.RecipientType.TO,new InternetAddress("dionisiobarrantes@gmail.com"));  
                        
                       
                        //Transport t = session.getTransport("smtp");
                        Transport.send(message);
 			//t.close();
                                System.out.println("Done");
                
		} catch (MessagingException ex) {
			System.out.println(
        "Connection Refused Exception as the given hostname and port are invalid : "
        + ex.getMessage());
		}
 }
 public void enviaComunicacion(String texto, String correo_electronico, String importe,String observaciones, Locale lang) throws AddressException, MessagingException {
     props.put("mail.smtp.auth", "true");		
     props.put("mail.smtp.starttls.enable", "true");
     props.put("mail.smtp.ssl.trust", "panel.anticapitalistas.org");


     props.put("mail.smtp.host", "panel.anticapitalistas.org");
     props.put("mail.smtp.port", "465");
     
     String lenguaje= lang.toString();
    
    Session session;
    session = Session.getInstance(props,
            new jakarta.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
    
		try {
//                       Multipart multipart = new MimeMultipart();
                       
			Message message = new MimeMessage(session);
//                        message.setFrom(new InternetAddress("contacto@unianticapi.info"));                       
			message.setFrom(new InternetAddress("universidadverano@anticapitalistas.org"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(correo_electronico));
			message.setSubject("Mensaje XIV Universidad de Verano de Anticapitalistas");
//                        MimeBodyPart messageBodyPart = new MimeBodyPart();
			message.setText("Te confirmamos la recepción de tu transferencia por un importe de "
			+ importe + " euros. " + observaciones);
 			
                         
 //                        message.addRecipient(Message.RecipientType.TO,new InternetAddress("dionisiobarrantes@gmail.com"));  
                                 
                         
                        
                         
                        Transport.send(message);
 			System.out.println("Done");
                
		} catch (MessagingException ex) {
			System.out.println(
        "Connection Refused Exception as the given hostname and port are invalid : "
        + ex.getMessage());
		}
 }   
 }
     
