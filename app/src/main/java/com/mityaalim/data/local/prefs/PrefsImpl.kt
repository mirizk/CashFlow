package com.mityaalim.data.local.prefs

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PrefsImpl @Inject constructor(@ApplicationContext private val context: Context) : Prefs{
}