package org.cesarferreira.kotlinstarterkit.navigation

import android.content.Context
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator
@Inject constructor() {

    fun navigateToDetails(context: Context, id: Int) {
//        val intent = Intent(context, ItemDetailsActivity::class.java)
//        val bundle = Bundle()
//
//        bundle.putParcelable(Constants.Cache.RECIPE_KEY, Parcels.wrap(recipe))
//        intent.putExtras(bundle)
//
//        context.startActivity(intent)
    }
}
