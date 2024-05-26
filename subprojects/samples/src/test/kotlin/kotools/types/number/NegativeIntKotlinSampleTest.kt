package kotools.types.number

import org.kotools.types.assertPrints
import kotlin.test.Test

class NegativeIntKotlinSampleTest {
    @Test
    fun `serialization processes should pass`() {
        val expected: String = listOf(-123, true)
            .joinToString(separator = "\n")
        val sample = NegativeIntKotlinSample()
        assertPrints(expected, sample::serialization)
    }
}
