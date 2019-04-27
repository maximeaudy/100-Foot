package fr.epsi.a100foot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {

    protected ArrayList<Match> listMatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
