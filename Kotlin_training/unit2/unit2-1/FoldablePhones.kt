open class Phone(var isScreenLightOn:Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var isFodablePhone:Boolean = true) :Phone() 
{
        override fun switchOn(){
            isScreenLightOn = if (isFodablePhone) false else true
            //println("Foldable phone screen light is $isScreenLightOn.")
        }
        
        fun changeFodablePhone(){
            if(isFodablePhone){
                isFodablePhone = false
            }
            else{
                isFodablePhone = true
            }
        }
}
    
    
fun main() {
    val newFoldablePhone = FoldablePhone()

    newFoldablePhone.switchOn() 
    newFoldablePhone.checkPhoneScreenLight()
    newFoldablePhone.changeFodablePhone()
    newFoldablePhone.switchOn()
    newFoldablePhone.checkPhoneScreenLight()
}