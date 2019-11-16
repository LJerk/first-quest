package pack

import kotlin.system.exitProcess

private val users = listOf(User("admin", "admin"), User("user1", "user"))
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
    val valid = Validate(users)
    if (valid.isLoginValid(login = args.login))
    else exitProcess(status = 2)
    val user = valid.findUser(args.login) ?: exitProcess(status = 3)
    if (valid.isPassCorrect(user, args.pass)) exitProcess(status = 0)
        else exitProcess(status = 4)

}

