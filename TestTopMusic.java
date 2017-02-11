package estructurasIII;
/**
 * @author Nieves Borrero
 * @version 1.0
 */
import utiles.Menu;
import utiles.Teclado;

public class TestTopMusic {
	static TopMusic<Cancion> topMusic= new TopMusic<Cancion>();
	public static void main(String[] args) {
	Menu menu= new Menu("OPCIONES:", new String[]{"añadir cancion", "Mostrar lista",
			"subir puesto de cancion","Bajar puesto de cancion", "Sacar del Top 10",
			"Mostrar cancion en el puesto numero 1", "salir"});
	deseaPregenerar();
	int opcion;
	 do{
		switch(opcion=menu.gestionar()){
		 	case 1: añadirCancion(); break;
		 	case 2: mostrarTop();break;				
		 	case 3: subirPosicion();break;
		 	case 4: bajarPosicion();break;
		 	case 5: sacarDelTop();break;
		 	case 6:	topCancion();break;
		 	case 7: salir();break;
		}
	 }while(opcion!=7);
	}//main

	private static void salir() {
		System.out.println("Hasta otra");
	}

	private static void topCancion() {
		System.out.println(topMusic.top());
	}

	private static void sacarDelTop() {
		boolean boleano;
		do {
			boleano = topMusic.pullOut(Teclado.leerEntero("Introduce el indice de la cancion"));
			if (boleano == false)
				System.out
						.println("Indice no valido,no se ha podido sacar del top");
		} while (boleano==false);
		System.out.println("La canción ha salido del top10");
	}

	private static void bajarPosicion() {
		boolean boleano;
		do {
			boleano = topMusic.down(Teclado.leerEntero("Introduce el indice de la cancion"));
			if (boleano == false)
				System.out.println("Imposible bajar de posicion, comprueba el indice introducido");
		} while (boleano==false);
		System.out.println("La canción ha bajado de posicion");
	}

	private static void subirPosicion() {
		boolean boleano;
		do {
			boleano = topMusic.up(Teclado.leerEntero("Introduce el indice de la cancion"));
			if (boleano == false)
				System.out.println("Imposible subir de posicion, Comprueba el indice introducido");
		} while (boleano==false);
		System.out.println("La canción ha subido de posicion");
	}

	private static void mostrarTop() {
		System.out.println(topMusic);
	}

	private static void añadirCancion() {
		boolean boleano;
			boleano = topMusic.add(Teclado.leerEntero("Introduce la posicion de la cancion a introducir"),
						new Cancion(Teclado.leerCadena("Título:"), Teclado.leerCadena("Artista o grupo:"),
								Teclado.leerCadena("año:")));
			if (boleano == false)
				System.out.println("Imposible añadir cancion, el índice es inválido o la cancion ya existe");
	}
	/**
	 * Pregunta al usuario si desea obtener un top music pregenerado
	 */
	private static void deseaPregenerar() {
		boolean boleano=false;
		do{
			switch(Teclado.leerCaracter("Desea que se pregenere un top 10?")){
			case 's':
			case 'S': boleano=true; pregenerar();break;
			case 'n':
			case 'N': boleano=true; break;
			default:boleano=false;
			}
		}while(boleano==false);		
	}
	/**
	 * Añade canciones ya creadas al topmusic
	 */
	static void pregenerar(){
		topMusic.getTop().add(new Cancion("Californication","Red Hot Chili Peppers","1999"));
		topMusic.getTop().add(new Cancion("Thunderstruck","AC/DC","1990"));
		topMusic.getTop().add(new Cancion("American Woman", "Lenny Kravitz","1999"));
		topMusic.getTop().add(new Cancion("The Trooper","Iron Maiden","1983"));
		topMusic.getTop().add(new Cancion("I Wish I Had an Angel","Nightwish","2004"));
		topMusic.getTop().add(new Cancion("So Payaso","Extremoduro","1996"));
		topMusic.getTop().add(new Cancion("Corazon de Mimbre","Marea","2000"));
		topMusic.getTop().add(new Cancion("Estampida","Ska-p","2002"));
		topMusic.getTop().add(new Cancion("Hit the Road Jack","Ray Charles","1961"));
		topMusic.getTop().add(new Cancion("House of the Rising Sun","White Buffalo","2011"));
		topMusic.getTop().add(new Cancion("La Danza del Fuego","Mago de Oz","2000"));	
		topMusic.getTop().add(new Cancion("Alas de Cristal","Avalanch","2005"));
		topMusic.getTop().add(new Cancion("Feo, Fuerte y Formal","Loquillo","2006"));
	}
}
