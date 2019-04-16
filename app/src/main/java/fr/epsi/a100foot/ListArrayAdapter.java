package fr.epsi.a100foot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

public class ListArrayAdapter extends ArrayAdapter {

    protected int listItemRessources;

    public ListArrayAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.listItemRessources = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Match leMatch = (Match)getItem(position);

        View matchListItem;
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            matchListItem = layoutInflater.inflate(this.listItemRessources, parent, false);
        } else {
            matchListItem = convertView;
        }

        TextView textViewTitle = matchListItem.findViewById(R.id.textViewTitle);
        TextView textViewDate = matchListItem.findViewById(R.id.textViewDate);

        textViewTitle.setText(leMatch.getTitre());
        textViewDate.setText(new SimpleDateFormat("dd-MM-yyyy' à ' H:mm").format(leMatch.getDatePublication()));

        return matchListItem;
    }
}
