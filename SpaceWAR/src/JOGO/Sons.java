/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JOGO;

import java.io.File;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

/**
 *
 * @author Ilgner
 */
public class Sons {

 
Sequencer player; //ESSE É O NOSSO TOCADOR
String musica1 = "res/batalha.mid";	//ISSO É SÓ A URL DA NOSSA MÚSICA
String musica2 = "res/campo.mid";	//ISSO AQUI TAMBÉM É OUTRA URL	
        
    public Sons() {
        
     
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
   
}
    
    
    
