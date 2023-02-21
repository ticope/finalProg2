import java.time.LocalDate;

public class FiltroPorFecha extends Filtro{
	LocalDate fecha;
	public FiltroPorFecha(LocalDate f) {
		this.fecha=f;
	}
	public boolean cumple(Gasto g) {
		return fecha.isEqual(g.getFecha());
	}

}
