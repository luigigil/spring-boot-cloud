package com.example.rest.webservices.restfulwebservices.internationalization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internationalization")
public class InternationalizationController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/internationalization")
    public String internationalization(
    // @RequestHeader(name = "Accept-Language", required = false) Locale locale
    ) {
        // return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
        return messageSource.getMessage("good.morning.message", null, "Default Message",
                LocaleContextHolder.getLocale());
    }

}