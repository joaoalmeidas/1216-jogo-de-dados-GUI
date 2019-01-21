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
	private Status statusDoJogo;
	private int somaDosDados;
	private int dado1;
	private int dado2;

	
	public void iniciaJogo(){
		
		setSomaDosDados(jogaDados());
		
		switch(getSomaDosDados()) {
		
			case SEVEN:
			case YO_LEVEN:
				setStatusDoJogo(Status.VENCEU);
				break;
			case SNAKE_EYES:
			case TREY:
			case BOX_CARS:
				setStatusDoJogo(Status.PERDEU);
				break;
			default:
				setStatusDoJogo(Status.CONTINUA);
				setMeuPonto(getSomaDosDados());
				
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
	
	

	public int getDado1() {
		return dado1;
	}



	public void setDado1(int dado1) {
		this.dado1 = dado1;
	}



	public int getDado2() {
		return dado2;
	}



	public void setDado2(int dado2) {
		this.dado2 = dado2;
	}



	public int jogaDados() {
		
		setDado1( 1 + aleatorio.nextInt(6));
		setDado2( 1 + aleatorio.nextInt(6));
		setSomaDosDados(getDado1() + getDado2());
		
		return getSomaDosDados();
	}
	
	public Status verificaJogo() {
		
		if(getSomaDosDados() == getMeuPonto()) {
			
			return Status.VENCEU;
			
		}else if(getSomaDosDados() == SEVEN) {
			
			return Status.PERDEU;
			
		}else {
			
			return Status.CONTINUA;
			
		}
		
	}
}
