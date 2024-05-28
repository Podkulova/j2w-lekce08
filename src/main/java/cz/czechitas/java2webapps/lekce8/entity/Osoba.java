package cz.czechitas.java2webapps.lekce8.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Entita – údaje o jedné osobě.
 * <p>
 * Pojmenování properties musí zůstat zachováno, protože odpovídá názvům sloupečků v databázové tabulce. Stejně tak musí být zachováno jméno třídy, odpovídá
 * jménu tabulky v databázi.
 */
@Entity
public class Osoba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 100)
    @NotBlank
    private String jmeno;

    @Length(max = 100)
    @NotBlank
    private String prijmeni;

    @PastOrPresent
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate datumNarozeni;

    @Length(max = 200)
    @NotBlank
    private String adresa;

    @Length(max = 100)
    @Email
    private String email;

    @Length(min = 9, max = 13)
    @Pattern(regexp = "\\+?\\d+")
    private String telefon;

    public Osoba() {
    }

    public Osoba(Long id, String jmeno, String prijmeni, LocalDate datumNarozeni, String adresa, String email, String telefon) {
        this.id = id;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.datumNarozeni = datumNarozeni;
        this.adresa = adresa;
        this.email = email;
        this.telefon = telefon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public LocalDate getDatumNarozeni() {
        return datumNarozeni;
    }

    public void setDatumNarozeni(LocalDate datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Integer getVek() {
        if (datumNarozeni == null) {
            return null;
        }
        return datumNarozeni.until(LocalDate.now()).getYears();
    }

}
