package kotools.types.number

import kotools.types.experimental.ExperimentalKotoolsTypesApi

internal class StrictlyNegativeIntCompanionKotlinSample {
    @OptIn(ExperimentalKotoolsTypesApi::class)
    fun create() {
        val number: StrictlyNegativeInt = StrictlyNegativeInt.create(-7)
        println(number) // -7
    } // END
}
