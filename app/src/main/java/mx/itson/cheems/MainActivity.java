package mx.itson.cheems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
public int ubicacion=0;
public int contador=0;
int[] destapadas = new int[12];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciar();
        Button btnReiniciar =(Button)findViewById(R.id.btn_reiniciar);
        btnReiniciar.setOnClickListener(this);

        for (int i=1; i<=12; i++) {
            ImageButton btnSeleccion=(ImageButton)findViewById(getResources().getIdentifier("opcion"+i,"id",this.getPackageName()));
            btnSeleccion.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() ==R.id.opcion1){
            if(destapadas[0]!=1){  destapar(1); destapadas[0]=1;}
        }else
        if (v.getId() ==R.id.opcion2){
           if (destapadas[1]!=1){destapar(2);destapadas[1]=1;}
        }else
        if (v.getId() ==R.id.opcion3){
            if (destapadas[2]!=1){destapar(3);destapadas[2]=1;}
        }else
        if (v.getId() ==R.id.opcion4){
            if (destapadas[3]!=1){destapar(4);destapadas[3]=1;}
        }else
        if (v.getId() ==R.id.opcion5){
           if (destapadas[4]!=1){destapar(5);destapadas[4]=1;}
        }else
        if (v.getId() ==R.id.opcion6){
          if (destapadas[5]!=1){ destapar(6);destapadas[5]=1;}
        }
        if (v.getId() ==R.id.opcion7){
           if (destapadas[6]!=1){destapar(7);destapadas[6]=1;}
        }else
        if (v.getId() ==R.id.opcion8){
            if (destapadas[7]!=1){destapar(8);destapadas[7]=1;}
        }else
        if (v.getId() ==R.id.opcion9){
            if (destapadas[8]!=1){destapar(9);destapadas[8]=1;}
        }else
        if (v.getId() ==R.id.opcion10){
            if (destapadas[9]!=1){destapar(10);destapadas[9]=1;}
        }else
        if (v.getId() ==R.id.opcion11){
            if (destapadas[10]!=1){destapar(11);destapadas[10]=1;}
        }else if (v.getId() ==R.id.opcion12){
            if (destapadas[11]!=1) { destapar(12);destapadas[11]=1;}
        }else
        if (v.getId() ==R.id.btn_reiniciar){
            iniciar();
        }
    }
    public void iniciar(){
        (findViewById(R.id.opcion1)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion2)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion3)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion4)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion5)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion6)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion7)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion8)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion9)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion10)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion11)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion12)).setBackgroundResource(R.drawable.icon_pregunta);

        Random random = new Random();
        ubicacion = random.nextInt(11)+1;
contador=0;
        destapadas = new int[12];
    }


    public void destapar(int opcion){
        if(opcion == ubicacion){
            Toast.makeText(this, "Perdiste", Toast.LENGTH_SHORT).show();
            for (int i=1; i<=12; i++){
                ImageButton btnSeleccion=(ImageButton)findViewById(getResources().getIdentifier("opcion"+i,"id",this.getPackageName()));
                if (i==opcion){
                    btnSeleccion.setBackgroundResource(R.drawable.icon_cheems_llora);
                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    long[] wave = new long[]{
                            0,200,70,200,70,200
                    };
                    vibrator.vibrate(VibrationEffect.createWaveform(wave,-1));

                }else{
                    btnSeleccion.setBackgroundResource(R.drawable.icon_cheems);
                }

            }

        }else {

            ImageButton btnSeleccion = (ImageButton) findViewById(getResources().getIdentifier("opcion" + opcion, "id", this.getPackageName()));
            btnSeleccion.setBackgroundResource(R.drawable.icon_cheems);

            contador++;

            if(contador==11){

                ImageButton btngGanador=(ImageButton)findViewById(getResources().getIdentifier("opcion"+ubicacion,"id",this.getPackageName()));
                btngGanador.setBackgroundResource(R.drawable.cheems_win);
                Toast.makeText(this, "Ganaste", Toast.LENGTH_SHORT).show();

                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                long[] wave = new long[]{
                        0,200,70,200,70,500
                };
                vibrator.vibrate(VibrationEffect.createWaveform(wave,-1));


            }
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(VibrationEffect.createOneShot(20,VibrationEffect.DEFAULT_AMPLITUDE));
        }



    }

}
