package com.octochimp.phonefinder3

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

class PhoneFinderViewModel : ViewModel() {



    var selectedItemNavigationIndex by mutableIntStateOf(0)
        private set

    fun setSelectedItemIndex(index: Int) {
        selectedItemNavigationIndex = index
    }

}
