package org.kotools.types

import kotools.types.experimental.ExperimentalKotoolsTypesApi

internal class ClassIdentityCompanionKotlinSample {
    @OptIn(ExperimentalKotoolsTypesApi::class)
    fun from() {
        val identity: ClassIdentity<Zero> = ClassIdentity.from(Zero::class)
        println(identity)
    } // END
}
