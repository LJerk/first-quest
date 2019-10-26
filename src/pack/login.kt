package pack

fun help(){
    print("To login you need to write you login and password : -login yourlogin | -pass yourpass")
    return;
}

fun main(args: Array<String>){
    when (args.size) {
        0 -> {
            println("LOGIN")
            val login = readLine()!!.split(' ')
            check(login)
        }
        else ->{
            check(args.toList())
        }
    }
}

fun check(args: List<String>){
    val admin: user = user("admin","admin")
    val user1: user = user("user1","user")

    if (args.isEmpty() || args[0] == "-h" || args.size !=4 ) help()

    if (args[0]=="-login" && args[2] == "-pass")
    {
        if (args[1] == admin.login && args[3] == admin.pass) println("you login up as admin!")
        if (args[1] == user1.login && args[3] == user1.pass) println("you login up as user!")
    }
    else help()
}

