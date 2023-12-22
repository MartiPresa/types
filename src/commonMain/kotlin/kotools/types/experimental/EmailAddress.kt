/*
 * Copyright 2023 Kotools S.A.S.U.
 * Use of this source code is governed by the MIT license.
 */

package kotools.types.experimental

import kotools.types.internal.ExperimentalSince
import kotools.types.internal.KotoolsTypesVersion
import kotools.types.internal.text.SpecialChar
import kotools.types.text.NotBlankString
import kotools.types.text.toNotBlankString
import kotlin.jvm.JvmSynthetic

/**
 * Represents an [email address](https://en.wikipedia.org/wiki/Email_address).
 *
 * You can use the [EmailAddress.Companion.from] function for creating an
 * instance of this type.
 */
@ExperimentalKotoolsTypesApi
@ExperimentalSince(KotoolsTypesVersion.Unreleased)
public class EmailAddress private constructor(
    private val localPart: NotBlankString,
    private val domain: NotBlankString
) {
    /**
     * Returns the string representation of this email address.
     *
     * Here's an example of calling this function from Kotlin code:
     *
     * ```kotlin
     * val text = "contact@kotools.org"
     * val address: EmailAddress = EmailAddress.from(text)
     *     ?: error("'$text' is a valid email address")
     * val message = "$address" // or address.toString()
     * println(message) // contact@kotools.org
     * ```
     *
     * Please note that being **experimental**, this function is not available
     * yet for Java users.
     */
    @JvmSynthetic
    @Suppress("RedundantModalityModifier")
    final override fun toString(): String =
        "$localPart${SpecialChar.AtSign}$domain"

    /** Contains static declarations for the [EmailAddress] type. */
    public companion object {
        /**
         * The regular expression that an [EmailAddress] should match.
         *
         * The underlying pattern is `^\S+@\S+\.\S+$`.
         *
         * Here's the explanation associated to each symbol used in this regular
         * expression:
         * - `^` **Beginning.** Matches the beginning of the string, or the
         * beginning of a line if the multiline flag (m) is enabled.
         * - `\S` **Not whitespace.** Matches any character that is not a
         * whitespace character (spaces, tabs, line breaks).
         * - `+` **Quantifier.** Match 1 or more of the preceding token.
         * - `@` **Character.** Matches a "@" character (char code 64).
         * - `\.` **Escaped character.** Matches a "." character (char code 46).
         * - `$` **End.** Matches the end of the string, or the end of a line if
         * the multiline flag (m) is enabled.
         *
         * Here's an example of calling this property from Kotlin code:
         *
         * ```kotlin
         * println(EmailAddress.regex) // ^\S+@\S+\.\S+$
         * ```
         *
         * Please note that being **experimental**, this property is not
         * available yet for Java users.
         */
        @get:JvmSynthetic
        public val regex: Regex =
            Regex("^\\S+${SpecialChar.AtSign}\\S+\\.\\S+\$")

        /**
         * Creates an [EmailAddress] from the specified [text], or returns
         * `null` if the [text] doesn't match [EmailAddress.Companion.regex].
         *
         * Here's an example of calling this function from Kotlin code:
         *
         * ```kotlin
         * val address: EmailAddress? = EmailAddress.from("contact@kotools.org")
         * println(address) // contact@kotools.org
         * ```
         *
         * Please note that being **experimental**, this function is not
         * available yet for Java users.
         */
        @JvmSynthetic
        public fun from(text: String): EmailAddress? {
            val isValid: Boolean = text matches this.regex
            if (!isValid) return null
            val delimiter: Char = SpecialChar.AtSign.toChar()
            val parts: List<String> = text.split(delimiter)
            val localPart: NotBlankString = parts.first()
                .toNotBlankString()
                .getOrThrow()
            val domain: NotBlankString = parts.last()
                .toNotBlankString()
                .getOrThrow()
            return EmailAddress(localPart, domain)
        }
    }
}