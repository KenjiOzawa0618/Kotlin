fun main() {
    val  song = Song("春夏秋冬", "Hilcryme", 2001, 100000)
    song.popular()
}

class Song(val title: String, val artists: String, val relesed: Int,  val number: Int) {
    fun popular() {
       if (number < 1000){
           print("Not popular")
           print("$title, performed by $artists, was released in $relesed.")
       }
       else{
         	print("popular\n")
            print("$title, performed by $artists, was released in $relesed.")
       }
    }

