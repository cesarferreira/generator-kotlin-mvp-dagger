package cesarferreira.movies.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator
@Inject constructor() {

    fun navigateToDetails(context: Context, id: String) {
        val intent = Intent(context, cesarferreira.movies.features.details.DetailsActivity::class.java)
        val bundle = Bundle()
        bundle.putString(cesarferreira.movies.features.common.Constants.ITEM_KEY, id)
        intent.putExtras(bundle)
        context.startActivity(intent)
    }
}
