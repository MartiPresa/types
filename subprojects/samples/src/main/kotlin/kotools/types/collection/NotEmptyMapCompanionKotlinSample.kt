package kotools.types.collection

import kotools.types.experimental.ExperimentalKotoolsTypesApi

internal class NotEmptyMapCompanionKotlinSample {
    @OptIn(ExperimentalKotoolsTypesApi::class)
    fun createWithMap() {
        val map: Map<Char, Int> = mapOf('a' to 1, 'b' to 2)
        val result: NotEmptyMap<Char, Int> = NotEmptyMap.create(map)
        println(result) // {a=1, b=2}
    } // END

    @OptIn(ExperimentalKotoolsTypesApi::class)
    fun createWithMutableMap() {
        val original: MutableMap<Char, Int> = mutableMapOf('a' to 1, 'b' to 2)
        val notEmptyMap: NotEmptyMap<Char, Int> = NotEmptyMap.create(original)
        println(original) // {a=1, b=2}
        println(notEmptyMap) // {a=1, b=2}

        original.clear()
        println(original) // {}
        println(notEmptyMap) // {a=1, b=2}
    } // END

    @OptIn(ExperimentalKotoolsTypesApi::class)
    fun createOrNullWithMap() {
        val map: Map<Char, Int> = mapOf('a' to 1, 'b' to 2)
        val result: NotEmptyMap<Char, Int>? = NotEmptyMap.createOrNull(map)
        println(result) // {a=1, b=2}
    } // END

    @OptIn(ExperimentalKotoolsTypesApi::class)
    fun createOrNullWithMutableMap() {
        val original: MutableMap<Char, Int> = mutableMapOf('a' to 1, 'b' to 2)
        val notEmptyMap: NotEmptyMap<Char, Int>? =
            NotEmptyMap.createOrNull(original) // TABS: 1
        println(original) // {a=1, b=2}
        println(notEmptyMap) // {a=1, b=2}

        original.clear()
        println(original) // {}
        println(notEmptyMap) // {a=1, b=2}
    } // END

    @OptIn(ExperimentalKotoolsTypesApi::class)
    fun of() {
        val map: NotEmptyMap<Char, Int> = NotEmptyMap.of('a' to 1, 'b' to 2)
        println(map) // {a=1, b=2}
    } // END
}
