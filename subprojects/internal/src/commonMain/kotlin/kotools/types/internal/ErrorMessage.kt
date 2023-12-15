/*
 * Copyright 2023 Kotools S.A.S.U.
 * Use of this source code is governed by the MIT license.
 */

package kotools.types.internal

/**
 * Creates an error message from the message of the specified [throwable], or
 * throws an [IllegalArgumentException] if the [throwable] doesn't have a
 * message or have a blank one.
 */
public fun ErrorMessage(throwable: Throwable): ErrorMessage {
    val text: String =
        requireNotNull(throwable.message) { "Throwable should have a message." }
    return ErrorMessage(text)
}

/**
 * Returns an error message indicating that this number should be greater than
 * zero.
 */
public fun Number.shouldBeGreaterThanZero(): ErrorMessage =
    ErrorMessage("Number should be greater than zero (tried with $this)")

/**
 * Represents an error message.
 *
 * @constructor Creates an error message with the specified [text], or throws
 * an [IllegalArgumentException] if the [text] is [blank][CharSequence.isBlank].
 */
public class ErrorMessage(private val text: String) {
    init {
        val isValid: Boolean = text.isNotBlank()
        require(isValid) { "Error message shouldn't be blank" }
    }

    /**
     * Returns `true` if the [other] object is an [ErrorMessage] having the same
     * value as this error message.
     */
    override fun equals(other: Any?): Boolean =
        other is ErrorMessage && text == other.text

    /** Returns a hash code value for this error message. */
    override fun hashCode(): Int = hashCodeOf(text)

    /** Returns this error message as [String]. */
    override fun toString(): String = text
}