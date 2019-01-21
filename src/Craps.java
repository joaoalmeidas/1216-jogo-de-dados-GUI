import java.security.SecureRandom;

public class Craps {
	
	private static final SecureRandom aleatorio = new SecureRandom();
	
	private enum Status{CONTINUA, VENCEU, PERDEU};
	
	private static final int SNAKE_EYES = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_LEVEN = 11;
	private static final int BOX_CARS = 12;
	
	private int meuPonto = 0;
	private Status statusDoJogo = Status.CONTINUA;
	private int somaDosDados;


	public Craps(){
		
		somaDosDados = jogaDados();
		
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
	}
		

	
	public int getMeuPonto() {
		return meuPonto;
	}


	public void setMeuPonto(int meuPonto) {
		this.meuPonto = meuPonto;
	}


	public Status getStatusDoJogo() {
		return statusDoJogo;
	}

	public void setStatusDoJogo(Status statusDoJogo) {
		this.statusDoJogo = statusDoJogo;
	}


	public int getSomaDosDados() {
		return somaDosDados;
	}


	public void setSomaDosDados(int somaDosDados) {
		this.somaDosDados = somaDosDados;
	}


	public static SecureRandom getAleatorio() {
		return aleatorio;
	}
	

	public static int jogaDados() {
		
		int dado1 = 1 + aleatorio.nextInt(6);
		int dado2 = 1 + aleatorio.nextInt(6);
		int soma = dado1 + dado2;
		
		return soma;
	}

}
