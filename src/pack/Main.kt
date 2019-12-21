package pack

import kotlin.system.exitProcess

private val users = listOf(
    User("admin", "8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918"),
    User("user1", "04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb")
)
private val roles = listOf(
    Resource(users.first(), "AB", Role.EXECUTE),
    Resource(users.first(), "AB.CD", Role.WRITE),
    Resource(users.last(), "AB.CD.E", Role.READ)
)

fun help() {
    println(
        """
        | To log in you need to write
        | -login login -pass pass   
        | where login - your username pass - your password""".trimMargin()
    )
    exitProcess(status = 255)
}

fun main(args: Array<String>) {
    val params = Params(args)
    if (params.help) help()
    signing(params)
}


fun signing(args: Params) {
    val hashing = HasherService(args.pass)
    val valid = AuthenticationService(users)
    val access = AuthorizationService(roles)
    if (valid.isLoginValid(login = args.login))
    else exitProcess(status = 2)
    val user = valid.findUser(args.login) ?: exitProcess(status = 3)
    if (valid.isPassCorrect(user, hashing.hash(args.pass))) {
        val userPlus =
            access.isAccess(login = args.login, resource = args.res, role = args.role) ?: exitProcess(status = 5)
        exitProcess(status = 0)
    } else exitProcess(status = 4)

}

