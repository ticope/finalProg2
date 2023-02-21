import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;


public class GastoCompuesto extends Gasto{
	ArrayList<Gasto>gastos;
	ArrayList<String>palabrasClave;
	public GastoCompuesto(String nombre, double monto) {
		super(nombre, monto);
		gastos = new ArrayList<Gasto>();
		palabrasClave = new ArrayList<String>();
	}
	@Override
	public LocalDate getFecha() {
		LocalDate fechaMayor=gastos.get(0).getFecha();
		for(int i=0;i<gastos.size();i++) {
			LocalDate fechaAux = gastos.get(i).getFecha();
			if(fechaAux.isAfter(fechaMayor)) {
				fechaMayor=fechaAux;
			}
		}
		return fechaMayor;
		
	}
	@Override
	public double getMonto(Filtro f) {
		double montoFinal=0;
		for(int i=0;i<gastos.size();i++) {
			montoFinal+=gastos.get(i).getMonto(f);
		}
		return montoFinal;
	}
	@Override
	public ArrayList<String> getPalabrasClave() {
		ArrayList<String> result = new ArrayList<String>();
		for(int i=0;i<gastos.size();i++) {
			ArrayList<String> aux = gastos.get(i).getPalabrasClave();
			for(int j=0;j<aux.size();j++) {
				if(!result.contains(aux.get(j))) {
					result.add(aux.get(j));
				}
			}
		}
		Collections.sort(result);
		return result;
	}
	@Override
	public ArrayList<Gasto> BuscarGastos(Filtro f) {
		ArrayList<Gasto> result = new ArrayList<Gasto>();
		if(f.cumple(this)) {
			result.add(this);
		}
		else {
			for(int i = 0; i < gastos.size(); i++) {
				ArrayList<Gasto>aux=gastos.get(i).BuscarGastos(f);	
					result.addAll(aux);
			}
		}
		return result;
	}
	public boolean contienePalabra(String p) {
		return palabrasClave.contains(p);
	}
	
}
