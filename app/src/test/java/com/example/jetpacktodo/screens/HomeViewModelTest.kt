import com.example.jetpacktodo.database.TodoEntity
import com.example.jetpacktodo.repositories.TodoRepo
import com.example.jetpacktodo.screens.HomeViewModel
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.TestInstance
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.spyk
// Other imports...

import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HomeViewModelTest {

    @MockK
    private lateinit var repo: TodoRepo


    @MockK
    private lateinit var viewModel: HomeViewModel

    @BeforeEach
    fun setUp() {
        // Initialize Koin with a module providing the mocked repository
        val testModule = module {
            single { repo as TodoRepo }
        }

        startKoin {
            modules(testModule)
        }

        MockKAnnotations.init(this)

        // Mock the behavior of the repository
        coEvery { repo.getTodos() } returns flowOf(emptyList()) // Add more mock behavior if needed

        viewModel = HomeViewModel()
    }

    @AfterEach
    fun tearDown() {
        stopKoin()
        // Cleanup if needed
    }
    @Test
    fun `updateTodo should call repo updateTodo`() = runBlocking {
        // Given
        val testTodo = TodoEntity(id = 1, title = "any", subTitle = "any")

        // When
        viewModel.updateTodo(testTodo)

        // Then
        coVerify { repo.updateTodo(testTodo) }
    }

    @Test
    fun `deleteTodo should call repo deleteTodo`() = runBlocking {
        // Given
        val testTodo = TodoEntity(id = 1, title = "Task 1", subTitle = "SubTask 1")

        // When
        viewModel.deleteTodo(testTodo)

        // Then
        coVerify { repo.deleteTodo(testTodo) }
    }

    @Test
    fun `addTodo should call repo addTodo`() = runBlocking {
        // Given
        val testTodo = TodoEntity(id = 1, title = "Task 1", subTitle = "SubTask 1")

        // When
        viewModel.addTodo(testTodo)

        // Then
        coVerify { repo.addTodo(testTodo) }
    }





}
