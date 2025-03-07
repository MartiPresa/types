package kotools.types.collection

import org.kotools.types.assertPrints
import kotlin.test.Test

class NotEmptySetCompanionKotlinSampleTest {
    @Test
    fun `create(Collection) should pass`() {
        val sample = NotEmptySetCompanionKotlinSample()
        assertPrints(expected = "[1, 2, 3]", sample::createWithCollection)
    }

    @Test
    fun `create(MutableCollection) should pass`() {
        val expected: String = listOf(
            "[1, 2, 3]",
            "[1, 2, 3]",
            "[]",
            "[1, 2, 3]"
        ).joinToString(separator = "\n")
        val sample = NotEmptySetCompanionKotlinSample()
        assertPrints(expected, sample::createWithMutableCollection)
    }
}
