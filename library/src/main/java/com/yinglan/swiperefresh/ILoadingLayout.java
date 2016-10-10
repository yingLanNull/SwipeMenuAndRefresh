package com.yinglan.swiperefresh;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

public interface ILoadingLayout {

	/**
	 * Set the Last Updated Text. This displayed under the main label when
	 * Pulling
	 * 
	 */
	public void setLastUpdatedLabel(CharSequence label);

	/**
	 * Set the drawable used in the loading layout. This is the same as calling
	 * <code>setLoadingDrawable(drawable, Mode.BOTH)</code>
	 */
	public void setLoadingDrawable(Drawable drawable);

	/**
	 * Set Text to show when the Widget is being Pulled
	 * <code>setPullLabel(releaseLabel, Mode.BOTH)</code>
	 * 
	 */
	public void setPullLabel(CharSequence pullLabel);

	/**
	 * Set Text to show when the Widget is refreshing
	 * <code>setRefreshingLabel(releaseLabel, Mode.BOTH)</code>
	 * 
	 */
	public void setRefreshingLabel(CharSequence refreshingLabel);

	/**
	 * Set Text to show when the Widget is being pulled, and will refresh when
	 * released. This is the same as calling
	 * <code>setReleaseLabel(releaseLabel, Mode.BOTH)</code>
	 * 
	 */
	public void setReleaseLabel(CharSequence releaseLabel);

	/**
	 * Set's the Sets the typeface and style in which the text should be
	 * displayed. Please see
	 * TextView#setTypeface(Typeface)}.
	 */
	public void setTextTypeface(Typeface tf);

}
