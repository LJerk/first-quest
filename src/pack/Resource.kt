package pack

class Resource(val way: String) {
    fun isResValid(way: String) : Boolean{
            val valid = Regex(pattern = "[a-zA-Z]{1,10}")
            return valid.containsMatchIn(way)
    }
    fun Wayfinder(way: String): List<String> {
        val subStr = way.split(".");
        return subStr
    }
}