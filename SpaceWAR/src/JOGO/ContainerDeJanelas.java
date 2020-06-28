package jogo;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;


public class ContainerDeJanelas extends JFrame{
	Sequencer player; //ESSE É O NOSSO TOCADOR
        String musica1 = "res/SomFundo.midi";	//ISSO É SÓ A URL DA NOSSA MÚSICA
        String musica2 = "res/campo.mid";	//ISSO AQUI TAMBÉM É OUTRA URL
	
        public ContainerDeJanelas(){
		
		JMenuBar barraMenu = new JMenuBar();
		
		JMenu menu = new JMenu("Menu");

		JMenuItem sobre = new JMenuItem("Sobre");
		sobre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "Jogo desenvolvido em JOGOS DIGITAIS.\n"
                                        + "Teclas para jogar: \n"
                                        + "Direcionais para mover a nave. \n"
                                        + "Barra de espaço para disparar os misseis. \n"
                                        + "Para jogar novamente pressione a tecla ENTER. \n", "Informações", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JMenuItem sair = new JMenuItem("Sair");
		sair.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		menu.add(sobre);
		menu.add(new JSeparator());
		menu.add(sair);
		
		barraMenu.add(menu);
		
		setJMenuBar(barraMenu);
		
		
		add(new Fase());
		setTitle("Desenvolvimento de Jogos digitais");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,420);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
                tocarMusica(musica1, 999);
                
                
	}
        public void tocarMusica(String nome, int repetir){
		
            try{ player = 
			player = MidiSystem.getSequencer();		//INICIA O TOCADOR
			Sequence musica = MidiSystem.getSequence(new File(nome));//CARREGA A MÚSICA A SER TOCADA
			player.open();	//ABRE O TOCADOR
			player.setSequence(musica);	//PASSA A MÚSICA QUE VAI SER TOCADA PARA O TOCADOR
			player.setLoopCount(repetir); //DEFINE QUANTAS VEZES VAI TOCAR A MÚSICA OBS: 0 = 1 vez; 1 = 2 vezes; 2 = 3 vezes...
			player.start();	//COMEÇA A TOCAR.... CASO QUEIRA PARAR DE TOCAR A MÚSICA BASTA: player.stop();
		}catch(Exception e){
			System.out.println("Erro ao tocar: "+nome);
                }
    } 
        	
	
	public static void main(String[] args) {	
            
            new ContainerDeJanelas();
            
	}
}
