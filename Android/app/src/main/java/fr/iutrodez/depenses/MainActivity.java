package fr.iutrodez.depenses;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView texte;
    private TextView depenseMois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texte = findViewById(R.id.texte);
        depenseMois = findViewById(R.id.textViewDepenseMois);
        depenseMois.setText(getString(R.string.textViewDepenseMois) + "1800 €");

        /*
         * On récupère un accès à la Toolbar définie dans le fichier layout.
         * On associe cette Toolbar à l'activité courante.
        */
        Toolbar maBarreOutil = findViewById(R.id.ma_tool_bar);
        setSupportActionBar(maBarreOutil);

    }

    /**
     * Méthode invoquée à la première activation du menu d'options
     * @param menuActivite menu d'option activé
     * @return un booléen égal à vrai si le menu a pu être créé
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menuActivite) {
        // on désérialise la vue associée au menu
        getMenuInflater().inflate(R.menu.menu_barre_titre, menuActivite);
        // on récupère un accès à l'option permettant de lancer une recherche
        MenuItem itemRecherche = menuActivite.findItem(R.id.menu_recherche);
        /*
         * on récupère la vue affichée lors du lancement d'une recherche
         * (si l'utilisateur clique sur la loupe)
         * on modifie cette vue pour afficher une phrase d'indication dans la zone
         * de saisie du mot à chercher
         * on associe un écouteur à la zone de saisie
         */
        SearchView vuePourRecherche = (SearchView) itemRecherche.getActionView();
        vuePourRecherche.setQueryHint(getResources().getString(R.string.aide_recherche));
        vuePourRecherche.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            /**
             * Méthode invoquée quand l'utilisateur valide la recherche,
             * i.e. quand il clique sur la loupe du clavier virtuel
             * @param query texte tapé par l'utilisateur dans la zone de saisie
             * @return vrai si la recherche a pu être gérée
             */
            @Override
            public boolean onQueryTextSubmit(String query) {
                texte.setText(new StringBuilder(
                        getResources().getString(R.string.resultat_recherche)).append(query));
                return true;
            }
            /**
             * Méthode invoquée quand l'utilisateur modifie le texte de la recherche
             * @param s texte modifie
             * @return vrai si le changement de texte a pu être géré
             */
            @Override
            public boolean onQueryTextChange(String s) {
                return true;
            }
        });
        return true;
    }


    /**
     * Méthode invoquée automatiquement lorsque l'utilisateur choisira une option
     * dans le menu d'options
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // selon l'option sélectionnée dans le menu, on réalise le traitement adéquat
        switch(item.getItemId()) {
            case R.id.menu_aide :
                //TODO
                break;
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
        final View boiteSaisie = getLayoutInflater().inflate(R.layout.ajouter_depense, null);

        new AlertDialog.Builder(this)
                .setView(boiteSaisie)
                .setPositiveButton(getResources().getString(R.string.valider), null)
                .setNegativeButton(getResources().getString(R.string.annuler), null)
                .show();
    }

    /**
     * Appel la popup permettant de gérer les catégories
     *
     * @param view de l'application
     */
    public void gererCategorie(View view) {
        final View boiteSaisie = getLayoutInflater().inflate(R.layout.liste_categorie, null);

        new AlertDialog.Builder(this)
                .setView(boiteSaisie)
                .setPositiveButton(getResources().getString(R.string.valider), null)
                .setNegativeButton(getResources().getString(R.string.annuler), null)
                .show();
    }


    //Méthodes Bouchon pour afficher l'accueil et le menu dépliant de la page d'accueil
    public void filtreAccueil(View view) {
        setContentView(R.layout.filtre_accueil);

    }

    public void retourAccueil(View view) {
        setContentView(R.layout.activity_main);
    }
}