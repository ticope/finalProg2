import java.time.LocalDate;
import java.util.ArrayList;

public class GastoSimple extends Gasto{
	String descripcion;
	LocalDate fecha;
	ArrayList<String>palabrasClave;
	public GastoSimple(String nombre,double monto,String desc) {
		super(nombre,monto);
		this.fecha=getFecha();
		this.descripcion=desc;
		palabrasClave=new ArrayList<String>();	
	}
	public LocalDate getFecha() {
		return LocalDate.now();
	}
	public double getMonto(Filtro f) {
		if(f.cumple(this)) {
			return this.monto;
		}
		else {
			return 0;
		}
	}
	public ArrayList<String> getPalabrasClave() {
		ArrayList<String>aux = new ArrayList<String>();
		aux.addAll(palabrasClave);
		return aux;
	}
	@Override
	public ArrayList<Gasto> BuscarGastos(Filtro f) {
		ArrayList<Gasto> aux = new ArrayList<Gasto>();
		if(f.cumple(this)) {
			aux.add(this);
		}
		return aux;
	}
	public boolean contienePalabra(String p) {
		return palabrasClave.contains(p);
	}
}