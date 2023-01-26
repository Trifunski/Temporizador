import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.Timer;

public class Temporizador {
    
    public static void main(String[] args) {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        /* int height = (int) screenSize.getHeight(); */

        JFrame frame = new JFrame();

        frame.setUndecorated(true);
        frame.setBackground(new Color(0,0,0,0));
    
        frame.setVisible(true);

        frame.setSize(200, 200);

        frame.setAlwaysOnTop(true);
        
        JLabel timerLabel = new JLabel("01:00:00");
        timerLabel.setForeground(Color.WHITE);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 30));
        frame.add(timerLabel);

        frame.setLocation(width - 140, -70);

        String tiempo = JOptionPane.showInputDialog(frame, "Ingresa el tiempo en formato horas:minutos:segundos:");
        
        timerLabel.setText(tiempo);
        
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                
                String[] tiempo = timerLabel.getText().split(":");
                int horas = Integer.parseInt(tiempo[0]);
                int minutos = Integer.parseInt(tiempo[1]);
                int segundos = Integer.parseInt(tiempo[2]);
                segundos--;
                
                if (segundos < 0) {
                    segundos = 59;
                    minutos--;
                }
                
                if (minutos < 0) {
                    minutos = 59;
                    horas--;
                }
                
                if (horas < 0) {
                    horas = 0;
                    minutos = 0;
                    segundos = 0;
                }
                
                timerLabel.setText(String.format("%02d:%02d:%02d", horas, minutos, segundos));
            }
        }, 0, 1000);

    }

}
