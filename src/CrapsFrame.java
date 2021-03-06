import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CrapsFrame extends JFrame {
	
	private final JPanel panelBotoes;
	private final JPanel panelInformacoes;	
	private final JPanel panelStatus;	
	
	private final JButton botaoJogarDados;
	private final JButton botaoIniciar;
	private final JButton botaoJogarNovamente;
	
	
	private final JLabel labelDadoUm;
	private final JLabel labelDadoDois;
	private final JLabel labelSoma;
	private final JLabel labelPontuacao;
	private final JLabel labelStatus;
	
	private final JTextField textoDadoUm;
	private final JTextField textoDadoDois;
	private final JTextField textoSoma;
	private final JTextField textoPontuacao;
	
	
	public CrapsFrame() {
		
		super("Jogo de Craps");
		setLayout(new GridLayout(3, 1));
		
		panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());
		add(panelBotoes);
		
		panelStatus = new JPanel();
		panelStatus.setLayout(new FlowLayout());
		add(panelStatus);
		
		panelInformacoes = new JPanel();
		panelInformacoes.setLayout(new GridLayout(4, 2));
		add(panelInformacoes);
		
		botaoJogarDados = new JButton("Jogar Dados!");
		botaoIniciar = new JButton("Iniciar!");
		botaoJogarNovamente = new JButton("Jogar Novamente!");
		
		panelBotoes.add(botaoIniciar);
		panelBotoes.add(botaoJogarDados);
		panelBotoes.add(botaoJogarNovamente);
		
		labelStatus = new JLabel("Teste");
		panelStatus.add(labelStatus);
		
		labelDadoUm = new JLabel("Dado 1");
		labelDadoDois = new JLabel("Dado 2");
		labelSoma = new JLabel("Soma");
		labelPontuacao = new JLabel("Pontua��o Vencedora");
		
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
		
		botaoJogarDados.setVisible(false);
		botaoJogarNovamente.setVisible(false);
		panelStatus.setVisible(false);
		panelInformacoes.setVisible(false);
		
		Craps craps = new Craps();
		
		botaoIniciar.addActionListener(
				
					new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							
							
							botaoIniciar.setVisible(false);
							botaoJogarDados.setVisible(true);
							panelStatus.setVisible(true);
							panelInformacoes.setVisible(true);
							textoPontuacao.setVisible(false);
							labelPontuacao.setVisible(false);
							
							craps.iniciaJogo();
							
							textoDadoUm.setText(Integer.toString(craps.getDado1()));
							textoDadoDois.setText(Integer.toString(craps.getDado2()));
							textoSoma.setText(Integer.toString(craps.getSomaDosDados()));
							
							if(craps.getStatusDoJogo() == Status.PERDEU) {
								
								labelStatus.setText(String.format("VOC� perdeu!!! Voc� tirou um %d na primeira jogada.", craps.getSomaDosDados()));
								botaoJogarDados.setVisible(false);
								botaoJogarNovamente.setVisible(true);
								
							}else if(craps.getStatusDoJogo() == Status.VENCEU) {
								
								labelStatus.setText(String.format("VOC� VENCEU!!! Voc� tirou um %d na primeira jogada.", craps.getSomaDosDados()));
								botaoJogarDados.setVisible(false);
								botaoJogarNovamente.setVisible(true);
								
							}else if(craps.getStatusDoJogo() == Status.CONTINUA) {
								
								textoPontuacao.setVisible(true);
								textoPontuacao.setText(Integer.toString(craps.getMeuPonto()));
								labelPontuacao.setVisible(true);
								
								
								labelStatus.setText(String.format("A sua pontua��o vencedora � %d", craps.getMeuPonto()));
								
							}
							
							
							
						}
						
					}
					
				);
		
		botaoJogarDados.addActionListener(
				
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						craps.jogaDados();
						
						textoDadoUm.setText(Integer.toString(craps.getDado1()));
						textoDadoDois.setText(Integer.toString(craps.getDado2()));
						textoSoma.setText(Integer.toString(craps.getSomaDosDados()));
						
						if(craps.verificaJogo() == Status.VENCEU) {
							
							botaoJogarNovamente.setVisible(true);
							botaoJogarDados.setVisible(false);
							labelStatus.setText(String.format("VOC� VENCEU!!! Voc� tirou um %d", craps.getSomaDosDados()));
							
						}else if(craps.verificaJogo() == Status.PERDEU) {
							
							botaoJogarNovamente.setVisible(true);
							botaoJogarDados.setVisible(false);
							labelStatus.setText(String.format("VOC� PERDEU!!! Voc� tirou um %d", craps.getSomaDosDados()));
							
						}else if(craps.verificaJogo() == Status.CONTINUA) {
							
							labelStatus.setText(String.format("Voc� tirou um %d, Voc� precisa de um %d", craps.getSomaDosDados(), 
									craps.getMeuPonto()));
							
						}
						
					}
					
					
					
				}
				
		);
		
		botaoJogarNovamente.addActionListener(
				
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						botaoIniciar.setVisible(true);
						botaoJogarNovamente.setVisible(false);
						botaoJogarDados.setVisible(false);
						
						panelInformacoes.setVisible(false);
						panelStatus.setVisible(false);
						
					}
					
					
					
				}
				
		);
		
		
	}

}
