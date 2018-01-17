package ru.vasiliy.mtstest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.vasiliy.mtstest.dataaccess.service.InvoiceService;
import ru.vasiliy.mtstest.model.Invoice;
import ru.vasiliy.mtstest.protocol.ResponseHolder;

import java.util.List;

/**
 * @author Vasiliy Bogatyrev on 12/01/2018.
 */

@RestController
@RequestMapping(value = "/")
public class MainController {
    private final InvoiceService invoiceService;


    @Autowired
    public MainController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MainController.class);


    @RequestMapping(value = "/getInvoiceByName", params = {"name"})
    public @ResponseBody
    ResponseHolder <List<Invoice>> getInvoiceByName (@RequestParam("name") String name) {
        logger.info("/getInvoiceByName called with param \"name\" " + name);
        if (name.equals("")) {
            return new ResponseHolder<>("getInvoiceByName: name can not be null");
        }
        List<Invoice> invoiceList = invoiceService.findByName(name);
        if (invoiceList.isEmpty()) {
            return new ResponseHolder<>("getInvoiceByName: legal entity is null by name " + name);
        }
        return new ResponseHolder<>(invoiceList);
    }

}
