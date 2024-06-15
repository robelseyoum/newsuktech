

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.newsuktech.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsuktech.components.LightButtonStyle
import com.example.newsuktech.components.MUButtonStyle
import com.example.newsuktech.components.MUIconButton
import com.example.newsuktech.components.MUTextButton
import com.example.newsuktech.ui.theme.NewsUkTechTheme


@Composable
fun CustomToolbar(
    padding: PaddingValues = PaddingValues(20.dp),
    head: @Composable (() -> Unit)? = null,
    title: String,
    actions: @Composable (() -> Unit)? = null,
    showBackButton: Boolean = false,
    backButtonStyle: MUButtonStyle = LightButtonStyle(),
    middleTextColor: Color = NewsUkTechTheme.colors.Titles,
    onBackButtonClick: (() -> Unit)? = null
) {
    CustomBaseToolbar(
        contentPadding = padding,
        navigation = {
            Row(
                modifier = Modifier
                    .semantics(
                        properties = { contentDescription = "" }
                    )
            ) {
                if (showBackButton) {
                    MUIconButton(
                        icon = R.drawable.ic_arrow_left,
                        style = backButtonStyle,
                        modifier = Modifier.width(dimensionResource(id = R.dimen.spacing_40)),
                        compactMode = true
                    ) {
                        onBackButtonClick?.invoke()
                    }
                }

                head?.invoke()
            }
        },
        middle = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics(
                        properties = { contentDescription = "" }
                    )
            ) {
                Text(
                    text = title,
                    style = com.example.newsuktech.ui.theme.Typography.ButtonTitle,
                    textAlign = TextAlign.Center,
                    color = middleTextColor
                )
            }
        },
        actions = {
            Row {
                Column(
                    modifier = Modifier.semantics(
                        properties = { contentDescription = "" }
                    )
                ) {
                    actions?.invoke()
                }
            }
        }
    )
}

@Composable
fun CustomBaseToolbar(
    contentPadding: PaddingValues = PaddingValues(0.dp),
    navigation: @Composable () -> Unit,
    middle: @Composable () -> Unit,
    actions: @Composable () -> Unit
) {
    Box(
        modifier = Modifier.padding(contentPadding)
    ) {
        Box(modifier = Modifier.align(Alignment.CenterStart)) {
            navigation()
        }
        Box(modifier = Modifier.align(Alignment.Center)) {
            middle()
        }
        Box(modifier = Modifier.align(Alignment.CenterEnd)) {
            actions()
        }
    }
}


@Preview
@Composable
fun PreviewMUBaseToolbar() {
    Card(modifier = Modifier.fillMaxWidth()) {
        CustomBaseToolbar(
            contentPadding = PaddingValues(20.dp),
            {
                MUTextButton(title = "Back") {}
            },
            {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Title", modifier = Modifier.padding(horizontal = 8.dp))
                }
            },
            {
                MUTextButton(
                    title = "Edit",
                    backgroundColor = Color.Green
                ) {}
            }
        )
    }
}