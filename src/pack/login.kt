package pack

import kotlin.system.exitProcess

fun help(){
    print("To login you need to write you login and password : -login yourlogin | -pass yourpass")
    exitProcess(status = -1)
    return;
}

fun main(args: Array<String>){
    when (args.size) {
        0 -> {
            println("LOG IN")
            val arg1 = readLine()!!.split(' ')
            check(arg1)
            val arg2 = readLine()!!.split(' ')
            val login = arg1 + arg2
            check(login)

        }
        else ->{
            check(args.toList())
        }
    }
}

fun check(args: List<String>) {

    if(args.isEmpty() || args[0] == "-h") help()

    if (args.size == 1 && args[0] != "-h") help()

    if(args.size == 2) {
        if (args[0] == "-login" || args[0] == "-pass") println("enter login/pass")
            else help()
    }

    if(args.size == 4){
        if ((args[0] == "-login" && args[2] == "-pass") || (args[0] == "-pass" && args[2] == "-login")){
            signin(args)
        } else help()
    }

    if (args.size == 3 || args.size > 4  ) help()

}

fun signin(args: List<String>){
    var c =0
    val users = listOf(User("admin","admin"), User("user1","user"))

    if (args[0]=="-pass") c=2

    for (user in users){
        if (user.login == args[1+c]) {
            for (user in users){
                if (user.pass == args[3-c]) exitProcess(status = 0)
            }
            exitProcess(status = 4)
        }
    }
    exitProcess(status = 3)


}

