val arrayOfClients: ArrayList<Klient> = arrayListOf()
fun main() {
    arrayOfClients.add(Klient("Martin", "Kolčevsky", 27, 121314151))
    arrayOfClients.add(Klient("Honza", "Havaček", 35, 213141511))
    arrayOfClients.add(Klient("Jan", "Povansky", 43, 233242241))
    displayOptions()
    val moznost = readLine()?.toInt() ?: -1
    when (moznost) {
        1 -> newUser()
        2 -> {
            arrayOfClients.display()
            goToMainMenu()
        }

        3 -> findByName()
        4 -> println("Konec")
        else -> println("Špatná možnost")

    }
}

private fun displayOptions() {
    println("================================================")
    println("Vyberte si Moznost:")
    println("================================================")
    println("1 - Pridat nového pojisteného")
    println("2 - Vypsat vsechny pojistené")
    println("3 - Vyhledat pojisteného")
    println("4 - Konec")
}

private fun goToMainMenu() {
    println("Vyberte si Moznost")
    println("1 - Vrátit se na Hlavní Obrazovku.")
    println("2 - Konec.")
    println("Vyberte si Moznost:")
    when (readLine()?.toIntOrNull() ?: 0) {
        1 -> displayOptions()
        2 -> println("Konec operace!")
        else -> {
            println("Špatná možnost")
            goToMainMenu()
        }
    }

}

private fun newUser() {
    println("Zadejte jméno pojisteného:")
    val jmeno = readLine().toString()
    println("Zadejte príjmení:")
    val prijmeni = readLine().toString()
    println("Zadejte vek:")
    val vek = readLine()?.toIntOrNull() ?: -1
    if (vek !in 0..140) {
        println("Špatne zadani")
    }
    println("Zadejte telefonní císlo:")
    val telefonnicislo = readLine()?.toInt() ?: 0
    val person = Klient(jmeno, prijmeni, vek, telefonnicislo)
    arrayOfClients.add(person)
    println("Client ${person.jmeno} ${person.prijmeni} byl ulozen. ")
    println("Pokracujte libovolnou klávesou...")
    goToMainMenu()
}

private fun findByName() {
    println("============")
    println("Vyberte si možnost")
    println("1 - Zadejte Jmeno")
    println("2 - Zadejte Prijmeni")
    var list = listOf<Klient>()
    when (readLine()?.toIntOrNull() ?: 0) {
        1 -> {
            println("Jmeno")
            val name = readLine().toString()
            list = arrayOfClients.filter { it.jmeno.contains(name) }
        }

        2 -> {
            println("Přijmeni")
            val surname = readLine().toString()
            list = arrayOfClients.filter { it.prijmeni.contains(surname) }
        }

        else -> {
            println("Nic Nenalezeno")
            findByName()
        }
    }
    list.display()
    goToMainMenu()
}

private fun <T> List<T>.display() = forEach { println(it) }