package com.pouillos.suiviseries.activities.afficher;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.pouillos.suiviseries.activities.NavDrawerActivity;
import com.pouillos.suiviseries.R;
import com.pouillos.suiviseries.entities.Contact;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import icepick.Icepick;

public class AfficherContactActivity extends NavDrawerActivity {

    Contact contactSelected;

    List<Contact> listContactsBD;

    @BindView(R.id.layoutDr)
    TextInputLayout layoutDr;
    @BindView(R.id.textDr)
    TextInputEditText textDr;
    @BindView(R.id.layoutName)
    TextInputLayout layoutName;
    @BindView(R.id.textName)
    TextInputEditText textName;
    @BindView(R.id.layoutFirstName)
    TextInputLayout layoutFirstName;
    @BindView(R.id.textFirstName)
    TextInputEditText textFirstName;

    @BindView(R.id.layoutJob)
    TextInputLayout layoutJob;
    @BindView(R.id.textJob)
    TextInputEditText textJob;

    @BindView(R.id.layoutPlace)
    TextInputLayout layoutPlace;
    @BindView(R.id.textPlace)
    TextInputEditText textPlace;

    @BindView(R.id.layoutComplement)
    TextInputLayout layoutComplement;
    @BindView(R.id.textComplement)
    TextInputEditText textComplement;

    @BindView(R.id.layoutNumStreet)
    TextInputLayout layoutNumStreet;
    @BindView(R.id.textNumStreet)
    TextInputEditText textNumStreet;

    @BindView(R.id.layoutZip)
    TextInputLayout layoutZip;
    @BindView(R.id.textZip)
    TextInputEditText textZip;
    @BindView(R.id.layoutTown)
    TextInputLayout layoutTown;
    @BindView(R.id.textTown)
    TextInputEditText textTown;

    @BindView(R.id.layoutPhone)
    TextInputLayout layoutPhone;
    @BindView(R.id.textPhone)
    TextInputEditText textPhone;

    @BindView(R.id.layoutFax)
    TextInputLayout layoutFax;
    @BindView(R.id.textFax)
    TextInputEditText textFax;

    @BindView(R.id.layoutEmail)
    TextInputLayout layoutEmail;
    @BindView(R.id.textEmail)
    TextInputEditText textEmail;

    @BindView(R.id.fabGoogleMap)
    FloatingActionButton fabGoogleMap;
    @BindView(R.id.fabWaze)
    FloatingActionButton fabWaze;
    @BindView(R.id.fabSave)
    FloatingActionButton fabSave;

    @BindView(R.id.activity_main_toolbar)
    Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_afficher_contact);

        this.configureToolBar();
        this.configureBottomView();

        ButterKnife.bind(this);

        //AfficherContactActivity.AsyncTaskRunner runner = new AfficherContactActivity.AsyncTaskRunner();
        //runner.execute();

        setTitle("Contact");

        displayFabs();
        hideAllFields();

        traiterIntent();

        Menu bottomNavigationViewMenu = bottomNavigationView.getMenu();
        bottomNavigationViewMenu.findItem(R.id.bottom_navigation_search_doctor).setChecked(true);
    }



    public void traiterIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("contactId")) {

            Long contactId = intent.getLongExtra("contactId", 0);
            //contactSelected = Contact.findById(Contact.class, contactId);
            contactSelected =  contactDao.load(contactId);

           /* int position = 0;
            for (Contact contact : listContactsBD) {
                if (contact.getId().longValue() != contactId) {
                    position ++;
                } else {
                    break;
                }
            }

            selectedContact.setText(selectedContact.getAdapter().getItem(position).toString(), false);
            */
            fillAllFields();
            displayAllFields(false);
            displayFabs();
        }
        enableFields(false);
    }





    public void displayFabs() {
        if (contactSelected == null) {
            fabGoogleMap.hide();
            fabWaze.hide();
            fabSave.hide();
        } else {
            if (!contactSelected.getIsSelected()) {
                fabSave.show();
            }
            if (contactSelected.getAdresse() != null && contactSelected.getCp() != null &&
                    contactSelected.getVille() != null && !contactSelected.getAdresse().equalsIgnoreCase("")
                    && !contactSelected.getCp().equalsIgnoreCase("") && !contactSelected.getVille().equalsIgnoreCase("")) {
                fabWaze.show();
                fabGoogleMap.show();
            } else {
                fabWaze.hide();
                fabGoogleMap.hide();
            }
        }
    }

    private void fillAllFields() {

        if (contactSelected.getCodeCivilite() != null && !contactSelected.getCodeCivilite().equalsIgnoreCase("")) {
            textDr.setText(contactSelected.getCodeCivilite());
        }
        if (contactSelected.getNom() != null && !contactSelected.getNom().equalsIgnoreCase("")) {
            textName.setText(contactSelected.getNom());
        }
        if (contactSelected.getPrenom() != null && !contactSelected.getPrenom().equalsIgnoreCase("")) {
            textFirstName.setText(contactSelected.getPrenom());
        }
        if (contactSelected.getProfession() != null && !contactSelected.getProfession().getName().equalsIgnoreCase("")) {
            textJob.setText(contactSelected.getProfession().getName());
        }
        if (contactSelected.getSavoirFaire() != null && !contactSelected.getSavoirFaire().getName().equalsIgnoreCase("")) {
            textJob.setText(contactSelected.getSavoirFaire().getName());
        }
        if (contactSelected.getRaisonSocial() != null && !contactSelected.getRaisonSocial().equalsIgnoreCase("")) {
            textPlace.setText(contactSelected.getRaisonSocial());
        }
        if (contactSelected.getComplement() != null && !contactSelected.getComplement().equalsIgnoreCase("")) {
            textComplement.setText(contactSelected.getComplement());
        }
        if (contactSelected.getAdresse() != null && !contactSelected.getAdresse().equalsIgnoreCase("")) {
            textNumStreet.setText(contactSelected.getAdresse());
        }
        if (contactSelected.getCp() != null && !contactSelected.getCp().equalsIgnoreCase("")) {
            textZip.setText(contactSelected.getCp());
        }
        if (contactSelected.getVille() != null && !contactSelected.getVille().equalsIgnoreCase("")) {
            textTown.setText(contactSelected.getVille());
        }
        if (contactSelected.getTelephone() != null && !contactSelected.getTelephone().equalsIgnoreCase("")) {
            textPhone.setText(contactSelected.getTelephone());
        }
        if (contactSelected.getFax() != null && !contactSelected.getFax().equalsIgnoreCase("")) {
            textFax.setText(contactSelected.getFax());
        }
        if (contactSelected.getEmail() != null && !contactSelected.getEmail().equalsIgnoreCase("")) {
            textEmail.setText(contactSelected.getEmail());
        }
    }

    private void enableFields(boolean bool) {
        layoutDr.setEnabled(false);
        layoutName.setEnabled(false);
        layoutFirstName.setEnabled(false);
        layoutJob.setEnabled(false);
        layoutPlace.setEnabled(bool);
        layoutComplement.setEnabled(bool);
        layoutNumStreet.setEnabled(bool);
        layoutZip.setEnabled(bool);
        layoutTown.setEnabled(bool);
        layoutPhone.setEnabled(bool);
        layoutFax.setEnabled(bool);
        layoutEmail.setEnabled(bool);
    }

    private void displayAllFields(boolean bool) {
        layoutName.setVisibility(View.VISIBLE);
        layoutFirstName.setVisibility(View.VISIBLE);
        layoutJob.setVisibility(View.VISIBLE);
        if (bool) {
            layoutDr.setVisibility(View.VISIBLE);
            layoutPlace.setVisibility(View.VISIBLE);
            layoutComplement.setVisibility(View.VISIBLE);
            layoutNumStreet.setVisibility(View.VISIBLE);
            layoutZip.setVisibility(View.VISIBLE);
            layoutTown.setVisibility(View.VISIBLE);
            layoutPhone.setVisibility(View.VISIBLE);
            layoutFax.setVisibility(View.VISIBLE);
            layoutEmail.setVisibility(View.VISIBLE);
        } else {


            if (textDr.getText() == null || textDr.getText().toString().equalsIgnoreCase("")) {
                layoutDr.setVisibility(View.GONE);
            } else {
                layoutDr.setVisibility(View.VISIBLE);
            }
            if (textPlace.getText() == null || textPlace.getText().toString().equalsIgnoreCase("")) {
                layoutPlace.setVisibility(View.GONE);
            } else {
                layoutPlace.setVisibility(View.VISIBLE);
            }
            if (textComplement.getText() == null || textComplement.getText().toString().equalsIgnoreCase("")) {
                layoutComplement.setVisibility(View.GONE);
            } else {
                layoutComplement.setVisibility(View.VISIBLE);
            }
            if (textNumStreet.getText() == null || textNumStreet.getText().toString().equalsIgnoreCase("")) {
                layoutNumStreet.setVisibility(View.GONE);
            } else {
                layoutNumStreet.setVisibility(View.VISIBLE);
            }
            if (textZip.getText() == null || textZip.getText().toString().equalsIgnoreCase("")) {
                layoutZip.setVisibility(View.GONE);
            } else {
                layoutZip.setVisibility(View.VISIBLE);
            }
            if (textTown.getText() == null || textTown.getText().toString().equalsIgnoreCase("")) {
                layoutTown.setVisibility(View.GONE);
            } else {
                layoutTown.setVisibility(View.VISIBLE);
            }
            if (textPhone.getText() == null || textPhone.getText().toString().equalsIgnoreCase("")) {
                layoutPhone.setVisibility(View.GONE);
            } else {
                layoutPhone.setVisibility(View.VISIBLE);
            }
            if (textFax.getText() == null || textFax.getText().toString().equalsIgnoreCase("")) {
                layoutFax.setVisibility(View.GONE);
            } else {
                layoutFax.setVisibility(View.VISIBLE);
            }
            if (textEmail.getText() == null || textEmail.getText().toString().equalsIgnoreCase("")) {
                layoutEmail.setVisibility(View.GONE);
            } else {
                layoutEmail.setVisibility(View.VISIBLE);
            }
        }
    }

    private void hideAllFields() {
        layoutDr.setVisibility(View.GONE);
        layoutName.setVisibility(View.GONE);
        layoutFirstName.setVisibility(View.GONE);
        layoutJob.setVisibility(View.GONE);
        layoutPlace.setVisibility(View.GONE);
        layoutComplement.setVisibility(View.GONE);
        layoutNumStreet.setVisibility(View.GONE);
        layoutZip.setVisibility(View.GONE);
        layoutTown.setVisibility(View.GONE);
        layoutPhone.setVisibility(View.GONE);
        layoutFax.setVisibility(View.GONE);
        layoutEmail.setVisibility(View.GONE);
    }

    @OnClick(R.id.fabGoogleMap)
    public void fabGoogleMapClick() {
            String url = "geo:";
            String addr = "";
            if (contactSelected.getLatitude() != 0 && contactSelected.getLongitude() != 0) {
                url += contactSelected.getLatitude()+","+contactSelected.getLongitude();
                url += "?q="+contactSelected.getLatitude()+","+contactSelected.getLongitude();
            } else if (contactSelected.getAdresse() != null && contactSelected.getCp() != null && contactSelected.getVille() != null) {
                url += "0,0?q=";
                addr += Uri.parse(contactSelected.getAdresse()+", "+contactSelected.getCp()+", "+contactSelected.getVille()+", FRANCE");
                url += addr;
            }
            Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( url ) );
            intent.setPackage("com.google.android.apps.maps");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
    }

    @OnClick(R.id.fabWaze)
    public void fabWazeClick() {
        try
        {
            String url = "https://waze.com/ul?q=";
            url += contactSelected.getAdresse()+"%20"+contactSelected.getCp()+"%20"+contactSelected.getVille();
            Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( url ) );
            startActivity( intent );
        }
        catch ( ActivityNotFoundException ex  )
        {
            Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( "market://details?id=com.waze" ) );
            startActivity(intent);
        }
    }

    @OnClick(R.id.fabSave)
    public void fabSaveClick() {
        contactSelected.setIsSelected(true);
        contactDao.update(contactSelected);
        fabSave.hide();
    }

}

