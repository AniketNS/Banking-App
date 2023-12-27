package com.example.banking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CertificatePrintController {

    @GetMapping("/certprint")
    public String certificatePrint() {
        return "certificateprint";
    }
}