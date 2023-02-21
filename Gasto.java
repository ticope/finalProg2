import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Gasto {
	String nombre;
	double monto;
	Pago pago;
	public Gasto(String nombre,double monto) {
		this.nombre=nombre;
		this.monto=monto;
	}
	public abstract LocalDate getFecha();
	
	public abstract double getMonto(Filtro f);
	
	public abstract ArrayList<String> getPalabrasClave();
	
	
	public abstract ArrayList<Gasto> BuscarGastos(Filtro f);
	
	public double pagarGasto() {
		if(this.pago!=null) {
			double m=pago.pagar(monto);
			return m;
		}
		else {
			return monto;
		}
	}
}

