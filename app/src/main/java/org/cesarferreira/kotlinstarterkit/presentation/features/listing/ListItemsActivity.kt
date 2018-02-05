package org.cesarferreira.kotlinstarterkit.presentation.features.listing

import org.cesarferreira.kotlinstarterkit.presentation.framework.base.BaseActivity
import org.cesarferreira.kotlinstarterkit.presentation.framework.base.BaseFragment

class ListItemsActivity : BaseActivity() {
    override fun fragment(): BaseFragment = ListItemsFragment()
}
