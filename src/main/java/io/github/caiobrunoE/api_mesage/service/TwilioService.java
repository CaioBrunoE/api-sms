package io.github.caiobrunoE.api_mesage.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import io.github.caiobrunoE.api_mesage.domain.SMSRequest;
import io.github.caiobrunoE.api_mesage.repository.SMSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {

    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.phoneNumber}")
    private String phoneNumber;

    @Autowired
    SMSRepository repository;

    public void sendSMS(String to, String message) {
        Twilio.init(accountSid, authToken);

        Message.creator(
                new PhoneNumber(to),
                new PhoneNumber(phoneNumber),
                message
        ).create();
    }
    public SMSRequest receiveSMS(String from, String message) {
        SMSRequest request = new SMSRequest();
        request.setTo(from);
        request.setMessage(message);
        return repository.save(request);
    }

}
