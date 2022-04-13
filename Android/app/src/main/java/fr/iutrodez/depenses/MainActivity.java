package fr.iutrodez.depenses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Méthode invoquée automatiquement lorsque l'utilisateur active le menu d'options,
     * pour la première fois
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        /*
         *  on désérialise le fichier XML décriant le menu et on l'associe
         *  au menu argument (celui qui a été activé)
         */
        new MenuInflater(this).inflate(R.menu.menu_contextuel, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Méthode invoquée automatiquement lorsque l'utilisateur choisira une option
     * dans le menu d'options
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // selon l'option sélectionnée dans le menu, on réalise le traitement adéquat
        switch(item.getItemId()) {
            case R.id.menu_liste_depenses :  		 // affiche la liste des dépenses
                //TODO
                break;
            case R.id.menu_graphique_depenses:   	// affiche le graphique des dépenses
                Intent myIntent = new Intent(getBaseContext(), PartDepenses.class);
                startActivityForResult(myIntent, 0);
                Log.i("Depense", "Déplacement vers part dépenses");
                break;
            case R.id.menu_annuler :
                break;
        }
        return (super.onOptionsItemSelected(item));
    }
}