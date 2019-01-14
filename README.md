# Keyboard Height Provider
Getting keyboard height in android it's a pain in the ass. For activities where soft input mode is `adjustResize`, you can set up an `OnGlobalLayoutListener` and measure how the activity window is resized, to make room for the keyboard.

For other modes of soft input mode, you're out of luck. As the android brick-heads refuse to solve this problem even after 28 iterations of SDK development, someone came with a cool solution:
* create a pop-up window and observe it's global layout changes
* set it's soft input behaviour as `adjustResize`
* attach this popup window to your activity and let it report the keyboard height, based on it's layout changes.

## Set up
Add the following repo to your project

```gradle
    repositories {
        maven {
            url  "https://dl.bintray.com/crysis21/Android"
        }
    }
```

Add the following dependency to your project:

```gradle
    implementation 'com.hold1:keyboardheightprovider:0.0.4'
```

## Usage

1. Keep a reference to `KeyboardHeightProvider` in your activity.
```kotlin
    private var keyboardHeightProvider: KeyboardHeightProvider? = null
```
2. Create a `KeyboardListener`
``` kotlin

    private fun getKeyboardListener() = object : KeyboardHeightProvider.KeyboardListener {
        override fun onHeightChanged(height: Int) {
            sizeText.text = "$height"
        }
    }
```
3. Create the height provider after your activity has been created
```kotlin
        keyboardHeightProvider = KeyboardHeightProvider(this)
        baseView.post {
            keyboardHeightProvider?.start()
        }
```
4. Register for keyboard changes
```kotlin 
        keyboardHeightProvider?.addKeyboardListener(getKeyboardListener())
```
5. Clean up :)
```kotlin
    public override fun onDestroy() {
        super.onDestroy()
        keyboardHeightProvider?.close()
    }
```

Also the `KeyboardInfo` object provides information about the current state of the keyboard, and it's cached height.

### Credits
All credits for this project goes to [Siebe Brouwer](https://github.com/siebeprojects). He had a great idea of using an android `PopupWindow` in order to extract the keyboard height in activities where you don't want to use the `adjustResize` behaviour.
