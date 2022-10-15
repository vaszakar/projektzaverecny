data class Klient(val jmeno:String, val prijmeni:String, val vek:Int, val telefonni_cislo:Int){
    override fun toString(): String {
        return "$jmeno $prijmeni vek:$vek telefonni_cislo: $telefonni_cislo"
    }
}