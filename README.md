
# Material Segmented Buttons
Segmented Buttons inspired by Google's Material 3 Design Guideline with dynamic color support


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

![GitHub release (latest by date)](https://img.shields.io/github/v/release/Esarve/MaterialSegmentedButton)
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
)
```


## Acknowledgements

 - [Android segmented control or Toggle using jetpack compose](https://medium.com/@manojbhadane/hello-everyone-558290eb632e)


