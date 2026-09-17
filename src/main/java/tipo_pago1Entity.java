import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "tipo_pago1")
@Getter
@Setter

public class tipo_pago1Entity {

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