package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.example.freya.loginfoodos.contact;
import com.google.gson.Gson;

public class SharedPreference {

	public static final String PREFS_NAME = "PRODUCT_APP";
	public static final String FAVORITES = "Product_Favorite";
	
	public SharedPreference() {
		super();
	}

	// This four methods are used for maintaining favorites.
	public void saveFavorites(Context context, List<contact> favorites) {
		SharedPreferences settings;
		Editor editor;

		settings = context.getSharedPreferences(PREFS_NAME,
				Context.MODE_PRIVATE);
		editor = settings.edit();

		Gson gson = new Gson();
		String jsonFavorites = gson.toJson(favorites);

		editor.putString(FAVORITES, jsonFavorites);

		editor.commit();
	}

	public void addFavorite(Context context, contact product) {
		List<contact> favorites = getFavorites(context);
		if (favorites == null)
			favorites = new ArrayList<contact>();
		favorites.add(product);
		saveFavorites(context, favorites);
	}

	public void removeFavorite(Context context, contact product) {
		ArrayList<contact> favorites = getFavorites(context);
		if (favorites != null) {
			favorites.remove(product);
			saveFavorites(context, favorites);
		}
	}

	public ArrayList<contact> getFavorites(Context context) {
		SharedPreferences settings;
		List<contact> favorites;

		settings = context.getSharedPreferences(PREFS_NAME,
				Context.MODE_PRIVATE);

		if (settings.contains(FAVORITES)) {
			String jsonFavorites = settings.getString(FAVORITES, null);
			Gson gson = new Gson();
			contact[] favoriteItems = gson.fromJson(jsonFavorites,
					contact[].class);

			favorites = Arrays.asList(favoriteItems);
			favorites = new ArrayList<contact>(favorites);
		} else
			return null;

		return (ArrayList<contact>) favorites;
	}
}
