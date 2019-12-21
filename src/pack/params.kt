package pack

class Params(args: Array<String>) {
    val login: String
    val pass: String
    val res: String
    val role: String
    val help: Boolean

    init {
        when {
            args.isEmpty() -> {
                help = true
                login = null.toString()
                pass = null.toString()
                res = null.toString()
                role = null.toString()
            }
            args[0] == "-h" -> {
                help = true
                login = null.toString()
                pass = null.toString()
                res = null.toString()
                role = null.toString()
            }
            args[0] == "-login" -> {
                help =
                    !(args.size == 8 && ((args[4] == "-res" && args[6] == "-role") && ((args[0] == "-login" && args[2] == "-pass") || (args[0] == "-pass" && args[2] == "-login"))))
                login = args[1]
                pass = args[3]
                res = args[5]
                role = args[7]
            }
            else -> {
                help = true
                login = null.toString()
                pass = null.toString()
                res = null.toString()
                role = null.toString()
            }
        }

    }


}