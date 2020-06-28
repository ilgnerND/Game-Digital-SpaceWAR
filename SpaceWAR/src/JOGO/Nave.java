package jogo;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

import javax.swing.ImageIcon;

public class Nave {

	private int x, y;
	private int dx, dy;
	private int altura, largura;
	private boolean isVisivel;

	private Image imagem;
	Sequencer player; 
        String musica2 = "res/campo.mid";
	private List<Missel> misseis;
	
	public Nave(){
		
		ImageIcon referencia = new ImageIcon("res\\nave3.gif");
		imagem = referencia.getImage();
		
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
		
		misseis = new ArrayList<Missel>();
		
		this.x = 100;
		this.y = 100;
		
	}
	
	public void mexer(){

		x += dx; // 1 e 462
		y += dy; // 1 e 340

		if(this.x < 1){
			x = 1;
		}
		
		if(this.x > 462){
			x = 462;
		}
		
		if(this.y < 1){
			y = 1;
		}

		if(this.y > 340){
			y = 340;
		}
		
	}
	
	public List<Missel> getMisseis() {
		return misseis;
	}
        public void tocarMusica(String nome, int repetir){
		
            try{
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

	public int getX() {
		return x;
	}
	
	public int getY() {	
		return y;
	}
	
	public Image getImagem() {
		return imagem;
	}

	public boolean isVisivel() {
		return isVisivel;
	}
	
	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}
	
	public void atira(){
		this.misseis.add(new Missel(x+largura, y + altura/2 ));
                tocarMusica(musica2, 999);
	}

	public Rectangle getBounds(){
		return new Rectangle(x, y, largura, altura);
	}
	
	
	public void keyPressed(KeyEvent tecla){
		
		int codigo = tecla.getKeyCode();
		
		if(codigo == KeyEvent.VK_SPACE){
			atira();
                }        

		if(codigo == KeyEvent.VK_UP){
			dy = -1;
		}
		
		if(codigo == KeyEvent.VK_DOWN){
			dy = 1;
		}
		
		if(codigo == KeyEvent.VK_LEFT){
			dx = -1;
		}
		
		if(codigo == KeyEvent.VK_RIGHT){
			dx = 1;
		}
		
	}
	
	public void keyReleased(KeyEvent tecla){
		
		int codigo = tecla.getKeyCode();
		
		if(codigo == KeyEvent.VK_UP){
			dy = 0;
		}
 
		if(codigo == KeyEvent.VK_DOWN){
			dy = 0;
		}
		
		if(codigo == KeyEvent.VK_LEFT){
			dx = 0;
		}
		
		if(codigo == KeyEvent.VK_RIGHT){
			dx = 0;
		}
		
	}
	
	
}
