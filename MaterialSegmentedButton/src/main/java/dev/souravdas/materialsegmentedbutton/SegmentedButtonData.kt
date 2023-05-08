package dev.souravdas.materialsegmentedbutton

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Created by Sourav
 * On 4/25/2023 11:41 PM
 * For Hush!
 */

@Immutable
class SegmentedButtonColors internal constructor(
    private val containerColor: Color,
    private val contentColor: Color,
    private val outlineColor: Color,
    private val selectedContainerColor: Color,
    private val selectedContentColor: Color,
    private val selectedLeadingIconColor: Color,
    private val leadingIconColor: Color,
) {
    @Composable
    fun containerColor(): State<Color> = rememberUpdatedState(containerColor)

    @Composable
    fun contentColor(): State<Color> = rememberUpdatedState(contentColor)

    @Composable
    fun outlineColor(): State<Color> = rememberUpdatedState(outlineColor)

    @Composable
    fun selectedContainerColor(): State<Color> = rememberUpdatedState(selectedContainerColor)

    @Composable
    fun selectedContentColor(): State<Color> = rememberUpdatedState(selectedContentColor)

    @Composable
    fun selectedLeadingIconColor(): State<Color> = rememberUpdatedState(selectedLeadingIconColor)

    @Composable
    fun leadingIconColor(): State<Color> = rememberUpdatedState(leadingIconColor)
}

object SegmentedButtonDefaults {
    private const val CORNER_DEFAULT = 16
    val ITEM_WIDTH = 120.dp

    @Composable
    fun segmentedButtonColors(
        containerColor: Color = Color.Transparent,
        contentColor: Color = MaterialTheme.colorScheme.primary,
        outlineColor: Color = MaterialTheme.colorScheme.primary,
        selectedContainerColor: Color = MaterialTheme.colorScheme.primary,
        selectedContentColor: Color = MaterialTheme.colorScheme.onPrimary,
        selectedLeadingIconColor: Color = MaterialTheme.colorScheme.onPrimary,
        leadingIconColor: Color = MaterialTheme.colorScheme.onPrimary
    ): SegmentedButtonColors = SegmentedButtonColors(
        contentColor = contentColor,
        containerColor = containerColor,
        outlineColor = outlineColor,
        selectedContentColor = selectedContentColor,
        selectedContainerColor = selectedContainerColor,
        selectedLeadingIconColor = selectedLeadingIconColor,
        leadingIconColor = leadingIconColor
    )

    fun segmentedButtonPadding(): PaddingValues = PaddingValues(4.dp)

    fun segmentedButtonCorners(cornerValueInPercentage: Int = CORNER_DEFAULT): SegmentedButtonCorners = SegmentedButtonCorners(cornerValueInPercentage)
    fun segmentedButtonCorners(
        topStartPercentage: Int = CORNER_DEFAULT,
        topEndPercentage: Int = CORNER_DEFAULT,
        bottomStartPercentage: Int = CORNER_DEFAULT,
        bottomEndPercentage: Int = CORNER_DEFAULT,
    ): SegmentedButtonCorners = SegmentedButtonCorners(
        topStartPercentage = topStartPercentage,
        topEndPercentage = topEndPercentage,
        bottomStartPercentage = bottomStartPercentage,
        bottomEndPercentage = bottomEndPercentage
    )

}


class SegmentedButtonItem constructor(
    val leadingIcon: @Composable () -> Unit ={},
    val title: @Composable () -> Unit,
    val onClick: () -> Unit
)

class SegmentedButtonCorners {
    val topStartPercentage: Int
    val topEndPercentage: Int
    val bottomStartPercentage: Int
    val bottomEndPercentage: Int

    internal constructor(topStartPercentage: Int, topEndPercentage: Int, bottomStartPercentage: Int, bottomEndPercentage: Int) {
        this.topStartPercentage = topStartPercentage
        this.topEndPercentage = topEndPercentage
        this.bottomStartPercentage = bottomStartPercentage
        this.bottomEndPercentage = bottomEndPercentage
    }

    internal constructor(percentage: Int) {
        this.topStartPercentage = percentage
        this.topEndPercentage = percentage
        this.bottomStartPercentage = percentage
        this.bottomEndPercentage = percentage
    }
}
