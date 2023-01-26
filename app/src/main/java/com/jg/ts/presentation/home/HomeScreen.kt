package com.jg.ts.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jg.ts.domain.model.Section


@Composable
fun HomeScreen(name: String,
              homeViewModel: HomeViewModel = hiltViewModel()
)
{
    when(val state = homeViewModel.viewState.collectAsState().value){
        is HomeUIState.Initial -> homeViewModel.getAllSectionsFromDB()
        HomeUIState.Loading -> Text(text = "Loading!")
        is HomeUIState.ShowError -> Text(text = "Error {${state.message}}!")
        is HomeUIState.ShowSections -> showList(state.list, homeViewModel)
    }

}
@Composable
fun showList(list: List<Section>, homeViewModel: HomeViewModel) {
    Column {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {homeViewModel.getAllSectionsFromApi()}) {
            Text(text = "Get from API")
        }
        list.forEach {
                HeaderView(modifier = Modifier, questionText = it.label){}
            }
        }
}


@Composable
fun HeaderView(modifier: Modifier, questionText: String, onClickItem: () -> Unit) {

    Card(
        modifier = modifier
            .clickable(
                onClick = onClickItem
            )
            .padding(8.dp)
            .background(Color.Magenta)
    ) {
        Text(
            text = questionText,
            fontSize = 17.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Magenta)
                .padding(16.dp)
        )
    }
}