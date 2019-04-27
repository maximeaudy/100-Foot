package fr.epsi.a100foot;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;

import android.os.Environment;
import android.util.Log;
import java.io.IOException;

public class FootDataReader {

    protected ArrayList<Match> listesMatchs;
    protected Context context;
    protected String country;

    public FootDataReader(Context context, String country) {
        this.context = context;
        this.country = country;
    }

    public void mettreAJourListe(boolean premierLigneContientIntitules){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            listesMatchs = new ArrayList<>();
            String root = Environment.getExternalStorageDirectory().toString();
            InputStream is = new FileInputStream(root+"/"+this.country);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            String csvSplitBy = ";";

            if(premierLigneContientIntitules) {
                br.readLine(); //On lit pour rien la première ligne qui contient les intitulés de colonnes
            }

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(csvSplitBy);
                Match unMatch = new Match();

                //On récupère le titre
                unMatch.setTitre(columns[0]);

                //On récupère la date
                String dateFermetureAsString = columns[1];
                Date datePublication = simpleDateFormat.parse(dateFermetureAsString);
                unMatch.setDatePublication(datePublication);

                listesMatchs.add(unMatch);
            }
        }catch(IOException e){
            Log.v("ERROR","Erreur lors de la tentative de lecture du fichier CSV." + e.getLocalizedMessage());

        }catch(ParseException e){
            Log.v("ERROR","Erreur lors de la lecture de la date" + e.getLocalizedMessage());
        }


    }

    public ArrayList<Match> getListesMatchs() {
        return listesMatchs;
    }

}
