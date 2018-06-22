package com.example.anselcorona2.projecttest.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.anselcorona2.projecttest.R;
import com.example.anselcorona2.projecttest.adapters.CardAdapter;
import com.example.anselcorona2.projecttest.entities.Author;
import com.example.anselcorona2.projecttest.entities.Card;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Card> cards = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<Boolean> redes = new ArrayList<>();

        redes.add(true);
        redes.add(false);
        redes.add(true);

        String[] tipos = new String[4];
        tipos[0] = "Asignación";
        tipos[1] = "Encuesta";
        tipos[2] = "Mensaje";
        tipos[3] = "Noticias";
        String[] nivel = new String[4];
        nivel[0] = "Nacional";
        nivel[1] = "Provincial";
        nivel[2] = "Municipal";
        nivel[3] = "Regional";
        Author Generic = new Author("Ansel Corona", "национален", "Santiago de los Caballeros");
        Random r = new Random();
        cards.add(new Card(tipos[RandomInteger(r)],"Titulo","you can use the ContextCompat.getColor() which is part of the Support V4 Library (so it will work for all the previous API).",nivel[RandomInteger(r)], redes , new Date(), Generic));
        cards.add(new Card(tipos[RandomInteger(r)], "Titulo","Espere a las 8:00 AM, nuestra  participación en el Programa Encuentro Matinal por Nexxo TV, como invitado para tratar temas de interés en el ámbito politico nacional.", nivel[RandomInteger(r)], redes, new Date(), Generic));
        cards.add(new Card(tipos[RandomInteger(r)], "Titulo","Comprendieron que la guerra era la paz del futuro! ...59 Aniversario de la Gesta insigne de Constanza, Maimón y Estero Hondo de 1959.   #14DeJunio", nivel[RandomInteger(r)], redes, new Date(), Generic));
        cards.add(new Card(tipos[RandomInteger(r)], "Titulo","Mañana es un dia histórico, tomará posesión el presidente más joven de un partido mayoritario actualmente, porque no sé si Leonel llegó a ser presidente del PLD, siendo más joven que Paliza.", nivel[RandomInteger(r)], redes, new Date(), Generic));
        cards.add(new Card(tipos[RandomInteger(r)], "Titulo","Osea que mientras el mundo entero volteo a ayudar para que Haiti pudiera salir del desastre en el que quedo su país a causa de varios desastres naturales, nuestro flamante senador Felix Bautista decidió aprovecharse de la situación. ", nivel[RandomInteger(r)], redes, new Date(), Generic));
        cards.add(new Card(tipos[RandomInteger(r)], "Titulo","Saben de que se aprovecho?  De los heridos, de los muertos, de la desgracia, de la necesidad y el dolor de nuestros vecinos Haitianos, y no solo de eso si no que también engaño y se aprovecho de todo aquel que en un acto de buena fe, de solidaridad y amor se despojo de algo para ayudar al sufrido pueblo Haitiano. ", nivel[RandomInteger(r)], redes, new Date(), Generic));
        cards.add(new Card(tipos[RandomInteger(r)], "Titulo","I thought ISC thesis should have something to do with software and actually creating software or technology", nivel[RandomInteger(r)], redes, new Date(), Generic));
        cards.add(new Card(tipos[RandomInteger(r)], "Titulo","Pues yo digo que lo correcto seria hacer algún junte con ellos por el kiosko y poder hacer algo con ellos. Si tienes contacto con esa gente hablales para poder hacer algo.", nivel[RandomInteger(r)], redes, new Date(), Generic));
        cards.add(new Card(tipos[RandomInteger(r)], "Titulo","estas claro que al departamento de nosotros es al que menos ayuda económica le dan y que el Barcamp de este año se quiere que sea grande, cierto ?", nivel[RandomInteger(r)], redes, new Date(), Generic));
        cards.add(new Card(tipos[RandomInteger(r)], "Titulo","Señores y que les parece nos juntamos con las matrículas más recientes, para que conozcan a su comité, sus compañeros de carrera y darles ánimo para que sigan tirando o lante?", nivel[RandomInteger(r)], redes, new Date(), Generic));
        cards.add(new Card(tipos[RandomInteger(r)], "Titulo","Podemos hablar de inteligencia de negocios, minería de datos (o hasta AI) para tomas de decisiones en el área de mercadotecnia, quizás hablar del proyecto de Frangel, que se hizo en conjunto en el dpto de Neurociencias de la uni", nivel[RandomInteger(r)], redes, new Date(), Generic));
        cards.add(new Card(tipos[RandomInteger(r)], "Titulo","Ya, hablando enserio, podemos prescindir de una reunión, pero entiendo que necesitamos cuajar una o dos de las actividades propuestas", nivel[RandomInteger(r)], redes, new Date(), Generic));
        cards.add(new Card(tipos[RandomInteger(r)], "Titulo","Lo tengo pendiente. Estoy entrevistando algunas personas que me respondieron previamente. Una vez concluya le contacto nuevamente.", nivel[RandomInteger(r)], redes, new Date(), Generic));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView feedRecyclerView = findViewById(R.id.feedRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        feedRecyclerView.setLayoutManager(linearLayoutManager);

        CardAdapter cardAdapter = new CardAdapter(MainActivity.this, cards);
        cardAdapter.setOnCardClickListener(new CardAdapter.OnCardClickListener() {
            @Override
            public void onCardClick(Card card) {
                Intent detalles = new Intent(getApplicationContext(), CardDetailActivity.class);
                detalles.putExtra("card", card);
                startActivity(detalles);
            }
        });
        feedRecyclerView.setAdapter(cardAdapter);

    }
    private static int RandomInteger(Random aRandom){
        long range = (long) 3 + 1;
        long fraction = (long)(range * aRandom.nextDouble());
        return (int)(fraction);
    }
}
