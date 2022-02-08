package com.mityaalim.data.repo

import com.mityaalim.data.local.prefs.Prefs
import javax.inject.Inject

class RepoImpl @Inject constructor(private val prefs: Prefs) : GeneralRepo {
}