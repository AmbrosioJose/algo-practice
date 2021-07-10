package testFoundations

interface TestCaseFactoryInterface<E> {
    fun basicTestCase(): E
    fun multipleTestCases(): List<E>
}