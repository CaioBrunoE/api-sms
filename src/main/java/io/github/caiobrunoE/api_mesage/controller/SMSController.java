package io.github.caiobrunoE.api_mesage.controller;

import io.github.caiobrunoE.api_mesage.domain.SMSRequest;
import io.github.caiobrunoE.api_mesage.service.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SMSController {

    private final TwilioService twilioService;

    @Autowired
    public SMSController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }

    @PostMapping("/send-sms")
    public void sendSMS(@RequestBody SMSRequest request) {
        twilioService.sendSMS(request.getTo(), request.getMessage());
    }

    @PostMapping("/receive-sms")
    public SMSRequest receiveSMS(@RequestBody SMSRequest request) {
        return twilioService.receiveSMS(request.getTo(),request.getMessage());
    }
}