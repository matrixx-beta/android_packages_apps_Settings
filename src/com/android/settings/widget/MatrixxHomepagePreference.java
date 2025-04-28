package com.android.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import androidx.preference.PreferenceViewHolder;
import com.android.settingslib.RestrictedTopLevelPreference;
import com.android.settings.widget.HomepagePreferenceLayoutHelper;
import com.android.settings.widget.HomepagePreference;

public class MatrixxHomepagePreference extends RestrictedTopLevelPreference
        implements HomepagePreferenceLayoutHelper.HomepagePreferenceLayout {

    private final HomepagePreferenceLayoutHelper mHelper;
    private int mCustomLayoutResId = 0;  // Store the custom layout resource ID

    // Constructor to handle all the attributes
    public MatrixxHomepagePreference(Context context, AttributeSet attrs, int defStyleAttr,
            int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mHelper = new HomepagePreferenceLayoutHelper(this); // Initialize layout helper
    }

    public MatrixxHomepagePreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mHelper = new HomepagePreferenceLayoutHelper(this); // Initialize layout helper
    }

    public MatrixxHomepagePreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        mHelper = new HomepagePreferenceLayoutHelper(this); // Initialize layout helper
    }

    public MatrixxHomepagePreference(Context context) {
        super(context);
        mHelper = new HomepagePreferenceLayoutHelper(this); // Initialize layout helper
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        mHelper.onBindViewHolder(holder); // Bind the custom layout to the holder

        // Set custom layout resource if it's set
        if (mCustomLayoutResId != 0) {
            View view = holder.itemView;
            LayoutInflater.from(getContext()).inflate(mCustomLayoutResId, (ViewGroup) view, true);
        }
    }

    @Override
    public HomepagePreferenceLayoutHelper getHelper() {
        return mHelper; // Return the layout helper
    }

    // Custom method to set a custom layout resource
    public void setCustomLayoutResource(int layoutResId) {
        mCustomLayoutResId = layoutResId; // Store the custom layout resource
        notifyChanged(); // Refresh the view
    }
}
