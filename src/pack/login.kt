package pack

import kotlin.system.exitProcess

val users = listOf(User("admin", "admin"), User("user1", "user"))
fun help() {
    println("To login you need to write you login and password : -login yourlogin | -pass yourpass")
    exitProcess(status = 255)
    return;
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
    if (valid.isLoginValid(login = args.login)) println("login valid")
    else exitProcess(status = 2)
    valid.findUser(args.login)
    for (user in users) {
        if (user.login == args.login) {
            if (user.pass == args.pass) exitProcess(status = 0)
            exitProcess(status = 4)
        }
    }
    exitProcess(status = 3)


}

