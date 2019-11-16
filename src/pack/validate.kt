package pack

class Validate (val logins : List<User>){

    fun isLoginValid(login:String) : Boolean {
        val valid = Regex(pattern = "[a-zA-Z0-9]")
        return valid.containsMatchIn(login)
    }

    fun findUser(login:String) : User? {
     /*   val logins = listOf("admin","user")
        for(log in logins){
            if (login == log)
            {return}
        }

      */
        TODO()
    }

    fun isPassCorrect( user : User, pass: String) : Boolean {
        TODO()
    }

}