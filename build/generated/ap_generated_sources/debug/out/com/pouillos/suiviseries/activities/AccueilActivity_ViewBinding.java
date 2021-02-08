// Generated code from Butter Knife. Do not modify!
package com.pouillos.suiviseries.activities;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pouillos.suiviseries.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AccueilActivity_ViewBinding implements Unbinder {
  private AccueilActivity target;

  @UiThread
  public AccueilActivity_ViewBinding(AccueilActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AccueilActivity_ViewBinding(AccueilActivity target, View source) {
    this.target = target;

    target.textView = Utils.findRequiredViewAsType(source, R.id.textView, "field 'textView'", TextView.class);
    target.textNbContact = Utils.findRequiredViewAsType(source, R.id.textNbContact, "field 'textNbContact'", TextView.class);
    target.textNbEtablissement = Utils.findRequiredViewAsType(source, R.id.textNbEtablissement, "field 'textNbEtablissement'", TextView.class);
    target.progressBar = Utils.findRequiredViewAsType(source, R.id.my_progressBar, "field 'progressBar'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AccueilActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textView = null;
    target.textNbContact = null;
    target.textNbEtablissement = null;
    target.progressBar = null;
  }
}
