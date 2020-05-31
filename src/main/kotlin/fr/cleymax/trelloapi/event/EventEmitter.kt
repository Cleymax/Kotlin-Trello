package fr.cleymax.trelloapi.event

import fr.cleymax.trelloapi.utils.MultiMap
import java.util.function.Consumer
import kotlin.reflect.KClass


inline fun <reified T : Event> event(
    noinline block: T.() -> Unit
) {
    event(T::class, block)
}

fun <T : Event> event(
    type: KClass<T>,
    block: T.() -> Unit
) {
    EventEmitter().register(type, Consumer { (it as T).block() })
}

class EventEmitter {

    fun <T : Event> register(type: KClass<T>, consumer: Consumer<Event>) {
        listeners.put(type, consumer)
    }

    fun <T : Event> emit(type: KClass<T>, event: Event) {
        listeners.entrySet().filter { it.key.isInstance(type) }
            .forEach { consumer -> consumer.value!!.forEach { it.accept(event) } }
    }

    companion object {
        private val listeners: MultiMap<KClass<out Event>, Consumer<Event>> = MultiMap()
    }
}