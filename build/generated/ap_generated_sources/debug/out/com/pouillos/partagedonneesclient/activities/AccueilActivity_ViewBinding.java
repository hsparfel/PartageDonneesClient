// Generated code from Butter Knife. Do not modify!
package com.pouillos.partagedonneesclient.activities;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.pouillos.partagedonneesclient.R;
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
    target.textView2 = Utils.findRequiredViewAsType(source, R.id.textView2, "field 'textView2'", TextView.class);
    target.textView3 = Utils.findRequiredViewAsType(source, R.id.textView3, "field 'textView3'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AccueilActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textView = null;
    target.textView2 = null;
    target.textView3 = null;
  }
}
