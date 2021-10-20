import java.util.Scanner;

public class ContadorDeFelicidad {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		char[] Arraycaracters;
		String caracter;
		int contadorFeliz = 0, contadorTriste = 0;

		try {
			
			System.out.println("INGESE FRASE");
			String frase = scan.nextLine();
		
			//Separa o String en  char[]
			Arraycaracters = frase.toCharArray();
			
			for (int i = 0; i < Arraycaracters.length; i++) {
			
				//Reparte todo en equipos de 3 char
				caracter = "" + Arraycaracters[i] + Arraycaracters[i + 1] + Arraycaracters[i + 2];
				
				//Avalia los equipos y evalua si cumplen con los emogis
				if (caracter.equals(":-)"))
					contadorFeliz++;
				if (caracter.equals(":-("))
					contadorTriste++;
			}
		} catch (Exception e) {
		}

		
		//Calculo de Felicidad
		if (contadorFeliz > contadorTriste)
			System.out.println("divertido");
		else if (contadorFeliz < contadorTriste)
			System.out.println("chateado");
		else
			System.out.println("neutro");

	}

}
