import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "online"
        protected set

    open val deviceType = "unknown"

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }
    
    open fun printDeviceInfo() {
    println("Device name: $name, category: $category, type: $deviceType")
	}

}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }
    
    fun decreaseVolume() {
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }
    
    fun previousChannel() {
        channelNumber--
        println("Channel number decreased to $channelNumber.")
    }

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    } 
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }
    
    fun decreaseBrightness() {
        brightnessLevel--
        println("Brightness decreased to $brightnessLevel.")
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {

    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        if (smartTvDevice.deviceStatus == "on")
        	smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        if (smartTvDevice.deviceStatus == "on")
        	smartTvDevice.nextChannel()
    }

    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness() {
        if (smartTvDevice.deviceStatus == "on")
        	smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
    
    fun decreseTvVolume(){
        if (smartTvDevice.deviceStatus == "on")
        	smartTvDevice.decreaseVolume()
    }
    
    fun changeTvChannelToPrevious(){
        if (smartTvDevice.deviceStatus == "on")
        	smartTvDevice.previousChannel()
    }
    
    fun printSmartTvInfo(){
        if (smartTvDevice.deviceStatus == "on")
        	smartTvDevice.printDeviceInfo()
    }
    
    fun printSmartLigntInfo(){
        //if (smartTvDevice.deviceStatus == "on")
        	smartLightDevice.printDeviceInfo()
    }
    
    fun decreaseLightBrightness(){
        if (smartTvDevice.deviceStatus == "on")
    		smartLightDevice.decreaseBrightness()
    }
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {
    val smartTvDevice = SmartTvDevice("Android TV", "Entertainment")
    //smartTvDevice.turnOn()
    //smartTvDevice.printDeviceInfo()
 
    val smartLightDevice = SmartLightDevice("Google Light", "Utility")
    //smartLightDevice.turnOn()
    //smartLightDevice.printDeviceInfo()
    val smartHome: SmartHome = SmartHome(smartTvDevice, smartLightDevice)
    smartHome.turnOnTv()
    smartHome.printSmartTvInfo()
    smartHome.decreseTvVolume()  
    smartHome.changeTvChannelToPrevious()
    smartHome.printSmartTvInfo()
    smartHome.turnOnTv()
    smartHome.changeTvChannelToNext()
    smartHome.changeTvChannelToNext()
    smartHome.decreseTvVolume()
    smartHome.decreseTvVolume()
    smartHome.turnOnTv()
    
    val Home: SmartHome = SmartHome(smartTvDevice, smartLightDevice)
    println("")
    Home.turnOnTv()
    Home.changeTvChannelToPrevious()
    Home.printSmartTvInfo()
    Home.turnOnTv()
}