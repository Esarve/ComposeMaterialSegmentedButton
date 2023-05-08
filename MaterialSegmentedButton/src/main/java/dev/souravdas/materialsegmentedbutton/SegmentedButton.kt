package dev.souravdas.materialsegmentedbutton

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun SegmentedButton(
    items: List<SegmentedButtonItem>,
    defaultSelectedItemIndex: Int = 0,
    buttonPadding: PaddingValues = SegmentedButtonDefaults.segmentedButtonPadding(),
    cornerRadius: SegmentedButtonCorners = SegmentedButtonDefaults.segmentedButtonCorners(),
    color: SegmentedButtonColors = SegmentedButtonDefaults.segmentedButtonColors(),
    showIconForSelectedOnly: Boolean = false,
    modifier: Modifier = Modifier.fillMaxWidth(),
) {
    val selectedIndex = remember { mutableStateOf(defaultSelectedItemIndex) }

    Row(
        modifier = modifier
    ) {
        val weight = 10.0f / items.size.toFloat()
        items.forEachIndexed { index, item ->
            OutlinedButton(
                modifier = when (index) {
                    0 -> {
                        Modifier
                            .weight(weight)
                            .offset(0.dp, 0.dp)
                            .zIndex(1f)
                    }

                    else -> {
                        Modifier
                            .weight(weight)
                            .offset((-1 * index).dp, 0.dp)
                            .zIndex(if (selectedIndex.value == index) 1f else 0f)
                    }
                },
                onClick = {
                    selectedIndex.value = index
                    item.onClick.invoke()
                },
                shape = when (index) {
                    0 -> RoundedCornerShape(
                        topStartPercent = cornerRadius.topStartPercentage,
                        topEndPercent = 0,
                        bottomStartPercent = cornerRadius.bottomStartPercentage,
                        bottomEndPercent = 0
                    )

                    items.size - 1 -> RoundedCornerShape(
                        topStartPercent = 0,
                        topEndPercent = cornerRadius.topEndPercentage,
                        bottomStartPercent = 0,
                        bottomEndPercent = cornerRadius.bottomEndPercentage
                    )

                    else -> RoundedCornerShape(
                        topStartPercent = 0,
                        topEndPercent = 0,
                        bottomStartPercent = 0,
                        bottomEndPercent = 0
                    )
                },
                border = BorderStroke(1.dp, color.outlineColor().value),
                colors = if (selectedIndex.value == index) {
                    ButtonDefaults.outlinedButtonColors(
                        containerColor = color.selectedContainerColor().value,
                        contentColor = color.selectedContentColor().value
                    )
                } else {
                    ButtonDefaults.outlinedButtonColors(containerColor = color.containerColor().value)
                },
                contentPadding = buttonPadding
            ) {
                AnimatedVisibility(selectedIndex.value == index && showIconForSelectedOnly) {
                    CompositionLocalProvider(content = item.leadingIcon)
                    Spacer(modifier = Modifier.width(4.dp))
                }
                if (!showIconForSelectedOnly) {
                    CompositionLocalProvider(content = item.leadingIcon)
                    Spacer(modifier = Modifier.width(4.dp))
                }
                CompositionLocalProvider(content = item.title)
            }
        }
    }
}