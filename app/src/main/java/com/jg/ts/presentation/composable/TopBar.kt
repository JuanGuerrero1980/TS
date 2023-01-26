package com.jg.ts.presentation.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    titleId: Int,
    modifier: Modifier,
    openDrawer: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = titleId))
                },
        navigationIcon = { Icon (
                            imageVector = Icons.Default.Menu,
                            modifier = Modifier.padding(start = 8.dp)
                                .clickable { openDrawer() },
        contentDescription = null) },
        modifier = modifier
        )
}