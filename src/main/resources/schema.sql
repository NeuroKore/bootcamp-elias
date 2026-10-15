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
    fecha_expiracion DATE NOT NULL,
    pais_origen VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS tipo_pago1 (
    id BIGSERIAL PRIMARY KEY,
    clave_rastreo VARCHAR(255),
    cuenta_ordenante VARCHAR(255),
    cuenta_beneficiario VARCHAR(255),
    referencia_numerica VARCHAR(255),
    monto NUMERIC(19, 2),
    ts_liquidacion TIMESTAMPTZ,
    concepto_pago VARCHAR(255),
    estado VARCHAR(255)
);
