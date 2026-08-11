CREATE TABLE IF NOT EXISTS beer (
    id BIGSERIAL PRIMARY KEY,
    brand VARCHAR(100),
    company VARCHAR(100),
    type VARCHAR(50),
    color VARCHAR(50),
    mililiters INTEGER,
    abv REAL,
    flavour VARCHAR(50),
    olor VARCHAR(50),
    fecha_expiracion DATE NOT NULL
    pais_origen VARCHAR(50)
);

