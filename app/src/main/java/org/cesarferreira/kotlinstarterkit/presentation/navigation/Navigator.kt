package org.cesarferreira.kotlinstarterkit.presentation.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import org.cesarferreira.kotlinstarterkit.presentation.features.common.Constants
import org.cesarferreira.kotlinstarterkit.presentation.features.details.DetailsActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator
@Inject constructor() {

    fun navigateToDetails(context: Context, id: String) {
        val intent = Intent(context, DetailsActivity::class.java)
        val bundle = Bundle()
        bundle.putString(Constants.ITEM_KEY, id)
        intent.putExtras(bundle)
        context.startActivity(intent)
    }
}
