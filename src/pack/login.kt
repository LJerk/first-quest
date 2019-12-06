package pack

import kotlin.system.exitProcess

private val users = listOf(User("admin", "8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918"), User("user1", "04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb"))
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
    val hashing = Hasher(args.pass)
    val valid = Validate(users)
    if (valid.isLoginValid(login = args.login))
    else exitProcess(status = 2)
    val user = valid.findUser(args.login) ?: exitProcess(status = 3)
    if (valid.isPassCorrect(user, hashing.hash(args.pass))) exitProcess(status = 0)
    else exitProcess(status = 4)

}

