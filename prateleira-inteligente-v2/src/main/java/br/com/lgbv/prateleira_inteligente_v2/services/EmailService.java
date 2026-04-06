package br.com.lgbv.prateleira_inteligente_v2.services;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendVerificationEmail(String to, String link) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Confirmação de email");
        message.setText("""
                Olá!

                Clique no link abaixo para confirmar sua conta:

                %s

                Se você não criou essa conta, ignore este email.
                """.formatted(link));
        mailSender.send(message);
    }
}
