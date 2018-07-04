/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reloj;

import java.util.Calendar;
import javax.swing.JLabel;

/**
 *
 * @author JuandeJesus
 */
public class LabelR extends Thread {

    JLabel et;

    public LabelR() {

    }

    @Override

    public void run() {

        Calendar calendario = Calendar.getInstance();
        int hora, minuto, segundos;
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minuto = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        //        hor(hora, minutos, segundos);
        et.setText(hora + ":" + minuto + ":" + segundos);
        int a = 0, b = 0, c = 0;
        String h = "am";
        for (a = hora; true; hora++) {
            System.out.println(a);
            if (b == 60) {
                minuto = 0;
            }
            if (a > 12 && a < 24) {
                hora -= 12;
                a -= 12;
                h = "pm";
                
            }
            if (a == 24) {
                hora = 0;
                a = 0;
                h = "am";
            }
//           
            for (b = minuto; b < 60; b++) {
                if (c == 60) {
                    segundos = 0;
                    c = 0;
                }
//              
                

                for (c = segundos; c < 60; c++) {

                    try {
//                        System.out.println(c + "Segundos");
                        
                        if (c < 10) {
                            if(b<10){  et.setText(a + ":" +"0"+ b + ":" + "0" + c + h);}
                            else
                                System.out.println(a + ":" + b + ":" + "0" + c + h);
                            et.setText(a + ":" + b + ":" + "0" + c + h);

                        } else {
                            et.setText(a + ":" + b + ":"  + c + h);
                        }
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }

                }

            }
        }

    }

    public void recibeEt(JLabel etiqueta) {
        this.et = etiqueta;
    }

}
