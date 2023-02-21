
public class FiltroMonto extends Filtro{
	double montoMinimo;
	public FiltroMonto(double m) {
		this.montoMinimo=m;
	}
	public boolean cumple(Gasto g) {
		return g.getMonto()>this.montoMinimo;
	}
}
