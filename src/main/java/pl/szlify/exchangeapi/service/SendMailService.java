package pl.szlify.exchangeapi.service;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.szlify.exchangeapi.model.ConvertReponse;

import java.text.MessageFormat;

@Service
@AllArgsConstructor
public class SendMailService {

    private final JavaMailSender javaMailSender;

    public void sendSimpleMessage(String to,String subject,ConvertReponse content){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("olbrachjanek@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(buildMessage(content));
        javaMailSender.send(message);
    }

    private String buildMessage(ConvertReponse content){
        return MessageFormat.format("""
                Thank you for using our Roztycie Currency Exchange, below is your confirmation:
                
               Exchanged amount: {0}
               Curreny From: {1}
               Currency To: {2}
               Exchanged amount: {3}{2}
               
               Exchange Rate: {4}
               Date of exchange: {5}
               
               Thank you for using our services!
               
                """, content.getQuery().getAmount(),content.getQuery().getFrom(),content.getQuery().getTo(),
                content.getResult(),content.getInfo().getRate(),content.getDate());
    }
}
