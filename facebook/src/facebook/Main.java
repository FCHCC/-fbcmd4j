package facebook;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import facebook4j.Facebook;
import facebook4j.Post;
import facebook4j.ResponseList;

public class Main {
	 static final Logger logger = LogManager.getLogger(Main.class);
	 private static final String CONFIG_DIR = "config";
	 private static final String CONFIG_FILE = "fbcmd4j.properties";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.info("Iniciando app");
		Facebook fb = null;
		Properties props = null;
		
		//Carga propiedades
		try {
			props = Utils.loadPropertiesFromFile(CONFIG_DIR, CONFIG_FILE);
		}catch(IOException ex) {
			logger.error(ex);
		}
		
		//Cargando Menu
		int seleccion;
		try(Scanner  scanner = new Scanner(System.in)) {
			while(true) {
			//Menu
			fb = Utils.configurarFacebook(props);
			System.out.format("Simple Facebook client %s\n\n");
			System.out.println("Opciones: ");
			System.out.println("0) Cargar configuracion");
			System.out.println("1) Publicar Estado");
			System.out.println("2) Cargar NewsFeed");
			System.out.println("3) Obtener wall");
			System.out.println("4) Publicar Link ");
			System.out.println("5) Salir ");
			System.out.println("\n Ingresa una opcion: ");
			
			try {
				seleccion = scanner.nextInt();
				scanner.nextLine();
				
				switch(seleccion) {
						case 0:
							Utils.obtenerAccessTokens(CONFIG_DIR, CONFIG_FILE, props, scanner);
							props= Utils.loadPropertiesFromFile(CONFIG_DIR, CONFIG_FILE);
							break;
				
						case 1:
							System.out.println("¿Qué estas pensando?");
							String estado = scanner.nextLine();
							Utils.publicarEstado(estado, fb);
							break;
							
						case 2:
							System.out.println("Cargando NewsFeed...");
							ResponseList<Post> newsFeed = fb.getFeed();
							newsFeed.forEach(System.out::println);
							break;
							
						case 3:
				}
			}catch() {
				
			}
		}
		}

	}

}
