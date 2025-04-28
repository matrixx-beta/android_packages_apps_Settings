package com.android.settings.widget;

import android.view.View;

import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

import com.android.settings.R;
import com.android.settings.widget.HomepagePreferenceLayoutHelper;

/** Custom Helper for Matrixx homepage preference to manage layout. */
public class MatrixxHomepagePreferenceLayoutHelper extends HomepagePreferenceLayoutHelper {

    private final Preference mPreference;
    private View mIcon;
    private View mText;
    private boolean mIconVisible = true;
    private int mIconPaddingStart = -1;
    private int mTextPaddingStart = -1;
    private int mCustomLayoutResId = 0;

    public MatrixxHomepagePreferenceLayoutHelper(Preference preference) {
        super(preference); // still call super constructor
        mPreference = preference;
    }

    /** Sets custom layout */
    public void setCustomLayoutResource(int layoutResId) {
        mCustomLayoutResId = layoutResId;
        if (mCustomLayoutResId != 0) {
            mPreference.setLayoutResource(mCustomLayoutResId);
        }
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        if (mCustomLayoutResId != 0) {
            mPreference.setLayoutResource(mCustomLayoutResId);
        }
        mIcon = holder.findViewById(R.id.icon_frame);
        mText = holder.findViewById(R.id.text_frame);
        setIconVisible(mIconVisible);
        setIconPaddingStart(mIconPaddingStart);
        setTextPaddingStart(mTextPaddingStart);
    }

    /** Copy necessary methods from original helper */
    @Override
    public void setIconVisible(boolean visible) {
        mIconVisible = visible;
        if (mIcon != null) {
            mIcon.setVisibility(visible ? View.VISIBLE : View.GONE);
        }
    }

    @Override
    public void setIconPaddingStart(int paddingStart) {
        mIconPaddingStart = paddingStart;
        if (mIcon != null && paddingStart >= 0) {
            mIcon.setPaddingRelative(paddingStart, mIcon.getPaddingTop(), mIcon.getPaddingEnd(),
                    mIcon.getPaddingBottom());
        }
    }

    @Override
    public void setTextPaddingStart(int paddingStart) {
        mTextPaddingStart = paddingStart;
        if (mText != null && paddingStart >= 0) {
            mText.setPaddingRelative(paddingStart, mText.getPaddingTop(), mText.getPaddingEnd(),
                    mText.getPaddingBottom());
        }
    }
}
