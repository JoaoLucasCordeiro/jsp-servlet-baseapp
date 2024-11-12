package br.mendonca.testemaven.services;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import br.mendonca.testemaven.dao.BookRenterDAO;
import br.mendonca.testemaven.model.entities.BookRenter;
import br.mendonca.testemaven.services.dto.BookRenterDTO;

public class BookRenterService {

    public void register(List<BookRenterDTO> renters) throws ClassNotFoundException, SQLException {
        BookRenterDAO dao = new BookRenterDAO();
        for (BookRenterDTO dto : renters) {
            BookRenter renter = new BookRenter();
            renter.setId(UUID.randomUUID().toString());
            renter.setName(dto.getName());
            renter.setEmail(dto.getEmail());
            renter.setAddress(dto.getAddress());
            renter.setPhoneNumber(dto.getPhoneNumber());
            dao.register(renter);
        }
    }

    public void populateDatabase(List<BookRenterDTO> renters) throws ClassNotFoundException, SQLException {
        register(renters);
    }

    public List<BookRenter> listAllRenters() throws ClassNotFoundException, SQLException {
        BookRenterDAO dao = new BookRenterDAO();
        return dao.listAllRenters();
    }
}