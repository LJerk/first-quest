package pack

class AuthorizationService(private val roles: List<Resource>) {

    fun isResValid(role: String): Boolean {
        val valid = Regex(pattern = "[a-zA-Z]{1,10}")
        return valid.containsMatchIn(role)
    }

    fun Wayfinder(way: String): List<String> {
        val subStr = way.split(".");
        return subStr
    }

    fun isAccess(login: String, resource: String, role: String): Resource? = roles.find {
        it.user.login == login && it.resource == resource && it.role.name == role
    }
}