CREATE TABLE osoba
(
    id IDENTITY PRIMARY KEY,
    jmeno          VARCHAR(100) NOT NULL,
    prijmeni       VARCHAR(100) NOT NULL,
    adresa         VARCHAR(200) NOT NULL,
    datum_narozeni DATE         NOT NULL,
    email          VARCHAR(100),
    telefon        VARCHAR(13)
);


INSERT INTO osoba (jmeno, prijmeni, adresa, datum_narozeni, email, telefon)
VALUES ('Božena', 'Němcová', 'Vídeň', '1820-02-04', NULL, '+420800123456'),
       ('Karel', 'Čapek', 'Malé Svatoňovice', '1890-01-09', 'karel@capek.cz', '+420800987654'),
       ('Josef', 'Čapek', 'Hronov', '1887-03-23', 'josef@capek.cz', NULL),
       ('Věra', 'Adlová', 'Praha', '1919-07-22', NULL, NULL)
;
