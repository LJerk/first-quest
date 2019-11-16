package pack

import kotlin.system.exitProcess

class Validate (val logins : List<User>){

    fun isLoginValid(login:String) : Boolean {
        val valid = Regex(pattern = "[a-zA-Z0-9]")
        return valid.containsMatchIn(login)
    }

    fun findUser(login:String) : User {
        for (user in users){
            if(login == user.login) return user
        }
        exitProcess(status = 3)
    }

    fun isPassCorrect( user : User, pass: String) : Boolean {
        if(pass == user.pass) exitProcess(status = 0)
            else exitProcess(status = 4)
    }

}