package estructurasIII;
/**
 * @author Nieves Borrero
 * @version 1.0
 */
import utiles.Menu;
import utiles.Teclado;

public class TestTopMusic {
	static TopMusic<Cancion> topMusic = new TopMusic<Cancion>();

	public static void main(String[] args) {
		Menu menu = new Menu("OPCIONES:", new String[] { "añadir cancion",
				"Mostrar lista", "subir puesto de cancion",
				"Bajar puesto de cancion", "Sacar del Top 10", 
				"Mostrar cancion en el puesto numero 1","Eliminar una cancion", "salir" });
		deseaPregenerar();
		int opcion;
		do {
			switch (opcion = menu.gestionar()) {
			case 1:
				añadirCancion();
				break;
			case 2:
				mostrarTop();
				break;
			case 3:
				subirPosicion();
				break;
			case 4:
				bajarPosicion();
				break;
			case 5:
				sacarDelTop();
				break;
			case 6:
				topCancion();
				break;
			case 7:
				EliminarCancion();
				break;
			case 8:
				salir();
				break;
			}
		} while (opcion != 8);
	}// main
	
	private static void salir() {
		System.out.println("Hasta otra");
	}
	
	private static void EliminarCancion() {
		boolean eliminada;
		if(!isEmpty()){
				eliminada = topMusic.remove(Teclado.leerEntero("Introduce el indice de la cancion"));
				if (!eliminada){
					System.out.println("No se ha podido eliminar");
					return;
				}
				System.out.println("Eliminada");
		}
		
	}

	private static void topCancion() {
			if(!isEmpty())
				System.out.println(topMusic.top());
	}

	private static void sacarDelTop() {
		boolean sacado;
		if(!isEmpty()){
				sacado = topMusic.pullOut(Teclado.leerEntero("Introduce el indice de la cancion"));
				if (!sacado){
					System.out.println("No se ha podido sacar del top");
					return;
				}
				System.out.println("La canción ha salido del top10");
		}
	}

	private static void bajarPosicion() {
		boolean bajado;
		if(!isEmpty()){
			bajado= topMusic.down(Teclado.leerEntero("Introduce el indice de la cancion"));
				if (!bajado){
					System.out.println("Imposible bajar de posicion");
					return;
				}
				System.out.println("La canción ha bajado de posicion");
		}
		
	}

	private static void subirPosicion() {
		boolean subido;
		if(!isEmpty()){
			subido=topMusic.up(Teclado.leerEntero("Introduce el indice de la cancion"));
				if (!subido){
					System.out.println("Imposible subir de posicion");
						return;
				}
				System.out.println("La canción ha subido de posicion");
		}
	}

	private static boolean isEmpty() {
		if(topMusic.isEmpty()){
			System.out.println("El top 10 esta vacio");
			return true;
		}
		return false;
	}

	private static void mostrarTop() {
		System.out.println(topMusic);
	}

	private static void añadirCancion() {
		int posicion;
		if(topMusic.isEmpty()){
			topMusic.add(new Cancion(Teclado.leerCadena("Título:"), Teclado.leerCadena("Artista o grupo:"), 
				Teclado.leerCadena("año:")));
			return;
		}
		posicion = Teclado.leerEntero("Introduce la posicion de la cancion a añadir:");
		if(indiceEsValido(posicion)){ //Si el índice no es válido, se sale sin pedir la canción
			pedirCancion(posicion);
		}
	}
	private static boolean indiceEsValido(int posicion) {
		if (!topMusic.comprobarIndex(posicion-1)){
			System.out.println("Imposible añadir cancion");
		return false;
		}
		return true;
	}
	private static void pedirCancion(int posicion) {
		if(!topMusic.add((posicion), new Cancion(Teclado.leerCadena("Título:"), Teclado.leerCadena("Artista o grupo:"), 
				Teclado.leerCadena("año:"))))
		System.out.println("Imposible añadir una cancion que ya existe");		
	}

	/**
	 * Pregunta al usuario si desea obtener un top music pregenerado
	 */
	private static void deseaPregenerar() {
		boolean respuesta = false;
		do {
			switch (Teclado.leerCaracter("Desea que se pregenere un top 10?")) {
			case 's':
			case 'S':
				respuesta = true;
				pregenerar();
				break;
			case 'n':
			case 'N':
				respuesta = true;
				break;
			default:
				respuesta = false;
			}
		} while (!respuesta);
	}
	/**
	 * Añade canciones ya creadas al topmusic
	 */
	static void pregenerar(){
		topMusic.add(new Cancion("Californication","Red Hot Chili Peppers","1999"));
		topMusic.add(new Cancion("Thunderstruck","AC/DC","1990"));
		topMusic.add(new Cancion("American Woman", "Lenny Kravitz","1999"));
		topMusic.add(new Cancion("The Trooper","Iron Maiden","1983"));
		topMusic.add(new Cancion("I Wish I Had an Angel","Nightwish","2004"));
		topMusic.add(new Cancion("So Payaso","Extremoduro","1996"));
		topMusic.add(new Cancion("Corazon de Mimbre","Marea","2000"));
		topMusic.add(new Cancion("Estampida","Ska-p","2002"));
		topMusic.add(new Cancion("Hit the Road Jack","Ray Charles","1961"));
		topMusic.add(new Cancion("House of the Rising Sun","White Buffalo","2011"));
		topMusic.add(new Cancion("La Danza del Fuego","Mago de Oz","2000"));	
		topMusic.add(new Cancion("Alas de Cristal","Avalanch","2005"));
		topMusic.add(new Cancion("Feo, Fuerte y Formal","Loquillo","2006"));
	}
}
