package jogo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Inimigo {

	private Image imagem;
	private int x, y;
	private int largura, altura;
	private boolean isVisivel;

	private static final int LARGURA_TELA = 500;
	private static int VELOCIDADE;

	private static int contador = 0;
	
	public Inimigo(int x, int y) {

		this.x = x;
		this.y = y;

		ImageIcon referencia;

		if(contador++ % 6 == 0){
			VELOCIDADE = 3;
                        referencia = new ImageIcon("res\\inimigo_1.gif");
                        
		} else {
			VELOCIDADE = 1;
                        referencia = new ImageIcon("res\\inimigo_2.gif");
                        
		}
		imagem = referencia.getImage();
		
		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);

		isVisivel = true;
	}

	public void mexer(){

		if(this.x < 0){
			this.x = LARGURA_TELA;
		} else {
			this.x -= VELOCIDADE;
		}
		
	}
	
	public boolean isVisivel() {
		return isVisivel;	
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public Image getImagem() {
		return imagem;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, largura, altura);
	}
	
}
