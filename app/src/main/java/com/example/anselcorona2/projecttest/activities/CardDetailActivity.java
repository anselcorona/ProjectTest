package com.example.anselcorona2.projecttest.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.anselcorona2.projecttest.R;
import com.example.anselcorona2.projecttest.entities.Card;

public class CardDetailActivity extends AppCompatActivity {

    private TextView title;
    private TextView nivel;
    private TextView body;
    private TextView date;

    private TextView AuthorName;
    private TextView AuthorNivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_detail);
        Bundle extras = getIntent().getExtras();
        assert extras != null;
        Card c = extras.getParcelable("card");

        title = findViewById(R.id.detail_view_title);
        nivel = findViewById(R.id.detail_view_nivel);
        body = findViewById(R.id.detail_view_body);
        date = findViewById(R.id.detail_view_date);
        AuthorName = findViewById(R.id.detail_view_author_name);
        AuthorNivel = findViewById(R.id.detail_view_author_nivel);

        title.setText(c.getTitle());
        nivel.setText(c.getNivel());
        body.setText(c.getBody());
        date.setText(c.getFecha().toString());
        AuthorName.setText(c.getAuthor().getName());
        AuthorNivel.setText(c.getAuthor().getLevel());
    }
}
