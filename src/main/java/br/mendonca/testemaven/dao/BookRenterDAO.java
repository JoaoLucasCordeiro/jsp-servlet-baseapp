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
        String sql = "INSERT INTO book_renters (id, name, email, address, phone_number, visible) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, renter.getId());
        stmt.setString(2, renter.getName());
        stmt.setString(3, renter.getEmail());
        stmt.setString(4, renter.getAddress());
        stmt.setString(5, renter.getPhoneNumber());
        stmt.setBoolean(6, renter.isVisible());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public List<BookRenter> listAllRenters(int offset, int limit) throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionPostgres.getConexao();
        String sql = "SELECT id, name, email, address, phone_number, visible FROM book_renters WHERE visible = true LIMIT ? OFFSET ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, limit);
        stmt.setInt(2, offset);
        ResultSet rs = stmt.executeQuery();
        List<BookRenter> renters = new ArrayList<>();
        while (rs.next()) {
            BookRenter renter = new BookRenter();
            renter.setId(rs.getString("id"));
            renter.setName(rs.getString("name"));
            renter.setEmail(rs.getString("email"));
            renter.setAddress(rs.getString("address"));
            renter.setPhoneNumber(rs.getString("phone_number"));
            renter.setVisible(rs.getBoolean("visible"));
            renters.add(renter);
        }
        rs.close();
        stmt.close();
        conn.close();
        return renters;
    }

    public void markAsHidden(String id) throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionPostgres.getConexao();
        String sql = "UPDATE book_renters SET visible = false WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, id);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public List<BookRenter> listHiddenRenters() throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionPostgres.getConexao();
        String sql = "SELECT id, name, email, address, phone_number, visible FROM book_renters WHERE visible = false";
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
            renter.setVisible(rs.getBoolean("visible"));
            renters.add(renter);
        }
        rs.close();
        stmt.close();
        conn.close();
        return renters;
    }
}