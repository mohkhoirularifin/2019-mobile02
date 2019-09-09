package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
//	int random, guess;
	private int random;
	private EditText masukkanAngka;
	private Button tombol;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
        masukkanAngka = findViewById(R.id.number_input);
        tombol = findViewById(R.id.guess_button);
	}

	@Override
	protected void onStart() {
		super.onStart();
		initRandomNumber();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
//		random = (int) (Math.random()*100);
		Random random = new Random();
		int rando = random.nextInt(101);
//		int rando = random.nextInt(4);
//		int rando = random.nextInt(6);
		this.random = rando;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		tombol.setEnabled(false);
        String sIn = masukkanAngka.getText().toString();
        int     in = Integer.parseInt(sIn);
                if (in > random){
                    Toast.makeText(this, "Tebakan anda terlalu besar", Toast.LENGTH_SHORT).show();
                }
                else if(in < random){
                    Toast.makeText(this, "Tebakan anda terlalu kecil", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this, "Tebakan anda benar", Toast.LENGTH_SHORT).show();
                }

	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		masukkanAngka.setText("");
		tombol.setEnabled(true);
		initRandomNumber();
	}
}
