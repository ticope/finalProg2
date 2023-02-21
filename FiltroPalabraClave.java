
public class FiltroPalabraClave extends Filtro{
	String palabraBuscada;
	public FiltroPalabraClave(String p) {
		this.palabraBuscada=p;
	}
	public boolean cumple(Gasto g) {
		return g.contienePalabra(this.palabraBuscada);
	}
}
