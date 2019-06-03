package fr.pcohen.devged_kotlin.library.extensions

fun Exception.toTreatFor(containerTag: String) {
    System.out.println("An exception occured with $containerTag")
    this.printStackTrace()
}

fun Throwable.toTreatFor(
    containerTag: String,
    exceptionType: ExceptionType
) {
    this.printStackTrace()
}