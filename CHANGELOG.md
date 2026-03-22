## 0.1.0-alpha.2 (upcoming)
* `get()` methods on svg attributes can no longer by called in Kotlin.
  * Previously they could throw. This should make it so that cannot happen if someone does this by mistake.
* Made `Url(...)`'s constructor public and added a convenience `url(...)` function to call the constructor as this
  matches SVG's url call quite well.
* Added convenience method to `repeatDur` so `repeatDur` can be called with a `Duration` (ex `repeatDur(10.seconds)`)
* Added convenience method to `dur` so `dur` can be called with a `Duration` (ex `dur(10.seconds)`)
* `DelayedTagConsumer` will now throw if you attempt to set elements after starting a child element.
  * This mirrors the behavior of `kotlinx-html` but I'll be honest that I don't like it.
  * Prior to this change attributes would simply disappear if they were after a child element.
  * This affects `svgString { ... }` and any `Appendable` SVG builder.
  * This does not affect DOM based builders