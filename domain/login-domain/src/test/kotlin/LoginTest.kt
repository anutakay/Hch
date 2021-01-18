import org.junit.Test
import org.mockito.Mockito.mock
import ru.anutakay.hch.domain.login.repositories.LoginRepository
import ru.anutakay.hch.domain.login.usecases.Login

class LoginTest {

    @Test
    fun emptyTest() {
        val repository: LoginRepository = mock(LoginRepository::class.java)
        val login = Login(repository)
        val state = login("", "")
    }
}