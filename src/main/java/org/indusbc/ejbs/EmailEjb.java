package org.indusbc.ejbs;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.URLName;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import java.util.logging.Logger;
import org.indusbc.collections.Access;

/**
 *
 * @author singh
 */
@Stateless
public class EmailEjb implements EmailEjbLocal {
    
    private static final Logger LOGGER = Logger.getLogger(EmailEjb.class.getName());
    @Resource(mappedName = "java:comp/env/mail/indusbc")
    private Session mailSession;
    
    @Resource(name = "webURI")
    private String webURI;
    
    @Resource(name = "createAccessURI")
    private String createAccessURI;
    
    @Resource(name="sender")
    private String sender;
    
    @PostConstruct
    public void init(){
        
        
    }
    @Override
    public void sendRegistrationEmail(Access access) {
        String username=mailSession.getProperty("mail.smtp.user");
        String password=mailSession.getProperty("password");
        
        final URLName url= new URLName(mailSession.getProperty("mail.transport.mail"), mailSession.getProperty("mail.smtp.host"),
        -1, null, username, null);
        
        mailSession.setPasswordAuthentication(url, new PasswordAuthentication(username, password));
        LOGGER.info("MailSession set successfully!!");
        MimeMessage mimeMessage = new MimeMessage(mailSession);
        Multipart multipart = new MimeMultipart();
        StringBuilder htmlMsg = new StringBuilder("<html><body>");
        htmlMsg.append("<h2>Dear, ").append(access.getEmail()).append("</h2>");
        htmlMsg.append("<p>Congratulations on registering yourself successfully with us !!").append(".</p>");
        htmlMsg.append("<p>As a final step, please create your account password by following the link below:</p>");
        String createAccess=String.format(createAccessURI, access.getEmail());
        htmlMsg.append("<a href=\"").append(webURI).append(createAccess).append("\">")
                .append(webURI).append(createAccess)
                .append("</a>");
        
        htmlMsg.append("<p>Best Wishes, <br/>www.indusbc.org Admin</p>");
        htmlMsg.append("</body></html>");
        MimeBodyPart htmlPart=new MimeBodyPart();
        try{
            htmlPart.setContent(htmlMsg.toString(), "text/html; charset=utf-8");
            multipart.addBodyPart(htmlPart);
            mimeMessage.setSender(new InternetAddress(sender));
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(access.getEmail()));
            mimeMessage.setContent(multipart);
            mimeMessage.setSubject("User Registration");
            Transport.send(mimeMessage);
            LOGGER.info("Email sent successfully....");
        
        }catch(MessagingException ex){
            LOGGER.severe(ex.getMessage());
        }
    }

}