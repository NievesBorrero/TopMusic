package estructurasIII;
/**
 * Sobre la canci�n se almacenar� el t�tulo, artista o grupo y a�o de grabaci�n.
 * 7.3
 * @author Nieves Borrero.
 * @version 1.0
 */
public class Cancion {
	private String titulo;
	private String artistaOgrupo;
	private String anio;
	
	/**
	 * Constructor
	 * @param titulo
	 * @param artistaOgrupo
	 * @param anio
	 */
	public Cancion(String titulo, String artistaOgrupo, String anio) {
		super();
		this.titulo = titulo;
		this.artistaOgrupo = artistaOgrupo;
		this.anio = anio;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anio == null) ? 0 : anio.hashCode());
		result = prime * result
				+ ((artistaOgrupo == null) ? 0 : artistaOgrupo.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cancion other = (Cancion) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equalsIgnoreCase(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "titulo:" + titulo + ", artista/grupo:" + artistaOgrupo + ", a�o:" + anio;
	}
	
}
