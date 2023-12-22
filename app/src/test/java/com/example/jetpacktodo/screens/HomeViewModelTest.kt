import com.example.jetpacktodo.database.TodoEntity
import com.example.jetpacktodo.repositories.TodoRepo
import com.example.jetpacktodo.screens.HomeViewModel
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.TestInstance
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HomeViewModelTest {

    @MockK
    private lateinit var repo: TodoRepo

    private lateinit var viewModel: HomeViewModel

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = HomeViewModel(repo)
    }

    @AfterEach
    fun tearDown() {
        // Cleanup if needed
    }

    @Test
    fun `getTodos should update _todos LiveData`() = runBlocking {
        // Given
        val testTodos = listOf(TodoEntity(id = 1, title = "Task 1", subTitle = "SubTask 1"))
        coEvery { repo.getTodos() } returns flowOf(testTodos)

        // When
        viewModel.getTodos()

        // Then
        assertEquals(testTodos, viewModel.todos.value)
    }

    @Test
    fun `updateTodo should call repo updateTodo`() = runBlocking {
        // Given
        val testTodo = TodoEntity(id = 1, title = "Task 1", subTitle = "SubTask 1")

        // When
        viewModel.updateTodo(testTodo)

        // Then
        coEvery { repo.updateTodo(testTodo) }
    }

    @Test
    fun `deleteTodo should call repo deleteTodo`() = runBlocking {
        // Given
        val testTodo = TodoEntity(id = 1, title = "Task 1", subTitle = "SubTask 1")

        // When
        viewModel.deleteTodo(testTodo)

        // Then
        coEvery { repo.deleteTodo(testTodo) }
    }

    @Test
    fun `addTodo should call repo addTodo`() = runBlocking {
        // Given
        val testTodo = TodoEntity(id = 1, title = "Task 1", subTitle = "SubTask 1")

        // When
        viewModel.addTodo(testTodo)

        // Then
        coEvery { repo.addTodo(testTodo) }
    }
}
