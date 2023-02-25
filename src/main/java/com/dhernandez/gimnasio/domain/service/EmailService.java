package com.dhernandez.gimnasio.domain.service;

import com.dhernandez.gimnasio.domain.dto.EmailBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender sender;


    public boolean sendEmail(EmailBody emailBody)  {
        LOGGER.info("EmailBody: {}", emailBody.toString());
        return sendEmailTool(emailBody.getContent(),emailBody.getEmail(), emailBody.getSubject());
    }


    private boolean sendEmailTool(String textMessage, String email,String subject) {
        boolean send = false;


            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("gimnasio.app.demo@gmail.com");
            message.setTo(email);
            message.setText(textMessage);
            message.setSubject(subject);
            sender.send(message);
            send = true;
            LOGGER.info("Mail enviado!");

        return send;
    }
}
