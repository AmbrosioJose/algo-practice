package testFoundations

interface TestCaseInterface<T, E> {
    val expectedResult: E
    val input: T?
}