import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
	
	//Creamos el diccionario como una variable global, ya que este nunca va a cambiar;
	public static Hashtable<Integer, String> diccionario=new Hashtable<Integer,String>();
	
	public static int[] utilizadas;
	
	//escribimos esta variable globar para ver si hay un resultado, o por el contrario que no hay a ninguno.
	public static boolean estado;
	
	//Estas dos variables las vamos a utilizar para trabajar sobre ellas al comparar las palabras;
	public static String principio;
	public static String fin;
	
	/**
	 * este metodo lo que hace es jugar con el origen y el destino para ver por que palabras tiene que pasar.
	 * @param origen
	 * @param destino
	 */
	
	public static void juego(String origen, String destino){
		
		principio=origen;
		
		//Contados utilizado para recorrer las palabras del diccionario.
		int contDic=0;
		
		//Contados que utilizamos para llevar la cuenta de letras en comun de una palabra con otra.
		int contLetra=0;
		
		for(int i=0;i<diccionario.size();i++){
			
			fin=obtenerPalabra(i);
			
		}
		
	}
	
	
	/**
	 * Metodo al que se le pasa una posicion y devuelve la palabra que se encuentra en esa posicion del diccionario.
	 * @param pos
	 * @return
	 */
	public static String obtenerPalabra(int pos){
		
		String palabra=diccionario.get(pos);
		
		return palabra;
		
	}
	
	/**
	 * Metodo al cual se le pasa como parametro la entrada, y esta compruebla que tenga solucion, por las longitudes de las 2 palabras, si tiene solucion las divide en el origen y
	 * en el destino, para poder seguir trabajando con ellas.	
	 * @param entrada
	 */
	public static void trataEntrada(String entrada){
		
		String origen;
		String destino;
		
		if(entrada.length()%2!=0){
			
			estado=false;
			
		}else{
			
			origen=entrada.substring(0, entrada.length()/2);
			destino=entrada.substring(entrada.length()/2, entrada.length());
			
			juego(origen, destino);
			
		}
		
	}
	
	/**
	 * El main lo que hace es leer las palabras del diccionario , y las trasformaciones a realizar. 
	 * Inicializa un array de 0 y 1 para saber que palabras hemos utilizado.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		utilizadas=new int[25143];
		
		String palabra="0";
		int cont=0;

		while(palabra.length()!=0){
			
			if(cont<=25143){
				
				palabra=sc.nextLine();
				
				diccionario.put(cont, palabra);
				
				cont++;
				
			}		
			
		}
		
		String transformacion="0";
		
		while(transformacion.length()!=0){
			
			//Este for lo que hace es inicializar a 0 el array cada vez que tenemos una nueva interaccion
			for(int i=0;i<utilizadas.length;i++){
				utilizadas[i]=0;
			}
			
			transformacion=sc.nextLine();
			
			trataEntrada(transformacion.replace(" ", ""));
			
			
		}		
		
		sc.close();
		
	}

}
