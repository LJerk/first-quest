package pack

class Params(args: Array<String>) {
    val login: String
    val pass: String
    val help: Boolean

    init {
        when {
            args.isEmpty() -> {
                help = true
                login = null.toString()
                pass = null.toString()
            }
            args[0] == "-h" ->{
                help = true
                login = null.toString()
                pass = null.toString()
            }
            args.size == 4 ->
                if ((args[0] == "-login" && args[2] == "-pass") || (args[0] == "-pass" && args[2] == "-login")){
                    help = false
                    if (args[0] == "-login") {
                        login = args[1]
                        pass = args[3]
                    } else {
                        login = args[3]
                        pass = args[1]
                    }
                } else {
                    help = true
                    login = null.toString()
                    pass = null.toString()
                }
            else -> {
                help = true
                login = null.toString()
                pass = null.toString()
            }
        }

    }


}