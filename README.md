
# Compose Material Segmented Buttons
Segmented Buttons for Jetpack Compose inspired by Google's Material 3 Design Guideline with dynamic color support

## Screenshots

<img src="https://i.ibb.co/nzzKG9G/msb.png" width="400">


## Installation



Add this in your project level gradle file

```groovy
allprojects {
    repositories {
	...
	maven { url 'https://jitpack.io' }
	}
}
```

after that, add this dependency to your app level gradle file

```groovy
implementation 'com.github.Esarve:MaterialSegmentedButton:release-version' 
```

Current release version: 

[![](https://jitpack.io/v/Esarve/MaterialSegmentedButton.svg)](https://jitpack.io/#Esarve/MaterialSegmentedButton)
## Usage

This library was designed to be as close as possible to the Material 3 components. 
just use the `SegmentedButton` to use the button in any place. Use a list of `SegmentedButtonItem` for adding the child items into the button. A demo is provided below:
 
```kotlin
val itemList = listOf(
    SegmentedButtonItem(
        leadingIcon = {
            // Icon composable goes here
        }

        title = {
            // Text composable goes here
        }

        onClick = {
            // on click for this item goes here
        }
    ),

    SegmentedButtonItem(
            leadingIcon = {
                // Icon composable goes here
            }

            title = {
                // Text composable goes here
            }

            onClick = {
                // on click for this item goes here
            }
        ),

)

SegmentedButton(
    items = itemList,
    modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 32.dp)
)
```

SegmentedButton with custom corner radius and colors

```kotlin
SegmentedButton{
    item = itemList,
    color = SegmentedButtonDefaults.segmentedButtonColors(
         containerColor = MaterialTheme.colorScheme.tertiaryContainer,
         selectedContainerColor = MaterialTheme.colorScheme.tertiary
         //more arguments availabe here
    ),
    cornerRadius = SegmentedButtonDefaults.segmentedButtonCorners(40) //or you can individually mention each corners here
    showIconForSelectedOnly = true // this keep the icon for selected item visible only
}
```

check out this gist for more usage https://gist.github.com/Esarve/98f8baaa9b73540800fc208dc013dc60


## Acknowledgements

 - [Android segmented control or Toggle using jetpack compose](https://medium.com/@manojbhadane/hello-everyone-558290eb632e)


