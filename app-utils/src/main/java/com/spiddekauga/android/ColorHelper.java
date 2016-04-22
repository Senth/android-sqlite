package com.spiddekauga.android;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;


/**
 * Help get colors from the right API version
 */
public class ColorHelper {

/**
 * Returns a themed color integer associated with a particular resource ID.
 * If the resource holds a complex {@link ColorStateList}, then the default
 * color from the set is returned.
 * @param resources location of the color resource
 * @param id The desired resource identifier, as generated by the aapt
 * tool. This integer encodes the package, type, and resource
 * entry. The value 0 is an invalid identifier.
 * @param theme The theme used to style the color attributes, may be
 * {@code null}.
 * @return A single color value in the form 0xAARRGGBB.
 * @throws NotFoundException Throws NotFoundException if the given ID does
 *                           not exist.
 */
@ColorInt
@SuppressWarnings("deprecated")
public static int getColor(Resources resources, @ColorRes int id, @Nullable Theme theme) throws NotFoundException {
	if (Build.VERSION.SDK_INT <= 22) {
		return resources.getColor(id);
	} else {
		return resources.getColor(id, theme);
	}
}

@Nullable
@SuppressWarnings("deprecated")
public static ColorStateList getColorStateList(Resources resources, @ColorRes int id, @Nullable Theme theme) throws NotFoundException {
	if (Build.VERSION.SDK_INT <= 22) {
		return resources.getColorStateList(id);
	} else {
		return resources.getColorStateList(id, theme);
	}
}

}
