package com.ai.meeting_summarizer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // Keep this in application.properties as: mail.from=your_verified_sender@example.com
    @Value("${mail.from}")
    private String fromAddress;

    public void sendEmail(String to, String subject, String text) {
        sendEmail(new String[]{to}, subject, text);
    }

    public void sendEmail(String[] to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromAddress);          // IMPORTANT: must be a verified sender in Mailjet
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        try {
            mailSender.send(message);
        } catch (MailException ex) {
            // optional: replace with your logger
            System.err.println("Failed to send email: " + ex.getMessage());
            throw ex; // rethrow so controller returns 500 if needed
        }
    }
}
