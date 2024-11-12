package br.mendonca.testemaven.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.mendonca.testemaven.model.entities.BookRenter;

public class BookRenterDAO {

    public void register(BookRenter renter) throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionPostgres.getConexao();
        String sql = "INSERT INTO book_renters (name, email, address, phone_number) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, renter.getName());
        stmt.setString(2, renter.getEmail());
        stmt.setString(3, renter.getAddress());
        stmt.setString(4, renter.getPhoneNumber());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public List<BookRenter> listAllRenters() throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionPostgres.getConexao();
        String sql = "SELECT id, name, email, address, phone_number FROM book_renters";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<BookRenter> renters = new ArrayList<>();
        while (rs.next()) {
            BookRenter renter = new BookRenter();
            renter.setId(rs.getString("id"));
            renter.setName(rs.getString("name"));
            renter.setEmail(rs.getString("email"));
            renter.setAddress(rs.getString("address"));
            renter.setPhoneNumber(rs.getString("phone_number"));
            renters.add(renter);
        }
        rs.close();
        stmt.close();
        conn.close();
        return renters;
    }
}