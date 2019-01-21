import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CrapsFrame extends JFrame {
	
	private final JPanel panelBotoes;
	private final JPanel panelInformacoes;	
	
	private final JButton botaoJogarDados;
	private final JButton botaoIniciar;
	private final JButton botaoJogarNovamente;
	
	
	private final JLabel labelDadoUm;
	private final JLabel labelDadoDois;
	private final JLabel labelSoma;
	private final JLabel labelPontuacao;
	
	private final JTextField textoDadoUm;
	private final JTextField textoDadoDois;
	private final JTextField textoSoma;
	private final JTextField textoPontuacao;
	
	
	public CrapsFrame() {
		
		super("Jogo de Craps");
		setLayout(new GridLayout(2, 1));
		
		panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());
		add(panelBotoes);
		
		panelInformacoes = new JPanel();
		panelInformacoes.setLayout(new GridLayout(4, 2));
		add(panelInformacoes);
		
		botaoJogarDados = new JButton("Jogar Dados!");
		botaoIniciar = new JButton("Iniciar!");
		botaoJogarNovamente = new JButton("Jogar Novamente!");
		
		panelBotoes.add(botaoIniciar);
		panelBotoes.add(botaoJogarDados);
		panelBotoes.add(botaoJogarNovamente);
		
		labelDadoUm = new JLabel("Dado 1");
		labelDadoDois = new JLabel("Dado 2");
		labelSoma = new JLabel("Soma");
		labelPontuacao = new JLabel("Pontuação Vencedora");
		
		textoDadoUm = new JTextField();
		textoDadoDois = new JTextField();
		textoSoma = new JTextField();
		textoPontuacao = new JTextField();
		
		panelInformacoes.add(labelDadoUm);
		panelInformacoes.add(textoDadoUm);
		panelInformacoes.add(labelDadoDois);
		panelInformacoes.add(textoDadoDois);
		panelInformacoes.add(labelSoma);
		panelInformacoes.add(textoSoma);
		panelInformacoes.add(labelPontuacao);
		panelInformacoes.add(textoPontuacao);
		
	}

}
