import java.time.LocalDate;

public class Pago {
	LocalDate fecha;
	boolean pagado=false;
	public Pago(LocalDate f) {
		this.fecha=f;
	}
	public double pagar(double p) {
		//fecha>hoy 
		//pagado = true
		//return p
		//fecha<hoy
		//monto+=diferencia de dias
		//pagado = true
		//return nuevoMonto
	}
}
