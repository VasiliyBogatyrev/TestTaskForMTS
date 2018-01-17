package ru.vasiliy.mtstest.dataaccess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vasiliy.mtstest.dataaccess.repository.InvoiceRepository;
import ru.vasiliy.mtstest.dataaccess.service.InvoiceService;
import ru.vasiliy.mtstest.model.Invoice;
import java.util.List;

/**
 * @author Vasiliy Bogatyrev on 12/01/2018.
 */

@Service
@Transactional

public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> findByName(String name){
        return invoiceRepository.findByName(name);
    }

}
