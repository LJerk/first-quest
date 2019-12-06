package pack

import java.security.MessageDigest

class Hasher(pass:String) {
    fun hash(pass: String): String {
        val bytes = pass.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        return digest.fold("", { str, pass -> str + "%02x".format(pass) })
    }
}