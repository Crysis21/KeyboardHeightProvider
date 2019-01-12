# KeyboardHeightProvider
Getting keyboard height in android it's a pain in the ass. For activities where soft input mode is `adjustResize`, you can set up an `OnGlobalLayoutListener` and measure how the activity window is resized, to make room for the keyboard.

For other modes of soft input mode, you're out of luck. As the android brick-heads refuse to solve this problem even after 28 iterations of SDK development, someone came with a cool solution:


### Credits
All credits for this project goes to [Siebe Brouwer](https://github.com/siebeprojects). He had a great idea of using an android `PopupWindow` in order to extract the keyboard height in activities where you don't want to use the `adjustResize` behaviour.
