package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;


    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("wand");
        Product product2 = new Product("robes");
        Product product3 = new Product("spell book");
        Item item1 = new Item(product1, new BigDecimal("50.0"),
                1);
        Item item2 = new Item(product2, new BigDecimal("140.0"), 2);
        Item item3 = new Item(product3, new BigDecimal("75.0"), 3);
        Item item4 = new Item(product3, new BigDecimal("90.0"), 4);
        Invoice invoice = new Invoice("3/2018");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        invoice.getItems().add(item4);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        //invoiceDao.delete(id);
    }

}
