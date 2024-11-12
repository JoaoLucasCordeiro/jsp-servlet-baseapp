package br.mendonca.testemaven.services.dto;

import br.mendonca.testemaven.model.entities.BookRenter;

public class BookRenterDTO {
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public BookRenterDTO() {}

    public BookRenterDTO(String name, String email, String address, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static BookRenterDTO bookRenterMapper(BookRenter bookRenter) {
        BookRenterDTO dto = new BookRenterDTO();
        dto.setName(bookRenter.getName());
        dto.setEmail(bookRenter.getEmail());
        dto.setAddress(bookRenter.getAddress());
        dto.setPhoneNumber(bookRenter.getPhoneNumber());
        return dto;
    }
}