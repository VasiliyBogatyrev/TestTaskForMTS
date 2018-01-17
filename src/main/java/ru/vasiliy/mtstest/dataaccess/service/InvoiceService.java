package ru.vasiliy.mtstest.dataaccess.service;

import ru.vasiliy.mtstest.model.Invoice;
import java.util.List;

/**
 * @author Vasiliy Bogatyrev on 12/01/2018.
 */

public interface InvoiceService {
    List<Invoice> findByName(String name);
   }
