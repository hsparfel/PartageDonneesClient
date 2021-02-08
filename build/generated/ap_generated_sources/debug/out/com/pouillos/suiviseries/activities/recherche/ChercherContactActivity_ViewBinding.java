// Generated code from Butter Knife. Do not modify!
package com.pouillos.suiviseries.activities.recherche;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.pouillos.suiviseries.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ChercherContactActivity_ViewBinding implements Unbinder {
  private ChercherContactActivity target;

  private View view7f080077;

  private View view7f080072;

  private View view7f08007a;

  private View view7f080071;

  private View view7f080075;

  private View view7f080079;

  private View view7f0800b2;

  private View view7f0800b6;

  @UiThread
  public ChercherContactActivity_ViewBinding(ChercherContactActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ChercherContactActivity_ViewBinding(final ChercherContactActivity target, View source) {
    this.target = target;

    View view;
    target.textRechercheIntervenant = Utils.findRequiredViewAsType(source, R.id.textRechercheIntervenant, "field 'textRechercheIntervenant'", AutoCompleteTextView.class);
    target.layoutContact = Utils.findRequiredViewAsType(source, R.id.layoutContact, "field 'layoutContact'", TextInputLayout.class);
    view = Utils.findRequiredView(source, R.id.chipMedecin, "field 'chipMedecin' and method 'chipMedecinClick'");
    target.chipMedecin = Utils.castView(view, R.id.chipMedecin, "field 'chipMedecin'", Chip.class);
    view7f080077 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.chipMedecinClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.chipAutre, "field 'chipAutre' and method 'chipAutreClick'");
    target.chipAutre = Utils.castView(view, R.id.chipAutre, "field 'chipAutre'", Chip.class);
    view7f080072 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.chipAutreClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.chipSpecialite, "field 'chipSpecialite' and method 'chipSpecialiteClick'");
    target.chipSpecialite = Utils.castView(view, R.id.chipSpecialite, "field 'chipSpecialite'", Chip.class);
    view7f08007a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.chipSpecialiteClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.chipActivite, "field 'chipActivite' and method 'chipActiviteClick'");
    target.chipActivite = Utils.castView(view, R.id.chipActivite, "field 'chipActivite'", Chip.class);
    view7f080071 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.chipActiviteClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.chipDepartement, "field 'chipDepartement' and method 'chipDepartementClick'");
    target.chipDepartement = Utils.castView(view, R.id.chipDepartement, "field 'chipDepartement'", Chip.class);
    view7f080075 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.chipDepartementClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.chipRegion, "field 'chipRegion' and method 'chipRegionClick'");
    target.chipRegion = Utils.castView(view, R.id.chipRegion, "field 'chipRegion'", Chip.class);
    view7f080079 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.chipRegionClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.fabChercher, "field 'fabChercher' and method 'fabChercherClick'");
    target.fabChercher = Utils.castView(view, R.id.fabChercher, "field 'fabChercher'", FloatingActionButton.class);
    view7f0800b2 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.fabChercherClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.fabRaz, "field 'fabRaz' and method 'fabRazClick'");
    target.fabRaz = Utils.castView(view, R.id.fabRaz, "field 'fabRaz'", FloatingActionButton.class);
    view7f0800b6 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.fabRazClick();
      }
    });
    target.selectionMetier = Utils.findRequiredViewAsType(source, R.id.selectionMetier, "field 'selectionMetier'", AutoCompleteTextView.class);
    target.listMetier = Utils.findRequiredViewAsType(source, R.id.listMetier, "field 'listMetier'", TextInputLayout.class);
    target.selectionGeo = Utils.findRequiredViewAsType(source, R.id.selectionGeo, "field 'selectionGeo'", AutoCompleteTextView.class);
    target.listGeo = Utils.findRequiredViewAsType(source, R.id.listGeo, "field 'listGeo'", TextInputLayout.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.my_progressBar, "field 'progressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ChercherContactActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textRechercheIntervenant = null;
    target.layoutContact = null;
    target.chipMedecin = null;
    target.chipAutre = null;
    target.chipSpecialite = null;
    target.chipActivite = null;
    target.chipDepartement = null;
    target.chipRegion = null;
    target.fabChercher = null;
    target.fabRaz = null;
    target.selectionMetier = null;
    target.listMetier = null;
    target.selectionGeo = null;
    target.listGeo = null;
    target.progressBar = null;

    view7f080077.setOnClickListener(null);
    view7f080077 = null;
    view7f080072.setOnClickListener(null);
    view7f080072 = null;
    view7f08007a.setOnClickListener(null);
    view7f08007a = null;
    view7f080071.setOnClickListener(null);
    view7f080071 = null;
    view7f080075.setOnClickListener(null);
    view7f080075 = null;
    view7f080079.setOnClickListener(null);
    view7f080079 = null;
    view7f0800b2.setOnClickListener(null);
    view7f0800b2 = null;
    view7f0800b6.setOnClickListener(null);
    view7f0800b6 = null;
  }
}
