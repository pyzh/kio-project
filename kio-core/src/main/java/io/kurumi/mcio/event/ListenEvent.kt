package io.kurumi.mcio.event

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class ListenEvent(vararg val requireEvents : EventType) {

}