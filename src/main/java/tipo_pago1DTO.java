import lombok.Data;


@Data

public class tipo_pago1DTO {

    private Long id;
    private String claveRastreo;
    private String cuentaOrdenante;
    private String cuentaBeneficiario;
    private int referenciaNumerica;
    private float monto;
    private Long tsLiquidacion;
    private String conceptoPago;
    private String estado;
}


