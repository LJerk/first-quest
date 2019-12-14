package pack

class CheckAccess(val roles: List<UserPlus>) {

    fun isAccess(login: String, resource: String, role: String ): UserPlus? = roles.find{
        it.user.login == login && it.resource == resource && it.role.name == role
    }
}

