package fr.epsi.a100foot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

class SecondActivity extends AppCompatActivity {
    private ArrayList<Object> listMatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ListView laListView = findViewById(R.id.myListView);

        FootDataReader lesMatchDataReader = new FootDataReader(this, "france.csv");
        lesMatchDataReader.mettreAJourListe(true);

        ArrayList<Match> match = lesMatchDataReader.getListesMatchs();
        this.listMatch = new ArrayList<>();
        listMatch.addAll(match);

        ListArrayAdapter matchArrayAdapter = new ListArrayAdapter(this, R.layout.text_list_item, this.listMatch);

        laListView.setAdapter(matchArrayAdapter);
    }
}
