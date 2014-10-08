
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PatrickJoshua
 */
public class BlinkySound extends Thread {
    @Override
    public void run() {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("tone.wav"));
            Clip tone = AudioSystem.getClip();
            tone.open(ais);
            tone.start();
            if(System.getProperty("os.name").contains("Mac OS X"))
            {
                String tts = "Now serving " + ControllerDisplay.dNowServing.getText() + " on counter " + ControllerDisplay.counter;
                Runtime.getRuntime().exec("say " + tts);
            }
            ControllerDisplay.dNowServing.setForeground(Color.red);
            Thread.sleep(1000);
            ControllerDisplay.dNowServing.setForeground(Color.black);
            Thread.sleep(1000);
            ControllerDisplay.dNowServing.setForeground(Color.red);
            Thread.sleep(1000);
            ControllerDisplay.dNowServing.setForeground(Color.black);
            Thread.sleep(1000);
            ControllerDisplay.dNowServing.setForeground(Color.red);
            Thread.sleep(1000);
            ControllerDisplay.dNowServing.setForeground(Color.black);
            Thread.sleep(1000);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException x) {
            System.out.println("Error playing notification tone. " + x.getMessage());
        }
    }
}
