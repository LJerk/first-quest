package pack

import kotlin.system.exitProcess

val users = listOf(User("admin", "admin"), User("user1", "user"))
fun help() {
    exitProcess(status = 255)
}

fun main(args: Array<String>) {
    when (args.size) {
        0 -> {
            println("LOG IN")
            val log = readLine()!!.split(' ')
            check(log)
        }
        else -> {
            check(args.toList())
        }
    }
}

fun check(args: List<String>) {
    val params = Params(args)
    signing(params)

}

fun signing(args: Params) {
    val valid = Validate(users)
    if (valid.isLoginValid(login = args.login))
    else exitProcess(status = 2)
    valid.isPassCorrect(valid.findUser(args.login), args.pass)

}

