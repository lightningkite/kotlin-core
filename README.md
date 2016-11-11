# kotlin-core

This package is not Android-specific, and can be used across platforms.  However, for a good example of use in Android, take a look at [kotlin-components-starter](https://github.com/UnknownJoe796/kotlin-components-starter).

This package is meant to contain a collection of useful extensions on both the standard library and the Java standard library.

## Related Repositories

- [kotlin-observable](https://github.com/UnknownJoe796/kotlin-observable) - Observable properties and lists
- [kotlin-networking](https://github.com/UnknownJoe796/kotlin-networking) - Convenient networking with OkHTTP
- [kotlin-anko](https://github.com/UnknownJoe796/kotlin-anko) - Android layouts with Anko
- [kotlin-anko-view-controllers](https://github.com/UnknownJoe796/anko-view-controllers) - Replace activites with a more convenient alternative, view controllers.  Removes all of the struggles of retaining data between view creations and passing information to different screens.
- [kotlin-anko-observable](https://github.com/UnknownJoe796/kotlin-anko-observable) - Combining Anko with Observables
- [kotlin-anko-networking](https://github.com/UnknownJoe796/kotlin-anko-networking) - Combining Anko with networking
- [kotlin-anko-full](https://github.com/UnknownJoe796/kotlin-anko-full) - Uses all of the above packages
- [kotlin-components-starter](https://github.com/UnknownJoe796/kotlin-components-starter) - Example Android project

## Overall Philosophy

*Minimality:*  When possible, these libraries don't create new structure.  Instead, they use extension functions to let you use current objects and classes in a more convenient and expected way.

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
