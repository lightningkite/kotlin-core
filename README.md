# kotlin-core

This package is not Android-specific, and can be used across platforms.

## Overall Philosophy

*Complete reuse:*  Everything that is commonly used should be included, preferably as an inline 
extension function to reduce the app's method count.

*Intuitiveness:*  Use inline extension functions to make common tasks simple, such as requesting a 
photo from the user.  In standard Android, doing this properly would take at least a large file by 
itself.  We have extension functions that do it in one line.

## What this package contains

- Extension functions for using collections of lambdas as events
- A disposable interface for objects that need to do something when you're done with them (usually to remove references to enable garbage collection)
- String extension functions
- InputStream extension functions for putting all of the output into a ByteArray or String
- Range extension functions for getting a random number within a numerical range
- Math for angles and advanced rounding
- Lifecycles - a system for consistently defining start/stops for lifecycles and listeners to them.  Used extensively with Android in the `kotlin-anko` repository.
- Lambda - currently, a lambda extension function which puts a cooldown on a lambda.  More to come.
- Files - File.child("text")
- Dates - Date.toCalendar(), get and set month/year/day/minute/second/hour on Calendar
- Collections
  - Cache - a map which, when an unavailable key is requested, it will automatically generate and enter a value.
  - Various mapping functions, which wrap a real collection.  Each one is `<Collection>.mapping{...}` or some other verb with "ing" on the end, so as to not cause confusion the functions that actually create a new collection.
- ByteArray to and from a string using hex
- Async package, which includes
  - `<lambda>.invokeAsync(...){ /*ui thread callback*/ }`
