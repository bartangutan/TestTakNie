package com.example.testtaknie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button buttonTak, buttonNie, buttonNastepny;
    ImageView imageView;
    TextView textView;
    private ArrayList<Pytanie> wszystkiePytania = new ArrayList<>();
    int licznikPytan = 0;
    int ileDobrych = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonTak = findViewById(R.id.button);
        buttonNie = findViewById(R.id.button2);
        buttonNastepny = findViewById(R.id.button3);
        textView = findViewById(R.id.textViewTrescPytania);
        imageView = findViewById(R.id.imageView2);

        wszystkiePytania.add(new Pytanie("Czy na zdjęciu jest gnu?", R.drawable.gnu, true));
        wszystkiePytania.add(new Pytanie("Czy na zdjęciu widać Alpy?", R.drawable.tatry, false));
        wszystkiePytania.add(new Pytanie("Czy po angielsku to scateboard?", R.drawable.deska, true));

        wyswietlPytanie(0);

        buttonTak.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(wszystkiePytania.get(licznikPytan).isPoprawnaOdpowiedz()==true){
                            Toast.makeText(MainActivity.this, "Dobra odpowiedź", Toast.LENGTH_SHORT).show();
                            ileDobrych++;
                        }else{
                            Toast.makeText(MainActivity.this, "Zła odpowiedź", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );
        buttonNie.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(wszystkiePytania.get(licznikPytan).isPoprawnaOdpowiedz()==false){
                            Toast.makeText(MainActivity.this, "Dobra odpowiedź", Toast.LENGTH_SHORT).show();
                            ileDobrych++;
                        }else{
                            Toast.makeText(MainActivity.this, "Zła odpowiedź", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );
        buttonNastepny.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(licznikPytan == wszystkiePytania.size()-1){
                            buttonTak.setVisibility(View.INVISIBLE);
                            buttonNie.setVisibility(View.INVISIBLE);
                            buttonNastepny.setVisibility(View.INVISIBLE);
                            textView.setText("Koniec testu. Poprawdne: "+ileDobrych);
                            return;

                        }
                        licznikPytan++;
                        wyswietlPytanie(licznikPytan);
                    }
                }
        );

    }

    private void wyswietlPytanie(int ktore){
        //image view, text view
        Pytanie pytanie = wszystkiePytania.get(ktore);

        //imageView
        imageView.setImageResource(pytanie.getIdObrazka());
        textView.setText(pytanie.getTresc());

    }
}