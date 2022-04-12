package fr.iutrodez.depenses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

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
            case R.id.menu_graphique_depenses:    // affiche le graphique des dépenses
                //TODO
                break;
            case R.id.menu_annuler:
                break;
        }
        return (super.onOptionsItemSelected(item));
    }

    public void ajouterDepense(View view) {
    }
}