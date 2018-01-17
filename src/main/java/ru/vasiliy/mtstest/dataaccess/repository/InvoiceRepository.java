package ru.vasiliy.mtstest.dataaccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vasiliy.mtstest.model.Invoice;

import java.util.List;

/**
 * @author Vasiliy Bogatyrev on 12/01/2018.
 */

@Repository

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Query("select i from Invoice i where i.name like concat('%', :name, '%') ")
    List<Invoice> findByName(@Param("name") String name);
}
