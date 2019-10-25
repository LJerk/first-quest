package pack

fun main(args: Array<String>) {
    val words : List<String>
    when (args.size) {
        0 -> {
            println("Enter text")
            words = readLine()!!.split(' ')
           sort(words)
        }
        else ->{
            words = args.toList()
            sort(words)
        }
    }

}
fun sort(words: List<String>) {

    var awords = words.sorted()

    var count: Int = 1
    var i: Int = 0

    while (i < awords.size) {
        while (awords[i].isBlank()) {i+=1}
        if (i == awords.size - 1) {
            println("${awords[i]}  $count")
            break;
        }
        if (awords[i] == awords[i + 1]) {
            count += 1
        } else {
            println("${awords[i]}  $count")
            count = 1
        }
        i += 1
    }

}

