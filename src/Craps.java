import java.security.SecureRandom;

public class Craps {
	
	private static final SecureRandom aleatorio = new SecureRandom();
	
	private enum Status{CONTINUA, VENCEU, PERDEU};
	
	private static final int SNAKE_EYES = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_LEVEN = 11;
	private static final int BOX_CARS = 12;

	public static void main(String[] args) {
		
		
		int meuPonto = 0;
		Status statusDoJogo;
		
		int somaDosDados = jogaDados();
		
		switch(somaDosDados) {
		
			case SEVEN:
			case YO_LEVEN:
				statusDoJogo = Status.VENCEU;
				break;
			case SNAKE_EYES:
			case TREY:
			case BOX_CARS:
				statusDoJogo = Status.PERDEU;
				break;
			default:
				statusDoJogo = Status.CONTINUA;
				meuPonto = somaDosDados;
				System.out.printf("A pontuação é %d%n", meuPonto);
		}
		
		while(statusDoJogo == statusDoJogo.CONTINUA) {
			
			somaDosDados = jogaDados();
			
			if(somaDosDados == meuPonto) {
				
				statusDoJogo = Status.VENCEU;
				
			}else if(somaDosDados == SEVEN) {
				
				statusDoJogo = Status.PERDEU;
				
			}
			
		}
		
		if(statusDoJogo == Status.VENCEU) {
			System.out.println("O Jogador venceu!");
		}else {
			System.out.println("O Jogador perdeu!");
		}
		

	}
	
	public static int jogaDados() {
		
		int dado1 = 1 + aleatorio.nextInt(6);
		int dado2 = 1 + aleatorio.nextInt(6);
		int soma = dado1 + dado2;
		
		System.out.printf("O Jogador tirou nos dados %d + %d = %d%n", dado1, dado2, soma);
		
		return soma;
	}

}
