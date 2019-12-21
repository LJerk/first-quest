package pack

class AuthenticationService(val logins: List<User>) {

    fun isLoginValid(login: String): Boolean {
        val valid = Regex(pattern = "[a-zA-Z0-9]")
        return valid.containsMatchIn(login)
    }

    fun findUser(login: String): User? = logins.find { it.login == login }

    fun isPassCorrect(user: User?, pass: String): Boolean = pass == user?.pass


}