package pack

class Params(args: List<String>) {
    val login : String
    val pass: String
    val help: Boolean = args[0] ==  "-h" && args.isEmpty()

    init {
        when{
            args.isEmpty() -> help()
            args[0] == "-h" -> help()
            args.size == 4 -> if ((args[0] == "-login" && args[2] == "-pass") || (args[0] == "-pass" && args[2] == "-login"))
                    else help()
            else -> help()
        }
        if (args[0] == "-login"){
            login = args[1]
            pass = args[3]
        }
            else{
            login = args[3]
            pass = args[1]
        }
    }


}