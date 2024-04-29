fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)
    val kenji = Person("Atiqah", 28, "climb", atiqah)

    amanda.showProfile()
    atiqah.showProfile()
    kenji.showProfile()
}

class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
       if (referrer == null){
           print("Name:$name\n Age: $age\n Like to $hobby. Doesn't have a referrer.")
       }
       else{
         	print("Name:$name\n Age: $age\n Like to $hobby. Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}.")
       }
    }
}