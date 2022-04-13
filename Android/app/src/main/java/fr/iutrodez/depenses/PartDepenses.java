package fr.iutrodez.depenses;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartDepenses extends AppCompatActivity {

    private ProgressBar barre1;
    private ProgressBar barre2;
    private ProgressBar barre3;
    private ProgressBar barre4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.part_depenses);
        barre1 = findViewById(R.id.progressBar1);
        barre2 = findViewById(R.id.progressBar2);
        barre3 = findViewById(R.id.progressBar3);
        barre4 = findViewById(R.id.progressBar4);
        setData();
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
     * Méthode bouchon pour afficher des données à titre d'exemple pour les graphes
     */
    public void setData() {
        barre1.setProgress(5);
        barre2.setProgress(15);
        barre3.setProgress(30);
        barre4.setProgress(50);
    }

    /**
     * Méthode invoquée automatiquement lorsque l'utilisateur choisira une option
     * dans le menu d'options
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // selon l'option sélectionnée dans le menu, on réalise le traitement adéquat
        switch (item.getItemId()) {
            case R.id.menu_liste_depenses:         // affiche la liste des dépenses
                Intent myIntent = new Intent(getBaseContext(), MainActivity.class);
                startActivityForResult(myIntent, 0);
                break;
            case R.id.menu_graphique_depenses:    // affiche le graphique des dépenses
                Intent myIntent2 = new Intent(getBaseContext(), PartDepenses.class);
                startActivityForResult(myIntent2, 0);
                break;
            case R.id.menu_annuler:
                break;
        }
        return (super.onOptionsItemSelected(item));
    }
}
