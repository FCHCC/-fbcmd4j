package facebook;

import java.util.Properties;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import facebook4j.Facebook;

public class Main {
	 static final Logger logger = LogManager.getLogger(Main.class);
	 private static final String CONFIG_DIR = "config";
	 private static final String CONFIG_FILE = "fbcmd4j.properties";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.info("Iniciando app");
		Facebook facebook = null;
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
			System.out.format("Simple Facebook client %s\n\n", APP_VERSION);
			System.out.println("Opciones: ");
			System.out.println("0) Cargar configuracion");
			System.out.println("1) Obtener Tokens");
			System.out.println("2) Publicar Estado");
			System.out.println("3) Cargar NewsFeed");
			System.out.println("4) Obtener wall ");
			System.out.println("5) Publicar Link ");
			System.out.println("6) Salir");
			System.out.println("\n Ingresa una opcion: ");
			
			try {
				seleccion = scanner.nextInt();
				scanner.nextLine();
				
				switch(seleccion) {
						case 0:
							
				}
			}
		}
		}

	}

}
